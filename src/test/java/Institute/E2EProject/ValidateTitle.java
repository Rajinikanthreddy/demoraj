package Institute.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.core.config.Configurator;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	@BeforeTest
	public void intialize() throws IOException {
		Configurator.setLevel(Log.getName(), Level.DEBUG);
		driver=initializeDriver();
		Log.info("Driver is intialized");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(pr.getProperty("url"));
		Log.info("Navigated to URL");
	}
	
	  @AfterTest 
	  public void teardown() { 
		  driver.close(); 
		  }
	 

	@Test
	public void validate() throws IOException {
	lp=new LandingPage(driver);
	Log.info("blixav");
	Assert.assertEquals(lp.getTitletext().getText(),"FEATURED COURSES123");
	Log.info("alixav");
	//Assert.assertTrue(lp.getContactlink().isDisplayed());
	}
	
	@Test
	public void validateHeader() {
		Log.info("Before Header verification");
		Assert.assertEquals(lp.getHeaderText().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		Log.info("After Header verification");
	}

}
