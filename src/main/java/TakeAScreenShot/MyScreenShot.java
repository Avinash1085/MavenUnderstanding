package TakeAScreenShot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import UtilityLibraryByAvinash.Utility;

public class MyScreenShot 
{

	@Test
	public void takeScreenShot() throws IOException
	{
		
		Calendar calendar = Calendar.getInstance();
		Date currentDateTime = calendar.getTime();
//		System.out.println(currentDateTime);
		
//		Date date = new Date();
//		System.out.println(date.toString());
		
		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); //formatted without space as file name will not take special chars
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss"); //formatted without space as file name will not take special chars
		String formattedDate = sdf.format(date1);
		String formattedDate1 = sdf1.format(date1);

		System.out.println("FormatedDate BySimpleDateFormat : "+formattedDate);
		System.out.println("FormatedDate BySimpleDateFormat : "+formattedDate1);

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://www.facebook.com");
	String title=driver.getTitle();
	System.out.println("Title showing on browser window is : "+title);
	
	String d1=formattedDate.toString();
	
	String ScreenShotName="BrowserLaunched_";
	ScreenShotName=ScreenShotName.concat(d1);
	
	System.out.println("Concatenated ScreenShotName : "+ScreenShotName);
	
	Utility.GenericCodeForTakeScreenShot(driver, ScreenShotName);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	driver.findElement(By.id("email")).sendKeys("ambavaleavinash999@gmail.com");
	
	//calling Utility class method to take screenshot
	ScreenShotName="UserNameField_";
	ScreenShotName=ScreenShotName.concat(d1);

	Utility.GenericCodeForTakeScreenShot(driver,ScreenShotName);
	
	driver.findElement(By.xpath(".//div/div/input [@type='password' and @id='pass']")).sendKeys("PoojaAvi@15");
	driver.findElement(By.xpath("//div[@class='_9lsa']")).click();
	
	//calling Utility class method to take screenshot
	ScreenShotName="PasswordField_";
	ScreenShotName=ScreenShotName.concat(d1);

	Utility.GenericCodeForTakeScreenShot(driver,ScreenShotName);

	driver.findElement(By.name("login")).click();
	
	//Here I am using code to take screen shot & same code I have used in utility class just to make that function re-usable
	TakesScreenshot ScreenShot=(TakesScreenshot)driver;
	File Source=ScreenShot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(Source, new File("./TestScreenShots/LoginButtonClick"+d1+".png"));
	
	String Parentwindow=driver.getWindowHandle();
	System.out.println("Parent window is : "+Parentwindow);
	
	Set<String> allOpenWindows=driver.getWindowHandles();
	System.out.println("Total Window : "+allOpenWindows.size());
	driver.findElement(By.xpath("//input[@tabindex='0' and @type='password']")).sendKeys("TestPassword");
	driver.findElement(By.xpath("//div[@class='_9lsa']")).click();
	
	ScreenShotName="ScreenOfRetypedPassword_";
	ScreenShotName=ScreenShotName.concat(d1);
	Utility.GenericCodeForTakeScreenShot(driver, ScreenShotName);
	
//	driver.navigate().to("https:www.google.com");
//	driver.navigate().back();
//	driver.navigate().forward();
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

//	No need of below code which switches from one window to another as in this case there is no multiple windows present
//	for(String child:allOpenWindows)
//	{
//		if(!Parentwindow.equalsIgnoreCase(child))
//		{
//			driver.switchTo().window(child);
//			driver.findElement(By.xpath("//input[@tabindex='0' and @type='password']")).sendKeys("TestPassword");
//		}
//	}
	
//	driver.quit();
	}
}
