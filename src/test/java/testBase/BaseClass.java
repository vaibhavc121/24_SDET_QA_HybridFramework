package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass
{
	public WebDriver driver; // global class variable

	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

	}

	@AfterClass
	public void teardown()
	{
		// driver.quit();
	}

	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber()
	{
		String generatedNumer = RandomStringUtils.randomNumeric(10);
		return generatedNumer;
	}

	public String randomAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomNumeric(3);
		String generatedNumer = RandomStringUtils.randomNumeric(3);
		return (generatedString + "@" + generatedNumer);
	}

}
