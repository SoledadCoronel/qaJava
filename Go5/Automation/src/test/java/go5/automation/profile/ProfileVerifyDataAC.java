package go5.automation.profile;


import go5.automation.TestSuite;
import go5.pageObjects.ProfilePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ProfileVerifyDataAC extends TestSuite  {
	


ProfilePage profile = null;

@BeforeTest // call function to open the browser and login 
public void setup () throws Exception{
	 this.setUpMaven();
}


 @AfterClass // call function to close browser 
	
	public void teardown(){
		driver.quit();
	}
		
	@Test
	
	public void editProfile() throws Exception { 
	
		
		 profile = new ProfilePage(driver);
		 
		
		
		 
		 
		// Go to the user menu
		  this.goToMenuUsuario();
		//	driver.findElement(By.cssSelector(".applications .users .user")).click();
	
			
			//Ir a ver perfil
		   profile.goToProfile();
		   Thread.sleep(1000);
		
			profile.goToSupervisor();
			
			
			
	}	   
		   
	}
	
