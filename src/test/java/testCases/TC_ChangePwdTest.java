package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ChangePwdPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_ChangePwdTest extends BaseClass
{
	@Test
	public void verifyChangePwd()
	{
		logger.info("pwd change test started..");
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
			myac.clkPwd();
			logger.info("click on pwd");

			// change pwd
			ChangePwdPage pwd = new ChangePwdPage(driver);
			pwd.setPwd(p.getProperty("pwd"));
			pwd.setCnfPwd(p.getProperty("pwd"));
			pwd.btnCntinu();
			logger.info("pwd changed");

			// my ac
			boolean act = myac.isPwdUpdate();
			Assert.assertEquals(act, true);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("test case finished");
	}
}
