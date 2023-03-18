package testNGPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DateFormatter {
	WebDriver driver;
	@BeforeSuite
	  public void systemSetup() {
//		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Avinash\\geckodriver.exe");
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get("https://search.yahoo.com/search?fr=mcafee&type=E211US826G0&p=gmail+inbox");
		}
	@Test(description="This Test will look for Inbox keyword and click on it.")
	public void inboxLogin()
//	https://search.yahoo.com/search?fr=mcafee&type=E211US826G0&p=gmail+inbox
	{
		WebElement inboxKeyWordLink=driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[3]/ul[1]/li[1]/a/b"));
		inboxKeyWordLink.click();
	}
	@Test(description="This Test will search the insert mail id box and enter the mail id and proceed further",dependsOnMethods="inboxLogin")
	public void email_or_phoneNumberIsertText()
	{
		//*[@id="identifierId"]
		
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
//		//set the text
//		jsExecutor.executeScript("document.getElementById('identifierId').value='testuser'");  
//		//get the text
//		String text = (String) jsExecutor.executeScript("return document.getElementById('identifierId').value");  
//		System.out.println(text);  
//		
//		String javascript = "document.getElementById('identifierId')";  
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
//		WebElement element = (WebElement) jsExecutor.executeScript(javascript); 
//		element.sendKeys("ambavaleavinash999@gmail.com");
		
		String parent=driver.getWindowHandle();

		Set<String>childWindows=driver.getWindowHandles();
		
		Iterator<String> I1= childWindows.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());
		}
		}
		
		WebDriverWait wait=new WebDriverWait(driver,3000);
		WebElement enterMailId=driver.findElement(By.xpath("//input[@type='email' and @id='identifierId']"));
		wait.until(ExpectedConditions.visibilityOf(enterMailId));
//		WebElement enterMailId=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email' and @id='identifierId']")));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", enterMailId);
//		
		enterMailId.sendKeys("ambavaleavinash999@gmail.com");
		enterMailId.sendKeys(Keys.ENTER);
//		
		
		
	}
}
