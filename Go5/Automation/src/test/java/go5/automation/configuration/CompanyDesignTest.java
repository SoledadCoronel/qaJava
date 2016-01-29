package go5.automation.configuration;




import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CompanyDesignTest {


	 private WebDriver driver;

		
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
	public void editConfig(){
		
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
	
	// Go to  Users Menu
        Reporter.log("Abriendo administar personas" );  
        //driver.findElement(By.cssSelector(".usermenu")).click();
        Reporter.log("Abriendo titulos");
        
    // Go to Titles    
        
        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
      
        Reporter.log("Abriendo personas");
   // Go to Manage people
        
        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        

		// Go to Company Design 
       Reporter.log("Abriendo la pagina de diseño de la plataforma" );
       // Primero hay que clickear en otro si no no anda!!Clickeo titles
       driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
       
       Reporter.log(driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).getText());
       // Clickeo en Disenio
       
       driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
       // Verify list of colors in branding
       
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
    
	 // Verify that the selected color has been changed in the header
        
        //Select black colour
        driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10)")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      String colorSelected = new String (driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10) a")).getCssValue("background-color"));
      Reporter.log(colorSelected);
    
      //Save changes for colour
      driver.findElement(By.cssSelector(".primary")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
      
      
      String colorHeader = new String(driver.findElement(By.tagName("header")).getCssValue("background-color"));
      Reporter.log(colorHeader);
   
      //Compare the header color against the selected, converted to hexadecimal
      driver.findElement(By.cssSelector(".primary")).click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  
     Assert.assertEquals(colorSelected, colorHeader, "El color seleccionado en branding se muestra correctamente en el header" );
	}
}
