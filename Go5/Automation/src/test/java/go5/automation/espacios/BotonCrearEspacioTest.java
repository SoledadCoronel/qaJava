package go5.automation.espacios;

import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;





public class BotonCrearEspacioTest extends TestSuite {
	
			
	


	
	EspacioPage espacio=null; 
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
		this.quitBrowser();
		}
	
		 
	 @Test
	
	public void userBasicdoesnthaveCrearEspacioButton() throws Exception { 
	
		 espacio= new EspacioPage(driver); 
    		
	        
		 Reporter.log(" Unirse como user basic a un espacio y verificar que no este el boton de Crear Espacio");
		 
		 				
			
		    // Verificar que no esta el boton de Crear Espacio
		 
		     try{
		    espacio.goToCrearEspacio();
		   // driver.findElement(crearEspacio).click();
		      }    
		    		 catch (Exception e) {

		    		     Reporter.log("No esta el boton Crear Espacio");

		    		
		    		 }
	         
		}	
			
     }

