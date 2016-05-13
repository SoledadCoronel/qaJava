package go5.automation.social;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.MuroSocialPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class MuroSocialAC extends TestSuite {
	
	MuroSocialPage muro=null;
	EspacioPage espacio=null;
	
	private String iconoEmpresa=".igospaceadmin";
		
	
	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
	
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
		 Thread.sleep(1000);
		 
			
		 //Ir a espacios
		//Tengo q ir a un espacio
		espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(3000);
		
		muro.postTexto("Prueba");
		Thread.sleep(2000);
		muro.postear();
		Thread.sleep(3000);
		muro.postTexto("Try the second");
		muro.postear();
		Thread.sleep(3000);
		
		
	           
	       
	
	}	
		
		
     }

