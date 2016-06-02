package go5.automation.signup;


import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;



public class CreatePlatformToBeUpdated extends SignUp{

	private String urlToken;
	//private WebDriver driver= new FirefoxDriver();
	
	@BeforeClass // call function to open the browser and load url
	
	  public void openPlatform() throws Exception{
		
		 urlToken=this.signup();
		 driver.get(urlToken);
	    driver.manage().window().maximize();
	 }
	 
	   	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	/* @Test(priority=1)
		public void validateFieldsCreatePlatform() throws Exception { 
			
				  
		 	   
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.id("CreateAccount_company")).clear();
			driver.findElement(By.id("CreateAccount_company")).sendKeys("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456");
			String errorMessage= new String (driver.findElement(By.cssSelector(" .error-message-CreateAccount_company")).getText());
			log.info(errorMessage);
			Assert.assertEquals(errorMessage, "El campo no debe estar vacio y no debe exceder los 80 caracteres.");
			driver.findElement(By.id("CreateAccount_subdomain")).clear();
			driver.findElement(By.id("CreateAccount_subdomain")).sendKeys("??????????????????????????????????????????????????????????????????");
			String error2= new String(driver.findElement(By.cssSelector(".error-message-CreateAccount_subdomain ")).getText());
			log.info(error2);
			Assert.assertEquals(error2, "El subdominio ingresado es invalido");
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
	 }
	 */
	@Test (priority=1)
	public void registration() throws Exception { 
		
			  
	 	   
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("CreateAccount_company")).clear();
		driver.findElement(By.id("CreateAccount_company")).sendKeys("Automation_Company");
		driver.findElement(By.id("CreateAccount_subdomain")).clear();
		driver.findElement(By.id("CreateAccount_subdomain")).sendKeys("Automation3");
		driver.findElement(By.id("CreateAccount_qty_employees_label")).sendKeys("0-50");
		driver.findElement(By.id("CreateAccount_name_label")).sendKeys("FakeName");
		driver.findElement(By.id("CreateAccount_last_name_label")).sendKeys("FakeSurname");
		driver.findElement(By.id("CreateAccount_password_label")).sendKeys("Fake1234");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("CreateAccount_timezone_label")).sendKeys("(GMT-10:00)Hawaii");
		driver.findElement(By.id("CreateAccount_terms_and_conditions")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.id("submit_button")).submit();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.id("SignupRequest_email")).sendKeys("sdsdsdsadsa");
		
		// The new URL is http.subcompany.pla.qa.go5.gointegro.net

	}
	
}
