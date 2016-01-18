package go5.automation.profile;


import go5.automation.CommonFunctions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Profile {

	private WebDriver driver;
	

	@BeforeClass
	 @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "TestInDevolopment");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", true);
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	 
	  }  
	
	 	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
	
	@Test
	public void goToProfile() throws Exception { 
	
 	  	
 	 	driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
 	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		driver.findElement(By.id("signInIdentification")).clear();
 		driver.findElement(By.id("signInIdentification")).sendKeys("marinatouceda@gointegro.com");
 		driver.findElement(By.id("signInPassword")).clear();
 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
 		 driver.findElement(By.cssSelector(".primary")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        // driver.findElement(By.cssSelector(".applications .users .subusers li:nth-child(2)")).click();
         driver.findElement(By.cssSelector(".applications .users .subusers .user")).click();
	}
	
	
	
}

