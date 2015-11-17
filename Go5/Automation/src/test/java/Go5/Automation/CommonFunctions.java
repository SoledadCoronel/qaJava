package Go5.Automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class CommonFunctions {
    
	
	public static WebDriver driver= new FirefoxDriver(); 
	
    
	 
	 public void openSiteSignUp(){
		 
		 driver.get("http://signup.qa.go5.gointegro.net/landing");
		 driver.manage().window().maximize();
	   }
	   
	  public void openSiteWithToken(){
		  driver.get("http://signup.qa.go5.gointegro.net/en/createPlatform/token/4vrg9i0s08ao4c0c4wg80wo008s48gcw404o4cs0g4cw084o84");
		  driver.manage().window().maximize();
	  }
	 
	  public void openSiteLogin(){
			 
			 driver.get("http://gointegroautomationsite1.pla.qa.go5.gointegro.net/authentication/login");
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


	/*
	 public void goToFrame (css_selector) {
		 // Make a function to goToFrame using the css selector as parameter
		 
		 driver.switchTo().frame(driver.findElement(By.cssSelector(css_selector));
		 driver.switch_to.frame(driver.find_element_by_css_selector(css_selector));		
         driver.switchTo().defaultContent();
	 }
*/	  
	 
}


