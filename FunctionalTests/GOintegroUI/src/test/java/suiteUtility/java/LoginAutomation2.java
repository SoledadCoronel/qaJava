package suiteUtility.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class LoginAutomation2 {
    //Declared as public static to use same webdriver instance publicly
    public static WebDriver driver = new FirefoxDriver();

    //@BeforeSuite annotation describes this method has to run before all suites
    @BeforeSuite 
    public void setup() throws Exception { 
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("https://gocauto2.p2-stage.gointegro.com/auth/signin"); 
         driver.findElement(By.cssSelector("input[id=_username]")).sendKeys("automation");
         driver.findElement(By.cssSelector("a[id=_submit]")).click();
    } 
    //@AfterSuite annotation describes this method has to run after execution of all suites
    
	@AfterSuite
         public void tearDown() throws Exception { 
         driver.quit(); 
    } 
}


