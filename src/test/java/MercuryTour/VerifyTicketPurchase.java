package MercuryTour;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class VerifyTicketPurchase {
 
	WebDriver driver;
	
	@BeforeMethod
	  public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/buneetchandhok/Desktop/Testing/driver/chromedriver");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Test
	
  public void verifyTicketPurchase() {
		
		    driver.findElement(By.name("login")).click();
			driver.findElement(By.name("userName")).sendKeys("tutorial");
			driver.findElement(By.name("password")).sendKeys("tutorial");
			driver.findElement(By.name("login")).click();
			
			
			//driver.findElement(By.xpath("//input[@value='oneway']")).click();
			driver.findElement(By.cssSelector("input[value='oneway']")).click();
			//store the dropdown in webelement
			WebElement passCount=driver.findElement(By.xpath("//select[@name='passcount']"));
			//create object of select class
			Select sel=new Select(passCount);
			//select no of passengers; Index starts from 0
			sel.selectByIndex(1);
			
			WebElement fromPort=driver.findElement(By.name("fromPort"));
			Select sel1=new Select(fromPort);
			sel1.selectByValue("New York");
			
			
			
			
			
			
  }
 
  
  
  

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
