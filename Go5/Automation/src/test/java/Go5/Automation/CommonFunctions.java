package Go5.Automation;




import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class CommonFunctions {
    
	final WebDriver driver= new FirefoxDriver();
	//RemoteWebDriver driver = new FirefoxDriver();
	Logger log = Logger.getLogger("automation");
		
	 
	 public void openSiteSignUp(){
		 
		 driver.get("http://signup.qa.go5.gointegro.net/landing");
		 driver.manage().window().maximize();
	   }
	  
public void openSiteLogin(){
		 
		 driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		 driver.manage().window().maximize();
	   } 
	
      public void openSiteEnglish(){
		 
		 driver.get("http://automation5.pla.qa.go5.gointegro.net/authentication/login");
		 driver.manage().window().maximize();
	   } 
	  public void openSitePortuguese(){
			 
			 driver.get("http://automation4.pla.qa.go5.gointegro.net/authentication/login");
			 driver.manage().window().maximize();
		   } 
	  
	  public void openSignupForAccount(){
		   driver.get("http://signup.qa.go5.gointegro.net/es/signup");
		   driver.manage().window().maximize();
	  }
	  
	  public void openSiteAfterCreatePlatformSpanish() {
		  driver.get("http://signup.qa.go5.gointegro.net/es/signup");
		  driver.manage().window().maximize();
		}
	  
	  public void login(String sUsername,String sPassword) throws Exception { 
		 	
	 		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 		driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys(sUsername);
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys(sPassword);
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  	}
	  
	  //To Close Browser--It closes only the browser window that WebDriver is currently controlling.
	 public void closeBrowser(){
	  driver.close();
	 	 } 
	 
	 // To quit-- Close all the windows the driver use
	 public void quitBrowser(){
		 driver.quit();
	 }
  	 	 	
	 	
	 	public String generateRandomEmail(){
	 	
	 	 int rand = (int) (Math.random() * 999999999);
	    String email = "qa" + rand + "@gointegro.com";
	    return email;
}

	 // Function to select the 3 available languages
		 public void selectLanguage(String language){
			 if (language =="Spanish"){
				 driver.findElement(By.id("SignupRequest_language_0")).click();
			 }
			 else if (language=="English"){
				 driver.findElement(By.id("SignupRequest_language_2")).click();			 
			 }
			 else if (language=="Portuguese"){
				 driver.findElement(By.id("SignupRequest_language_1")).click();
				 }
	 	 }

}



