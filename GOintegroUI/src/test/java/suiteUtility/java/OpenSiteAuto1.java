package suiteUtility.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class OpenSiteAuto1 {
    //Declared as public static to use same webdriver instance publicly
    public static WebDriver driver = new FirefoxDriver();

    //@BeforeSuite annotation describes this method has to run before all suites
    @BeforeSuite 
    public void setup() throws Exception { 
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("https://gocauto1.p2-stage.gointegro.com/auth/signin"); 
             } 
    //@AfterSuite annotation describes this method has to run after execution of all suites
    
	@AfterSuite
         public void tearDown() throws Exception { 
         driver.quit(); 
    } 
}


