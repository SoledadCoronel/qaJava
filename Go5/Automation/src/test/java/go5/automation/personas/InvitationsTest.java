package go5.automation.personas;


import org.testng.annotations.BeforeClass;



public class InvitationsTest extends InvitationsAC{

		
	 @BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		 this.setUpMaven();
	 }
	
		
}
