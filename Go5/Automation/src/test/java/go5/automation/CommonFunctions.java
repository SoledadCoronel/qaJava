package go5.automation;




import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;







public class CommonFunctions {
		 
	protected WebDriver driver;
	protected Logger log = Logger.getLogger("automation");
	
	
	//Declaracion de variables	
	
	protected String strUsername= new String("marina.touceda@gointegro.com");
	protected String strPassword= new String("Auto1234");
	
	
	//Declaracion de cssSelectors
	
	protected String strCssConfiguration= new String(".applications .users .configuration");
	protected String irAMenu =new String (".menu");
	protected String irAPagina= new String("a[title='Ir a la página 4']");
	protected String irASpaces = new String ("a[title='Ir a listar espacios']");
	protected String searchButton = new String(".actions .search .btnsearch");
	protected String inputSearch = new String(".actions .search input");
	protected String orden =new String (".tables thead tr th:nth-child(2) a");
	protected String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
	protected String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
	
	
	
	  public void setUpBrowserStack(String browser, String version, String platform,String url,String build) throws Exception {
		    DesiredCapabilities capability = new DesiredCapabilities();
		    capability.setCapability("platform",platform);
		    capability.setCapability("browserName", browser);
		    capability.setCapability("browserVersion", version);
		    capability.setCapability("project", "GOIntegro");
		    capability.setCapability("build", build);
		    capability.setCapability("debug", false);
		     this.driver = new RemoteWebDriver(
		    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
		    	      capability);
    
		    driver.get(url);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 openSiteLogin();
			   login(strUsername,strPassword);
		  }  
	
	
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





