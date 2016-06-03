package go5.automation.profile;


import go5.automation.TestSuite;
import go5.pageObjects.ProfilePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ProfileVerifyDataAC extends TestSuite  {
	


ProfilePage profile = null;


 @AfterClass // call function to close browser 
	
	public void teardown(){
		driver.quit();
	}
		
	@Test
	
	public void verifyDataPofile() throws Exception { 
	
		
		 profile = new ProfilePage(driver);
		 
		
		
		 
		 
		// Go to the user menu
		  this.goToMenuUsuario();
		
	
			
			//Ir a ver perfil
		   profile.goToProfile();
		   Thread.sleep(1000);
		   
		   profile.verifyemaildisplayedAtHeader();
		   profile.verifyPhonesDisplayedAtHeader();
		   Thread.sleep(1000);
		   profile.goToTwitter();
		   
			 profile.goToFacebook();
		
			profile.goToSupervisor();
			
			
			
			
	}	   
		   
	}
	