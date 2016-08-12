package go5.automation.personas;

import go5.automation.SetUp;

import go5.pageObjects.AdministrarPersonasPage;
import go5.pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;




public class ListadoPersonasAB extends SetUp {
			 	 
	
	AdministrarPersonasPage personas = null;
	HomePage home=null;

	 
	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
		
	
	@Test
	

	public void listadoPersonas() throws Exception { 
			
		personas = new AdministrarPersonasPage(driver);
		home = new HomePage(driver);
         // Go to the configuration
       
		// Go to the configuration
	     home.goToConfiguration();
	     home.goToAdministrar();
    
        //Filtrados
		      
		  Reporter.log(" Hacer una busqueda de un usuario por Nombre");

          
          //Chequear q se muestre en la tabla users
          Reporter.log("El nombre del user buscado es:Automation");
        this.search("Automation ");    
          Thread.sleep(1000);     
          Reporter.log(" Imprimiendo el resultado del search:");
	  
         
           
          
        //Verificar Paginado
          Reporter.log("Seleccionar otra pagina del listado");
          this.cssgoToAPagina(3);
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
           
         
       //Hacer una busqueda
          
         
          Reporter.log(" Hacer una busqueda de un usuario por Nombre");

                                   
                   //Chequear q se muestre en la tabla users
                   Reporter.log("El nombre del user buscado es:Automation");
                      Thread.sleep(1000);     
                   Reporter.log(" Imprimiendo el resultado del search:");
                
   	
                  
                  Reporter.log(" Hacer una busqueda de un usuario por Apellido");
                  this.search("AutomationLastName");
                   Thread.sleep(1000);
                  //Chequear q se mueste en la tabla users
                  Reporter.log("El nombre del user buscado es AutomationLastName");
                 
                  Reporter.log(" Imprimiendo el resultado del search");
                 
                 
                  //Ir al profile del user buscado
                  this.click(firstRow);
	}         
}	