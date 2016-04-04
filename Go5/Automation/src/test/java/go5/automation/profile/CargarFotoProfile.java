package go5.automation.profile;


import go5.automation.TestSuite;

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



public class CargarFotoProfile extends TestSuite {
	
 
	
 @BeforeClass
  @Parameters(value={"browser","version","platform","url","build"})
  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
	this.setUpBrowserStack(browser, version, platform, url,build);
	
	
 }
   

 @AfterClass // call function to close browser 
	
	public void teardown(){
	this.quitBrowser();
	}
		
	@Test
	
	public void setUpPictureProfile() throws Exception { 
	
		     
		 
		 
		// Go to the user menu
		
		
		this.goToMenu();
		
		this.goToMenuUsuario();
		
				
			driver.findElement(By.cssSelector(".applications .users a[title='Usuario']")).click();
	
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

