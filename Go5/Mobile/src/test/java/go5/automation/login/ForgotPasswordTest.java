package go5.automation.login;



//driver
import go5.automation.driver.AndroidSetup;

//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages

import go5.pageObjects.*;





public class ForgotPasswordTest  extends AndroidSetup{
 
     private String wrongEmail= "cualquiera@gointegro.com";
     private String numericEmail= "11212232";
     LoginPage login=null;


   
    @Before
    
    public void setUp() throws Exception {
        
        prepareAndroidForAppium();
       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void forgotPasswordWrongEmail() throws InterruptedException {
    
    	// Init pages
    	

   	 login = new LoginPage(driver);
   	
       
   
       // Test
   	 login.goToForgotPassword();
   	 login.insertEmailForgotPassword(numericEmail);
   	 login.pressSendForgotPassword();
       Thread.sleep(13000);
    }     
      
       @Test
       public void forgotPasswordWrongFormat() throws InterruptedException {
       
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

}

