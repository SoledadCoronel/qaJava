package go5.automation.personas;


import go5.automation.TestSuite;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import go5.pageObjects.LoginPage;
import go5.pageObjects.PersonasPage;




public class UserInactiveAC extends TestSuite{
		 
	PersonasPage personas = null;
	
	LoginPage login = null;
	
	 private String estadoDesactivado = (".basicdata label:nth-child(2) input:nth-child(2)");
	 private  String estadoActivado = (".basicdata label:nth-child(2) input:nth-child(1)");
	 private String bloquearAcceso=(".basicdata label:nth-child(3) input");
	
	 @BeforeClass
	  
	  public void setUp() throws Exception {
		 this.setUpMaven();
	 }
	
	
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
		 this.quitBrowser();
		}

	 private void buscarAInactiveUser() throws Exception{
		 // Go to the configuration
	     this.goToConfiguration();
			this.goToMenu();
			Thread.sleep(1000);
		       Reporter.log("Abriendo administar personas" );  
		 	   // Go to Manage people
		         personas.goToPersonas();
		       	WebElement someElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputSearch)));
				    this.sendValue(inputSearch, "Inactive");
		               Thread.sleep(3000);
		 	       
		         Reporter.log("clickear usuario inactivo");
		      //  personas.editFirstPerson();
		         this.click(".tables tbody tr td:nth-child(7) a");
		         Thread.sleep(3000);
	 }
		
     
	@Test
	public void activateUser() throws Exception{
		
		personas = new PersonasPage(driver);
		
		login = new LoginPage(driver);
	
				 
     Reporter.log(" Activar el user User Inactive y uncheck block access");
		
     	this.buscarAInactiveUser();
	      //  personas.setEstadoActivo();
	        //Activarlo
	         this.click(estadoActivado);
	     
	         
	       //Le saco el bloqueo de acceso
	         
	       //  this.click(bloquearAcceso);
	       this.click(".basicdata label:nth-child(3) input ");
	         Reporter.log("Grabando usuario");
	         this.click(".container .addpeople .primary");
	      
	        this.goToMenuUsuario();
	          this.logout();
	         Thread.sleep(3000);
		  	 login.loginToGo("marina.touceda+058@gointegro.com", "Auto1234");
		  	 Thread.sleep(2000);
		  	  this.goToHome();
		  	 this.goToMenuUsuario();
	          this.logout();
		  	  
		 		}	
	        
	@Test(dependsOnMethods = { "activateUser"})
	public void blockAccessUser() throws Exception{
		
		personas = new PersonasPage(driver);
		
		login = new LoginPage(driver);
	
				 
        Reporter.log(" Probar que un usuario con bloqueo de acceso no se puede loguear");
		
        
	  	 login.loginToGo("marina.touceda@gointegro.com", "Auto1234");
	  	 Thread.sleep(1000);
     
	  	this.buscarAInactiveUser();
	      
	         //Bloquear acceso
	          //   this.click(bloquearAcceso);
	        this.click(".basicdata label:nth-child(3) input ");
	         Thread.sleep(2000);
	         Reporter.log("Grabando usuario");
	         this.click(".container .addpeople .primary");
	      
	        this.goToMenuUsuario();
	          this.logout();
	         Thread.sleep(3000);
   		  	 login.loginToGo("marina.touceda+058@gointegro.com", "Auto1234");
   		  	 Thread.sleep(2000);
   		  	 Reporter.log(driver.findElement(By.cssSelector("p.reject")).getText());
   		  	 
   		 		}
	
	
	
	@Test (dependsOnMethods = { "blockAccessUser"})
	public void loginAsInactive() throws Exception{
		
		personas = new PersonasPage(driver);
		
		login = new LoginPage(driver);
	
		login.loginToGo("marina.touceda@gointegro.com", "Auto1234");		 
        Reporter.log(" Probar que un usuario inactivo no se puede loguear");
		
     
	 	       this.buscarAInactiveUser();
	 	        this.click(estadoDesactivado);
	      
	         Reporter.log("Grabando usuario");
	         this.click(".container .addpeople .primary");
	      
	        this.goToMenuUsuario();
	          this.logout();
	         Thread.sleep(3000);
   		  	 login.loginToGo("marina.touceda+058@gointegro.com", "Auto1234");
   		  	 Thread.sleep(2000);
   		   	 Reporter.log(driver.findElement(By.cssSelector("p.reject")).getText());
   		  	 
   		 		}
	
}
