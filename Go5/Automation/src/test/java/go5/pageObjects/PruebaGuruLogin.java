package go5.pageObjects;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import go5.pageObjects.Guru99Login;
import go5.pageObjects.Guru99HomePage;


 
public class PruebaGuruLogin {
 
    WebDriver driver;
 
    LoginPage  objLogin;
 
    HomePage objHomePage;
 
     
 
    @BeforeTest
 
    public void setup(){
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
        Reporter.log("Abriendo la aplicacion");
 
    }
 
    /**
 
     * This test case will login in http://demo.guru99.com/V4/
 
     * Verify login page title as guru99 bank
 
     * Login to application
 
     * Verify the home page using Dashboard message
 
     */
 
    @Test(priority=0)
 
    public void test_Login_GoIntegro(){
 
        //Create Login Page object
 
    objLogin = new LoginPage(driver);
 
    //Verify login page title
 
   Reporter.log(" Obtener algo de la pagina!");
    String loginPageTitle = objLogin.getLoginTitle();
    Reporter.log(loginPageTitle);
    //Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
 
    //login to application
    Reporter.log(" Me quiero loguear");
    objLogin.loginToGo("marina.touceda@gointegro.com", "Auto1234");
 
    
   /* // go the next page
 
    objHomePage = new HomePage(driver);
    objHomePage = new Guru99HomePage(driver);
 
    //Verify home page
 
    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));*/
    }
    }