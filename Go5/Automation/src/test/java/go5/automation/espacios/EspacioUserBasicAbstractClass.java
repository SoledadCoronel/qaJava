package go5.automation.espacios;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;





public class EspacioUserBasicAbstractClass extends TestSuite {
	
			
	private String crearEspacio = new String (".title .primary");

	EspacioPage espacio=null; 
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
		this.quitBrowser();
		}
	
		 
	 @Test
	
	public void unirseAEspacio() throws Exception { 
	
		 espacio= new EspacioPage(driver);    		
	        
		 Reporter.log(" Unirse como user basic a un espacio y verificar que no este el boton de Crear Espacio");
		 
		// Go to hamburguesita
		 
		 this.goToMenu();
			Thread.sleep(1000);
		 
		
		 
		 espacio.goToEspacios();
			
			
		    // Verificar que no esta el boton de Crear Espacio
		 
		     try{
		 this.click(crearEspacio);
		     }    
		    		 catch (Exception e) {

		    		     Reporter.log("No esta el boton Crear Espacio");

		    		
		    		 }
	         
		}	
			
     }

