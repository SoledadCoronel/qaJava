package go5.automation.login;



//driver
import go5.automation.driver.AndroidSetup;

//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages

import go5.pageObjects.*;


//Utils




public class LoginUserBasicTest  extends AndroidSetup{
  //  private AppiumDriver<AndroidElement> driver;
    
    
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
    public void login() throws InterruptedException {
    
    	// Init pages
    	
   	
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
   	
      
   
       // Test
   	 
      login.loginToGoAsUSerBasic();
       page.logout();
      Thread.sleep(3000);
         
         
    }

}

