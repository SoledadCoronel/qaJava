package go5.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


    
    
    public class TitlesPage {

    	//Css
    	
    	 private String addTitle=".groupsform fieldset:nth-child(1) label:nth-child(1) a";
    	 
	     private String inputNameTitle=".groupsform fieldset:nth-child(1) label:nth-child(2) input"; 
	     private String  deleteTitle =".groupsform fieldset:nth-child(2) .delete";
	     private String confirm =".mconfirmation a";    	     
	     protected String addSubtitle = ".subtree .active a";
	     protected String inputNameSubgroup= ".additem.active input";
	     protected String titleProfile =".groupsdata select";
	          	
    	  WebDriver driver;
    
     
  //Constructor
    	    public TitlesPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
         

     public  void  addATitle(String nameTitle){
      
    	 Reporter.log("Agregando un title" );
    	 WebElement addgroupsavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(addTitle)));
 	      driver.findElement(By.cssSelector(addTitle)).click(); 
    	       
     //Insertar un nombre 
    
     
        driver.findElement(By.cssSelector(inputNameTitle)).sendKeys(nameTitle);
        driver.findElement(By.cssSelector(inputNameTitle)).sendKeys(Keys.RETURN);
       
    	 
			}
    
     public void deleteGroup(){
   
    	 
    	   driver.findElement(By.cssSelector(deleteTitle)).click();      
    	   driver.findElement(By.cssSelector(confirm)).click();     
    	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
   
    
     public void addASubtitle(String name) throws InterruptedException{
    	  //Agregar un Subgrupo
    	    	     	 driver.findElement(By.cssSelector(addSubtitle)).click();
    	    	     	
   	 WebElement addgroupsavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputNameSubgroup)));
	    driver.findElement(By.cssSelector(inputNameSubgroup)).sendKeys(name);
    	driver.findElement(By.cssSelector(inputNameSubgroup)).sendKeys(Keys.RETURN);
    	Thread.sleep(1000);
    
     }
    
     public void selectGroup(){
    		
    		Select selectGroups=new  Select(driver.findElement(By.cssSelector(titleProfile))); 
	 		
		 	  selectGroups.selectByIndex(1);
    	}
   


}


    
      
     

