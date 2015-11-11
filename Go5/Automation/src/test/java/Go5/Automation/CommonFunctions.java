package Go5.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class CommonFunctions {
    //Declared as public static to use same webdriver instance publicly, could be Firefox or Chrome 
    
	
	public static WebDriver driver=null; 
	public boolean browserAlreadyOpen=false;
	public static Properties SYSPARAM =null;

    
    public void login() throws Exception { 
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("http://signup.qa.go5.gointegro.net/landing");
         driver.findElement(By.cssSelector("#signupRequest_email_label"));          	 
         driver.findElement(By.cssSelector("#submit_button")).click();
         
    } 
   
	 
	 //To Initialize .properties file.
	 public void initData() throws IOException{
	  SYSPARAM = new Properties();
	  FileInputStream Ist = new FileInputStream(System.getProperty("user.dir")+"//src//Testng_Pack//SYSPARAM.properties");
	  SYSPARAM.load(Ist);
	 }
	 
	 public void initBrowser(){
	  //Check If browser Is already opened during previous test execution.
	  if(!browserAlreadyOpen){
	   //Read value of 'BrowserToTestIn' key from SYSPARAM.properties file.
	   //If key value Is MMF then execute If statement
	   //If key value Is CHRM then execute else statement.
	   if(SYSPARAM.getProperty("BrowserToTestIn").equals("MFF")){
	    driver = new FirefoxDriver();   
	   }
	   else if(SYSPARAM.getProperty("BrowserToTestIn").equals("CHRM")){
	    //Write lines to open chrome browser.
	    driver = new ChromeDriver();
	   }
	   
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  //At last browserAlreadyOpen flag will becomes true to not open new browser when start executing next test.
	  browserAlreadyOpen=true;
	  }
	 } 
	  //To Close Browser
	 public void closeBrowser(){
	  driver.quit();
	  browserAlreadyOpen=false;
	 } 
	}


