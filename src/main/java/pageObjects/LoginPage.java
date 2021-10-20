package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
		PageFactory.initElements(driver,this);
	}
	public WebDriver driver;
	@FindBy(id="user_email")
	WebElement email;
	@FindBy(id="user_password")
	WebElement pass;
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginButton;
	By forgotpass = By.partialLinkText("Forgot");
	public WebElement getUsername() {
		return email;
	}
	public WebElement getPassword() {
		return pass;	
	}
	public WebElement getloginButton() {
		return loginButton;
	}
	public ForgotPage getforgotPage() {
		driver.findElement(forgotpass).click();
		return new ForgotPage(driver);
	}
}
