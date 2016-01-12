package Go5.Automation;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class Home {

	private WebDriver driver;
	Logger log = Logger.getLogger("automation");

	@BeforeClass
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "P1");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("browserstack.debug", "true");
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
	  }  
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	public void login(String sUsername,String sPassword) throws Exception { 
		 	
	 		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 		driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys(sUsername);
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys(sPassword);
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         
	  	}
	 
	 
	 
	 
	 @Test(priority=1)
	public void enterTheHomePage() throws Exception{
		 org.apache.log4j.BasicConfigurator.configure();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.login("marina.touceda@gointegro.com","Auto1234");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Login into GoIntegro and check the menu is present");
		driver.findElement(By.cssSelector(".menu")).isDisplayed();
		// Go to the user menu
		driver.findElement(By.cssSelector(".applications .users .user")).click();
		// Made logout
		driver.findElement(By.cssSelector(".applications .active .users .active .logout")).click();
	}
	
	
	@Test(priority=2)
	public void validateElementsAtHomePage() throws Exception { 
	  
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.login("marina.touceda@gointegro.com","Auto1234");
 	  	log.info("Validate elements present in the page");
 	  	driver.findElement(By.cssSelector(".menu")).isDisplayed();
 	  	log.info("Menu is present");
 	// Go to the user menu
 			driver.findElement(By.cssSelector(".applications .users .user")).click();
 			// Made logout
 			driver.findElement(By.cssSelector(".applications .active .users .active .logout")).click();
	}

	
}
