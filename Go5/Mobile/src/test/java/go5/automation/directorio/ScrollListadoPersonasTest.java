package go5.automation.directorio;



//driver
import java.util.HashMap;

import go5.automation.driver.AndroidSetup;







//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages



import org.openqa.selenium.JavascriptExecutor;

import go5.pageObjects.*;


//Utils




public class ScrollListadoPersonasTest  extends AndroidSetup{
  
    
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
    public void scrollPersonas() throws InterruptedException {
    
    	// Init pages
    	
   	 directorio = new DirectorioPage(driver); 
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
   	 muro = new MuroSocialPage(driver);
   	 
   	 Integer startX=(int) 0.95;
   	 Integer startY=(int) 0.50;
   	 Integer endX=(int) 0.01;
   	 Integer endY=(int) 0.50;
   	 Integer duration =(int) 3.0;
   	 
     // java
 
   	 JavascriptExecutor js = (JavascriptExecutor) driver;
  
     //Set the hashmap with positions 
     
     HashMap<String, Double> swipeObject = new HashMap<String, Double>();
     swipeObject.put("startX", 0.95);
     swipeObject.put("startY", 0.50);
     swipeObject.put("endX", 0.01);
     swipeObject.put("endY", 0.50);
     swipeObject.put("duration", 3.0);
     
 
     // Test
     login.loginToGoAsUSerBasic();
     page.goToMenu();
     Thread.sleep(2000);
     page.goToDirectorio();
     Thread.sleep(3000);
       page.swipeLeftToRight();  
    // driver.swipe(startX, startY, endX, endY, duration);
     js.executeScript("mobile: swipe", swipeObject);
     Thread.sleep(3000);
  
    }   
     
}

