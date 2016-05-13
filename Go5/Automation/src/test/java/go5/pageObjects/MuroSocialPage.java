package go5.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class MuroSocialPage {

    	//Css
    	
    	protected String textAreaPostcss= "fieldset textarea";
    	protected String cameraPostcss=".igocamerawhite";
    	protected String linkPostcss=".igolink";
    	protected String attachPostcss=".igoattach";
    	protected String publicarContenidoCss="fieldset .primary";
    	protected String iconcss=".icon";
    	
    	
    	By textPost =By.cssSelector(textAreaPostcss);
    	By link =By.cssSelector(linkPostcss);
    	By publicarContenido = By.cssSelector(publicarContenidoCss);
    	By icon =By.cssSelector(iconcss);
    	
    	
    	  WebDriver driver;
    
     
  
    	    public MuroSocialPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set a string in a posttext
  
     public void setPostTexto(String strTextPost){
      
    	 driver.findElement(textPost).clear();
    	 driver.findElement(textPost).sendKeys(strTextPost);
    	
     }
   
     public void postear(){
    	 
    	 driver.findElement(publicarContenido).click();
    	 Reporter.log("CLikeo publicar");
    	 
     }
      
  /*
  
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
       // 	 this.setUserName(strUsername);
             
      
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

 }*/
    }



