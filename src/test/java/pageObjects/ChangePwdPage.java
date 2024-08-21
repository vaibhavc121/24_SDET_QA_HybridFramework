package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePwdPage extends BasePage
{

	public ChangePwdPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement passwordConfirm;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement cntinu;

	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void setCnfPwd(String pwd)
	{
		passwordConfirm.sendKeys(pwd);
	}

	public void btnCntinu()
	{
		cntinu.click();
	}

}
