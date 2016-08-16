package go5.automation.compania;




import go5.pageObjects.LoginPage;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BrandingFotosBS {

	 LoginPage login =null;
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
	     capability.setCapability("name", "Branding pictures");
	    
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    
	  ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
	    driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 login= new LoginPage(driver);
		 login.loginToGo("marina.touceda@gointegro.com","Auto1234");
	 }
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	
	 @Test
		public void brandingPictures() throws InterruptedException{
			

		 
	        		
	     
	
  
    

	// Go to Company Design 
   Reporter.log("Abriendo la pagina de diseño de la plataforma" );
   // Primero hay que clickear en otro si no no anda!!Clickeo titles
   driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
   
   Reporter.log(driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).getText());
  
   // Clickeo en Disenio
   
   driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
   	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 // Vuelvo a clikear en Diseño
	          
		       // Primero hay que clickear en otro si no no anda!!Clickeo titles
			        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
		          
		          driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
			        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);     
		       
		        			
		       //Restablecer interfaz 
			        Reporter.log("Restableciendo interfaz de usuario");
                    driver.findElement(By.cssSelector("div .container .design fieldset:nth-child(5) a")).click();
                    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                  
                    //Click en el popup de restorear
                    
                    driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) .primary")).click();
                    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
                    driver.findElement(By.cssSelector(".primary")).click(); 
              
	        
		

        //Load Logo Picture
    
 	   

 		// Go to Company Design 
        Reporter.log("Cargando una foto para el logo de la empresa" );
        // Primero hay que clickear en otro si no no anda!!Clickeo titles
        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
        Reporter.log("El nombre de la pagina es :");
        Reporter.log(driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).getText());
        // Clickeo en Disenio
        
        driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
          		
		
                        
       
     //function to make visible the button logoFilePicker, as it is set to class "off"
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("logoFilePicker"));
        js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);
      
      //Agarrar el elemento para cargar el file y pasarle el path 
        
        WebElement upload= driver.findElement(By.id("logoFilePicker"));
       
       
        File file = new File("src/test/resources/Girasol.jpeg");
        
        Reporter.log(file.getAbsolutePath());
        upload.sendKeys(file.getAbsolutePath());
        Thread.sleep(1000);
        
       driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) .primary")).click();
       Thread.sleep(2000);
       Reporter.log("Foto cargada exitosamente");
        
         
       
    //Save changes
          driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
          driver.findElement(By.cssSelector(".primary")).click();
    	
	
          WebElement disenioavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBgFilePicker")));
      // Load background file
        Reporter.log("Cargando foto para el backgroud de la plataforma");
     
      //function to make visible the button loginBgFilePicker, as it is set to class "off"
	        
	        JavascriptExecutor js2 = (JavascriptExecutor) driver;
	        WebElement elementbackground = driver.findElement(By.id("loginBgFilePicker"));
	        js2.executeScript("arguments[0].setAttribute('style', 'display:block')",elementbackground);
	      
	        //Agarrar el elemento para cargar el file y pasarle el path 
	          
	        //Agarrar el elemento para cargar el file y pasarle el path 
	        	        
	       
	        File filebackground = new File("src/test/resources/Background.jpg");
	        
	        Reporter.log(filebackground.getAbsolutePath());
	        elementbackground.sendKeys(filebackground.getAbsolutePath());
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	            
	      	       
	    //Save changes on the page
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
	          driver.findElement(By.cssSelector(".primary")).click(); 
	          Reporter.log("Foto para el backgroud cargada exitosamente");

	 }
	 
}
