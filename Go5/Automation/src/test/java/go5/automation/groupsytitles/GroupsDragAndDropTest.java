package go5.automation.groupsytitles;



import go5.automation.TestSuite;


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






public class GroupsDragAndDropTest extends TestSuite{

	

	
	@BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.openSite(urlSiteAutomation3);
		 this.login();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	
		
	 @Test
	public void dragAndDropGroups() throws Exception{
		
	 
		
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
	  	        this.goToGroups();
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
	


