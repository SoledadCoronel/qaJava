package go5.automation.profile;


import go5.automation.TestSuite;
import go5.pageObjects.ConfigurarCuentaPage;
import go5.pageObjects.HomePage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ConfigurarCuenta extends TestSuite {
	   
	HomePage home = null;
	ConfigurarCuentaPage config=null;
	
	
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
		this.quitBrowser();
		}
		
			
		@Test
		
		public void configurarCuenta() throws Exception { 
		
				
			home = new HomePage(driver);
			config= new ConfigurarCuentaPage(driver);
				
				
				// Ir a Datos Basicos
				
				home.goToUserMenu();
				config.goToConfigurarCuenta();
			
								
				//Ir a Contraseña
				
					  Reporter.log(" Cliqueando Ir a Contraseña");
			
				     config.goToPassword();
				
		}	
		
	
		
     }

