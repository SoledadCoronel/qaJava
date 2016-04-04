package go5.automation.espacios;


import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;



public class CrearEspacioTest extends TestSuite {
	
	 @BeforeClass
	 
	  public void setUp() throws Exception {
		 
		this.openSite(urlSiteAutomation1);
		this.login();
		 }
	   

	 @AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
	 }
	@Test
	
	public void crearEspacio() throws Exception { 
	
		    		
	        
		 Reporter.log(" Creando un espacio como user admin");
		 
		// Go to hamburguesita
		this.clickWhenReady(By.cssSelector(irAMenu), 10);
		 
			
		 //Ir a espacios
		// this.clickWhenReady(By.cssSelector(irASpaces), 10);
		 Thread.sleep(1000);
		 this.click(irASpaces);
		 
			
			
		    // Ir a Crear Espacio 
		    
		 	this.click(".title .primary");
		   		       
		      //Cargar formulario del espacio
		 			 
		   	this.sendValue(".spacecreate fieldset:nth-child(1) label:nth-child(1) input","Nombre del espacio");
		 	this.sendValue(".spacecreate fieldset:nth-child(1) label:nth-child(2) input","Descripcios del espacio");  
	       
	
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
	  
	       /*   //Verificar ayuda del tipo de espacio
	               
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
	           
	           Thread.sleep(1000);
	           
	
	}	
	
	
		
     }

