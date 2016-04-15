package go5.automation.compania;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;




public class DatosGenerales {
	
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
	    capability.setCapability("name", "Datos de la Compania");
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    driver.get(url);
		 driver.manage().window().maximize();
		 WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".session label:nth-child(2) input")));
	  }  
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
		
	
	@Test
	
	public void companyDataPage() throws Exception { 
	
	
		 //Login
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".session .primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        		
		
         // Go to the configuration
 		driver.findElement(By.cssSelector(".applications .users .configuration")).click();

 		// Go to Company Data
 		
 		driver.findElement(By.cssSelector(".generaldata fieldset label:nth-child(1) input")).click();
 		driver.findElement(By.cssSelector(".generaldata fieldset label:nth-child(1) input")).clear();

 //Verify that company name can not be blank
 		Reporter.log("Verificar que el nombre de la compañia no pueda ser blanco");
 		driver.findElement(By.cssSelector("..generaldata fieldset label:nth-child(1) input")).sendKeys("    ");
 		String companyMessage = new String(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) span")).getText());
 		Reporter.log(companyMessage);
 		Assert.assertEquals(companyMessage, "El campo es requerido");
 	
 		
 
//Insert some value at company name	
 		
 		driver.findElement(By.cssSelector(".generaldata fieldset label:nth-child(1) input")).sendKeys("    ");
 		driver.findElement(By.cssSelector(".generaldata fieldset label:nth-child(1) input")).sendKeys("TestingCompanyForm");		
 		
 // Select all values the drop-down for Language
 		Reporter.log(" Verificar el drop-down de lenguajes");
 		Select selectLanguage = new Select(driver.findElement(By.cssSelector(".generaldata fieldset label:nth-child(3) select"))); 
 		
 		selectLanguage.selectByValue("pt");
 		selectLanguage.selectByValue("en");	
 		selectLanguage.selectByValue("es");
 		
 //Select a value from drop-down Timezone
 		Reporter.log(" Verificar el drop-down de timezone ");
 		Select selectTimeZone = new Select(driver.findElement(By.cssSelector(".generaldata fieldset label:nth-child(4) select")));
		
		   for(int i=1; i<5; i++){
	           selectTimeZone.selectByIndex(i);  
			 }
		
		selectTimeZone.selectByValue("America/Anchorage");

 		 		
 		Reporter.log(" Se setea el lenguaje en español y se le deja el nombre Automation1 a company name");
 		//Save changes to come back original values when the test has finished
 		driver.findElement(By.cssSelector("..generaldata fieldset label:nth-child(1) input")).clear();
 		//driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("    ");
 		driver.findElement(By.cssSelector(".generaldata fieldset label:nth-child(1) input")).sendKeys("Automation1");
 		selectLanguage.selectByValue("es");
 		selectTimeZone.selectByValue("America/Argentina/Buenos_Aires");
 		driver.findElement(By.cssSelector(".primary")).click();
 		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 		Reporter.log(" Caso de Datos de la Compañia finalizado");
 		
 		
 }
}	