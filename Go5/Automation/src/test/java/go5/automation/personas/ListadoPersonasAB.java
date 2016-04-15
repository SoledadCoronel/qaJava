package go5.automation.personas;

import go5.automation.TestSuite;
import go5.pageObjects.DirectorioPage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class ListadoPersonasAB extends TestSuite {
			 	 
	
	 DirectorioPage directorio = null;

		
	 @BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		this.setUpMaven();
	 }
	 
	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
		
	
	@Test
	

	public void listadoPersonas() throws Exception { 
			
		directorio = new DirectorioPage(driver);     
         // Go to the configuration
         
		 this.goToConfiguration();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 this.goToMenu();
	
        
 	
 	// Go to  Users Menu
         Reporter.log("Abriendo administar personas" );  
         this.click(irAGroups);
         this.click(irAPersonas);
         Thread.sleep(1000);
         
         WebElement tablevailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tables")));
         
         // Ver si esta ordenado por default cuando carga la pagina
            Reporter.log("Ver si esta ordenado por default cuando carga la pagina");
          //  directorio.verificarOrden();
            
           
           //Volver a ordenar, en forma descendente
           
          this.ordenarPorNombre();
          Thread.sleep(1000);
          this.ordenarPorEstado();
          this.ordenarPorRegistro();
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Reporter.log("Verificar que esta en orden descendiente despues de apretar ordenar en Nombre");
            directorio.verificarOrden();
          
        //Verificar Paginado
          Reporter.log("Seleccionar otra pagina del listado");
          this.cssgoToAPagina(3);
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
           
         
       //Hacer una busqueda
          
         
          Reporter.log(" Hacer una busqueda de un usuario por Nombre");
               	       this.search("Automation");          	 
                  
                                   
                   //Chequear q se muestre en la tabla users
                   Reporter.log("El nombre del user buscado es:Automation");
                      Thread.sleep(1000);     
                   Reporter.log(" Imprimiendo el resultado del search:");
                  Reporter.log(directorio.getFirstName()); 
   	
                  
                  Reporter.log(" Hacer una busqueda de un usuario por Apellido");
                  this.search("AutomationLastName");
                   Thread.sleep(1000);
                  //Chequear q se mueste en la tabla users
                  Reporter.log("El nombre del user buscado es AutomationLastName");
                 
                  Reporter.log(" Imprimiendo el resultado del search");
                  Reporter.log(directorio.getFirstName());
                 
                  //Ir al profile del user buscado
                  this.click(firstRow);
	}         
}	