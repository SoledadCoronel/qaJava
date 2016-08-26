package go5.automation.social;


import go5.automation.SetUp;
import go5.pageObjects.EspaciosPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class SubirFotoAC extends SetUp {
	
	MuroSocialPage muro=null;
	EspaciosPage espacio=null;
	LoginPage login =null;

	
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
		espacio= new EspaciosPage(driver);
		js=  (JavascriptExecutor) driver;
	
		
		 Reporter.log(" Entrar a un espacio y postear");
		 
			 
			
		 //Ir a espacios
		//Tengo q ir a un espacio
		 espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(1000);
		muro.postFile();
		Thread.sleep(5000);
		muro.postear();
		Thread.sleep(6000);
		}	
		
		
     }

