package Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demotest {
	private WebDriver driver;
	private String baseurl;
	
  @BeforeMethod
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "/Users/buneetchandhok/Desktop/Testing/driver/chromedriver");
	  baseurl="http://zero.webappsecurity.com";
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.get(baseurl);
    }
  
  @Test
  public void verifyinvalidLogin() {
	  driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		
		driver.findElement(By.name("submit")).click();
		String expectedTitle=driver.getTitle();
		System.out.println("Expected title" + expectedTitle);
		String actualTitle="Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  
  @AfterMethod
  public void teardown(ITestResult testResult) throws IOException {
	  if(testResult.getStatus() == ITestResult.FAILURE) 
	  {
		  Utility.Screenshot.takeScreenshot(driver, testResult.getName());
	  }
	  driver.quit();
 }
}
  
