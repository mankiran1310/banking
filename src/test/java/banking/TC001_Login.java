package banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_Login {

	WebDriver driver;
	
		@BeforeMethod
		public void setup(){
		System.setProperty("webdriver.chrome.driver", "/Users/buneetchandhok/Desktop/Testing/driver/chromedriver");
		driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().window().maximize();
		}

		@Test
		public void login() {
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		
		driver.findElement(By.name("submit")).click();
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
			
		}
}

