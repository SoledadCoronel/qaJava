package go5.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


  
    
    
    public class LoginPage {

    	//Css
    	
    	public static String strUsername= new String("marina.touceda@gointegro.com");
    	protected static String strUsernameAdminEspacios= new String("marina.touceda+023@gointegro.com");
    	protected static String strUsernameUserBasic= new String("marina.touceda+022@gointegro.com");
     	public static String strPassword= new String("Auto1234");
    	protected static String inputmailLogin = new String (".session label:nth-child(2) input");
    	protected static String inputPasswordLogin = new String (".session label:nth-child(3) input");
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
  
     public void setUserName(String strUserName){
      
    	driver.findElement(userName).sendKeys(strUserName);
  
     }
  
      
  
     //Set password in password textbox
  
     public void setPassword(String strPassword){
  
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
  
 
 
 
 
/*
 
 public static void loginAdmin(WebDriver driver){
	    	 LoginPage.id_User(driver).clear();
 		LoginPage.id_User(driver).sendKeys(strUsername);
 		LoginPage.id_Password(driver).clear();
 		LoginPage.id_Password(driver).sendKeys(strPassword);
 		LoginPage.go_Button(driver).click();
     }
 
     
     public static void loginAdminEspacios(WebDriver driver){
    		
    	     LoginPage.id_User(driver).clear();
     		LoginPage.id_User(driver).sendKeys(strUsernameAdminEspacios);
     		LoginPage.id_Password(driver).clear();
     		LoginPage.id_Password(driver).sendKeys(strPassword);
     		LoginPage.go_Button(driver).click();
         }
         
     public static void loginBasic(WebDriver driver){


            	 LoginPage.id_User(driver).clear();
         		LoginPage.id_User(driver).sendKeys(strUsernameUserBasic);
         		LoginPage.id_Password(driver).clear();
         		LoginPage.id_Password(driver).sendKeys(strPassword);
         		LoginPage.go_Button(driver).click();
             }
 */
 }
   



