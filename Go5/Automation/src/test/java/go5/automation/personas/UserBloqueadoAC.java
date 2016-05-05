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




public class UserBloqueadoAC extends TestSuite{

	String resend= new String(".tables tr:nth-child(1) td:nth-child(6) .link");
	String okModal = new String ("#modal-container .modal:nth-child(6) .primary");
	
	String cancel= new String(".tables tr:nth-child(1) td:nth-child(5) .link");
	String okModalCancelar = new String ("#modal-container .modal:nth-child(4) .primary");
	String tabla= new String (".tables");
	 
	PersonasPage personas = null;
	
	LoginPage login = null;
	
	
	 @BeforeClass
	  
	  public void setUp() throws Exception {
		 this.setUpMaven();
	 }
	
	
	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
		 this.quitBrowser();
		}

	 
		
		
	        
	@Test
	public void loginAsInactive() throws Exception{
		
		personas = new PersonasPage(driver);
		
		login = new LoginPage(driver);
	
				 
        Reporter.log(" Probar que un usuario inactivo no se puede loguear");
		
     // Go to the configuration
        this.goToConfiguration();
		this.goToMenu();
		Thread.sleep(1000);
	       Reporter.log("Abriendo administar personas" );  
	 	   // Go to Manage people
	         personas.goToPersonas();
	       	WebElement someElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputSearch)));
			    this.sendValue(inputSearch, "Inactive");
	               Thread.sleep(2000);
	 	       
	         Reporter.log("clickear usuario inactivo");
	         this.click(".tables tbody tr td:nth-child(7) a");
	         Thread.sleep(2000);
	         //Bloquear acceso
	         this.click(".basicdata label:nth-child(3) input ");
	         Reporter.log("Grabando usuario");
	         this.click(".container .addpeople .primary");
	      
	        this.goToMenuUsuario();
	          this.logout();
	         Thread.sleep(3000);
   		  	 login.loginToGo("marina.touceda+058@gointegro.com", "Auto1234");
   		  	 Thread.sleep(2000);
   		  //	 Assert.assertEquals("Email o contraseña incorrectos. Por favor, vuelve a intentarlo.",driver.findElement(By.cssSelector("p.reject")).getText());
   		  	 Reporter.log(driver.findElement(By.cssSelector("p.reject")).getText());
   		  	 
   		 		}
	
}
