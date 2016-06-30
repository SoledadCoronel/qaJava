package go5.automation.login;

//Appium


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;






//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;




//Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;






//Utils



import java.net.URL;
import java.util.List;
import java.util.Set;

import go5.pageObjects.LoginPage;
import go5.pageObjects.MainPage;



public class GO5LoginTest {
   
	private AppiumDriver<AndroidElement> driver;
    
    MainPage mainpage =null;

    @Before
    public void setUp() throws Exception {
        
        
    	DesiredCapabilities capabilities = new DesiredCapabilities();
              
      //  capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Android Emulator");            
     //   capabilities.setCapability("noReset", true);
      //  capabilities.setCapability("fullReset", false);
        capabilities.setCapability("platformVersion", "5.1.1");//  es el mobile OS version, si instalo api22 es 5.1.1
       // The app capability is not requires if you set appPackage and appActivity
       capabilities.setCapability("app", "/home/marinatouceda/Documentos/android-sdk-linux/platform-tools/go5-tag0.11.12.apk");
        capabilities.setCapability("appPackage", "com.gointegro.go5mobile");
      //  capabilities.setCapability("appActivity", "com.gointegro.go5mobile.MainActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    //Setear la aplicacion a hybrida
    	System.out.println("Haciendo cambio de contexto");
        Set<String> contextNames = driver.getContextHandles();
        
       for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")){
                driver.context(contextName);
            }
       }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
               
   	 mainpage = new MainPage(driver);  
        
        WebDriverWait wait = new WebDriverWait(driver, 20);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("BUTTON")));
      
        List<AndroidElement> textFieldsList = driver.findElementsByTagName("INPUT");
        textFieldsList.get(0).sendKeys("marina.touceda@gointegro.com");
        textFieldsList.get(1).sendKeys("Auto1234");
        Thread.sleep(3000);
        
        List<AndroidElement> dynamicTextFieldsList = driver.findElementsByTagName("INPUT");
        
        dynamicTextFieldsList.get(2).sendKeys("Automation1");
        
        WebElement button = driver.findElementByTagName("BUTTON");
        button.click();
        
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("h1")));

        WebElement title = driver.findElement(By.tagName("h1"));
        assertEquals("Principal", title.getText());
         // Go to menu
        Thread.sleep(3000);
        mainpage.goToMenu();
       // driver.findElementByCssSelector(".menu").click();
         Thread.sleep(2000);
         mainpage.goToProfile();
        // driver.findElementByCssSelector(".igouserwhite").click();
         Thread.sleep(5000);
          driver.findElementByCssSelector(".socialcomments .type").click();
         Thread.sleep(6000);
         
         
    }

}

