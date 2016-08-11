package go5.automation.espacios;


import go5.automation.SetUp;
import go5.pageObjects.AgregarEspacioPage;
import go5.pageObjects.EspacioPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class CrearEspacioPrivadoAC extends SetUp {
	

	
	AgregarEspacioPage addespacio=null;
	
		
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void crearEspacioEmpresa() throws Exception { 
	
		addespacio= new AgregarEspacioPage(driver); 
			
	        
		 Reporter.log(" Creando un espacio empresa como user admin");
		 
				
			
		    // Ir a Crear Espacio 
		 
		addespacio.goToCrearEspacio();
		 
		   		       
		      //Cargar formulario del espacio
		     	addespacio.setNameEspacio("PRIVADO");
		     	
		 		addespacio.setDescriptionEspacio("Espacio privado");	 
		 
		 	
	       //Configuracion del espacio
	          
	          //Desactivar
	          Reporter.log("Desactivar el espacio");
	         addespacio.activarEspacio();
	     
	
	         //Actividad Social
	          Reporter.log("Desactivar Acitividad Social");
	         addespacio.activarActividadSocial();
	  
	          //Seleccionar el icono
	        //  Reporter.log("Seleccionar el icono del espacio");
	        //  espacio.cambiarIconoBanana();
	         Thread.sleep(1000);
	         addespacio.setEspacioPrivado();
	         Thread.sleep(1000);
	     
	           	           
	           //Grabar el espacio nuevo
	          
	           addespacio.grabarEspacio();
	                   
	           Thread.sleep(1000);
	           
	           Reporter.log("Caso de crear espacio privado finalizado correctamente");  
	}	
	
	
		
     }

