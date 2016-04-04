package go5.automation.groupsytitles;



import go5.automation.TestSuite;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





@Test
public class GroupsDragAndDrop extends TestSuite{

	//private WebDriver driver;

	
		 @BeforeTest // call function to open the browser and login 
		 public void setup () throws Exception{
		   openSiteLogin();
		   login();
		   
		 }
		
		 @AfterTest // call function to close browser 
			
			public void teardown(){
				closeBrowser();
			}

	
		

	public void dragAndDrop() throws InterruptedException, FileNotFoundException{
		
	 
		
		  // Go to the configuration
			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	       driver.findElement(By.cssSelector(".menu")).click();
		
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles    
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	      
	        Reporter.log("Abriendo titulos");
	   
	  	  
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
  	    	 String jquerySimulator = new String(Files.readAllBytes(Paths.get("/home/marinatouceda/Documentos/qa/Go5/Automation/src/test/java/go5/automation/drag_and_drop_helper.js")));
		
  	       
  	          js.executeScript(jquerySimulator);
  	           
  	          js.executeScript("$('#"+element.getAttribute("id")+"').simulateDragDrop({ dropTarget: '#"+target.getAttribute("id")+"'});");
  	       	    
  	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	     
        
  	       
  	   
  	     
	   
	
	}   
	  	       
  	    
	 		        
	}
	


