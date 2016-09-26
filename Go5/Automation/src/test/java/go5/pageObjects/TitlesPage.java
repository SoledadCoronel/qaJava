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
    	
    	 private String addGroup= new String(".groupsform fieldset:nth-child(1) label a"); // modificado
    	 
	     private String inputNameGroup= new String (".groupsform fieldset:nth-child(1) label:nth-child(2) input"); 
	     private String  deleteGroup = new String (".groupsform fieldset:nth-child(2) .delete");
	     private String confirm = new String (".mconfirmation a");    
	     protected String irAGroups = new String (".igogroups");
	     protected String irATitles = new String (".igotitles");
	     protected String addSubgroup = new String (".subtree .active a"); //modificado
	     protected String inputNameSubgroup= new String (".additem.active input");
	     protected String groupEnProfile = new String (".groupsdata select");
	          	
    	  WebDriver driver;
    
     
  //Constructor
    	    public TitlesPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
     public  void  goToGroups(){
      
    	 Reporter.log("Abriendo pagina de grupos" );
    	    	          
    	    	 WebElement groupsavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(irAGroups)));
				driver.findElement(By.cssSelector(irAGroups)).click();
			}
       

     public  void  addATitle(String nameGroup){
      
    	 Reporter.log("Agregando un title" );
    	 WebElement addgroupsavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(addGroup)));
 	       
    	 
     driver.findElement(By.cssSelector(addGroup)).click();   
    
     //Insertar un nombre 
    
     
        driver.findElement(By.cssSelector(inputNameGroup)).sendKeys(nameGroup);
        driver.findElement(By.cssSelector(inputNameGroup)).sendKeys(Keys.RETURN);
       
    	 
			}
    
     public void deleteGroup(){
   
    	 
    	   driver.findElement(By.cssSelector(deleteGroup)).click();
       //driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .delete")).click();
    	   driver.findElement(By.cssSelector(confirm)).click();
      // driver.findElement(By.cssSelector(".mconfirmation a")).click();
    	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
   
    
     public void addASubgroup(String name) throws InterruptedException{
    	  //Agregar un Subgrupo
    	    	     	 driver.findElement(By.cssSelector(addSubgroup)).click();
    	    	     	
   	 WebElement addgroupsavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputNameSubgroup)));
	    driver.findElement(By.cssSelector(inputNameSubgroup)).sendKeys(name);
    	driver.findElement(By.cssSelector(inputNameSubgroup)).sendKeys(Keys.RETURN);
    	Thread.sleep(1000);
    
     }
    
     public void selectGroup(){
    		
    		Select selectGroups=new  Select(driver.findElement(By.cssSelector(groupEnProfile))); 
	 		
		 	  selectGroups.selectByIndex(1);
    	}
   


}


    
      
     

