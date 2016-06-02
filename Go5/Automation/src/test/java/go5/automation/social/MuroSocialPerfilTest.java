package go5.automation.social;

import org.testng.annotations.BeforeClass;




public class MuroSocialPerfilTest extends MuroSocialPerfilAC {
	
	
		
	
	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
	
}

