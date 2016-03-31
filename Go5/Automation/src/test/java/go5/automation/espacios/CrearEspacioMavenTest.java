package go5.automation.espacios;


import go5.automation.CommonFunctions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CrearEspacioMavenTest extends CommonFunctions {
	


	


 @BeforeTest // call function to open the browser and login 
 public void setup () throws Exception{
   openSiteLogin();
   login("marina.touceda@gointegro.com","Auto1234");
   
 }

 @AfterTest // call function to close browser 
	
	public void teardown(){
		closeBrowser();
	}


	@Test
	
	public void editarEspacio() throws Exception { 
	
       		
	        
		 Reporter.log(" Creando un espacio como user admin");
	
		 //Go to the menu (hamburguesita)
	        
	 		
	        driver.findElement(By.cssSelector(".menu")).click();
	 	
	 	// Go to  Directorio de personas
	         Reporter.log("Abriendo directorio de  personas" );  
	        
	         driver.findElement(By.cssSelector(".igouser")).click();
	         Thread.sleep(1000);
	         driver.findElement(By.cssSelector(".igousergroup")).click();
	         Thread.sleep(1000);
			
			//Ir a espacios
			driver.findElement(By.cssSelector("a[title='Ir a listar espacios']")).click();
			Thread.sleep(1000);
			Reporter.log("Abriendo espacios");
				
			
		    // Ir a Crear Espacio 
		      
		      driver.findElement(By.cssSelector(".title .primary")).click();
		      
		      //Cargar formulario del espacio
		      
		      driver.findElement(By.cssSelector(".spacecreate fieldset:nth-child(1) label:nth-child(1) input")).sendKeys("Nombre del  Espacio");
	          driver.findElement(By.cssSelector(".spacecreate fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("Descripcion del espacio");
	
	       //Configuracion del espacio
	          
	          //Desactivar
	          Reporter.log("Desactivar el espacio");
	          driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(2) span")).click();
	
	         //Actividad Social
	          Reporter.log("Desactivar Acitividad Social");
	          driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(3) span")).click();
	          
	          //Seleccionar el icono
	          Reporter.log("Seleccionar el icono del espacio");
	           driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(4) .igotrophy")).click();
	          driver.findElement(By.cssSelector(".igoeye")).click();
	          driver.findElement(By.cssSelector(".active .mconfirmation .primary")).click();
	  /*
	        //Verificar ayuda del tipo de espacio
	               
	           Reporter.log("Verificando modal de ayuda en Tipo de Espacio");
	           
	           JavascriptExecutor js = (JavascriptExecutor) driver;         
		        WebElement element = driver.findElement(By.linkText("Ayuda"));
		       Thread.sleep(1000);
		        js.executeScript("scroll(250, 0)");
		        
		        //js.executeScript("arguments[0].setAttribute('style', 'display: block; position: relative; height: 300px; width: 300px; opacity: 1; visiblity: visible')",element);
	           
	           
		        driver.findElement(By.cssSelector("a[title='Muestra la ayuda']")).click();
	           driver.findElement(By.cssSelector(".spaceformtype .help")).click();
	           
	           
	           //Cerrar el popup
	           driver.findElement(By.cssSelector(".active .minformation .primary")).click();
	           
	          */
	           //Seleccionar el tipo de espacio
	           
	           //Espacio publico
	           Reporter.log("Seleccionando un espacio publico");
	           driver.findElement(By.cssSelector(".spaceformtype .igounlock")).click();
	           
	           //Grabar el espacio nuevo
	           driver.findElement(By.cssSelector(".spacecreate .primary")).click();	           
	
	}	
	
	
		
     }

