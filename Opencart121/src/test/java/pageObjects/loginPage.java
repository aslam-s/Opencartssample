package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends Basepage {

	public loginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name = "email")
	WebElement uname;
	@FindBy(name = "password")
	WebElement upass;
	@FindBy(xpath = "//input[@value=\"Login\"]")
	WebElement lbtn;

	public void Setlogin(String user) {
		uname.sendKeys(user);

	}

	public void Setpass(String lpass) {
		upass.sendKeys(lpass);

	}

	public void btnlogin() {
		lbtn.click();

	}

}
