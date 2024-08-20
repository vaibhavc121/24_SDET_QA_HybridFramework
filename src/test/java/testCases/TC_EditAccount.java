package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EditAcPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_EditAccount extends BaseClass
{
	@Test
	public void verifyEditAc()
	{
		logger.info("edit ac test started..");
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
			myac.clkEditAc();
			logger.info("click on edit ac");

			// edit ac
			EditAcPage ac = new EditAcPage(driver);
			ac.setFname(p.getProperty("fname"));
			ac.setLname(p.getProperty("lname"));
			ac.btnContinue();

			// my ac
			// MyAccountPage myac = new MyAccountPage(driver);
			boolean act = myac.isMyAccountUpdates();
			Assert.assertTrue(act);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("test case finished");
	}
}
