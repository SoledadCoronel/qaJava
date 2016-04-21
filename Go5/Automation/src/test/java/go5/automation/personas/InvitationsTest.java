package go5.automation.personas;


import go5.automation.TestSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import go5.pageObjects.PersonasPage;



public class InvitationsTest extends TestSuite{

	String resend= new String(".tables tr:nth-child(1) td:nth-child(6) .link");
	String okModal = new String ("#modal-container .modal:nth-child(6) .primary");
	
	String cancel= new String(".tables tr:nth-child(1) td:nth-child(5) .link");
	String okModalCancelar = new String ("#modal-container .modal:nth-child(4) .primary");
	String tabla= new String (".tables");
	 
	PersonasPage personas = null;
	
	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
		 this.setUpMaven();
	 }
	 @AfterTest // call function to close browser 
		
		public void teardown(){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("localStorage.clear();");
		 closeBrowser();
		}

	
	 public void verificarTabla(){
	 // Verificar que hay un elemento en la tabla 
       
     WebElement htmltable=driver.findElement(By.cssSelector(".tables tbody"));

     List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
     log.info("Imprimiendo la cantidad de inivtaciones pendientes...");
     log.info(rows.size());
	 }
		
		
	        
	@Test
	public void invitattionResendwithAnAdminUser() throws Exception{
		
			
			
		log.info("Ir al menu de config");
        Reporter.log(" Testeando la pagina de Administrar personas");
		
        // Go to the configuration
        this.goToConfiguration();
		this.goToMenu();
	      
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles2    
	        this.goToTitles();
	       
	        log.info(driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).getText());
	        Reporter.log("Abriendo personas");
	   // Go to Manage people
	         this.click(irAPersonas);
	       //  personas.goToPersonas();
	     
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    
	          
 	        
         //Add a  user  
	     this.crearUserAdmin();
	    	        	      	
	        // Ir al tab de invitaciones pendientes
	      
	     	this.goToInvitations();
	              
	         log.info(driver.findElement(By.cssSelector(tabla)).isDisplayed());
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         this.verificarTabla();
	         
	         
	         JavascriptExecutor js = (JavascriptExecutor) driver;
	          js.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) {  if(settings.url.indexOf('http://api.qa.go5.gointegro.net/invitations') != -1 && settings.type == 'PATCH') { localStorage.setItem('invitationUrl', '/registration/invitation/'+$.parseJSON(xhr.responseText).data.id); } });");
	          
	      //  Reenviar la invitacion
	          
	          //Presiono boton reenviar del primer elemento de la tabla
	       this.click(resend);
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          this.click(okModal);
	            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          Reporter.log(" La invitacion se reenvio correctamente");
	         
	          Thread.sleep(500);
	          // Verificar que el email ha sido reenviado
	            this.goToMenuUsuario();
	         	this.logout();
	        
	          
	          js.executeScript("window.location = localStorage.getItem('invitationUrl');");
	          Thread.sleep(2000);
   	         
	         
	       
	  		
	  		
	
	
	}
	
}
