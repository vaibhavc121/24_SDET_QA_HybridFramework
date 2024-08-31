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

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AddressAdded;

	public void clkNewAddbtn()
	{
		newAddress.click();
	}

	public boolean isAddressAdded()
	{
		String addadded = AddressAdded.getText();
		if (addadded.equals("Your address has been successfully added"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
