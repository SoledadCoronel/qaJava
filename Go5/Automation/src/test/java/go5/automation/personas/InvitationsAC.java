package go5.automation.personas;


import go5.automation.TestSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;
import go5.pageObjects.LoginPage;
import go5.pageObjects.SignupPage;



public class InvitationsAC extends TestSuite{

	String resend= new String(".tables tr:nth-child(1) td:nth-child(6) .link");
	String okModal = new String ("#modal-container .modal:nth-child(6) .primary");
		String cancel= new String(".tables tr:nth-child(1) td:nth-child(5) .link");
	String okModalCancelar = new String ("#modal-container .modal:nth-child(4) .primary");
	String tabla= new String (".tables");
	protected String strPassword= new String("Auto1234");
	protected String irAProfile = new String (".subusers li:nth-child(2) a");
	SignupPage  signup = null;
	LoginPage login = null;
	
		
	 @AfterClass // call function to close browser 
		
		public void teardown(){
		 
		 js.executeScript("localStorage.clear();");
		this.quitBrowser();
		}

	
	 public void verificarTabla(){
	 // Verificar que hay un elemento en la tabla 
       
     WebElement htmltable=driver.findElement(By.cssSelector(".tables tbody"));

     List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
     Reporter.log("Imprimiendo la cantidad de inivtaciones pendientes...", rows.size());
	 }
		
		
	        
	@Test
	public void invitattionResendwithAnAdminUser() throws Exception{
		
		signup = new SignupPage(driver);
		login = new LoginPage(driver);
		js=  (JavascriptExecutor) driver;
			
	
        Reporter.log("Crear un user, reenviarle la invitacion y registrarlo");
		
        // Go to the configuration
        this.goToConfiguration();
		this.goToMenu();
	      
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles2    
	        this.goToTitles();
	              
	   // Go to Manage people
	         this.click(irAPersonas);
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
             
 	        
	          //Add a  user  
	          String name = new String( this.crearUserAdminReturningmail());
	    	        	      	
	        // Ir al tab de invitaciones pendientes
	      
	     	this.goToInvitations();
	             
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         this.verificarTabla();
	                    
	          js.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) {  if(settings.url.indexOf('http://api.qa.go5.gointegro.net/invitations') != -1 && settings.type == 'PATCH') { localStorage.setItem('invitationUrl', '/registration/invitation/'+$.parseJSON(xhr.responseText).data.id); } });");
	          
	      //  Reenviar la invitacion
	          
	          //Presiono boton reenviar del primer elemento de la tabla
	          this.click(resend);
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          this.click(okModal);
	           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          Reporter.log(" La invitacion se reenvio correctamente");
	           Thread.sleep(2000);
	           
	          // Desloguearse del usuario admin
	            this.goToMenuUsuario();
	         	this.logout();
	        
	          
	          js.executeScript("window.location = localStorage.getItem('invitationUrl');");
	          Thread.sleep(2000);
   	         
	       // Ir a regsitrase con ese token
	          	Reporter.log("Ir a regsitrase con ese token");
	          	signup.registrarse();
	          	Reporter.log("Comprobar loguearse a la aplicacion con ese user nuevo registrado");
	          	//Comprobar loguearse a la aplicacion con ese user nuevo registrado
	          	login.loginToGo(name, strPassword);
	          	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          	this.goToMenuUsuario();
	           	Reporter.log("Ir al perfil del usuario logueado");
	          	this.goToProfile();
	          	Reporter.log("El usuario se logueo exitosamente");
	          
	          	
	          
		  		
	  		
	  		
	
	
	}
	
}
