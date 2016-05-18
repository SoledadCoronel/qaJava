package go5.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class MuroSocialPage {

    	//Css
    	
    	protected String textAreaPostcss= ".postbox fieldset textarea";
    	protected String cameraPostcss=".igocamerawhite";
    	protected String linkPostcss=".igolink";
    	protected String attachPostcss=".igoattach";
    	protected String publicarContenidoCss="fieldset .primary";
    	protected String iconcss=".icon";
    	protected String linkVerMascss=".posttext:nth-child(n) p:nth-child(n) .link";
    	protected String textAreaPostViejo=".posttext:nth-child(n) fieldset textarea";
    	
    	
    	By textPost =By.cssSelector(textAreaPostcss);
    	By link =By.cssSelector(linkPostcss);
    	By publicarContenido = By.cssSelector(publicarContenidoCss);
    	By icon =By.cssSelector(iconcss);
    	By linkVerMas=By.cssSelector(linkVerMascss);
    	
    	
    	  WebDriver driver;
    
     
  
    	    public MuroSocialPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set a string in a posttext
  
     public void postTexto(String strTextPost){
      
    	 driver.findElement(textPost).clear();
    	 driver.findElement(textPost).sendKeys(strTextPost);
    	
     }
   
     public String returnTextoPublicado(){
         Reporter.log("Imprimir lo que tiene el post de texto");
    	return driver.findElement(textPost).getText();
    	 
    	
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
    
      
  
     
               
         
    


