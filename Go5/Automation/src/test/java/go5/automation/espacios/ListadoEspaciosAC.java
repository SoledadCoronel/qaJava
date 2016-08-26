package go5.automation.espacios;


import go5.automation.SetUp;
import go5.pageObjects.EspaciosPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class ListadoEspaciosAC extends SetUp {
	
		
	EspaciosPage espacio=null;
	HomePage home=null;
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void listarEspacios() throws Exception { 
	
		espacio= new EspaciosPage(driver); 
		home = new HomePage(driver);	
	        
		 Reporter.log(" Listado de espacios ");
		 
		home.goToConfiguration();
		home.goToHome();	
		 //Ir a espacios
		 home.goToHome();
		home.goToEspacios();
		
		Thread.sleep(3000);
		
			
		    // Ordenar espacios
				 
			
		 espacio.ordenarPorNombreEspacio();		  
		 espacio.buscarEspacio("Editado");  	
	      Thread.sleep(2000);     
	           
	       
	
	}	
	
	
		
     }

