package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

// 💡Every class is considered as one test case | One single class is one test case

public class TC_AccountRegistrationTest extends BaseClass
{
	@Test
	public void verify_ac_reg()
	{
		logger.info("test case started");

		try
		{
			HomePage hp = new HomePage(driver);
			hp.myacClick();
			logger.info("clicked on my ac link");
			hp.regClick();
			logger.info("clicked on reg link");

			AccountRegistrationPage regpg = new AccountRegistrationPage(driver);
//			regpg.setfname("vaibhav");
//			regpg.setlname("chavan");
//			regpg.setmail("vaibhavc121@gmail.com");
//			regpg.setele("7769967226");
//			regpg.setpwd("vaibhav");
//			regpg.setcnfpwd("vaibhav");
//			regpg.checkagree();
//			regpg.clickcont();

			logger.info("providing cust details");
			regpg.setfname(randomString());
			regpg.setlname(randomString());
			regpg.setmail(randomString() + "@gmail.com");
			regpg.setele(randomNumber());

			String password = randomAlphaNumeric();
			regpg.setpwd(password);
			regpg.setcnfpwd(password);
			regpg.checkagree();
			regpg.clickcont();

			String exp = "Your Account Has Been Created!";
			String act = regpg.getConfirmationMessage();

			logger.info("validating expected message");
			Assert.assertEquals(act, exp);
		}
		catch (Exception e)
		{
			logger.error("test failed..");
			logger.debug("debug logs..");
			Assert.fail();
		}

		logger.info("finished test case");
	}

}
