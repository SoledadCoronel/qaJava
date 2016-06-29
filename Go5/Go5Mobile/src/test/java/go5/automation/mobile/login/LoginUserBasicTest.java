package go5.automation.mobile.login;


//junit
import go5.automation.mobile.pages.BasePage;
import go5.automation.mobile.pages.LoginPage;
import go5.automation.mobile.pages.MainPage;
import go5.automation.resources.AndroidSetup;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages




//Utils




public class LoginUserBasicTest  extends AndroidSetup{
  //  private AppiumDriver<AndroidElement> driver;
    
    MainPage mainpage =null;
    LoginPage login=null;
    BasePage page=null;

   
    @Before
    
    public void setUp() throws Exception {
        
        this.prepareAndroidForAppium();
    /*   
   	DesiredCapabilities capabilities = new DesiredCapabilities();
              
     
        capabilities.setCapability("deviceName","Android Emulator");            
   
        capabilities.setCapability("platformVersion", "5.1.1");//  es el mobile OS version, si instalo api22 es 5.1.1
      
       capabilities.setCapability("app", "/home/marinatouceda/Documentos/android-sdk-linux/platform-tools/go5-tag0.11.12.apk");
        capabilities.setCapability("appPackage", "com.gointegro.go5mobile");
      
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    
        //Setear la aplicacion a hybrid
    	
        Set<String> contextNames = driver.getContextHandles();
        
       for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")){
                driver.context(contextName);
            }
       }*/
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
    
    	// Init pages
    	
   	 mainpage = new MainPage(driver); 
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
        
   
       // Test
      login.loginToGoAsUSerBasic();
      page.logout();
      Thread.sleep(3000);
         
         
    }

}

