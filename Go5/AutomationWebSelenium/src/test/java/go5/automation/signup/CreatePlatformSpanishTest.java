package go5.automation.signup;

import org.testng.annotations.BeforeTest;



public class CreatePlatformSpanishTest extends CreatePlatformSpanishAC{

	
	 @BeforeTest // call function to open the browser and load url
	 public void setup () throws Exception{
		 	
		 	this.setUpMavenSignup();
	 }
}
	