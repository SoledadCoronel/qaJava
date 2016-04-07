package go5.automation.espacios;



import java.util.concurrent.TimeUnit;

import go5.automation.TestSuite;
import go5.pageObjects.LoginPage;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class UnirseAEspacioUserBasicTest extends TestSuite {
	
	LoginPage login = null;

	
	private String crearEspacio = new String (".title .primary");
	
	@BeforeClass
	  
	  public void setUp() throws Exception {
	
		
		
        driver = new FirefoxDriver();
        login= new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        this.openSite(urlSiteAutomation1);
       
        Reporter.log("Abriendo la aplicacion");
		
		//this.openSite(urlSiteAutomation2);
		 login.loginToGo("marina.touceda+022@gointegro.com","Auto1234");
       // login.loginToGoAsUSerBasic();
		
	 }

	 @AfterClass // call function to close browser 
		
		public void teardown(){
		this.quitBrowser();
		}
		 
	 @Test
	
	public void unirseAEspacio() throws Exception { 
	
		    		
	        
		 Reporter.log(" Unirse como user basic a un espacio y verificar que no este el boton de Crear Espacio");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(1000);
		 
		
		 
		 
		 //Ir a espacios
		 this.click(irASpaces);
		 Thread.sleep(1000);
			
			
		    // Verificar que no esta el boton de Crear Espacio
		 
		     try{
		 this.click(crearEspacio);
		     }    
		    		 catch (Exception e) {

		    		     Reporter.log("No esta el boton Crear Espacio");

		    		
		    		 }
	         
		}	
			
     }

