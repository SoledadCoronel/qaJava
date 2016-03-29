package go5.automation.espacios;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CrearEspacioBasicUser  {
	
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
    capability.setCapability("name", "Crear Espacio como Usuario Basico");
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
		
 /*public boolean IsTestElementPresent( WebDriver driver)
 {
     try
     {
         driver.findElement(By.id("Test"));
         return true;
     }
     catch (NoSuchElementException)
     {
         return false;
     }
 }
 */
 
 
 
 @Test
	
	public void crearEspacio() throws Exception { 

	 //Login
		driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
		driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda+022@gointegro.com");
 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
 		 driver.findElement(By.cssSelector(".session .primary")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        		
		
				
		
	        
		 Reporter.log(" Creando un espacio como user admin de espacios");
		 
		// Go to hamburguesita
			driver.findElement(By.cssSelector(".menu")).click();
	
			
			//Ir a espacios
			driver.findElement(By.cssSelector("a[title='Ir a listar espacios']")).click();
			Reporter.log("Abriendo espacios como usuario basico");
				
			
		    //Chequear que no este el elemento para Crear Espacio
			
		      
		      driver.findElement(By.cssSelector(".title .primary")).click();
		      
		    
	
	}	
	
	
		
     }

