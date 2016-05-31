package go5.automation.social;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;



public class MuroSocialAC extends TestSuite {
	
	MuroSocialPage muro=null;
	EspacioPage espacio=null;
	LoginPage login =null;
	
	private String iconoEmpresa=".igospaceadmin";
	private String iconoCallCenter=".igospacecallcenter";
	private String link ="https://gointegrotech.atlassian.net/browse/FRONT-823";
		
	
	
	
	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
	
			 
	 
	 
	@Test
	
	public void postearLikearComentar() throws Exception { 
	
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
			
	
		Thread.sleep(10000);
		muro.postTexto("Posteo como usuario admin para probar los likes ");
		muro.postLink(link);
		Thread.sleep(3000);
		muro.postear();
		Thread.sleep(2000);
		Reporter.log("Like el post creado como user admin");
		muro.likearFirstPost();
		Thread.sleep(2000);
		this.goToMenuUsuario();	
		Reporter.log("Desloguearse como usuario admin");
		this.logout();
		Thread.sleep(2000);
		Reporter.log("Loguearse como usuario basico");
		login.loginToGoAsUSerBasic();
		Thread.sleep(3000);
		this.goToMenu();
		Thread.sleep(1000);
		espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(2000);
		Reporter.log("Imprimir y assertear que el texto posteado es el deñ user admin");
		Reporter.log(muro.getTextFirstPost());
		//Assert.assertEquals(muro.getTimeFirstPost(), "HACE 0 MINUTOS");
		Reporter.log("Likear el post del user admin, como user basic");
		muro.likearFirstPost();
		muro.comentarFIrstPost("Comento el post del usuario admin, siendo el user basic");
		Thread.sleep(2000);
		Reporter.log(" Ir al profile del posteador, que es el user admin");
		muro.goToProfilePost();
		Thread.sleep(2000);
	  
	   
	
	}	
		
		
     }

