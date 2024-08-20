package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAcPage extends BasePage
{

	public EditAcPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement cntnu;

	public void setFname(String fname)
	{
		firstName.clear();
		firstName.sendKeys(fname);
	}

	public void setLname(String lname)
	{
		lastName.clear();
		lastName.sendKeys(lname);
	}

	public void btnContinue()
	{
		cntnu.click();
	}

}
