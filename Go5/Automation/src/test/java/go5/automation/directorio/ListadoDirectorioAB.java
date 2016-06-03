package go5.automation.directorio;

import java.util.concurrent.TimeUnit;

import go5.automation.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import go5.pageObjects.DirectorioPage;





public class ListadoDirectorioAB extends TestSuite{
	
	// Css 
	 String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
	 String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
	
	// Uso de la pagina Directorio
	
	 
	 DirectorioPage directorio = null;
	
		 
	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	 			
		
	
	@Test 
	
	public void listadoDirectorio() throws Exception { 
	
				
	// Inicializar pagina de Directorio
		
	 directorio = new DirectorioPage(driver);
    
	 	 
		// Go to the menu (hamburguesita)
	 this.goToMenu();
       Thread.sleep(2000);  
 	
 	// Go to  Directorio de personas
        
 	 directorio.goToDirectorio();
 	 
 		
        WebElement tablevailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".people")));
         
      // Ver si esta ordenado por default cuando carga la pagina
         Reporter.log("Ver si esta ordenado por default cuando carga la pagina");
         directorio.verificarOrden();
         
        
        //Volver a ordenar, en forma descendente
        
     //  this.ordenar();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         Reporter.log("Verificar que esta en orden descendiente despues de apretar ordenar en Nombre");
         directorio.verificarOrden();
       
     //Verificar Paginado
       Reporter.log("Seleccionar otra pagina del listado");
        this.goToPagina(8);
        WebElement tablevailable2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".people")));
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        
      
    //Hacer una busqueda
       
      
       Reporter.log(" Hacer una busqueda de un usuario por Nombre");
            	       this.search("Automation");          	 
               
                                
                //Chequear q se muestre en la tabla users
                Reporter.log("El nombre del user buscado es:Automation");
                   Thread.sleep(2000);     
                Reporter.log(" Imprimiendo el resultado del search:");
               Reporter.log(directorio.getFirstName()); 
	
               
               Reporter.log(" Hacer una busqueda de un usuario por Apellido");
               this.search("AutomationLastName");
                Thread.sleep(2000);
               //Chequear q se mueste en la tabla users
               Reporter.log("El nombre del user buscado es AutomationLastName");
              
               Reporter.log(" Imprimiendo el resultado del search");
               Reporter.log(directorio.getFirstName());
              
               //Ir al profile del user buscado
               Thread.sleep(2000);
               this.click(firstRow);
               
            
              
             
              
           
	}
}	