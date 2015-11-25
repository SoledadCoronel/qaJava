package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;




public class Login extends CommonFunctions{
 

	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteLogin();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}
	
	@Test	
	@Parameters({"sUsername","sPassword"})
	
	public void login(String sUsername,String sPassword) throws Exception { 
	
		
		driver.findElement(By.id("signInIdentification")).sendKeys(sUsername);
		driver.findElement(By.id("signInPassword")).sendKeys(sPassword);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".primary")).click();
 
	}

	
}
