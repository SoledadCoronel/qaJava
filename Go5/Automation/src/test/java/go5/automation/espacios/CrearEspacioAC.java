package go5.automation.espacios;


import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class CrearEspacioAC extends TestSuite {
	
	
	private String crearEspacio = new String (".title .primary");
	private String espacioPublico = new String (".spaceformtype .igounlock");
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
	
	 public void elegirTipoDeEspacio () throws Exception{
	 Reporter.log("Seleccionando un tipo de espacio:");
	 this.click(espacioPublico);
	 }
	 
	 
	 
	@Test
	
	public void crearEspacio() throws Exception { 
	
		    		
	        
		 Reporter.log(" Creando un espacio como user admin");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(1000);
		 
			
		 //Ir a espacios
		 this.click(irASpaces);
		 Thread.sleep(1000);
			
			
		    // Ir a Crear Espacio 
		     
		 	this.click(crearEspacio);
		   		       
		      //Cargar formulario del espacio
		 			 
		   	this.sendValue(".spacecreate fieldset:nth-child(1) label:nth-child(1) input","Nombre del espacio");
		 	this.sendValue(".spacecreate fieldset:nth-child(1) label:nth-child(2) input","Descripcion del espacio");  
	       
	
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
	          
	           this.elegirTipoDeEspacio();
	           
	           //Grabar el espacio nuevo
	           driver.findElement(By.cssSelector(".spacecreate .primary")).click();
	           
	           Thread.sleep(1000);
	           
	
	}	
	
	
		
     }

