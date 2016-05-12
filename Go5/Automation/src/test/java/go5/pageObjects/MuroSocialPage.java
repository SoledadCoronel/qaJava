package go5.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


  
    
    
    public class MuroSocialPage {

    	//Css
    	
    	protected String textAreaPost= "TBD";
    	protected String cameraPost=".igocamerawhite";
    	protected String linkPost=".igolink";
    	
    	
    	By textPost =By.cssSelector(textAreaPost);
    	By link =By.cssSelector(linkPost);
    	
    	
    	  WebDriver driver;
    
     
  
    	    public MuroSocialPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
     public MuroSocialPage setPostTexto(String strUserName){
      
    	driver.findElement(textPost).clear();
    	 driver.findElement(textPost).sendKeys(strUserName);
    	return this;
  
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



