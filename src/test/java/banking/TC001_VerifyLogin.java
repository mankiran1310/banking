package banking;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TC001_VerifyLogin {
	
	WebDriver driver;
	
	@BeforeMethod
	  public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/buneetchandhok/Desktop/Testing/driver/chromedriver");
		driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	
	
	@Test
  public void verifylogin() {
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		String expectedTitle=driver.getTitle();
		System.out.println("Expected title" + expectedTitle);
		String actualTitle="Zero - Account Summary";
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
  }
  

  @AfterMethod
  public void tearDown() {
	  
	  
	  driver.close();
  }

}
