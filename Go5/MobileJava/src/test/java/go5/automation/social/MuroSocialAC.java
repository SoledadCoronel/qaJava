package go5.automation.social;


import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;

import org.testng.Assert;
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
	
			 
	 
	 
	@Test(description="Creo un post con usuario admin, lo likeo.Respondo como usuario basico,likeo y respondo")
	
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
			
	
		muro.postTexto("Posteo como usuario admin para probar los likes ");
		muro.postLink(link);
		Thread.sleep(6000);
		muro.postear();
		Thread.sleep(2000);
		Reporter.log("Like el post creado como user admin");
		muro.likearPost();
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
		Reporter.log("Imprimir y assertear que el texto posteado es el del user admin");
		Reporter.log(muro.getTextFirstPost());
		//Assert.assertEquals(muro.getTimeFirstPost(), "HACE 0 MINUTOS");
		Reporter.log("Likear el post del user admin, como user basic");
		muro.likearPost();
		Reporter.log("Imprimo la cantidad de likes del post:");
		Reporter.log(muro.countLikesPost());
		// Aserteo que el post tengo 2 likes, uno del user admin y otro del user basic
		//Assert.assertEquals(muro.countLikesPost(),"2 LIKES");
		//Deslike el post y vuelvo a contar
		muro.likearPost();
		
		muro.comentarFIrstPost("Comento el post del usuario admin, siendo el user basic");
		muro.likearComment();
		// Cuento los likes del comment, 1 solo
		Reporter.log("Imprimo la cantidad de likes del comment, debe ser 1");
		Reporter.log(muro.countLikesComments());
		Thread.sleep(2000);
		Reporter.log("Imprimo la cantidad de likes del post:");
		Reporter.log(muro.countLikesPost());
		
		
		// Repondo a mi comment y lo likeo
		
		muro.responderComment("Respondo el comment que hice como user basic");
		Thread.sleep(4000);
	    
		muro.likearResponseComment();
	    Reporter.log(muro.countLikesResponseComment());
	  //  Assert.assertEquals(muro.countLikesResponseComment(),"1 likes");

		Reporter.log(" Ir al profile del posteador, que es el user admin");
		muro.goToProfilePost();
		Thread.sleep(2000);
	  
	   
	
	}	
		
		
     }

