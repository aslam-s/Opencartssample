package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.Registrationpage;
import testbase.BaseClass;

public class TC_Accountreg extends BaseClass {

	@Test(priority = 1, groups = { "Regression", "master" })
	void verifyaccountpafe() throws InterruptedException {
		try {
			Registrationpage r = new Registrationpage(driver);
			Thread.sleep(3000);
			logger.info("click on my account link");
			r.clickmyAcclick();
			logger.info("click on my reg link");
			r.clickmyRegclick();
			Thread.sleep(3000);
			logger.info("providing customer details..");
			r.setUsername(randomeString().toUpperCase());
			r.setFirstname("cola");
			r.setLastname("info");
			r.setEmail(randomeString() + "@gmail.com");
			Thread.sleep(3000);
			r.setTelephone(randomenumber());
			// r.setCountry();
			String password = randomeAlphanumber();
			r.setPassword(password);
			r.setcnfrmPassword(password);
			Thread.sleep(5000);
			r.setAgree();
			r.setButtonreg();

		} catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("Debugg logs..");
			Assert.fail();
		}
		driver.quit();
	}
}