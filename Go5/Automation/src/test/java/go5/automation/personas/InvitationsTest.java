package go5.automation.personas;


import go5.automation.TestSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import go5.pageObjects.PersonasPage;



public class InvitationsTest extends TestSuite{

	String resend= new String(".tables tr:nth-child(1) td:nth-child(6) .link");
	String okModal = new String ("#modal-container .modal:nth-child(6) .primary");
	
	String cancel= new String(".tables tr:nth-child(1) td:nth-child(5) .link");
	String okModalCancelar = new String ("#modal-container .modal:nth-child(4) .primary");
	 
	PersonasPage personas = null;
	
	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
		 this.setUpMaven();
	 }
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
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
	          
	      
	         log.info(driver.findElement(By.cssSelector(".tables")).isDisplayed());
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         
	         // Verificar que hay un elemento en la tabla 
	         	     	         
	          WebElement htmltable=driver.findElement(By.cssSelector(".tables tbody"));

	          List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	          log.info("Imprimiendo la cantidad de inivtaciones pendientes...");
	          log.info(rows.size());
	        //  Assert.assertEquals(rows.size(),1);
	          
	            
	          
	      //  Reenviar la invitacion
	          
	          //Presiono boton reenviar del primer elemento de la tabla
	       this.click(resend);
	          Thread.sleep(1000);
	          this.click(okModal);
	       //    driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) .primary")).click();
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          Reporter.log(" La invitacion se reenvio correctamente");
	          
	          
	          // Verificar que el email ha sido reenviado
	          
	          /*JavascriptExecutor js = (JavascriptExecutor) driver;
	  		js.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) { $('.primary').after('<a class=\"forgot-pass-link\" href=\"/authentication/reset-password/'+$.parseJSON(xhr.responseText).data.id+'\">Forgot Link!</a>'); });");*/
   	         	         	 
	  	/*  //Agarrar esa invitation y cancelarla
	  		
	  		this.click(cancel);
	  		Thread.sleep(1000);
	  		this.click(okModalCancelar);
	  		Reporter.log("La invitacion se cancelo correctamente");
	  		*/
	  		
	  		
	
	
	}
	
}
