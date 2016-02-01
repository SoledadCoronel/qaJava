package go5.automation.home;


import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class HomeTest extends CommonFunctions{


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
	public void EnterTheHomePage(){
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Login into GoIntegro and check the menu is present");
		
		
		  // Go to the configuration
        
				driver.findElement(By.cssSelector(".applications .users .configuration")).click();
		       driver.findElement(By.cssSelector(".menu")).click();
			
			// Go to  Users Menu
		        Reporter.log("Abriendo administar personas" );  
		        //driver.findElement(By.cssSelector(".usermenu")).click();
		        Reporter.log("Abriendo titulos");
		        
		     // Go to Company Design 
		        Reporter.log("Abriendo la pagina de diseño de la plataforma" );
		        // Primero hay que clickear en otro si no no anda!!Clickeo titles
		        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
		        
		        Reporter.log(driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).getText());
		        // Clickeo en Disenio
		        
		        driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
		        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		        
		     
		        //Verify that the image selected is being displayed at the header
		         
		       
		         
		          WebElement upload= driver.findElement(By.cssSelector(".brandinterfaces"));
		          upload.sendKeys("/home/marinatouceda/Documentos/Girasol.jpg");

		       
		        //Save changes
		          driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 
		          driver.findElement(By.cssSelector(".primary")).click();
		    	
		
	}
	
	}

