package go5.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class SignupPlatformPage {

    	//Css
    	
       protected String idCorporateEmail= "SignupRequest_email_label";
       protected String idLenguajeEspañol="SignupRequest_language_1";
       protected String idLenguajePortuges="SignupRequest_language_2";
       protected String idLenguajeEnglish="SignupRequest_language_3";
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
    	driver.findElement(By.id(idSubmitButton)).click();
    	    	
    }
    
    public void createPlatformEspanish(String strEmail){
    	this.setCorporateEmail(strEmail);
    	this.setEspañol();
    	this.clickSubmitButton();
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
