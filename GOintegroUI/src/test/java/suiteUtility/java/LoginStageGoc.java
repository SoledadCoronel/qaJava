package suiteUtility.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class LoginStageGoc {
    //Declared as public static to use same webdriver instance publicly
    public static WebDriver driver = new FirefoxDriver();

    //@BeforeSuite annotation describes this method has to run before all suites
    @BeforeSuite 
    public void setup() throws Exception { 
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("https://goc.p2-stage.gointegro.com/auth/signin"); 
         driver.findElement(By.cssSelector("input[id=_username]")).clear();
         driver.findElement(By.cssSelector("input[id=_username]")).sendKeys("soledad.coronel@gointegro.com");
         driver.findElement(By.cssSelector("input[id=_password]")).clear();
         driver.findElement(By.cssSelector("input[id=_password]")).sendKeys("coquito25");
         driver.findElement(By.cssSelector("a[id=_submit]")).click();
    } 
    //@AfterSuite annotation describes this method has to run after execution of all suites
    
	@AfterSuite
         public void tearDown() throws Exception { 
         driver.quit(); 
    } 
}


