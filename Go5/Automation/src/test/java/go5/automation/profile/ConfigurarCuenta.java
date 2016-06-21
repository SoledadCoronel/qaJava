package go5.automation.profile;


import go5.automation.TestSuite;


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
	
	protected String irADatosBasicos = new String (".title menu li:nth-child(1) a");
	 protected String irAContrasenia = new String (".title menu li:nth-child(2) a");	
	 protected String irANotificaciones = new String (".title menu li:nth-child(3) a");
	 protected String inputPassword = new String (".content .generaldata label:nth-child(1) input");
	 
	 
	@BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build,"Test de Configurar Cuenta");
		
		
	 }
	   

	 @AfterClass // call function to close browser 
		
		public void teardown(){
		this.quitBrowser();
		}
		
			
		@Test
		
		public void configurarCuenta() throws Exception { 
		
				Reporter.log(" Ir a Menu");
				Thread.sleep(1000);
				this.goToMenu();
				
				Thread.sleep(1000);
				
				Reporter.log(" Ir a Menu de Usuario");
				this.goToMenuUsuario();
				
				Thread.sleep(1000);
				//Ir a configurar cuenta
				Reporter.log(" Ir a Configurar Cuenta");
				this.click(irAConfigurarCuenta);
				Thread.sleep(1000);
				
				
				// Ir a Datos Basicos
				
				Reporter.log(" Ir a  Datos Basicos");
				this.clickWhenReady(By.cssSelector(irADatosBasicos),10);
				
			
				
				//Ir a Idioma
				Reporter.log(" Chequeando idiomas"); 
				Select selectLanguage= new Select (driver.findElement(By.cssSelector(".content .generaldata label:nth-child(1) select")));
				
				  selectLanguage.selectByIndex(2);
				  driver.findElement(By.cssSelector(".primary")).click();
				  Thread.sleep(1000);
				  
				   log.info(driver.findElement(By.cssSelector(".title menu li:nth-child(2)")).getText());
				  		  
				  selectLanguage.selectByIndex(3);
				  driver.findElement(By.cssSelector(".primary")).click();
				  Thread.sleep(1000);
				  
				  
				   log.info(driver.findElement(By.cssSelector(".title menu li:nth-child(3)")).getText());
				  
				 
				   selectLanguage.selectByIndex(1);
				   driver.findElement(By.cssSelector(".primary")).click();
				   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
				 
				   
				   //Ir a Time Zone
				  
				   Reporter.log(" Chequeando los time zone");
				   
				   Select selectTimeZone= new Select (driver.findElement(By.cssSelector(".content .generaldata label:nth-child(2) select")));
				   
				    selectTimeZone.selectByIndex(9);
				    driver.findElement(By.cssSelector(".primary")).click();
					  Thread.sleep(1000);
				    
					
					  selectLanguage.selectByIndex(2); 
				   
				//Ir a Contraseña
				
					  Reporter.log(" Cliqueando Ir a Contraseña");
			
				   this.clickWhenReady(By.cssSelector(irAContrasenia), 10);
				   this.sendValue(inputPassword, "1234");
						
				Assert.assertEquals(driver.findElement(By.cssSelector(".generaldata label span")).getText(),"La contraseña es invalida.");
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
				
				//Ir a Notificaciones
				  
				
				this.clickWhenReady(By.cssSelector(irANotificaciones),10);
				
				
		}	
		
	
		
     }

