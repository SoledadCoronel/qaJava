package go5.automation.resources;




import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;


public class AndroidSetup {
	
	
	// Driver

	 @SuppressWarnings("rawtypes")
	protected AndroidDriver driver;
    
	@SuppressWarnings("unchecked")
	public void prepareAndroidForAppium() throws MalformedURLException {
    	
			
		 
		DesiredCapabilities capabilities = new DesiredCapabilities();
          
          capabilities.setCapability("deviceName","Android Emulator");            
          capabilities.setCapability("platformVersion", "5.1.1");//  es el mobile OS version, si instalo api22 es 5.1.1
          capabilities.setCapability("app", "/home/marinatouceda/Documentos/android-sdk-linux/platform-tools/go5-tag0.11.12.apk");
          capabilities.setCapability("appPackage", "com.gointegro.go5mobile");
      
          driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
      
          //Set to  hybrid
          
      	
          Set<String> contextNames = driver.getContextHandles();
          
         for (String contextName : contextNames) {
              System.out.println(contextName);
              if (contextName.contains("WEBVIEW")){
                  driver.context(contextName);             }
         }
}
}