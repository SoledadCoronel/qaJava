package go5.automation;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface Gofunctions {

	final WebDriver driver= new FirefoxDriver();
	//RemoteWebDriver driver = new FirefoxDriver();
	  
	/* final RemoteWebDriver  driver = new RemoteWebDriver(
	    		new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
			capability);
	*/
	
	
	
	  public void openSiteEnglish(); 
	  
	  
	  public void login(String sUsername,String sPassword) throws Exception;
	  
	  //To Close Browser--It closes only the browser window that WebDriver is currently controlling.
		 public void closeBrowser(); 
		 
		 // To quit-- Close all the windows the driver use
		 public void quitBrowser();
}
