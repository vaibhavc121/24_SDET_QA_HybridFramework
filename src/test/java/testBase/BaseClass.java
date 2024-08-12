package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{
	public WebDriver driver; // global class variable
	public Logger logger; // log4j
	public Properties p;

	@BeforeClass(groups =
	{ "sanity", "regression", "master" })
	@Parameters(
	{ "os", "browser" })
	public void setup(String os, String br) throws IOException
	{
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2

		switch (br.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();

			break;

		case "edge":
			driver = new EdgeDriver();

			break;

		default:
			System.out.println("invalid browser name");
			return; // return- totally exit from the execution

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl")); // Reading URL from properties file

	}

	@AfterClass(groups =
	{ "sanity", "regression", "master" })
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
