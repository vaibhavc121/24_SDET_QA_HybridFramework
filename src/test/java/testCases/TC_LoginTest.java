package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass
{
	@Test(groups =
	{ "sanity", "master" }, retryAnalyzer = utilities.RetryAnalyzerClass.class)
	public void verifyLogin()
	{
		logger.info("login test started..");

		try
		{
			// homePage
			HomePage hp = new HomePage(driver);
			hp.myacClick();
			hp.clkLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPwd(p.getProperty("password"));
			lp.clkLogin();

			// MyAccount
			MyAccountPage myac = new MyAccountPage(driver);
			boolean act = myac.isMyAccountPageExists();
			// Assert.assertEquals(act, true,"login failed");
			Assert.assertTrue(act);

		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("test case finished");
	}
}
