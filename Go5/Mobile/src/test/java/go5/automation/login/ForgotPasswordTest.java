package go5.automation.login;



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





public class ForgotPasswordTest  extends AndroidSetup{
 
     private String wrongEmail= "cualquiera@gointegro.com";
     private String numericEmail= "11212232";
     private String validEmail="marina.touceda@gointegro.com";
     LoginPage login=null;


   
    @Before
    
    public void setUp() throws Exception {
        
        prepareAndroidForAppium();
       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

   /* @Test
    public void forgotPasswordFormatmail() throws InterruptedException {
         

   	 login = new LoginPage(driver);
   	      
          // Test
   	 login.goToForgotPassword();
   	 login.insertEmailForgotPassword(numericEmail);
   	 login.pressSendForgotPassword();
   	 login.validateFormatEmail();
       Thread.sleep(13000);
    }     
      
       @Test
       public void forgotPasswordEmailNotRegistered() throws InterruptedException {
       
       	// Init pages
       	
      	 login = new LoginPage(driver);
             
      
          // Test
      	 login.goToForgotPassword();
      	 login.insertEmailForgotPassword(wrongEmail);
      	 Thread.sleep(2000);
      	 login.pressSendForgotPassword();
      	Thread.sleep(4000);
      	System.out.println(driver.findElementByCssSelector(".signup fieldset:first-child .reject").getText());
         	// login.validateErrorEmail();
          Thread.sleep(3000);
         
    }
*/
       @Test
       public void forgotPassword() throws InterruptedException{
    	   login = new LoginPage(driver);
    	   
    	   login.goToForgotPassword();
    	   login.insertEmailForgotPassword(validEmail);
    	  // driver.hideKeyboard();
    	   login.clickearLogo();
    	   Thread.sleep(5000);
    	   List<AndroidElement> dynamicTextFieldsList = driver.findElementsByTagName("INPUT");
          
           dynamicTextFieldsList.get(1).sendKeys("Automation1");
           
           WebElement button = driver.findElementByTagName("BUTTON");
           button.click();
           Thread.sleep(5000);
    	   //login.insertSubdomainForgotPassword("Automation4");
    	     login.pressSendForgotPassword();
    	   
    	   
    	   
       }
       
}

