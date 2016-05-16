package go5.automation.compania;




import go5.automation.TestSuite;





import go5.pageObjects.CompanyPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class BrandingAC extends TestSuite{

	
	   CompanyPage company=null;
	
	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
	 
	 @Test
		public void verifyColors() throws Exception{
			
		 company = new CompanyPage(driver);
	       
	
    // Go to the configuration
	         
		 this.goToConfiguration();
		 this.goToMenu();

  


	// Go to Company Design 
  
   // Primero hay que clickear en otro si no no anda!!Clickeo titles
		 this.goToTitles();
 
   
 
  
   // Clickeo en Disenio
		 
		 company.irADesign();
      	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	    			
		      company.restablecerInterfaz();
             company.verifyColors();
             Thread.sleep(4000);
             company.changeColorHeader();
             Thread.sleep(4000);
             company.changeColorContrast();
             Thread.sleep(4000);
	 }
    }
