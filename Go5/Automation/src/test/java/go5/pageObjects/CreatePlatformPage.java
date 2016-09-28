package go5.pageObjects;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


  
    
    
    public class CreatePlatformPage {

    	//Css
    	
    	
    	protected  String  idCompania= "CreateAccount_company";
    	protected String idSubdomain="CreateAccount_subdomain";
    	protected String idCantEmpleados= "CreateAccount_qty_employees";
    	protected String idNombre ="CreateAccount_name_label";
    	protected String idApellido ="CreateAccount_last_name";
    	protected String idPassword="CreateAccount_password";
    	protected String idTimeZone="CreateAccount_timezone";
    	protected String idTermsAndConditions="CreateAccount_terms_and_conditions";
    	protected String idSubmitButton="submit_button";
    	protected String urltokenVencido="http://signup.qa.go5.gointegro.net/en/createPlatform/token/3e8hap5qzxes404s0goocso08wocwk0kw4k8c4cw4sosg4c8wo";
    	
    	
      	  	
    	  WebDriver driver;
    
    	
  
    	    public CreatePlatformPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
    	 
    	   
   	      
           
  
     public void setCompanyName(String strName){
    	 driver.findElement(By.id(idCompania)).clear();
    	 driver.findElement(By.id(idCompania)).sendKeys(strName);
         }
    
     public void setSubdomainName(String strName) throws InterruptedException{
    	 driver.findElement(By.id(idSubdomain)).click();
    	 driver.findElement(By.id(idCompania)).sendKeys(strName);
    	 driver.findElement(By.id(idSubdomain)).sendKeys(Keys.ENTER);
    	 Thread.sleep(2000);
    	  }
   
   
     public void selectCantEmpleados(){
    	 Reporter.log(" Seleccionar la cantidad de empleados");
	 		Select selectEmployees = new Select(driver.findElement(By.cssSelector(idCantEmpleados))); 
	 		
	 	     selectEmployees.selectByIndex(1);
    	 
     }
     
     public void setName( String strUserName){
    	 driver.findElement(By.id(idNombre)).click();
    	 	driver.findElement(By.id(idNombre)).sendKeys(strUserName);
	    	   driver.findElement(By.id(idNombre)).sendKeys(Keys.ENTER);
	       }

	       public void setLastName(String strUserLastName){
	    	   driver.findElement(By.id(idApellido)).sendKeys(strUserLastName);
	       }
     public void setTimeZone (){
  	   Reporter.log(" Elegir valor de timezone ");
   		Select selectTimeZone = new Select(driver.findElement(By.id(idTimeZone)));
  		        		
  		selectTimeZone.selectByValue("America/Anchorage");
      }
     
     public void setPassword (String strPassword){
    	 driver.findElement(By.id(idPassword)).sendKeys(strPassword);
     }
     
     public void aceptarTerminosYCondiciones(){
  	   
  	   driver.findElement(By.id(idTermsAndConditions)).click();
     }
     public void clickSubmitButton(){
      	 
            driver.findElement(By.id(idSubmitButton)).click();
     }
       
 
     
 
     
     public void registrarse(String strcompanyname) throws InterruptedException{
    	
    	 	setCompanyName(strcompanyname);
    		setSubdomainName(strcompanyname);
    	//	selectCantEmpleados();
    		setName("Thiago");
    		setLastName("My best friend");    	 	
    		setPassword("Auto1234");
    		setTimeZone();
	  		aceptarTerminosYCondiciones();
	  		 Thread.sleep(1000);
	  		clickSubmitButton();
	  		Thread.sleep(3000);
	  		
	  		
    }
     
    	
     }
    
    


