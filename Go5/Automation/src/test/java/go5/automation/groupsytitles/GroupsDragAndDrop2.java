package go5.automation.groupsytitles;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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



public class GroupsDragAndDrop2 {

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
	    capability.setCapability("name", "GroupsDrangAndDrop ");
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
	    
	    driver.get(url);
		 driver.manage().window().maximize();
		 WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".session label:nth-child(2) input")));
	  }  
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

		

	
		

	@Test
	 public void dragAndDrop() throws InterruptedException, FileNotFoundException{
			 	
		 //Login
		driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
		driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda@gointegro.com");
 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
 		 driver.findElement(By.cssSelector(".session .primary")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
				     		
	   		  // Go to the configuration
	   			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	   	       driver.findElement(By.cssSelector(".menu")).click();
	   		
	   		// Go to  Users Menu
	   	        Reporter.log("Abriendo administar personas" );  
	   	       
	   	        
	   	    // Go to Titles2    
	   	        
	   	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	   	      
	   	        Reporter.log("Abriendo Grupos");
	   	   
	   	  	  
	   	         // Go to Grupos
	   	  	        
	   	  	        driver.findElement(By.cssSelector(".space:nth-child(3) ol li:nth-child(4) a")).click();
	   	  	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	            
	             	 	  	     
	   	  	        
	   	  	         
	   	  	      //  Drag and Drop
	   	  	         
	   	  	        //Cargando elementos
	   	  	       WebElement element = driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2)"));
	   	  	       WebElement target = driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(3)"));
	   	  	  
	   	//Cargando el javascript
	   	  	       
	     	     JavascriptExecutor js = (JavascriptExecutor) driver;

	     	    	  
	     	     
	     	 
	     	    
	     	    try {
	     	    	 String jquerySimulator = new String(Files.readAllBytes(Paths.get("src/test/java/go5/automation/drag_and_drop_helper.js")));
	   		
	     	       
	     	          js.executeScript(jquerySimulator);
	     	           
	     	          js.executeScript("$('#"+element.getAttribute("id")+"').simulateDragDrop({ dropTarget: '#"+target.getAttribute("id")+"'});");
	     	       	    
	     	    } catch (IOException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}
	     	     
	}          
}	       
		

