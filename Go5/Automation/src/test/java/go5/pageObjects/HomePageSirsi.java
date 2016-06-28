package go5.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


  
    
    
    public class HomePageSirsi {

    	//Css
    	
    	protected  String idsearchInput ="edit-search-block-form--2";
    	protected  String idsearchAction="edit-submit";
    	protected String idlistResults= "search-page-results";
    	protected String cssnameScondNodeResults="#search-page-results li:nth-child(2) .title a";		
    	
    	By search =By.id(idsearchInput);
    	By runSearch=By.id(idsearchAction);
    	By nameTitle =By.cssSelector(cssnameScondNodeResults);
    	By listResults= By.id( idlistResults);
        	    	
    	  WebDriver driver;
        
  
    	    public HomePageSirsi(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Function to run a search
  
     public void searchForAString(String strUserName){
      
    	driver.findElement(search).clear();
    	 driver.findElement(search).sendKeys(strUserName);
    	 driver.findElement(runSearch).click();
    
     }

     public void waitForResults(){
    	 WebDriverWait wait = new WebDriverWait(driver, 10);

    	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(listResults));
     }
     
	public String  getSecondTitle() {
		// Return the second title of the result of a search done in the Home Page
		return(driver.findElement(nameTitle).getText());
		
	}
     }
  
      
  