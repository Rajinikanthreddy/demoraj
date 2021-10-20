package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPage {

	public ForgotPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebDriver driver;
	@FindBy(id="user_email")
	WebElement emailID;
	@FindBy(xpath="//input[@value='Send Me Instruction']")
	WebElement sendInstruct;
	public WebElement getMailID() {
		return emailID;
	}
	public WebElement getSendInButton() {
		return sendInstruct;
	}
}
