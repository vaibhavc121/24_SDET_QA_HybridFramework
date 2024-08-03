package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Mail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement passwordConfirm;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement cont;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement acCreated;

	public void setfname(String fname)
	{
		firstName.sendKeys(fname);
	}

	public void setlname(String lname)
	{
		lastName.sendKeys(lname);
	}

	public void setmail(String mail)
	{
		Mail.sendKeys(mail);
	}

	public void setele(String tele)
	{
		telephone.sendKeys(tele);
	}

	public void setpwd(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void setcnfpwd(String pwd)
	{
		passwordConfirm.sendKeys(pwd);
	}

	public void checkagree()
	{
		agree.click();
	}

	public void clickcont()
	{
		cont.click();
	}

	public String getConfirmationMessage()
	{
		try
		{
			return (acCreated.getText());
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}

}
