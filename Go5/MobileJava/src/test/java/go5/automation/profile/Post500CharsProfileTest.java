package go5.automation.profile;



//driver
import go5.automation.driver.AndroidSetup;



//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages



import go5.pageObjects.*;


//Utils




public class Post500CharsProfileTest  extends AndroidSetup{
  
    
    ProfilePage profile =null;
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
    public void postUserProfile() throws InterruptedException {
    
    	// Init pages
    	
   	 profile = new ProfilePage(driver); 
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
   	 muro = new MuroSocialPage(driver);
       
   
       // Test
     login.loginToGoAsUSerBasic();
     page.goToMenu();
     Thread.sleep(2000);
     page.goToProfile();
     Thread.sleep(5000);
     profile.goToMuroProfile();
     Thread.sleep(5000);
     muro.goToCreatePost();
     Thread.sleep(5000);
     muro.postTexto(muro.randomString(200)+"    "+muro.randomString(100)+"        "+muro.randomString(100)+"    "+muro.randomString(200));
     Thread.sleep(8000);
     muro.postear();
     Thread.sleep(3000);
     muro.likearPost();
     Thread.sleep(3000);
     muro.comentarFIrstPost(" Comento el post con el mismo user");
      Thread.sleep(3000);
      muro.likearComment();
      Thread.sleep(5000);
          
    }

}

