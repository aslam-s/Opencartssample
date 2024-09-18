package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myaccclick;
	@FindBy(xpath = "(//a[contains(text(),'Register')])[1]")
	WebElement regclick;
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginclick;

	public void clickmyacclick() {
		myaccclick.click();
	}

	public void clcikregclick() {
		regclick.click();
	}

	public void clickloginclick() {
		loginclick.click();
	}

}
