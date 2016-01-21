package go5.automation.configuration;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Configuration {
	
	 private WebDriver driver;

	
	 @BeforeClass
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "GoIntegro");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", false);
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	 
	  }  
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
		
	
	@Test
	
	public void editCompany() throws Exception { 
	
		driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("signInIdentification")).clear();
 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
 		driver.findElement(By.id("signInPassword")).clear();
 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
 		 driver.findElement(By.cssSelector(".primary")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         // Go to the configuration
 		driver.findElement(By.cssSelector(".applications .users .configuration")).click();

 		// Go to Company Data
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).click();
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).clear();

 //Verify that company name can not be blank
 		
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("    ");
 		String companyMessage = new String(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) span")).getText());
 		System.out.println(companyMessage);
 		Assert.assertEquals(companyMessage, "Nombre no puede estar vacío");
 		
 //Insert some value at company name	
 		
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("Test3333332222222222222");
 		
 // Select all values the drop-down for Language
 		
 		Select selectLanguage = new Select(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(3) select"))); 
 		
 		selectLanguage.selectByValue("pt");
 		selectLanguage.selectByValue("en");	
 		selectLanguage.selectByValue("es");
 		
 //Select a value from drop-down Timezone
 		
 		Select selectTimeZone = new Select(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(4) select")));
 		selectTimeZone.selectByValue("America/Anchorage");
 		
 //Save changes
 		
 		driver.findElement(By.cssSelector(".primary")).click();
 		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 }
}	