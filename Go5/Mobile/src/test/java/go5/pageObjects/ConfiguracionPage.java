package go5.pageObjects;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;


    
    
    public class ConfiguracionPage {

    	//Css
    	
    	private String datosBasicoscss = ".basicata";
    	
        
        private String selectIdiomacss = ".basicdata fieldset label:nth-child(1) select";
        private String selectTimezonecss = ".basicdata fieldset label:nth-child(2) select";
       
    	
        //References
        By selectIdioma=By.cssSelector(selectIdiomacss);
        By selectTimeZone=By.cssSelector(selectTimezonecss);
       
        protected WebDriver driver;
    
     
  //Constructor
    	    
    	  public ConfiguracionPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
      
         
         
         public void setIdioma(){
     		
        	 // Select all values the drop-down for Language
        	 		Reporter.log(" Verificar el drop-down de lenguajes");
        	 		Select selectLanguage = new Select(driver.findElement(selectIdioma)); 
        	 		
        	 		selectLanguage.selectByValue("pt");
        	 		selectLanguage.selectByValue("en");	
        	 		selectLanguage.selectByValue("es");
         }
      
         public void setTimezone(){
        	//Select a value from drop-down Timezone
      		Reporter.log(" Verificar el drop-down de timezone ");
      		
      		
      		Select selectTZ= new Select(driver.findElement(selectTimeZone));
      		     		     		
     		selectTZ.selectByValue("America/Anchorage");

         }
    	  
          
        
    
      }
  
    
    

