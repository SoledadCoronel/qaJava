package go5.automation.signup;




import java.util.concurrent.TimeUnit;

import go5.automation.SetUp;
import go5.pageObjects.CreatePlatformPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.SignupPage;
import go5.pageObjects.SignupPlatformPage;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CreatePlatformExpiredTokenTest extends SetUp{
			
 protected String urltokenVencido="http://signup.qa.go5.gointegro.net/en/createPlatform/token/3e8hap5qzxes404s0goocso08wocwk0kw4k8c4cw4sosg4c8wo";			
		
	@BeforeTest // call function to open the browser and load url
	 public void setup () throws Exception{
		 	
		 	
		 	driver = new FirefoxDriver();	          	 
	        this.openSite(urltokenVencido);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        Reporter.log("Abriendo la crear plataforma con token vencido");
	 }
	

		
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
	 }
	 
 
	// protected String urltokenVencido="http://signup.qa.go5.gointegro.net/en/createPlatform/token/3e8hap5qzxes404s0goocso08wocwk0kw4k8c4cw4sosg4c8wo";
 	
 	 @Test (description=" Tratar de abrir la pagina de crear plataforma con un token vencido")
 
 	  	 
 	 public void createPlatformwithExpiredToken() throws Exception { 
 		signup = new SignupPlatformPage(driver);
 		//Abro la pagina con el token expirado, me devuelve la de signup  		
 		driver.get(urltokenVencido);
 		  Thread.sleep(3000);
 		if(  signup.isEmailInputPresent())
 			Reporter.log("Se abrio la pagina de signup");
		
		// WebElement compania = wait.until(ExpectedConditions.elementToBeClickable(By.id("CreateAccount_company")));
		
 	  	 }
 	 	 }
	
	
	