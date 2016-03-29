package go5.automation.profile;


import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CargarFotoProfile  {
	
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
    capability.setCapability("name", "CargarFotoProfile");
    driver = new RemoteWebDriver(
    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
    	      capability);
    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
    
    driver.get(url);
	 driver.manage().window().maximize();
	 WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("signInIdentification")));
  }  

 @AfterClass // call function to close browser 
	
	public void teardown(){
		driver.quit();
	}
		
	@Test
	
	public void setUpPictureProfile() throws Exception { 
	

		 //Login
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".session .primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        				
	        
		 
		 
		// Go to the user menu
			driver.findElement(By.cssSelector(".applications .users .user")).click();
	
			 Reporter.log(" Ir a perfil y cargar una foto en el profile");
			//Ir a ver perfil
			driver.findElement(By.cssSelector(".applications .users .subusers li a[title='Ir a ver perfil']")).click();
			
				
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		        WebElement element = driver.findElement(By.id("photoFilePicker"));
		        js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);
		     
		      
		      //Agarrar el elemento para cargar el file y pasarle el path 
		        
		        WebElement upload= driver.findElement(By.id("photoFilePicker"));
		       
		       
		        File file = new File("src/test/resources/Girasol.jpeg");
		        
		        Reporter.log(file.getAbsolutePath());
		        upload.sendKeys(file.getAbsolutePath());
		        Thread.sleep(1000);
		        
		       driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) .primary")).click();
		       Thread.sleep(1000);
		        //Para cancelar 
		      //   driver.findElement(By.cssSelector(".cutpictures .optional")).click();
		         
		       Reporter.log(" Foto cargada exitosamente");
		   
	
	
	
	}	
	
	
		
     }

