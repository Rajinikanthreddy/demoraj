package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LandingPage {
	public WebDriver driver;
	//By login=By.xpath("//span[contains(text(),'Login')]");
	@FindBy(xpath="//span[contains(text(),'Login')]")
	private WebElement login;
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	private WebElement textTitle;
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	private WebElement contact;
	@FindBy(xpath="//h3[contains(text(),'Everything about Testing')]")
	private WebElement header;
	By popup=By.xpath("//button[contains(text(),'NO THANKS')]");
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
		PageFactory.initElements(driver,this);
	}
	public LoginPage getLoginlink() {
		login.click();
		LoginPage lop=new LoginPage(driver);
		return lop;
	}
	public WebElement getTitletext() {
		return textTitle;
	}
	public WebElement getContactlink() {
		return contact;
	}
	public WebElement getHeaderText() {
		return header;
	}
	public int getPopupsize() {
		return driver.findElements(popup).size();
	}
	public WebElement getPopup() {
		return driver.findElement(popup);
	}
}
