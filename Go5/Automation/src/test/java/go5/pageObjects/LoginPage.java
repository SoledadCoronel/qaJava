package go5.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


  
    
    
    public class LoginPage {

    	//Css
    	
    	public static String strUsername= new String("marina.touceda@gointegro.com");
    	protected static String strUsernameAdminEspacios= new String("marina.touceda+023@gointegro.com");
    	protected static String strUsernameUserBasic= new String("marina.touceda+022@gointegro.com");
     	public static String strPassword= new String("Auto1234");
    	protected static String inputmailLogin = new String (".session label:nth-child(3) input");
    	protected static String inputPasswordLogin = new String (".session label:nth-child(4) input");
    	protected static String goButton = new String (".session .primary");
    	
    	By userName =By.cssSelector(inputmailLogin);
    	By password =By.cssSelector(inputPasswordLogin);
    	By go=By.cssSelector(goButton);
    	By title = By.cssSelector(".session legend");
    	
    	
    	  WebDriver driver;
    
     
  
    	    public LoginPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
     public LoginPage setUserName(String strUserName){
      
    	driver.findElement(userName).clear();
    	 driver.findElement(userName).sendKeys(strUserName);
    	return this;
  
     }
  
      
  
     //Set password in password textbox
  
     public void setPassword(String strPassword){
  
         driver.findElement(password).clear();
    	 driver.findElement(password).sendKeys(strPassword);
  
     }
  
     //Get the title of Login Page
     
     public String getLoginTitle(){
  
      return    driver.findElement(title).getText();
  
     }
  
     //Click on login button
  
     public void clickLogin() throws InterruptedException{
    	 	Thread.sleep(2000);
             driver.findElement(go).click();
  
     }
       
   
     /**
  
      * This POM method will be exposed in test case to login in the application
  
      * @param strUserName
  
      * @param strPasword
  
      * @return
     * @throws InterruptedException 
  
      */
  
     public void loginToGo(String strUserName,String strPasword) throws InterruptedException{
  
         //Fill user name
    	 
    	
         this.setUserName(strUserName);
       
         
         //Fill password
  
         this.setPassword(strPasword);
  
         //Click Login button
      //   driver.findElement(password).sendKeys(Keys.ENTER);
          
  
         this.clickLogin();
     } 
  
         public void loginToGoAsAdmin() throws InterruptedException{
        	  
             //Fill user name
        	 this.setUserName(strUsername);
             
      
             //Fill password
      
             this.setPassword(strPassword);
      
             //Click Login button
      
             this.clickLogin();
               
         
     }
  
 
 
         public void loginToGoAsAdminEspacios() throws InterruptedException{
       	  
             //Fill user name
        	 this.setUserName(strUsernameAdminEspacios);
             
      
             //Fill password
      
             this.setPassword(strPassword);
      
             //Click Login button
      
             this.clickLogin();
               
         }
 
         public void loginToGoAsUSerBasic() throws InterruptedException{
          	  
             //Fill user name
        	 this.setUserName(strUsernameUserBasic);
             
      
             //Fill password
      
             this.setPassword(strPassword);
      
             //Click Login button
      
             this.clickLogin();

 }
    }



