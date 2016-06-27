package scenarios;


import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;


public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
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
          driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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
}