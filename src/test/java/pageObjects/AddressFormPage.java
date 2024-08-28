package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressFormPage extends BasePage
{

	public AddressFormPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='input-company']")
	WebElement company;
	@FindBy(xpath = "//input[@id='input-address-1']")
	WebElement address1;
	@FindBy(xpath = "//input[@id='input-address-2']")
	WebElement address2;
	@FindBy(xpath = "//input[@id='input-city']")
	WebElement city;
	@FindBy(xpath = "//input[@id='input-postcode']")
	WebElement postCode;

	public void setFname(String fname)
	{
		firstName.sendKeys(fname);
	}

	public void setLname(String lname)
	{
		lastName.sendKeys(lname);
	}

	public void setCompany(String comp)
	{
		company.sendKeys(comp);
	}

	public void setAdd1(String add1)
	{
		address1.sendKeys(add1);
	}

	public void setAdd2(String add2)
	{
		address2.sendKeys(add2);
	}

	public void setCity(String cty)
	{
		city.sendKeys(cty);
	}

	public void setPostcode(String pcode)
	{
		postCode.sendKeys(pcode);
	}
}
