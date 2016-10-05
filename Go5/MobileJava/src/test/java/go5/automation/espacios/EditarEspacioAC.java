package go5.automation.espacios;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class EditarEspacioAC extends TestSuite {
	
	EspacioPage espacio=null;
		
	
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void editarEspacio() throws Exception { 
	
		espacio= new EspacioPage(driver); 
			
	        
		 Reporter.log(" Editando un espacio como user admin");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(1000);
		 
			
		 //Ir a espacios
		 espacio.goToEspacios();
		
		 Thread.sleep(5000);
			
			
		    // Ir a Editar un  Espacio 
		 
		 espacio.editarEspacio();
		 espacio.setNameEspacio("Editado");
		
		 //Activar o Desactivar el espacio
		 
		 espacio.activarEspacio();
		 espacio.activarActividadSocial();
		
		// espacio.cambiarIconoOso();
		 
		//Si es de tipo empresa, no aparece la opcion de cambiar el tipo espacio.setEspacioPrivado();
		 espacio.grabarEspacio();
		 Thread.sleep(1000);
			
		    Reporter.log("Caso de editar espacio finalizado correctamente");       
	           
	       
	
	}	
		
		
     }

