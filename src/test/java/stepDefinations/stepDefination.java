package stepDefinations;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class stepDefination extends Base{
	LandingPage lp;
	LoginPage lop;
	WebDriver driver;
	@Given("Initilaize the browser with chrome")
	public void initilaize_the_browser_with_chrome() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
	}

	@Given("Navigate to {string} application")
	public void navigate_to_application(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(string);
	}

	@Given("Click on Sign in Link in home page to land on secure sign in page")
	public void click_on_sign_in_link_in_home_page_to_land_on_secure_sign_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		lp=new LandingPage(driver);
		if(lp.getPopupsize()>0) {
			lp.getPopup().click();
		}
		lp.getLoginlink();
	}

	@When("^user login enters with (.+) and (.+)$")
	public void user_login_enters_with_and(String string, String string2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		lop=new LoginPage(driver);
		lop.getUsername().sendKeys(string);
		lop.getPassword().sendKeys(string2);
		lop.getloginButton().click();
	}

	@Then("verify user is successfully logged in")
	public void verify_user_is_successfully_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement ws=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]"));
		System.out.println(ws.getText());
	}
	@And("^close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.close();
	    }


}