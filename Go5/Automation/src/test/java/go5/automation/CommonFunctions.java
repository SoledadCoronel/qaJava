package go5.automation;




import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class CommonFunctions {
		 
	protected WebDriver driver= new FirefoxDriver();
	protected Logger log = Logger.getLogger("automation");
		
	 
	 public void openSiteSignUp(){
		 
		 driver.get("http://signup.qa.go5.gointegro.net/landing");
		 driver.manage().window().maximize();
	   }
	  
public void openSiteLogin(){
	    org.apache.log4j.BasicConfigurator.configure();
		 driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   } 
	
public void openSiteMobile(){
    org.apache.log4j.BasicConfigurator.configure();
	 driver.get("http://mobile.uat.go5.gointegro.net/");
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
		 	
		 // WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".session label:nth-child(2) input")));
		  driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".session .primary")).click();
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

		 public void loginMobile(String Username,String Password) {

				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 		driver.findElement(By.cssSelector(".signup fieldset label:nth-child(2)")).sendKeys(Username);		 		
		 		driver.findElement(By.cssSelector(".signup fieldset label:nth-child(3)")).sendKeys(Password);
		 		 driver.findElement(By.cssSelector(".primary")).click();
		         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 }
			
		         public void sendValue(String sSelector,String sValue) throws Exception{
		           driver.findElement(By.cssSelector(sSelector)).sendKeys(sValue);
		         }
		           
		           public void click(String sSelector) throws Exception{
			           driver.findElement(By.cssSelector(sSelector)).click();
		           }
		           
			           public void clear(String sSelector) throws Exception{
				           driver.findElement(By.cssSelector(sSelector)).clear();
				               
		           }
			           public String getText(String sSelector) throws Exception{
				           return (driver.findElement(By.cssSelector(sSelector)).getText());
				           
				               
		           }

}





