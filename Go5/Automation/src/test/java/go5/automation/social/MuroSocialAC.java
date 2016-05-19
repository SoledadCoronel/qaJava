package go5.automation.social;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class MuroSocialAC extends TestSuite {
	
	MuroSocialPage muro=null;
	EspacioPage espacio=null;
	LoginPage login =null;
	
	private String iconoEmpresa=".igospaceadmin";
	private String iconoCallCenter=".igospacecallcenter";
		
	
	
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void postearTexto() throws Exception { 
	
		muro= new MuroSocialPage(driver); 
		espacio= new EspacioPage(driver);
		login =new LoginPage(driver);
			
	        
		 Reporter.log(" Entrar a un espacio y postear");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(3000);
		 
			
		 //Ir a espacios
		//Tengo q ir a un espacio
		 espacio.clickEspacioSidebar(iconoEmpresa);
		//espacio.clickEspacioSidebar(iconoCallCenter);
		Thread.sleep(1000);
		
		muro.postTexto("Posteo como usuario admin prueba selenium ");
		Thread.sleep(2000);
		muro.postear();
		this.goToMenuUsuario();		
		this.logout();
		Thread.sleep(2000);
		login.loginToGoAsUSerBasic();
		Thread.sleep(3000);
		this.goToMenu();
		Thread.sleep(1000);
		espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(2000);
		Reporter.log(muro.getTextFirstPost());
		Assert.assertEquals(muro.getTimeFirstPost(), "HACE 0 MINUTOS");
	  
	   
	
	}	
		
		
     }

