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

import com.sun.jna.ptr.ByteByReference;


    
    
    public class TitlesPage {

    	//Css
    	
    	 private String addTitleCss=".groupsform fieldset:nth-child(1) label:nth-child(1) a";   	 
	     private String inputNameTitleCss=".groupsform fieldset:nth-child(1) label:nth-child(2) input"; 
	     private String  deleteTitleCss =".groupsform fieldset:nth-child(2) .delete";
	     private String confirmCss =".mconfirmation a";    	     
	     protected String addSubtitle = "";	   
	     protected String titleProfile =".groupsdata select";
	          	
		 	 	
	 	// Subtitle
	 	protected String addSubtitlecss = ".subtree .active a";
	 	protected String inputNameSubtitleCss = ".additem.active input";
	 	protected String editfirstRowCss = ".tables tbody tr:nth-child(1) td:nth-child(7) a";
	 	protected String desplegarCamposCss = ".addpeople .secondary";
	 	protected String savePersonCss = ".container .addpeople .primary";
	 	
	 	// References

	 	By addTitle=By.cssSelector(addTitleCss);
	 	By inputNameTitle=By.cssSelector(inputNameTitleCss);
	 	By inputNameSubtitle=By.cssSelector(inputNameSubtitleCss);
	 	By confirm = By.cssSelector(confirmCss);
	 	By deleteTitle=By.cssSelector(deleteTitleCss);
	 	     
	     //Driver
	     
	     WebDriver driver;
    
     
  //Constructor
    	    public TitlesPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
         

     public  void  addATitle(String nameTitle){
      
    	 Reporter.log("Agregando un title" );    	
 	      driver.findElement(addTitle).click(); 
    	       
     //Insertar un nombre 
    
     
        driver.findElement(inputNameTitle).sendKeys(nameTitle);
        driver.findElement(inputNameTitle).sendKeys(Keys.RETURN);
       
    	 
			}
    
     public void deleteGroup(){
   
    	 
    	   driver.findElement(deleteTitle).click();      
    	   driver.findElement(confirm).click();     
    	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
   
    
     public void addASubtitle(String name) throws InterruptedException{
    	  //Agregar un Subgrupo
    	    	     	 driver.findElement(By.cssSelector(addSubtitle)).click();
    	    	     	WebElement addgroup = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(addTitle));
	    driver.findElement( inputNameSubtitle).sendKeys(name);
    	driver.findElement( inputNameSubtitle).sendKeys(Keys.RETURN);
    	   
     }
    
   


}


    
      
     

