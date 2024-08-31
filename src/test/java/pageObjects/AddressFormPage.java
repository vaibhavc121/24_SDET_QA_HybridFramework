package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(xpath = "//select[@id='input-country']")
	WebElement country;
	@FindBy(xpath = "//select[@id='input-zone']")
	WebElement state;
	@FindBy(xpath = "//input[@value='0']")
	WebElement defadd;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement contnu;

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

	public void setCountry(String cntry)
	{
		Select select = new Select(country);
		select.selectByVisibleText(cntry);
	}

	public void setState(String region)
	{
		Select select = new Select(state);
		select.selectByVisibleText(region);
	}

	public void setDefaultAdd()
	{
		defadd.click();
	}

	public void clkContinueBtn()
	{
		contnu.click();
	}

}
