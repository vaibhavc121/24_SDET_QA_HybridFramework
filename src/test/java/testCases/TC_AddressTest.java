package testCases;

import org.testng.annotations.Test;

import pageObjects.AddressFormPage;
import pageObjects.AddressPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_AddressTest extends BaseClass
{
	@Test(dataProvider = "AddressData", dataProviderClass = DataProviders.class)
	public void verify_address(String fname, String lname, String company, String add1, String add2, String city,
			String pincode)
	{
		logger.info("*** starting address DDT... ***");

		try
		{
			// homePage
			HomePage hp = new HomePage(driver);
			hp.myacClick();
			hp.clkLogin();
			logger.info("completed homepage");

			// login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPwd(p.getProperty("password"));
			lp.clkLogin();
			logger.info("completed login");

			// MyAccount
			MyAccountPage myac = new MyAccountPage(driver);
			myac.clkAddBook();
			logger.info("clicked on address book");

			// address
			AddressPage ap = new AddressPage(driver);
			ap.clkNewAddbtn();

			// address form
			logger.info("providing info to address form");
			AddressFormPage afp = new AddressFormPage(driver);
			afp.setFname(fname);
			afp.setLname(lname);
			afp.setCompany(company);
			afp.setAdd1(add1);
			afp.setAdd2(add2);
			afp.setCity(city);
			afp.setPostcode(pincode);

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
