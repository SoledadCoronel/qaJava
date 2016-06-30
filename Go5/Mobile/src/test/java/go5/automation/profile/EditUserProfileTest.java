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




public class EditUserProfileTest  extends AndroidSetup{
  //  private AppiumDriver<AndroidElement> driver;
    
    ProfilePage profile =null;
    LoginPage login=null;
    BasePage page=null;

   
    @Before
    
    public void setUp() throws Exception {
        
        prepareAndroidForAppium();
       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void editProfileUser() throws InterruptedException {
    
    	// Init pages
    	
   	 profile = new ProfilePage(driver); 
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
       
   
       // Test
     login.loginToGoAsUSerBasic();
     page.goToMenu();
     Thread.sleep(2000);
     page.goToProfile();
     Thread.sleep(2000);
     profile.editarProfile();
     profile.agregarDatosLaborales();
    // profile.agregarDatosPersonales();
     profile.agregarRedesSociales();
     Thread.sleep(3000);
     profile.grabarUsuario();
    
     
         
    }

}

