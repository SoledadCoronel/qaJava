package go5.automation.signup;


import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class DataCompanyTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
	   openSiteLogin();
	   login("marina.touceda@gointegro.com","Auto1234");
	   
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}
		
	
	@Test(priority=1)
	public void ChangeNameCompanyToBlankValue(){
		log.info(" Validar que el campo compañia no puede ser blanco");
		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
		driver.findElement(By.id("companyName")).clear();
		driver.findElement(By.cssSelector(".primary")).click();
		//TBD::Need to validate the message for blank
		
	}
		
	
	@Test(priority=1)
	public void verifySubdomainCanNotBeChanged(){
		
		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	if (driver.findElement(By.id("companySubdomain")).isEnabled())
		log.info(" El campo de subdominio esta hablitado para el cambio, esto es un error!");
	else 
		log.info("El campo de subdominio no esta habilitado para cambiar");
		
		//TBD::Need to validate the message for blank
		
	}
	
}
