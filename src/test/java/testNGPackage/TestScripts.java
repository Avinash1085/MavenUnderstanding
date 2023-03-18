package testNGPackage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ReadExcelFileData.ExcelDataProvider;
import UtilityLibraryByAvinash.Utility;
import junit.framework.Assert;

public class TestScripts extends BaseClass{

//	private static final String ScreenShotName = null;
	ExcelDataProvider ex=new ExcelDataProvider("C:\\Users\\Avinash\\Documents\\SeleniumTestData.xlsx", "Number");	
	
	/*
	Reporter reporter=new Reporter();
	  @Test(description="This test is to enter the text in search box and then click enter using keys event",priority=1)
	  public void searchBoxTest() throws InterruptedException
	  {
		  JavascriptExecutor js = (JavascriptExecutor)driver;

		  Actions action=new Actions(driver);
		  By cssSelector=By.cssSelector(".gLFyf");  
		  WebElement searchbox=driver.findElement(cssSelector);
		  searchbox.sendKeys("Avinash Ambavale");
		  String enteredText=searchbox.getText();
		  System.out.println("Text Searched is : "+enteredText);
		  reporter.log("You have searched for "+enteredText);
		  js.executeScript("document.getElementById('SIvCob').click();");
		  searchbox.sendKeys(Keys.ENTER);
		  Thread.sleep(3000);
	  }
	  
//	  @Test(priority=2)
//	  public void javascriptExecuterTest()
//	  {
//		  JavascriptExecutor js1 = (JavascriptExecutor)driver;
////	--	  js1.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
//		  js1.executeScript("document.getElementByName('btnK').value='Google Search';");
//		  js1.executeScript("document.getElementByName('btnK').click();");
//
//	  }
	  

	  @Test(description="This test wil Clear the searched Text from search bar",dependsOnMethods="searchBoxTest")
	  public void clearSearchedText()
	  {
		  By clearText=By.xpath("//span[@aria-label='Clear']");
		  WebElement clearTextClick=driver.findElement(clearText);
		  clearTextClick.click();
		  reporter.log("Searched Text has been Cleared");
	  }
	  @Test(description="This test is to Scroll down on webpage",dependsOnMethods="clearSearchedText")
	  public void scrollDown()
	  {
		  reporter.log("Started scrolling down on the webpage");
		  WebElement scrolltoAvinashText=driver.findElement(By.xpath("//div/a/h3[text()='avinash ambavale - YouTube']"));
		  JavascriptExecutor j=(JavascriptExecutor)driver;
		  j.executeScript("arguments[0].scrollIntoView();", scrolltoAvinashText);
		  reporter.log("You scrolled down on the webpage");
	  }
	  @Test(description="This test is for searching New Text",dependsOnMethods="scrollDown")
	  public void SearchNewText() throws InterruptedException
	  {
		  Thread.sleep(1000);
		  By searchbox2_1 =By.xpath("//input[@class='gLFyf gsfi']");
		  WebElement searchbox1=driver.findElement(searchbox2_1);

		  searchbox1.sendKeys("Rupesh More");
		  Thread.sleep(2000);
		  Actions action1= new Actions(driver);
		  List<WebElement> autoOption=driver.findElements(By.xpath("//div[@class='wM6W7d']"));
//		  List<WebElement> autoOption=driver.findElements(By.xpath("//div[@class='wM6W7d']/span[contains(text(),'rupesh more')]"));
		  WebElement rupeshText=driver.findElement(By.xpath("//div[@class='wM6W7d']/span[contains(text(),'rupesh more')]"));
		  
		  reporter.log("The execution is done for searching and selecting the text");
		  for(WebElement ele:autoOption)
		  {
			  System.out.println(ele.getText());
			  action1.sendKeys(Keys.DOWN).perform();
			  if(ele.getText().equalsIgnoreCase("rupesh more linkedin"))
			  {
				  action1.sendKeys(Keys.RETURN);
			  }
		  }

		  //		  searchbox1.sendKeys(Keys.ARROW_DOWN);
//		  action1.sendKeys(Keys.ARROW_DOWN).perform();
//		  action1.sendKeys(Keys.DOWN).perform();
//		  Thread.sleep(2000);
//		  action1.sendKeys(Keys.DOWN).perform();
//		  String s1;
		  
		//*[@id="rso"]/div[6]/div/div/div/div[1]/a/h3
		 
//		  JavascriptExecutor js = (JavascriptExecutor)driver;
//	      js.executeScript("window.scrollBy(0,800)");
//		  int cnt=0;
//		  if(cnt<=3)
//		  {
//			    action1.sendKeys(Keys.DOWN).perform();
//			  if(cnt==3)
//			  {
//			    action1.sendKeys(Keys.RETURN);
//			  }
//			  else
//				    action1.sendKeys(Keys.DOWN).perform();
//
//			  cnt++;
//		  }
//		  
//		  do {
//			    action.sendKeys(Keys.DOWN).perform();
//			    action.sendKeys(Keys.RETURN);
//			    Thread.sleep(2000);
//			  
//			} while (!rupeshText.isEnabled());
		  
//		  Select select=new Select(driver.findElement(searchbox2_1));
//		  List<WebElement> selectOptions=select.getOptions();
//		  for(WebElement e:selectOptions)
//		  {
//			  e.getText();
//		  }
//		  select.selectByIndex(4);
	  }
	  */
	
		@DataProvider(name="test-Data")
		public Object[][] getData() throws IOException
		{
			String excelFilePath="C:\\Users\\Avinash\\Documents\\SeleniumTestData.xlsx";
			Object data[][]=ex.testData(excelFilePath,"Number");
			return data;
		}
	  
		@Test(dataProvider="test-Data")
		public void readExcelDataFromSheet(String DataToPrint)
		{
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss"); //formatted without space as file name will not take special chars
			String formattedDate = sdf.format(date);
			String d1=formattedDate.toString();
			String ScreenShotName="ExecutionDate_";
			ScreenShotName=ScreenShotName.concat(d1);
			
			WebElement SearchText=driver.findElement(By.xpath("//*[@name='q']"));
//			double d=Double.parseDouble(SrNo);
			SearchText.sendKeys(DataToPrint);
			SearchText.sendKeys(Keys.ENTER);
			String driverTitle=driver.getTitle();
//			SearchText.clear(); //was failing with stale element exception as element was not finding after ente is pressed.
			System.out.println("Title of WebPage is : "+driverTitle);
			String S=driverTitle;
			System.out.println("Value of S before Trimmig "+S);
			String S1=S.substring(0,DataToPrint.length());
			System.out.println("Value of S after Trimmig "+S1);
			WebElement SearchedText=driver.findElement(By.xpath("//*[@name='q' and @class='gLFyf gsfi']"));
			System.out.println("TextSearched on webpage "+SearchedText.getText());
			System.out.println("Names Mentioned in Excel Sheet are : "+DataToPrint);
			Assert.assertEquals(S1,DataToPrint);
			Utility.GenericCodeForTakeScreenShot(driver,ScreenShotName);
		}
//		public static String dateformatter(String ScreenShotName)
//		{
//			Date date = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss"); //formatted without space as file name will not take special chars
//			String formattedDate = sdf.format(date);
//			String d1=formattedDate.toString();
//			ScreenShotName="abc";
//			ScreenShotName=ScreenShotName.concat(d1);
//		}
}

	  

