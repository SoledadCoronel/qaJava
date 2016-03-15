package go5.automation.compania;




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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Branding {


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
	    capability.setCapability("name", "Company Design");
	    
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
		public void verifyColors() throws InterruptedException{
			
			
			//Login
			
			driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	       
	
    // Go to the configuration
	         
	driver.findElement(By.cssSelector(".applications .users .configuration")).click();
   driver.findElement(By.cssSelector(".menu")).click();
  


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
                    driver.findElement(By.cssSelector("div .container .design fieldset:nth-child(5) a")).click();
                    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                   //Click en el popup de restorear
                    driver.findElement(By.cssSelector(".mconfirmation .primary")).click();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
               
	
     
       // Verify list of colors in branding
                    Reporter.log(" Veirificando que esten todos los colores disponibles");
       
        Assert.assertEquals("white",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(1)")).getText()));
     
        Assert.assertEquals("lightgrey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(2)")).getText()));
        
        Assert.assertEquals("grey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(3)")).getText()));
       
        Assert.assertEquals("darkgrey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(4)")).getText()));
      
        Assert.assertEquals("black",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(5)")).getText()));
       
        Assert.assertEquals("yellow",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(6)")).getText()));
        
        Assert.assertEquals("orange",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(7)")).getText()));
        
        Assert.assertEquals("red",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(8)")).getText()));
        
        Assert.assertEquals("green",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(9)")).getText()));
        
        Assert.assertEquals("skyblue",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10)")).getText()));
	       
       
    	//Change header color
    		
    	
           // Clickeo en Disenio
        Reporter.log(" Cambiando el color del header");
           
           driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        
        
        
	 // Verify that the selected color has been changed in the header
        
           Reporter.log(" Verificando que el color del header se haya cambiado");
           
        //Select black colour
        driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10)")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      String colorSelected = new String (driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10) a")).getCssValue("background-color"));
      Reporter.log(colorSelected);
    
      //Save changes for colour
      driver.findElement(By.cssSelector(".primary")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
      
      Thread.sleep(1000);
      String colorHeader = new String(driver.findElement(By.tagName("header")).getCssValue("background-color"));
      Reporter.log(colorHeader);
   
      //Compare the header color against the selected, converted to hexadecimal
      
    Reporter.log("El color seleccionado en branding se muestra correctamente en el header");
     Assert.assertEquals(colorSelected, colorHeader, "El color seleccionado en branding se muestra correctamente en el header" );
        
        
        
       
    	// Change Contrast Color(){
    		
     Reporter.log(" Cambiando el color del contraste ");
    	
           // Clickeo en Disenio
           
           driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        
        
        
	 // Verify that the selected color has been changed in the header
        
        //Select black colour for letters
        driver.findElement(By.cssSelector(".design fieldset:nth-child(3) .colorpicker .black")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
      String colorSelected2 = new String (driver.findElement(By.cssSelector(".design fieldset:nth-child(3) .colorpicker .black a")).getCssValue("background-color"));
      Reporter.log("El color seleccionado es :" );
      Reporter.log(colorSelected2);
      
   
     
      
      String colorHeader2 = new String(driver.findElement(By.cssSelector("header h1")).getCssValue("color"));
      Reporter.log("El color que esta en el header es :");
      Reporter.log(colorHeader2);
   
      Reporter.log(" El caso de branding-colors finalizo correctamente");
      //Compare the header color against the selected, converted to hexadecimal
      
  
    // Assert.assertEquals(colorSelected2, colorHeader2, "El color seleccionado en branding se muestra correctamente en el header" );
        }
    }
