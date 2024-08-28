package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage
{

	public AddressPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[normalize-space()='New Address']")
	WebElement newAddress;

	public void clkNewAddbtn()
	{
		newAddress.click();
	}

}
