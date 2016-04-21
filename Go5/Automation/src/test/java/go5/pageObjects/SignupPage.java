package go5.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


  
    
    
    public class SignupPage {

    	//Css
    	
    	protected String strPassword= new String("Auto1234");
    	protected String userName = new String (".signup fieldset:nth-child(1) label:nth-child(3) input");
    	protected String inputPassword = new String (".signup fieldset:nth-child(1) label:nth-child(5) input");
    	protected String terminosYcondiciones = new String ("input[type='checkbox']");
    	protected String terminosYcondicioneslink = new String ("..signup fieldset:nth-child(1) label:nth-child(6) a");
    	protected  String goButton = new String (".signup fieldset:nth-child(1) label:last-child .primary");
    	
      	  	
    	  WebDriver driver;
    
    	
  
    	    public SignupPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
  
    
  
      
  
     //Set password in password textbox
  
     public void setPassword(String strPassword){
    	 
    	driver.findElement(By.cssSelector(inputPassword)).sendKeys(strPassword);
        
  
     }
  
       
     //Click on login button
  
     public void clickgoButton(){
  
    	 
            driver.findElement(By.cssSelector(goButton)).click();
     }
       
   public void aceptarTerminosYCondiciones(){
	   
	   driver.findElement(By.cssSelector(terminosYcondiciones)).click();
   }
     
   public void clickearTerminosYCondiciones(){
	   driver.findElement(By.cssSelector(terminosYcondicioneslink)).click();
   }
     
     public void registrarse(){
    	
    	
    }
    
    
    }



