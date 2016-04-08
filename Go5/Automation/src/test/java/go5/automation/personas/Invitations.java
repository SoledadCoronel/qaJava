package go5.automation.personas;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;



public class Invitations extends InvitationsTest{


	
	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build);
		System.out.println(" Setup de BS");
		
	 }	
	 
	  
		public void invitattionBS() throws Exception{
		 this.invitattionResendwithAnAdminUser();
	 }

		

		 @AfterClass // call function to close browser 
			
			public void teardown(){
			this.quitBrowser();
			}
}
	   

	
