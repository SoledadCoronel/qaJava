package go5.automation.espacios;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ListadoEspaciosAC extends TestSuite {
	
	

	
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
	
	public void listarEspacios() throws Exception { 
	
		espacio= new EspacioPage(driver); 
			
	        
		 Reporter.log(" Listado de espacios ");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(1000);
		 
			
		 //Ir a espacios
		
		 espacio.goToEspacios();
		
		
					
			
		    // Ordenar espacios
				 
		 espacio.verificarOrdenDefault();
		 espacio.ordenarPorTipo();
		 espacio.ordenarPorEstado();
		 Thread.sleep(1000);
		 espacio.ordenarPorNombreEspacio();
		 
		  this.goToPagina(2);
		 Thread.sleep(1000);
		 espacio.ordenarPorTipo();
		 espacio.ordenarPorNombreEspacio();
		   	
	           
	           
	       
	
	}	
	
	
		
     }

