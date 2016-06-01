package com.saucelabs.appium;

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
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Utils
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;




public class GO5LoginTest {
    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        // set up appium
        //File classpathRoot = new File(System.getProperty("user.dir"));
        //File appDir = new File(classpathRoot, "../../../apps/ContactManager");
        //File app = new File(appDir, "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", "/home/marinatouceda/Documentos/android-sdk-linux/platform-tools/go5-tag0.9.4.apk");
        capabilities.setCapability("appPackage", "com.gointegro.go5mobile");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Set<String> contextNames = driver.getContextHandles();
        
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")){
                driver.context(contextName);
            }

        }
        
        WebDriverWait wait = new WebDriverWait(driver, 20);
        
        //wait.until(ExpectedConditions.elementToBeClickable(By.tagName("BUTTON")));
        Thread.sleep(10000);
        List<AndroidElement> textFieldsList = driver.findElementsByTagName("INPUT");
        textFieldsList.get(0).sendKeys("marina.touceda@gointegro.com");
        textFieldsList.get(1).sendKeys("Auto1234");
        
        List<AndroidElement> dynamicTextFieldsList = driver.findElementsByTagName("INPUT");
        
        dynamicTextFieldsList.get(2).sendKeys("Automation1");
        
        WebElement button = driver.findElementByTagName("BUTTON");
        button.click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("h1")));

        WebElement title = driver.findElement(By.tagName("h1"));
        assertEquals("Principal", title.getText());
        
    }

}

