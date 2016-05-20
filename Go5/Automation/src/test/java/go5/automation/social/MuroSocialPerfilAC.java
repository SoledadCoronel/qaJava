package go5.automation.social;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;
import go5.pageObjects.ProfilePage;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class MuroSocialPerfilAC extends TestSuite {
	
	MuroSocialPage muro=null;
	EspacioPage espacio=null;
	LoginPage login =null;
	ProfilePage profile=null;
	

	private String link ="https://goc.gointegro.com/benefits/benefit/4176";	
	
	
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void postearTexto() throws Exception { 
	
		muro= new MuroSocialPage(driver); 
		espacio= new EspacioPage(driver);
		profile =new ProfilePage(driver);
			
	        
		 Reporter.log(" Entrar a un espacio y postear");
		 
		
			// Go to the user menu
		  this.goToMenuUsuario();
	
			
			//Ir a ver perfil
		   profile.goToProfile();
		 
			
		 //Ir al muro del perfil
		
		muro.irAMuroEnPerfil();
		muro.postTexto("Posteo en el muro del profile ");
		muro.postLink(link);
		Thread.sleep(3000);
		muro.postear();
		Thread.sleep(3000);
		Reporter.log(muro.getTextFirstPost());
		Assert.assertEquals(muro.getTimeFirstPost(), "HACE 0 MINUTOS");
	  
	   
	
	}	
		
		
     }

