package go5.automation.personas;

import go5.automation.TestSuite;
import go5.pageObjects.PersonasPage;
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
		Thread.sleep(1000);
               
         //Filtrados
         
 	 //Elegir los inactivos
		
		Reporter.log(" Seleccionar usuarios inactivos");
         personas.elegirUsuarios(2);
         Thread.sleep(3000);
 	       personas.verificarUsuariosInactivos();
                 
        	  // Elegir Usuarios No Registrados
             Reporter.log(" Seleccionar usuarios no registrados");
             personas.elegirUsuarios(3);
           Thread.sleep(3000);
            personas.verificarUsuariosNoRegistrados();
                       
            	// Elegir Usuarios Activos
                 Reporter.log(" Seleccionar usuarios activos");
                    personas.elegirUsuarios(1);
                       Thread.sleep(3000);
                  personas.verificarUsuariosActivos();
                  
                  this.goToPagina(4);
               
               // Elegir Usuarios Activos
                  Reporter.log(" Seleccionar usuarios activos");
                     personas.elegirUsuarios(1);
                        Thread.sleep(3000);
                   personas.verificarUsuariosActivos();
                  
           	 
              
	
	}
}	