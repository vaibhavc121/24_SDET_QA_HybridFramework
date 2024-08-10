package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid - login success - test pass - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail - logout
Data is invalid -- login failed - test pass
*/

public class TC_LoginDDT extends BaseClass
{
	// Based on the data provider, Below method will repeat multiple times. How many
	// inputs data provider is passing those many times below method automatically
	// increment
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // Getting data provider from different
																				// class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("*** starting login DDT... ***");

		try
		{
			// homePage
			HomePage hp = new HomePage(driver);
			hp.myacClick();
			hp.clkLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPwd(pwd);
			lp.clkLogin();

			// MyAccount
			MyAccountPage myac = new MyAccountPage(driver);
			boolean act = myac.isMyAccountPageExists();

//			Data is valid - login success - test pass -I logout
//								login failed - test fail
			//
//			Data is invalid - login success - test fail - logout
//								login failed - test pass

			if (exp.equalsIgnoreCase("valid"))
			{
				if (act = true)
				{
					myac.clklogout();
					Assert.assertTrue(true);
					// assertion always should be After the action because After the assertion no
					// statement will be executed

				}
				else
				{
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("invalid"))
			{

				if (act = true)
				{
					myac.clklogout();
					Assert.assertTrue(false);
					// assertion always should be After the action because After the assertion no
					// statement will be executed

				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("*** finished login DDT... ***");
	}

}
