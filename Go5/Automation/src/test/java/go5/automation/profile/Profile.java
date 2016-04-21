package go5.automation.profile;


import go5.automation.TestSuite;
import go5.pageObjects.ProfilePage;


import org.openqa.selenium.By;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;



public class Profile extends TestSuite  {
	


ProfilePage profile = null;


 @AfterClass // call function to close browser 
	
	public void teardown(){
		driver.quit();
	}
		
	@Test
	
	public void editProfile() throws Exception { 
	
		
		 profile = new ProfilePage(driver);
		 
		
		
		 
		 
		// Go to the user menu
		  this.goToMenuUsuario();
		//	driver.findElement(By.cssSelector(".applications .users .user")).click();
	
			
			//Ir a ver perfil
		   profile.goToProfile();
		//	driver.findElement(By.cssSelector(".applications .users .subusers li a[title='Ir a ver perfil']")).click();
			
			
			//Editar perfil
		   
		   profile.editarProfile();	
			 
	
			
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
	         
	      /*   //Logout
	        driver.findElement(By.cssSelector(".applications .users .user")).click();
	     	driver.findElement(By.cssSelector("a[title='Cierra la sesión']")).click();
	     	Reporter.log("Se cerro la sesion");
	   	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	*/
	
	}	
	
	
		
     }

