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
import go5.pageObjects.AdministrarPersonasPage;
import go5.pageObjects.SignupPage;



public class AltaUserAC extends TestSuite{

	String resend= new String(".tables tr:nth-child(1) td:nth-child(6) .link");
	String okModal = new String ("#modal-container .modal:nth-child(6) .primary");
	
	String cancel= new String(".tables tr:nth-child(1) td:nth-child(5) .link");
	String okModalCancelar = new String ("#modal-container .modal:nth-child(4) .primary");
	String tabla= new String (".tables");
	 
	AdministrarPersonasPage personas = null;
	SignupPage  signup = null;
	LoginPage login = null;
	
	
	//Init variables
	
	
	
	 
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
	public void addUserWholeFlow() throws Exception{
		
		personas = new AdministrarPersonasPage(driver);
		signup = new SignupPage(driver);
		login = new LoginPage(driver);
		js=  (JavascriptExecutor) driver;
		
				 
        Reporter.log(" Creando un user admin y dando de alta en go5,flujo completo");
		
        // Go to the configuration
        this.goToConfiguration();
		this.goToMenu();
	      
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles2    
	        this.goToTitles();
	      	      
	       
	   // Go to Manage people
	 //        this.click(irAPersonas);
	       
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
             
	          js.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) {   if(settings.url.indexOf('http://api.qa.go5.gointegro.net/invitations') != -1 && settings.type == 'POST') { localStorage.setItem('invitationUrl', '/registration/invitation/'+$.parseJSON(xhr.responseText).data.id); } });");
 	        
	          //Add a  user  
	         
	          String emaillogin = new String (this.crearUserAdminReturningmail());
	         	        
	          this.goToMenuUsuario();
			  	this.logout();
		        	          
	          js.executeScript("window.location = localStorage.getItem('invitationUrl');");
	          Thread.sleep(2000);
   	         	         	 
	   			  		
	  	  	signup.registrarse();
	  	  	login.loginToGo(emaillogin, strPassword);
           	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          	this.goToMenuUsuario();
          	this.goToProfile();
          	
          
	
	}
	
}
