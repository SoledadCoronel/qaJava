package Go5.Automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class CommonFunctions {
    
	
	public static WebDriver driver= new FirefoxDriver(); 
	
    
	 
	 public void openSite(){
		 
		 driver.get("http://signup.qa.go5.gointegro.net/landing");
		 driver.manage().window().maximize();
	   }
	   
	  
		  
	  //To Close Browser--It closes only the browser window that WebDriver is currently controlling.
	 public void closeBrowser(){
	  driver.close();
	 	 } 
	 
	 // To quit-- Close all the windows the driver use
	 public void quitBrowser(){
		 driver.quit();
	 }
	}


