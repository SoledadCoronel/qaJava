package Go5.Automation;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class CommonFunctions {
    
	
	public static WebDriver driver= new FirefoxDriver();
	Logger log = Logger.getLogger("automation");
	
	
    
	 
	 public void openSiteSignUp(){
		 
		 driver.get("http://signup.qa.go5.gointegro.net/landing");
		 driver.manage().window().maximize();
	   }
	  	 
	  public void openSiteLogin(){
			 
			 driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
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


