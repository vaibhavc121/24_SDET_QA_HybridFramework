package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{
	// note- make webdriver static
	public static WebDriver driver; // global class variable
	public Logger logger; // log4j
	public Properties p;

	@SuppressWarnings("deprecation")
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

		// code for execution on selenium grid
		if (p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// OS (we are getting os from xml file)
			if (os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no matching os");
				return; // It will automatically exit
			}

			// browser (we are getting browser from xml file)
			switch (br.toLowerCase())
			{
			case "chrome":
				capabilities.setBrowserName("chrome");

				break;

			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");

				break;

			default:
				System.out.println("No matching browser ");
				return; // It will automatically exit from switch case statement
			}

			driver = new RemoteWebDriver(new URL("http://10.101.223.24:4444/wd/hub"), capabilities);

		}

		if (p.getProperty("execution_env").equals("local"))
		{
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

	public String captureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
