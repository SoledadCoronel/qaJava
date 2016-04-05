package go5.automation.personas;


import go5.automation.TestSuite;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



public class InvitationsResendTest extends TestSuite{


	
	
	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.openSite(urlSiteAutomation2);
		 this.login();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	
		
		
	        
	@Test
	public void invitattionResendwithAnAdminUser() throws Exception{
		 
		 org.apache.log4j.BasicConfigurator.configure();
		 Random numero= new Random();
		 Logger log = Logger.getLogger("automation");
	 	
			
		log.info("Ir al menu de config");
        Reporter.log(" Testeando la pagina de Administrar personas");
		
        // Go to the configuration
        this.goToConfiguration();
		this.goToMenu();
	      
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles    
	        this.goToTitles();
	       
	        log.info(driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).getText());
	        Reporter.log("Abriendo personas");
	   // Go to Manage people
	         this.goToPersonas();
	      //  driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    
         
         //Add a  user  
	     this.crearUserAdmin();
	    
	             
	      	
	         // Ir al tab de invitaciones pendientes
	          
	         driver.findElement(By.cssSelector(".title menu li:nth-child(2) a")).click();
	         log.info(driver.findElement(By.cssSelector(".tables")).isDisplayed());
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         
	         // Verificar que hay un elemento en la tabla 
	         	     	         
	          WebElement htmltable=driver.findElement(By.cssSelector(".tables tbody"));

	          List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	          log.info("Imprimiendo la cantidad de inivtaciones pendientes...");
	          log.info(rows.size());
	          Assert.assertEquals(rows.size(),1);	         
	         
	          
	       // Reenviar la invitacion
	          
	          //Presiono boton reenviar del primer elemento de la tabla
	          driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(6)")).click();
	          driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) .primary")).click();
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          
	          
	          // Verificar que el email ha sido reenviado
	          
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	  		js.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) { $('.primary').after('<a class=\"forgot-pass-link\" href=\"/authentication/reset-password/'+$.parseJSON(xhr.responseText).data.id+'\">Forgot Link!</a>'); });");
   	         	         	 
	}
	
}
