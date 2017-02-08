package go5.automation.driver;


import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;



import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Set;


public class AndroidSetup {
	
	
	// Driver

	 
	protected AndroidDriver<WebElement> driver;
    
	
	public void prepareAndroidForAppium() throws MalformedURLException {		
	
	        String sauceUserName = "mtouceda";
	        String sauceAccessKey = "e89480b4-3819-4a7a-8e5b-199ec7131814";
	        
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("appiumVersion","1.6");
	    capabilities.setCapability("deviceName","Android Emulator");
	    capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", "http://jenkins-go5.qa.gointegro.net/apk/go5-tag312.apk");
     //  capabilities.setCapability("appPackage", "com.gointegro.go5mobile");	   

	   driver = new AndroidDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)), capabilities);
	
	 //    driver = new AndroidDriver<WebElement>(new URL("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey), capabilities);
	
	/*
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("deviceName","Android Emulator");            
        capabilities.setCapability("platformVersion", "5.1.1");//  es el mobile OS version, si instalo api22 es 5.1.1
        capabilities.setCapability("app", "/home/marinatouceda/Documentos/android-sdk-linux/platform-tools/go5-tag0.13.12.apk");
        capabilities.setCapability("appPackage", "com.gointegro.go5mobile");
       
      driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
         
   */     
       
           	
          Set<String> contextNames = driver.getContextHandles();
          
         for (String contextName : contextNames) {
              System.out.println(contextName);
              if (contextName.contains("WEBVIEW")){
                  driver.context(contextName);             }
         }
}
	
	 public void changeToNative(String strtype){
	
		   	
         Set<String> contextNames = driver.getContextHandles();
         
        for (String contextName : contextNames) {
             System.out.println(contextName);
             if (contextName.contains(strtype)){
                 driver.context(contextName);             }
        }
		 
	}
}