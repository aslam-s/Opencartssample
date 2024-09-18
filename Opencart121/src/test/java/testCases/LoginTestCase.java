package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.MyAccountpage;
import pageObjects.loginPage;
import testbase.BaseClass;

public class LoginTestCase extends BaseClass {
	@Test(groups = { "sanity", "master" })
	public void verifyloginpage() {
		// my account home page

		logger.info("starting test...");

		Homepage hp = new Homepage(driver);
		hp.clickmyacclick();
		hp.clickloginclick();
		// loginpage
		loginPage lp = new loginPage(driver);
		lp.Setlogin(p.getProperty("email"));
		lp.Setpass(p.getProperty("password"));
		lp.btnlogin();
		// my account [page
		MyAccountpage m = new MyAccountpage(driver);
		boolean acp = m.isMyAccountpage();
		Assert.assertEquals(acp, true);

		// logger.info("finished");

		/*
		 * Data is valid - loginsuccess-testpass-logout login failed testfailed
		 * 
		 * data is invalid - loginsuccess -testfail-logout loginfailed-testpass
		 */
		driver.quit();
	}

}
