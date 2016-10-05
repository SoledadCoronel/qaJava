package go5.automation.social;



//driver
import go5.automation.driver.AndroidSetup;






//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages




import org.testng.Reporter;

import go5.pageObjects.*;


//Utils






public class PostearArchivoTest  extends AndroidSetup{
  
    
    ProfilePage profile =null;
    LoginPage login=null;
    BasePage page=null;
    MuroSocialPage muro=null;
    EspacioPage espacio=null;

    private String iconoEmpresa=".igospaceadmin";
    
    private String link ="http://www.lanacion.com.ar/";

    		
    @Before
    
    public void setUp() throws Exception {
        
        prepareAndroidForAppium();
       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void postearComentarLikear() throws InterruptedException {
    
    	// Init pages
    	
   	 profile = new ProfilePage(driver); 
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
   	 muro = new MuroSocialPage(driver);
       
   
       // Test
     login.loginToGoAsUSerBasic();
     page.goToMenu();
     Thread.sleep(2000);
      // espacio.clickEspacioSidebar(".space:nth-child(3) li a");
	 	driver.findElementByCssSelector(".space:nth-child(3) li a").click();
	 	Thread.sleep(6000);
	 	 muro.goToCreatePost();
	     Thread.sleep(5000);
	     muro.postFile();
	     Thread.sleep(5000);
		
   
     
         
    }

}

