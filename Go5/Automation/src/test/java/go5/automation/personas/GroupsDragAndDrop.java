package go5.automation.personas;



import go5.automation.CommonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;



@Test
public class GroupsDragAndDrop extends CommonFunctions{

	//private WebDriver driver;

	String s = "It was the best of times, it was the worst of times,\n"
	         + "it was the age of wisdom, it was the age of foolishness,\n"
	         + "it was the epoch of belief, it was the epoch of incredulity,\n"
	         + "it was the season of Light, it was the season of Darkness,\n"
	         + "it was the spring of hope, it was the winter of despair,\n"
	         + "we had everything before us, we had nothing before us";

		 @BeforeTest // call function to open the browser and login 
		 public void setup () throws Exception{
		   openSiteLogin();
		   login("marina.touceda@gointegro.com","Auto1234");
		   
		 }
		
		 @AfterTest // call function to close browser 
			
			public void teardown(){
				closeBrowser();
			}

	
		

	public void addUserAdmin() throws InterruptedException, FileNotFoundException{
		
	 
		
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
	  	         
	  	        
	  	       WebElement element = driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2)"));
	  	       WebElement target = driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(3)"));
	  	  
	//Probando un js q te pone un cuadrado rojo
	  	       
  	     JavascriptExecutor js = (JavascriptExecutor) driver;

  	    
  	     js.executeScript("arguments[0].style.border='3px solid red'", element);
  	     
  	   // Need to wrap the javascript file
  	  
  	     
  	   /*  FileInputStream filescript= new FileInputStream("/home/marinatouceda/Documentos/qa/Go5/Automation/src/test/java/go5/automation/drag_and_drop_helper.js");
  	   
  	   InputStream inStreamObject = ((InputStream) filescript);
  	 Scanner sc = new Scanner( inStreamObject );
  	 String input = sc.nextLine();
  	 System.out.println(input);
  	     
  	   
       String js_TxtFile = ""; 
           while (sc.hasNext()) {          
               String[] s = sc.next().split("\r\n");   
               for (int i = 0; i < s.length; i++) {
                   js_TxtFile += s[i];
                   js_TxtFile += " ";
               }           
           }*/
  	    
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
	


