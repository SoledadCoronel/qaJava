package go5.automation.signup;


import go5.automation.CommonFunctions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class LoginTest extends CommonFunctions {

	private WebDriver driver= new FirefoxDriver();
	Logger log = Logger.getLogger("automation");

	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url"})
	  public void setUp(String browser, String version, String platform,String url) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "Inprogress");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", false);
	    capability.setCapability("name", "Login Test");
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  }  
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	@Test(priority=3)
	public void validatePage(){
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Validating login page");
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".link"));
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("El login button esta enabled");
		}
		else
				log.info("El login button esta disbled");
		
			
	}
	@Test(priority=4)
	public void testProperLogin() throws Exception { 
	
 	  	log.info("Probar el  login");
		this.login("marina.touceda@gointegro.com","Auto1234");
		log.info("Login successfull");
 
	}
	
	@Test(priority=1)
	public void testLoginWithBlankUser() throws Exception { 
	
		
		 org.apache.log4j.BasicConfigurator.configure();
 	  	log.info("Probar el login con el campo user vacio ");
		this.login("  ","Auto1234");
		// Verify if the button is disabled 
		
		
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("El login button esta enabled");
		}
		else
				log.info("El login button esta disabled");
	
		log.info("El login fallo porque el campo usuario estaba en blanco");
	}
	
	@Test(priority=2)
	public void testLoginWithBlankPassword() throws Exception { 
	
		org.apache.log4j.BasicConfigurator.configure();
 	  	log.info("Probar el login con  blank password");
		this.login("marina.touceda@gointegro.com"," ");
		// Verify if the button is disabled 
		
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("El login button esta enabled");
		}
		else
				log.info("El login button esta disabled");
	
		log.info("El login fallo porque el password estaba vacio");
	}
}
