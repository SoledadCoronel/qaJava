package go5.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


  
    
    
    public class ForgotPasswordPage {

    	//Css
    	
    	private  final String volverLinkCss = ".signup fieldset button";
		private String goToForgotPageCss=".signup .link";
    	public static String strUsername= new String("marina.touceda@gointegro.com");
    	
    	protected static String strUsernameUserBasic= new String("marina.touceda+022@gointegro.com");
     	public static String strPassword= new String("Auto1234");
    	protected static String inputmailLogin = "signInIdentification";
    	protected static String inputPassword = "passwordIdentification";
    	protected static String goButton =".primary";
    	private String mensajeErrorCss= ".signup .reject";
    	private String forgotLinkCss=".forgot-pass-link";
    	private String errorPassShortCss=".reject";
    	private String shortPassword="12345";
    	private String rightPassword="Auto1234";
    	 
    	
    	
    	By goToForgtoPage=By.cssSelector(goToForgotPageCss);
    	By userName =By.id(inputmailLogin);
    	By password =By.id(inputPassword);
    	By volver=By.cssSelector(volverLinkCss);
    	By go=By.cssSelector(goButton);
    	By mensajeError= By.cssSelector(mensajeErrorCss);
    	By forgotLink=By.cssSelector(forgotLinkCss);
    	By errorPassShort= By.cssSelector(errorPassShortCss);
    	
    	
    	//Drivers
    	    	
     WebDriver driver;
    
     
  
    	    public ForgotPasswordPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
    public void openForgotPage(){
    
    	WebElement forgotlink = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".signup .link")));
    	
    	driver.findElement(goToForgtoPage).click();
        	
    }
    	    
    	    
    	    
    	    //Set user name in textbox
  
     public ForgotPasswordPage insertEmail(String strUserName){
      
    	 WebElement insertEmail = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(userName));
    	driver.findElement(userName).clear();
    	 driver.findElement(userName).sendKeys(strUserName);
    	return this;
  
     }
  
      
  
     //Set password in password textbox
  
     public void setPassword(String strPassword){
  
         driver.findElement(password).clear();
    	 driver.findElement(password).sendKeys(strPassword);
  
     }
      
  
     //Click on login button
  
     public void clickGo(){
  
             driver.findElement(go).click();
  
     }
       
   
     /**
  
      * This POM method will be exposed in test case to login in the application
  
      
  
      * @param strPasword
     * @return 
  
      * @return
  
      */
  
    
  
       public void rememberPassword(String strUserName){
    	   this.insertEmail(strUsername);
    	   this.clickGo();
       }
  
      public void verifyErrorMessage (){
    	String text= (driver.findElement(mensajeError).getText());    	
   	   Reporter.log(text);
   		 Assert.assertEquals(text,"El email ingresado no se encuentra registrado. Por favor vuelve a intentarlo");
      }
 
       public void clickVolver() throws InterruptedException{
    	   driver.findElement(volver).click();
    	   Thread.sleep(2000);
       }
     

       public void verifyEmailSent(){
    	  
    	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
    	   Reporter.log(SpanishText);
    	   Assert.assertEquals(SpanishText,"Revisa tu email.");
    	   Reporter.log(" Token enviado exitosamente");
       }
    
     public void goToRestorePassword(){
    	 
		 // Ir a la pagina para recuperar la contraseña
    	 
    	 Reporter.log("Ir a la pagina para recuperar la contraseña");
    	  
    	 driver.findElement(forgotLink).click();
    	 WebElement insertPassword = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(password));
		 driver.findElement(password).sendKeys(shortPassword);
		 Reporter.log(driver.findElement(mensajeError).getText());
		 driver.findElement(password).clear();
		 driver.findElement(password).sendKeys(rightPassword);
		 this.clickGo();
		Reporter.log("Contraseña recuperdad exitosamente");
     }
    }
   



