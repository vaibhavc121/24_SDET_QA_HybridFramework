package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage
{

	public LogoutPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	WebElement accountLogout;

	public boolean isaclogoutExist()
	{
		try
		{
			return accountLogout.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
