package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registrationpage extends Basepage {

	public Registrationpage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myaccclick;

	@FindBy(xpath = "(//a[contains(text(),'Register')])[1]")
	WebElement regclick;

	@FindBy(xpath = "//input[@name=\"firstname\"]")
	WebElement username;
	@FindBy(id = "input-firstname")
	WebElement firstname;
	@FindBy(id = "input-lastname")
	WebElement lastname;
	@FindBy(id = "input-email")
	WebElement email;
	@FindBy(xpath = "//input[@name=\"telephone\"]")
	WebElement telephone;
	@FindBy(id = "input-password")
	WebElement password;
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement buttonreg;
	@FindBy(xpath = "//input[@name=\"confirm\"]")
	WebElement cnfrmpass;
	@FindBy(xpath = "//input[@name=\"agree\"]")
	WebElement cagree;

	public void clickmyAcclick() {
		myaccclick.click();

	}

	public void clickmyRegclick() {
		regclick.click();

	}

	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setFirstname(String fname) {
		username.sendKeys(fname);
	}

	public void setLastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void setEmail(String emails) {
		email.sendKeys(emails);
	}

	public void setTelephone(String tele) {
		telephone.sendKeys(tele);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void setcnfrmPassword(String cpass) {
		cnfrmpass.sendKeys(cpass);
	}

	public void setAgree() {
		cagree.click();
	}

	public void setButtonreg() {
		buttonreg.click();
	}
}
