package go5.automation.personas;



import go5.automation.TestSuite;
import go5.pageObjects.PersonasPage;
import go5.pageObjects.ProfilePage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AddUserAllFieldsTest extends TestSuite{

	PersonasPage personas=null;
    ProfilePage profile =null;
	

		 @BeforeTest // call function to open the browser and login 
		 public void setup () throws Exception{
		this.setUpMaven();
		
		   
		 }
		
		 @AfterTest // call function to close browser 
			
			public void teardown(){
				closeBrowser();
			}

	
		

	@Test
	public void addUserAdmin() throws Exception{
		 org.apache.log4j.BasicConfigurator.configure();
		
		 Random numero= new Random();
	     personas= new PersonasPage(driver);
	     profile = new ProfilePage(driver);
	     js=  (JavascriptExecutor) driver;
		 
		 // Go to the configuration
		   this.goToConfiguration();
		   this.goToMenu();
	       Thread.sleep(1000);
		   // Go to Manage people
	        
	        personas.goToPersonas();
	         Thread.sleep(2000);
	     	  this.click(crearUser);
	         Thread.sleep(3000);
	         personas.setEstadoDesactivado();
		        
	        personas.setRandomUserName();
	        personas.setRandomLastName();
	        personas.setRandomEmail();
	        personas.selectRol();
	        
	         profile.agrandarForm();
	         log.info("Seteando un grupo");
	         personas.setGrupo();
	         profile.agregarDatosLaborales();
	         profile.agregarDatosPersonales();
	         profile.agregarTelefono();
	         profile.agregarRedesSociales();
	         js.executeScript("scroll(0, 250);");
	         Thread.sleep(3000);
	         log.info("Grabando el usuario");
	           personas.grabarUsuarioSinInvite();
	        
		    	        
		   
		    
		    
		}
}
