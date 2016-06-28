package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


    
    
    public class LoginPage {

    	//Css
    	
    	public static String strUsername= new String("marina.touceda@gointegro.com");
    	protected static String strUsernameAdminEspacios= new String("marina.touceda+023@gointegro.com");
    	protected static String strUsernameUserBasic= new String("marina.touceda+100@gointegro.com");
     	public static String strPassword= new String("Auto1234");
    	protected static String inputmailLogin = ".signup fieldset label:nth-child(2) input";
    	protected static String inputPasswordLogin = ".signup fieldset label:nth-child(3) input";
    	protected String inputSubdominio=".signup fieldset label:nth-child(4) input";
    	protected static String goButton = new String (".signup .primary");
    	
    	By userName =By.cssSelector(inputmailLogin);
    	By password =By.cssSelector(inputPasswordLogin);
    	By userBasic = By.cssSelector(strUsernameUserBasic);
    	By go=By.cssSelector(goButton);
    	By title = By.cssSelector(".session legend");
    	
    	
    	 protected WebDriver driver;
    
    	
  
    	    public LoginPage(WebDriver driver){
    	    	 
    	        this.driver =  driver;
     }
  
     //Set user name in textbox
  
     public LoginPage setUserName(String strUserName){
      
    	driver.findElement(userName).clear();
    	driver.findElement(userName).sendKeys(strUserName);
     	return this;
  
     }
  
      
  
     //Set password in password textbox
  
     public void setPassword(String strPassword){
  
    	 
    	// wait.until(ExpectedConditions.elementToBeClickable(By.tagName("BUTTON")));
    	 driver.findElement(password).clear();
    	 driver.findElement(password).sendKeys(strPassword);
  
     }
  
     //Get the title of Login Page
     
     public String getLoginTitle(){
  
      return    driver.findElement(title).getText();
  
     }
  
     //Click on login button
  
     public void clickLogin(){
  
             driver.findElement(go).click();
  
     }
       
   
     /**
  
      * This POM method will be exposed in test case to login in the application
  
      * @param strUserName
  
      * @param strPasword
  
      * @return
  
      */
  
     public void loginToGo(String strUserName,String strPasword){
  
         //Fill user name
    	 
    	
         this.setUserName(strUserName);
       
         
         //Fill password
  
         this.setPassword(strPasword);
  
         //Click Login button
  
         this.clickLogin();
     } 
  
         public void loginToGoAsAdmin(){
        	  
             //Fill user name
        	 this.setUserName(strUsername);
             
      
             //Fill password
      
             this.setPassword(strPassword);
      
             //Click Login button
      
             this.clickLogin();
               
         
     }
  
 
 
         public void loginToGoAsAdminEspacios(){
       	  
             //Fill user name
        	 this.setUserName(strUsernameAdminEspacios);
             
      
             //Fill password
      
             this.setPassword(strPassword);
      
             //Click Login button
      
             this.clickLogin();
               
         }
 
         public void loginToGoAsUSerBasic(){
          	  
             //Fill user name
        	 this.setUserName(strUsernameUserBasic);
             
      
             //Fill password
      
             this.setPassword(strPassword);
      
             //Click Login button
      
             this.clickLogin();

 }
    }



