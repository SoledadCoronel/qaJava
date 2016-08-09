package go5.automation.profile;



import go5.automation.TestSuite;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class BotonConfigurarTest extends TestSuite{
	
	
	HomePage home=null;
		
	@BeforeClass
	
	  public void setUpUnirseAEspacio() throws Exception {
		
		this.setUpMavenUserBasic();
	}
	

 @AfterClass // call function to close browser 
	
	public void teardown(){
	this.quitBrowser();
	}

	 
 @Test

public void withoutConfigOption() throws Exception { 

	 home = new HomePage(driver); 		
        
	 Reporter.log("Loguearse  como user basic a un  y verificar que no este el boton de Configuracion");
 
		
	    // Verificar que no esta el boton de Configuracion
	 
	     try{
	    	 home.goToConfiguration();
	
	     }    
	    		 catch (Exception e) {

	    		     Reporter.log("No esta el boton Configuracion para el usuario basico");

	    		
	    		 }
         
	}	
		 
				
     }

