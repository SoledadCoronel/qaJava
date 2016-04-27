package go5.automation.profile;


import go5.automation.TestSuite;


import go5.pageObjects.ProfilePage;






import org.openqa.selenium.By;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;



public class IrAPerfilSidebarAC extends TestSuite {
	


 ProfilePage profile =null;
	

	
 
   

 @AfterClass // call function to close browser 
	
	public void teardown(){
		this.quitBrowser();
	}
		
	@Test
	
	public void editProfileDesdeElSideBar() throws Exception { 
	
		
				
			 profile = new ProfilePage(driver);
			 
			
			
			 
			 
			// Go to the user menu
			  this.goToMenuUsuario();
		
				
				//Ir a ver perfil
			profile.goToProfileSideBar();
			
				
				
				//Editar perfil
			   
			   profile.editarProfile();	
				 Thread.sleep(1000);
		
				
				//Insertar datos laborales
			    profile.editarDatosLaborales();
				
		         //Telefono
			    profile.agregarTelefono();
		        
		         
		      	          
		          //Datos Personales
			    
		         profile.agregarDatosPersonales(); 
	      
		            
		 		profile.agregarRedesSociales();
		 		
		 		profile.grabarUsuario();
		     
		            // Grabar el nuevo usuario creado
		            Reporter.log("Grabando perfil editado");
		        Thread.sleep(2000);
		         driver.findElement(By.cssSelector(".primary")).click();    
		         Reporter.log("Edicion de profile fue exitoso");
		         
		    
		
	
	}	
	
	
		
     }

