package go5.automation.personas;

import go5.automation.TestSuite;
import go5.pageObjects.PersonasPage;



import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;




public class ListadoPersonasFiltersAC extends TestSuite {
	
	
	PersonasPage personas=null;
	   

	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
	
	@Test
	
	public void listadoPersonasFilters() throws Exception { 
	
	 personas= new PersonasPage(driver);
       
         // Go to the configuration
		this.goToConfiguration();
		this.goToMenu();
		Thread.sleep(1000);
         
		personas.goToPersonas();
         
               
         //Filtrados
         
 	 //Elegir los inactivos
      personas.elegirUsuarios(3);
        
         personas.verificarUsuariosInactivos();
    
             
        	  // Elegir Usuarios No Registrados
             Reporter.log(" Seleccionar usuarios no registrados");
                                      
             personas.elegirUsuarios(4);
// userselect.selectByIndex(4);
             
             //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
             Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users que no estan registrados");
     	
           
             for(int i = 1;i<10;i++)
            	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(6n)")).getText(), "SIN CHEQUEAR");
            	 Reporter.log("Todos los usuarios de la lista se encuentran en estado no registrado");
            
            	// Elegir Usuarios Activos
                 Reporter.log(" Seleccionar usuarios activos");
                 
                
                 
                 
                personas.elegirUsuarios(2);
              //   userselect.selectByIndex(2);
                 //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
                 Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users activos");
         	               
                 for(int i = 1;i<10;i++)
                	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "CHEQUEADO");
                	 Reporter.log("Todos los usuarios de la lista se encuentran activados");
           	 
              
	
	}
}	