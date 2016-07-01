package go5.automation.directorio;


import go5.automation.driver.AndroidSetup;

import org.junit.After;
import org.junit.Before;

import org.testng.annotations.Test;

import go5.pageObjects.BasePage;
import go5.pageObjects.DirectorioPage;





public class DirectorioTest extends AndroidSetup{
	
	// Css 
	
	
	
	// Uso de la pagina Directorio
	
	 
	 DirectorioPage directorio = null;
	 BasePage base=null;
	
	 @Before
	    
	    public void setUp() throws Exception {
	        
	        prepareAndroidForAppium();
	       
	    } 
	 
	 @After // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
		
	
	@Test 
	
	public void listadoDirectorio() throws Exception { 
	
				
	// Inicializar pagina de Directorio
		
	 directorio = new DirectorioPage(driver);
	 base = new BasePage(driver);
    
	 	 
		// Go to the menu (hamburguesita)
	 
	 	base.goToMenu();
       Thread.sleep(2000);  
 	
 	// Go to  Directorio de personas
        
 	 directorio.goToDirectorio();
 	 		
          
    //Hacer una busqueda
       
            
       directorio.search("User Mobile");
       
      //Ir al profile del user que busque
       Thread.sleep(3000);
       
       directorio.goToFirstProfileUser();
       
       Thread.sleep(3000);
            	       
	}              
}	