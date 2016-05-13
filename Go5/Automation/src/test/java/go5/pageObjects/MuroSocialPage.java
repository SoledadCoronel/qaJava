package go5.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class MuroSocialPage {

    	//Css
    	
    	protected String textAreaPostcss= "fieldset textarea";
    	protected String cameraPostcss=".igocamerawhite";
    	protected String linkPostcss=".igolink";
    	protected String attachPostcss=".igoattach";
    	protected String publicarContenidoCss="fieldset .primary";
    	protected String iconcss=".icon";
    	
    	
    	By textPost =By.cssSelector(textAreaPostcss);
    	By link =By.cssSelector(linkPostcss);
    	By publicarContenido = By.cssSelector(publicarContenidoCss);
    	By icon =By.cssSelector(iconcss);
    	
    	
    	  WebDriver driver;
    
     
  
    	    public MuroSocialPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set a string in a posttext
  
     public void postTexto(String strTextPost){
      
    	 driver.findElement(textPost).clear();
    	 driver.findElement(textPost).sendKeys(strTextPost);
    	
     }
   
     public void postear(){
    	 
    	 driver.findElement(publicarContenido).click();
    	 Reporter.log("CLikeo publicar");
    	 
     }
      
     public void postLink (String strlink){
    	  driver.findElement(link).click();
    	  driver.findElement(By.cssSelector(".active input")).sendKeys(strlink);
    	 
    }
       
    }
    
      
  
     
               
         
    


