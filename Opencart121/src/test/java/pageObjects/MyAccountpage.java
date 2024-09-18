package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends Basepage {

	public MyAccountpage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	WebElement verifyacc;

	public boolean isMyAccountpage() {
		try {
			return (verifyacc.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
}