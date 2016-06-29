package go5.automation.signup;


import go5.pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;




public class ForgotPasswordTest extends ForgotPasswordAC{
	
		
	 @BeforeClass
	  public void setupMavenTest() throws Exception{
		 driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       this.openSite(urlSiteAutomation1);
	    
	        Reporter.log("Abriendo la aplicacion");
	 }
}
