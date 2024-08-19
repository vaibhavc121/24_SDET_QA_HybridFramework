package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_Logout extends BaseClass
{
	@Test
	public void verifyLogout()
	{
		try
		{
			logger.info("logout test started..");
			HomePage hp = new HomePage(driver);
			hp.myacClick();
			hp.clkLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPwd(p.getProperty("password"));
			lp.clkLogin();

			MyAccountPage myac = new MyAccountPage(driver);
			myac.clklogout();

			LogoutPage lgpg = new LogoutPage(driver);
			boolean act = lgpg.isaclogoutExist();
			Assert.assertEquals(act, true);

		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("test case finished");

	}
}
