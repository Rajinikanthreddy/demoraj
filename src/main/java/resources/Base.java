package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties pr;
	public WebDriver initializeDriver() throws IOException {
		pr=new Properties();
		//The Below code will be used for only Local user
		//FileInputStream fin=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		//The Below code can be used in any Local Machine and we can achieve deletion of hardcoding the path location
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		pr.load(fin);
		//mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		String browserName=pr.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			/*
			 * ChromeOptions options=new ChromeOptions(); //the below lines of code will use
			 * for to run chrome browser in Headleass mode in backround without invoking
			 * chrome browser in b/w if(browserName.contains("headless")) {
			 * options.addArguments("--headless"); }
			 */
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/Users/Admin/Downloads/geckodriver-v0.30.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			
		}
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		return driver;
	}
	public String failureMethod(String Mname,WebDriver driver) throws IOException{		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+Mname+".png";
		FileUtils.copyFile(source,new File(destFile));
		return destFile;
	}

}
