package go5.automation.profile;


import go5.automation.TestSuite;
import go5.pageObjects.ProfilePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class CargarFotoProfile extends TestSuite {
	
	 ProfilePage profile =null;
   

 @AfterClass // call function to close browser 
	
	public void teardown(){
	this.quitBrowser();
	}
		
	@Test(testName="Cambiar la foto de perfil del usuario")
	
	public void setUpPictureProfile() throws Exception { 
	
		 profile = new ProfilePage(driver);  
		
		
		// Go to the user menu
		
		
		this.goToMenu();
		
		this.goToMenuUsuario();
		profile.goToProfile();
		
		Thread.sleep(2000);
		profile.cancelarSubirFoto();
		Thread.sleep(2000);
		profile.cargarFoto();
	      }	
			
	}	
	
			
    

