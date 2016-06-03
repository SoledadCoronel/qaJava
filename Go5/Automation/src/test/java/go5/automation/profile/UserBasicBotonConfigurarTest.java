package go5.automation.profile;



import go5.automation.TestSuite;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class UserBasicBotonConfigurarTest extends TestSuite{
	
		
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

	    		
        
	 Reporter.log("Loguearse  como user basic a un  y verificar que no este el boton de Configuracion");
 
		
	    // Verificar que no esta el boton de Configuracion
	 
	     try{
	    	  this.click(irAConfiguration);
	
	     }    
	    		 catch (Exception e) {

	    		     Reporter.log("No esta el boton Configuracion para el usuario basico");

	    		
	    		 }
         
	}	
		 
				
     }
