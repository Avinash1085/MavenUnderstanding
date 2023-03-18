import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class SimpleTest {
  	
  	WebDriver driver;
  	
  	@DataProvider(name = "test-data")
  	public Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"Avinash Ambavale"},{"Automation"},{"T20 WorldCup"}
        	};
  	}
  	
  	@BeforeMethod
  	  public void setUp() throws Exception {
        	 
        	  System.out.println("Start test");
        	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\chromedriver.exe");
        	  driver = new ChromeDriver();
        	  String url = "https://www.google.com";
        	  driver.get(url);
        	  driver.manage().window().maximize();
        	//Call take screenshot function
        	SimpleTest.takeSnapShot(driver, "c://test.png") ; 
        	 
  	  }
  	//Passing the dataProvider to the test method through @Test annotation
  	@Test(dataProvider ="test-data")
  	public void search(String keyWord){
        	WebElement txtBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        	  txtBox.sendKeys(keyWord);
        	  Reporter.log("Keyword entered is : " +keyWord);
        	  txtBox.sendKeys(Keys.ENTER);
//          	  WebElement imageClick=driver.findElement(By.xpath("//a[@href='/search?q=Automation&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjQmL7H6_XxAhXzzDgGHcW0AxkQ_AUoAnoECAIQBA']"));
//				  													  href="/search?q=Automation&source=lnms&tbm=isch&sa=X&ved=2ahUKEwisvrjA7PXxAhV1zDgGHXRrABkQ_AUoAnoECAIQBA"
        	  WebElement imageClick=driver.findElement(By.xpath("//a[contains(text(),'Images')]"));
                  	  imageClick.click();

        	  Reporter.log("Search results are displayed.");
        	  

  	}
  	/*@Test
  	public void click_ImageTab()
  	{

  	}*/
  	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
  		//Convert web driver object to TakeScreenshot
  		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
  		//Call getScreenshotAs method to create image file
  		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
  		//Move image file to new destination
  		File DestFile=new File(fileWithPath);
  		//Copy file at destination
  		FileUtils.copyFile(SrcFile, DestFile);
  		}
  	@AfterMethod
  	public void burnDown(){
//        	driver.quit();
  		
  	}
 
}