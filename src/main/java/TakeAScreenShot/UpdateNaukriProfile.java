package TakeAScreenShot;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UpdateNaukriProfile 
{
	
	@Test
	public void profileUpdate() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		String url="https://www.naukri.com";
		driver.get(url);
		driver.manage().window().maximize();
		
//		WebElement JobSeekersLink=driver.findElement(By.xpath("//a[@target='_blank' and contains(text(),\"Naukri.com - Jobseeker's Login: Search the Best Jobs available in …\") and @onclick=\"null;return false;\"]"));
//		JobSeekersLink.click();
		
		String ParentPage=driver.getWindowHandle();
		
		Set<String> multipleWindows=driver.getWindowHandles();
		
		ArrayList<String> tabs=new ArrayList(multipleWindows); //converted Set into ArrayList
		
		int size=tabs.size();
		
		for(int i=0;i<size;i++)
		{
			if(!ParentPage.equalsIgnoreCase(tabs.get(i)))
			{
			driver.switchTo().window(tabs.get(i));
			driver.close();
			}
		}
		driver.switchTo().window(ParentPage);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Later']")));
		driver.findElement(By.xpath("//span[text()='Later']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Login']")));
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@type='text' or @placeholder='Enter your active Email ID / Username']/following-sibling::div[contains(text(),'Please enter your Email ID / Username')]")));
		WebElement UserNameText=driver.findElement(By.xpath("//input[@type='text' or"
				+ " @placeholder='Enter your active Email ID / Username']/following-sibling::div[contains(text(),'Please enter your Email ID / Username')]"));
		UserNameText.sendKeys("ambavaleavinash999@gmai.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("poojaavi@15");
		driver.findElement(By.xpath("//div[text()='My Naukri']")).click();
		
	}
	
}
