package UtilityLibraryByAvinash;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility 
{
	public static void GenericCodeForTakeScreenShot(WebDriver driver,String ScreenShotName)
	//Passing parameters i.e Webdriver and its instance driver to takeScreenshot method because while typecasting the
	//TakesScreenshot interface with driver object it was giving exception
	{
		try 
		{

//			Date date = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//			String formattedDate = sdf.format(date);
//			System.out.println(formattedDate);
			
			Date date1 = new Date();
//			System.out.println(date1.toString());
//			ScreenShotName=ScreenShotName+date1.toString();
			
			TakesScreenshot ScreenShot=(TakesScreenshot)driver;
			File Source=ScreenShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File("./TestScreenShots/"+ScreenShotName+".png"));
			FileUtils.copyFile(Source, new File("C:\\Users\\Avinash\\Documents\\ScreenShotsTakenBySeleniumAutomation\\"+ScreenShotName+".png"));

			System.out.println("ScreenShot Of "+"'"+ScreenShotName+"'"+" Taken Successfully...");
		}
		catch (Exception e) 
		{
			System.out.println("Unable to Take Screenshot : "+e.getMessage());
		} 

	}

}
