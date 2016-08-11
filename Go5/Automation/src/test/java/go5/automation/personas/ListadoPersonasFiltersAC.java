package go5.automation.personas;

import go5.automation.SetUp;
import go5.pageObjects.AdministrarPersonasPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;




public class ListadoPersonasFiltersAC extends SetUp {
	
	
	AdministrarPersonasPage personas=null;
	HomePage home=null;   

	private Integer allUsers=0;
	private Integer activos=1;
	private Integer inactivos=2;
	private Integer noRegistrados =3;
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
	
	@Test
	
	public void listadoPersonasFilters() throws Exception { 
	
	 personas= new AdministrarPersonasPage(driver);
     home = new HomePage(driver);
     
     
         // Go to the configuration
	     home.goToConfiguration();
	     home.goToAdministrar();
     
         //Filtrados
         
	     //Elegir los inactivos
		 Thread.sleep(5000);
	     Reporter.log(" Seleccionar usuarios inactivos");
	     personas.elegirUsuarios(inactivos);
	      personas.verificarUsuariosInactivos();
         Thread.sleep(3000);  
        
         // Elegir Usuarios No Registrados
           Reporter.log(" Seleccionar usuarios no registrados");
           personas.elegirUsuarios(noRegistrados);
            personas.verificarUsuariosNoRegistrados();
            Thread.sleep(3000);          
         
            // Elegir Usuarios Activos
             Reporter.log(" Seleccionar usuarios activos");
             personas.elegirUsuarios(activos);
             Thread.sleep(3000);
             personas.verificarUsuariosActivos();
             
                  this.goToPagina(4);
               
               // Elegir todos los usuarios
                  Reporter.log(" Seleccionar usuarios activos");
                    personas.elegirUsuarios(allUsers);
  	}
}	