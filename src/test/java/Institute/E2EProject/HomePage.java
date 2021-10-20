package Institute.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(Base.class.getName());
	JavascriptExecutor jse;
	LandingPage lp;
	@BeforeTest
	public void intialize() throws IOException {
		Configurator.setLevel(Log.getName(), Level.TRACE);
		driver=initializeDriver();
		Log.info("Initial was success");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Log.info("Maximize is Sucess");
		jse= (JavascriptExecutor)driver;
	}
	int c=0;
	@Test(dataProvider="getData")
	public void basePageNavigation(String email,String pass) throws IOException {
		driver.get(pr.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		//lp.getLoginlink().click();
		//LoginPage lop=new LoginPage(driver);
		LoginPage lop=lp.getLoginlink();
		//jse.executeScript("arguments[0].click()", lp.getLoginlink());
		lop.getUsername().sendKeys(email);
		lop.getPassword().sendKeys(pass);
		lop.getloginButton().click();
		Log.info(c+": user sucess");
		if(c==1) {
			ForgotPage fp=lop.getforgotPage();
			fp.getMailID().sendKeys("Rajini123");
			fp.getSendInButton().click();
		}
		c=c+1;
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="ram";
		data[0][1]="pass1";
		data[1][0]="Restriceduser";
		data[1][1]="Pass2";
		return data;	
	}
	
	  @AfterTest 
	  public void teardown() {
		  Log.info("driver closed");
		  driver.close(); 
		  }
	  
	 
}
