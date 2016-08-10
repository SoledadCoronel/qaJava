package go5.automation.espacios;


import go5.automation.SetUp;
import go5.pageObjects.EspacioPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class ListadoEspaciosAC extends SetUp {
	
		
	EspacioPage espacio=null;
	
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void listarEspacios() throws Exception { 
	
		espacio= new EspacioPage(driver); 
			
	        
		 Reporter.log(" Listado de espacios ");
		 
		
			
		 //Ir a espacios
		
		 espacio.goToEspacios();
		
		
					
			
		    // Ordenar espacios
				 
		 espacio.verificarOrdenDefault();
		
		 espacio.ordenarPorEstado();
		 Thread.sleep(2000);
		 espacio.ordenarPorNombreEspacio();
		 
		  this.goToPagina(2);
		 Thread.sleep(1000);
		
		 espacio.ordenarPorNombreEspacio();
		 espacio.buscarEspacio("Editado");  	
	      Thread.sleep(2000);     
	           
	       
	
	}	
	
	
		
     }

