package go5.automation.espacios;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class CrearEspacioEmpresaAC extends TestSuite {
	

	
	EspacioPage espacio=null;
	
		
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void crearEspacioEmpresa() throws Exception { 
	
		espacio= new EspacioPage(driver); 
			
	        
		 Reporter.log(" Creando un espacio empresa como user admin");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(1000);
		 
			
		 //Ir a espacios
		 espacio.goToEspacios();
		
		 Thread.sleep(1000);
			
			
		    // Ir a Crear Espacio 
		 
		 espacio.crearEspacio();
		 
		   		       
		      //Cargar formulario del espacio
		     	espacio.setNameEspacio("EMPRESA");
		     	
		 		espacio.setDescriptionEspacio("Espacio del tipo empresa");	 
		 
		 	
	       //Configuracion del espacio
	          
	          //Desactivar
	          Reporter.log("Desactivar el espacio");
	       //   espacio.activarEspacio();
	     
	
	         //Actividad Social
	          Reporter.log("Desactivar Acitividad Social");
	       //  espacio.activarActividadSocial();
	  
	          //Seleccionar el icono
	          Reporter.log("Seleccionar el icono del espacio");
	         // espacio.cambiarIconoBanana();
	      
	          espacio.setEspacioEmpresa();
	      	           
	           //Grabar el espacio nuevo
	          
	           espacio.grabarEspacio();
	                   
	           Thread.sleep(1000);
	           
	           Reporter.log("Caso de crear espacio empresa finalizado correctamente");  
	}	
	
	
		
     }

