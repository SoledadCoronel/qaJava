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
		Reporter.log(muro.returnTextoPublicado());
		muro.postTexto("TXbVBsVOiw ON6UvQ322k vahrFidyJP ZTpr5vbGIL fwiOQpconr BKkVvrWJ2b lEQPLO7Vtn MhJMnk0zwG qSjLwSmeCn qKGGWHROLZ wWDy1o9W9f SEiIyYU0lB lYus4U0Bkw TXbVBsVOiw ON6UvQ322k vahrFidyJP ZTpr5vbGIL fwiOQpconr BKkVvrWJ2b lEQPLO7Vtn MhJMnk0zwG qSjLwSmeCn qKGGWHROLZ wWDy1o9W9f SEiIyYU0lB lYus4U0Bkw TXbVBsVOiw ON6UvQ322k vahrFidyJP ZTpr5vbGIL fwiOQpconr BKkVvrWJ2b lEQPLO7Vtn MhJMnk0zwG qSjLwSmeCn qKGGWHROLZ wWDy1o9W9f SEiIyYU0lB lYus4U0Bkw TXbVBsVOiw ON6UvQ322k vahrFidyJP ZTpr5vbGIL fwiOQpconr BKkVvrWJ2b lEQPLO7Vtn MhJMnk0zwG qSjLwSmeCn qKGGWHROLZ wWDy1o9W9f SEiIyYU0lB lYus4U0Bkw");
		Thread.sleep(5000);
		Reporter.log(muro.returnTextoPublicado());
		
		
	           
	       
	
	}	
		
		
     }

