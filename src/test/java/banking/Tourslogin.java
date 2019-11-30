package banking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Tourslogin {
	
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
  public void tourLogin() {
	    driver.findElement(By.name("login")).click();
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		String expectedTitle=driver.getTitle();
		System.out.println("Expected title" + expectedTitle);
		String actualTitle="Find a Flight: Mercury Tours:";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	
  }
  

  @AfterMethod
  public void tearDown() {
	  driver.close();
  }

}
