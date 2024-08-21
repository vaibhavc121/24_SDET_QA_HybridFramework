package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//a[normalize-space()='Edit Account']")
	WebElement editAccount;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement acupdates;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement passupdate;

	@FindBy(xpath = "//a[normalize-space()='Password']")
	WebElement password;

	public boolean isMyAccountPageExists()
	{
		try
		{
			return myAccount.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}

	}

	public boolean isMyAccountUpdates()
	{
		String aString = acupdates.getText();
		if (aString.equals("Success: Your account has been successfully updated."))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isPwdUpdate()
	{
		String pwdupdate = passupdate.getText();
		if (pwdupdate.equals("Success: Your password has been successfully updated."))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void clklogout()
	{
		logout.click();
	}

	public void clkEditAc()
	{
		editAccount.click();
	}

	public void clkPwd()
	{
		password.click();
	}

}
