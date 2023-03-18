package testNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	WebDriver driver;
	  @BeforeSuite
	  public void systemSetup() {
//		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Avinash\\geckodriver.exe");
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\chromedriver.exe");

		  
	  }
	  
//@BeforeClass
//@BeforeTest
@BeforeMethod
public void openBrowser() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("http://www.google.com");
}
}
