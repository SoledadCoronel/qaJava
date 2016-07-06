package go5.automation.profile;



//driver
import io.appium.java_client.TouchAction;
import go5.automation.driver.AndroidSetup;




//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages



import org.openqa.selenium.WebElement;

import go5.pageObjects.*;


//Utils




public class ConfigurarCuentaTest  extends AndroidSetup{
  
    
    
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
    	
   
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
       
   
       // Test
     login.loginToGoAsUSerBasic();
     page.goToMenu();
     Thread.sleep(2000);
    page.goToConfigurarCuenta();
    /* 
    TouchAction action = new TouchAction(driver);
    WebElement element = driver.findElementByCssSelector("space:last-child li:nth-child(2) a");
   // action.press(element);
    action.moveTo(25, 50);
   */
    Thread.sleep(4000);
         
    }

}

