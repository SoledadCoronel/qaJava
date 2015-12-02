package Go5.Automation;


import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class CreatePlatformTest extends SignUp{

	private String urlToken;
	private WebDriver driver= new FirefoxDriver();
	
	@BeforeClass // call function to open the browser and load url
	
	  public void openPlatform() throws Exception{
		
		 urlToken=this.signup();
		 driver.get(urlToken);
	    driver.manage().window().maximize();
	 }
	 
	   	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.close();
		}

	
	@Test (enabled= true)
	public void registration() throws Exception { 
		
			  
	 	   
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("CreateAccount_company")).clear();
		driver.findElement(By.id("CreateAccount_company")).sendKeys("Automation_Company");
		driver.findElement(By.id("CreateAccount_subdomain")).clear();
		driver.findElement(By.id("CreateAccount_subdomain")).sendKeys("Automation1");
		driver.findElement(By.id("CreateAccount_qty_employees_label")).sendKeys("0-50");
		driver.findElement(By.id("CreateAccount_name_label")).sendKeys("FakeName");
		driver.findElement(By.id("CreateAccount_last_name_label")).sendKeys("FakeSurname");
		driver.findElement(By.id("CreateAccount_password_label")).sendKeys("Fake1234");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("CreateAccount_timezone_label")).sendKeys("(GMT-10:00)Hawaii");
		driver.findElement(By.id("CreateAccount_terms_and_conditions")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("submit_button")).submit();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.id("SignupRequest_email")).sendKeys("sdsdsdsadsa");
		
		// The new URL is http.subcompany.pla.qa.go5.gointegro.net

	}
	
}
