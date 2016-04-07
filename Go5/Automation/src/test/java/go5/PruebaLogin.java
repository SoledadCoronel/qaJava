package go5;


 
import go5.automation.TestSuite;
import go5.pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
 
 
public class PruebaLogin extends TestSuite{
 
    WebDriver driver;
 
   // LoginPage objLogin;
 
         
 
    @BeforeTest
 
    public void setup() throws Exception{
 
    this.openSite(urlSiteAutomation2);       
   //driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
 
    }
 
    /**
 
     * This test case will login in http://demo.guru99.com/V4/
 
     * Verify login page title as guru99 bank
 
     * Login to application
 
     * Verify the home page using Dashboard message
 
     */
 
    @Test(priority=0)
 
    public void test_Home_Page_Appear_Correct(){
 
        //Create Login Page object
    //	objLogin=new pageObjects.LoginPage();
 
    /*objLogin = new pageObjects.LoginPage();
 
    //Verify login page title
 
   // String loginPageTitle = objLogin.getLoginTitle();
 
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
 
    //login to application
 //   objLogin.loginObjectFactory(sUsername, sPassword);
 
    objLogin.loginToGuru99("mgr123", "mgr!23");
 
    // go the next page
 
    objHomePage = new Guru99HomePage(driver);
 
    //Verify home page
 
    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
 */}
    
    }