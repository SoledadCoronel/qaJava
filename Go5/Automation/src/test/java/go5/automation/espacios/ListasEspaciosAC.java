package go5.automation.espacios;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ListasEspaciosAC extends TestSuite {
	
	

	
	EspacioPage espacio=null;
	

	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void crearEspacio() throws Exception { 
	
		espacio= new EspacioPage(driver); 
			
	        
		 Reporter.log(" Creando un espacio como user admin");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(1000);
		 
			
		 //Ir a espacios
		 espacio.goToEspacios();
		
		 Thread.sleep(1000);
			
			
		    // Ir a Editar un  Espacio 
		 
		 espacio.editarEspacio();
		 espacio.setNameEspacio("Espacio Editado");
		
		 //Activar o Desactivar el espacio
		 
		 espacio.activarEspacio();
		 espacio.activarSocial();
		 
		 
		   	
	           
	           
	       
	
	}	
	
	
		
     }

