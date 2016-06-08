package go5.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;


  
    
    
    public class SignupPlatformPage {

    	//Css
    	
       protected String idCorporateEmail= "SignupRequest_email";
       protected String idLenguajeEspañol="SignupRequest_language_0";
       protected String idLenguajePortuges="SignupRequest_language_1";
       protected String idLenguajeEnglish="SignupRequest_language_2";
       protected String idSubmitButton="submit_button";
      	  	
    	  WebDriver driver;
    
    	
  
    	    public SignupPlatformPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
  
    
  
      
  
     //Set password in password textbox
  
     public void setCorporateEmail(String strcorporateemail){
    	 Reporter.log("Ingresar un mail corporativo para crear una plataforma");
    	 driver.findElement(By.id(idCorporateEmail)).sendKeys(strcorporateemail);
           }
  
  public void setEspañol(){
	  Reporter.log("Seleccionar lenguaje español");
	   driver.findElement(By.id(idLenguajeEspañol)).click();
  }
  
    public void setPortuges(){
    	Reporter.log("Seleccionar lenguaje Portuges");
    	driver.findElement(By.id(idLenguajePortuges)).click();
    }
    public void setIngles(){
    	Reporter.log("Seleccionar lenguaje Ingles");
    	driver.findElement(By.id(idLenguajeEnglish)).click();
    }
    
    public void clickSubmitButton(){
    	Reporter.log("Presionar submit button");
    	driver.findElement(By.id(idSubmitButton)).submit();
    	    	
    }
    
    public void createPlatformEspanish(String strEmail) throws InterruptedException{
    	//Me muevo al iframe
    	driver.switchTo().frame("iframe");
    	 
 		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
 		
    	this.setCorporateEmail(strEmail);
    	this.setEspañol();
    	//Thread.sleep(3000);
    	this.clickSubmitButton();
    	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    	Reporter.log("Clickeo en el link para abrir la pagina de crear plataforma");
		// Get the token
		String urlToken =new String(driver.findElement(By.id("create_platform_link")).getAttribute("href"));
		driver.get(urlToken);		   	
    }
    
    public void createPlatformPortugues(String strEmail){
    	this.setCorporateEmail(strEmail);
    	this.setPortuges();
    	this.clickSubmitButton();
        }
   
    public void createPlatfomrEnglish(String strEmail){
    	this.setCorporateEmail(strEmail);
    	this.setIngles();
    	this.clickSubmitButton();
    }
    
    public String  getToken(){
    	Reporter.log("Obtener el link para crear plataforma");
    	String urlToken =new String(driver.findElement(By.id("create_platform_link")).getAttribute("href"));
		//driver.findElement(By.id("create_platform_link")).click();
		return  getToken();
    	
    	
		
    }
    public void irACreatePlatform(){
    	Reporter.log("Clickear en el link para ir a crear plataforma");
    	driver.findElement(By.id("create_platform_link")).click();
    }
    }

