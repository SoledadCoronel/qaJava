package go5.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class CreatePlatformPage {

    	//Css
    	
    	
    	protected  String  idCompania= "CreateAccount_company_label";
    	protected String idSubdomain="CreateAccount_subdomain";
    	protected String idCantEmpleados= "CreateAccount_qty_employees_label";
    	protected String idNombre ="CreateAccount_name_label";
    	protected String idApellido ="CreateAccount_last_name_label";
    	protected String idTimeZone="CreateAccount_timezone_label";
    	protected String idTermsAndConditions="CreateAccount_terms_and_conditions_label";
    	protected String idSubmitButton="submit_button";
    	
    	
      	  	
    	  WebDriver driver;
    
    	
  
    	    public CreatePlatformPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
  
   
     
  
     public void setCompanyName(String strName){
    	 driver.findElement(By.id(idCompania)).sendKeys(strName);
         }
    
     public void setSubdomainName(String strSubdomain){
    	driver.findElement(By.id(idSubdomain)).sendKeys(strSubdomain);
         }
   
   
     public void selectCantEmpleados(){
    	 
     }
     
     public void clickSubmitButton(){
      	 
            driver.findElement(By.id(idSubmitButton)).click();
     }
       
   public void aceptarTerminosYCondiciones(){
	   
	   driver.findElement(By.id(idTermsAndConditions)).click();
   }
     
 
     
     public void registrarse(String strcompanyname,String strsubdomainname) throws InterruptedException{
    	 
    	 	setCompanyName(strcompanyname);
    	 	this.setSubdomainName(strsubdomainname);
	  		aceptarTerminosYCondiciones();
	  		 Thread.sleep(1000);
	  		clickSubmitButton();
	  		Thread.sleep(1000);
    	
    }
     
    	
     }
    
    


