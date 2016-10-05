package go5.automation.profile;



//driver
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import go5.automation.driver.AndroidSetup;





//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages




import org.openqa.selenium.WebElement;

import go5.pageObjects.*;


//Utils




public class MuroUserProfileTest  extends AndroidSetup{
  
    
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
     muro.postTexto("Post a ser borrado");
      Thread.sleep(5000);
     muro.postear();
     Thread.sleep(3000);
  /*   muro.likearPost();
     Thread.sleep(3000);
     muro.comentarFIrstPost(" Comento el post con el mismo user");
      Thread.sleep(3000);
      muro.likearComment();
      Thread.sleep(5000);*/
     muro.eliminarPost();
    // driver.findElementByCssSelector(".posttext:nth-child(2) .btnoptions").click();
     	Thread.sleep(2000);
     	//Me suicheo a nativa para los modals de eliminar post
       driver.context("NATIVE_APP");
       System.out.println(driver.getContext());
     //Clickear options del post
     //  driver.findElementByCssSelector(".posttext:nth-child(2) .btnoptions").click();
       Thread.sleep(5000);
       List<WebElement> lista = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
       System.out.println(lista.get(0).getText());
       lista.get(0).click();
       Thread.sleep(3000);
       List<WebElement> lista2 = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
       System.out.println(lista.get(1).getText());
        lista2.get(1).click();
         Thread.sleep(5000);
         
    }

}

