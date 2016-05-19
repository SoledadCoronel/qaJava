package go5.automation.social;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;



public class Post500CharsAC extends TestSuite {
	
	MuroSocialPage muro=null;
	EspacioPage espacio=null;
	LoginPage login =null;
	
	private String iconoEmpresa=".igospaceadmin";
	
	
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
		 
 
	 
	@Test
	
	public void postearTexto() throws Exception { 
	
		muro= new MuroSocialPage(driver); 
		espacio= new EspacioPage(driver);
		
			        
		 Reporter.log(" Entrar a un espacio y postear");
		 
		// Go to hamburguesita
		 
		 this.click(irAMenu);
		 Thread.sleep(3000);
		 
			
		 //Ir a espacios
		//Tengo q ir a un espacio
		 espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(1000);
		muro.postTexto(muro.randomString(200)+"    "+muro.randomString(100)+"        "+muro.randomString(100)+"    "+muro.randomString(200));
		muro.postear();
		Thread.sleep(2000);
		muro.verifyLinkVerMas();
		Thread.sleep(2000);
		muro.verifyLinkVerMenos();
		Thread.sleep(2000);
		
	 
	
	}	
		
		
     }

