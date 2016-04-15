package go5.automation.groupsytitles;



import go5.automation.TestSuite;
import go5.pageObjects.GroupsPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;







import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;






public class GroupsDragAndDrop extends TestSuite{

	GroupsPage groups = null;

	
	
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}

	
		
	 @Test
	public void dragAndDropGroups() throws Exception{
		
		 groups = new GroupsPage(driver);
		
		  // Go to the configuration
		 this.goToConfiguration();
		 this.goToMenu();	
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles2    
	       
	        Reporter.log("Abriendo titulos");
	 	     this.goToTitles();
	      
	      
	      
	  	  
	         // Go to Grupos
	  	        Reporter.log("Abriendo Grupos");
	  	        groups.goToGroups();
	  	     
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
	


