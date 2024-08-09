package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass
{
	@Test
	public void verifyLogin()
	{
		logger.info("login test started..");
		HomePage hp = new HomePage(driver);
		hp.myacClick();
		hp.clkLogin();
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd("password");
		MyAccountPage ac = new MyAccountPage(driver);
	}
}
