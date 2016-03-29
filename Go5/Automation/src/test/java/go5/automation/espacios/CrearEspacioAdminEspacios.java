package go5.automation.espacios;


import java.net.URL;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CrearEspacioAdminEspacios  {
	
 private WebDriver driver;

	

 @BeforeClass
  @Parameters(value={"browser","version","platform","url"})
  public void setUp(String browser, String version, String platform,String url) throws Exception {
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability("platform",platform);
    capability.setCapability("browserName", browser);
    capability.setCapability("browserVersion", version);
    capability.setCapability("project", "GOIntegro");
    capability.setCapability("build", "1.0");
    capability.setCapability("debug", false);
    capability.setCapability("name", "Crear Espacio como Admin");
    driver = new RemoteWebDriver(
    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
    	      capability);
   
    
    driver.get(url);
	 driver.manage().window().maximize();
	 WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".session label:nth-child(2) input")));
  }  

 @AfterClass // call function to close browser 
	
	public void teardown(){
		driver.quit();
	}
		
	@Test
	
	public void crearEspacio() throws Exception { 
	

		 //Login
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda+023@gointegro.com");
	 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".session .primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        		
	        
		 Reporter.log(" Creando un espacio como user admin de espacios");
		 
		// Go to hamburguesita
			driver.findElement(By.cssSelector(".menu")).click();
	
			
			//Ir a espacios
			driver.findElement(By.cssSelector("a[title='Ir a listar espacios']")).click();
			Reporter.log("Abriendo espacios");
				
			
		    // Ir a Crear Espacio 
		      
		      driver.findElement(By.cssSelector(".title .primary")).click();
		      
		      //Cargar formulario del espacio
		      Reporter.log("Validando largo de texto en Nombre del Espacio");
		      driver.findElement(By.cssSelector(".spacecreate fieldset:nth-child(1) label:nth-child(1) input")).sendKeys("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		      Reporter.log("Capturando el mensaje de error");
		      Reporter.log("El mensaje de error es ");
		      Reporter.log(driver.findElement(By.cssSelector(".spacecreate fieldset:nth-child(1) label:nth-child(1) span")).getText());
		      driver.findElement(By.cssSelector(".spacecreate fieldset:nth-child(1) label:nth-child(1) input")).sendKeys("Nombre del  Espacio");
	          driver.findElement(By.cssSelector(".spacecreate fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("Descripcion del espacio");
	
	       //Configuracion del espacio
	          
	          //Desactivar
	         
	          driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(2) span")).click();
	
	         //Actividad Social
	          driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(3) span")).click();
	          
	          //Seleccionar el icono
	          Reporter.log("Seleccionar el icono del espacio");
	           driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(4) .igotrophy")).click();
	          driver.findElement(By.cssSelector(".mconfirmation .inside .icons .igoeye")).click();
	          driver.findElement(By.cssSelector(".active .mconfirmation .primary")).click();
	
	          //Espacio publico
	           Reporter.log("Seleccionando un espacio publico");
	           driver.findElement(By.cssSelector(".spaceformtype .igocompany")).click();
	           
	           //Grabar el espacio nuevo
	           driver.findElement(By.cssSelector(".spacecreate .primary")).click();	     
	
	}	
	
	
		
     }

