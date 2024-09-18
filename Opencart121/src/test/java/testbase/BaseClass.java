package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@Parameters({ "os", "browser" })
	@BeforeClass(groups = { "sanity", "Regression", "master" })
	public void setup(String os, String br) throws IOException {

		// loading.config.properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());
		//
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalid browser..");
			return;
		}

		// driver.get(" https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL"));// reading url from properties file
		// https://tutorialsninja.com/demo/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterClass
	public void closedriver() {
		driver.quit();
	}

	// generate multiple emails randomly
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	// generate multiple emails randomly phonenumber
	public String randomenumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	// generate multiple password randomly
	public String randomeAlphanumber() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return (generatednumber + "@" + generatedString);
	}

	public String captureScreen(String tname) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // date
		TakesScreenshot tk = (TakesScreenshot) driver;
		File sourcefile = tk.getScreenshotAs(OutputType.FILE);
		String targetpath = System.getProperty("user.dir") + "\\screenshots\\" + tname + " " + timestamp + " .png";
		File targetfile = new File(targetpath);
		sourcefile.renameTo(targetfile); 

		return targetpath;

	}
}
