package go5.automation.directorio;



//driver
import go5.automation.driver.AndroidSetup;



//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages



import go5.pageObjects.*;


//Utils




public class SearchUserTest  extends AndroidSetup{
  
    
    DirectorioPage directorio =null;
    LoginPage login=null;
    BasePage page=null;
    MuroSocialPage muro=null;

   
    @Before
    
    public void setUp() throws Exception {
        
        prepareAndroidForAppium();
       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void searchForUser() throws InterruptedException {
    
    	// Init pages
    	
   	 directorio = new DirectorioPage(driver); 
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
   	 muro = new MuroSocialPage(driver);
       
   
       // Test
     login.loginToGoAsUSerBasic();
     page.goToMenu();
     Thread.sleep(2000);
     page.goToDirectorio();
      Thread.sleep(5000);
      directorio.search("User Mobile");   
     Thread.sleep(5000);
     directorio.goToFirstProfileUser();
     Thread.sleep(5000);
    
     
   
         
    }

}

