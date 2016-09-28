package go5.pageObjects;
import go5.automation.SetUp;

import java.io.File;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;


  
    
    
    public class SocialActivityPage extends SetUp{

    		
    	
    	//Css
    	
     //Generics	
    	protected String goToEscribaAquiCss="";
    	protected String permisoDeAdminCss=".list li:nth-child(1) button";
    	
    	
    	//By
    	
    	By goToEscribaAqui= By.cssSelector(goToEscribaAquiCss);
    	
    	//Objects
    	    
    	  WebDriver driver;
    
     //Inits
    	  
    	    public SocialActivityPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
    //Generics    
       
     public void goToEscribaAqui(){
    	 driver.findElement(goToEscribaAqui).click();
    	 
     }
    
		
    
    }
    
    
      
     
               
         
    


