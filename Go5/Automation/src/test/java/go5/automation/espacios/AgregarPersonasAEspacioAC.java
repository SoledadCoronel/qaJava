package go5.automation.espacios;


import go5.automation.SetUp;
import go5.pageObjects.AgregarEspacioPage;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class AgregarPersonasAEspacioAC extends SetUp {
	
		
	EspacioPage espacio=null;
	HomePage home=null;
	AgregarEspacioPage editspace=null;
	
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void listarEspacios() throws Exception { 
	
		espacio = new EspacioPage(driver);		
		home= new HomePage(driver);
		editspace= new AgregarEspacioPage(driver);

		Reporter.log(" Editando un espacio como user admin");

		// Ir a espacios
		Thread.sleep(2000);
		home.goToEspacios();

		Thread.sleep(2000);

	        
		 Reporter.log(" Listado de espacios ");
		 
							
			
		    // Ordenar espacios
				 
		 espacio.buscarEspacio("EMPRESA");
		 Thread.sleep(2000);
				
		
	           
	       
	
	}	
	
	
		
     }

