package go5.automation.configuration;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;




public class CompanyDataTest {
	
	 private WebDriver driver;

	
	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url"})
	  public void setUp(String browser, String version, String platform,String url) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "GOIntegro");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", false);
	    capability.setCapability("name", "Company Data");
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
		
	
	@Test
	
	public void companyDataPage() throws Exception { 
	
		
	//Login
		
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
 		Reporter.log(companyMessage);
 		Assert.assertEquals(companyMessage, "El campo es requerido");
 	
 		
 
//Insert some value at company name	
 		
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("    ");
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("TestingCompanyForm");		
 		
 // Select all values the drop-down for Language
 		
 		Select selectLanguage = new Select(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(3) select"))); 
 		
 		selectLanguage.selectByValue("pt");
 		selectLanguage.selectByValue("en");	
 		selectLanguage.selectByValue("es");
 		
 //Select a value from drop-down Timezone
 		
 		Select selectTimeZone = new Select(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(4) select")));
		
		   for(int i=1; i<20; i++){
	           selectTimeZone.selectByIndex(i);  
			 }
		
		selectTimeZone.selectByValue("America/Anchorage");
 		
 //Verify that the language has been changed within the page
		
		selectLanguage.selectByValue("en");	
		
		//Save changes to verify that the text are being displayed in the selected language
 		
 		driver.findElement(By.cssSelector(".primary")).click();
 		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		
 		
 // Check text in English
 		String check= new String(driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).getText());
 		Assert.assertEquals("Design", check);
 		
 		
 		//Save changes to come back original values when the test has finished
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).clear();
 		//driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("    ");
 		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("Automation1");
 		selectLanguage.selectByValue("es");
 		selectTimeZone.selectByValue("America/Argentina/Buenos_Aires");
 		driver.findElement(By.cssSelector(".primary")).click();
 		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 		
 		
 }
}	