package go5.automation.signup;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ForgotPasswordTest extends SignUp{


	 @BeforeClass // call function to open the browser and load url
	 public void setup (){
	   openSiteLogin();
	 }
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test(priority=1)
	
	public void openForgotPasswordPage(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Validando resending password");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".signup .link")).click();
		
		driver.findElement(By.cssSelector(".primary")).isEnabled();
		log.info(" El boton de resend esta enabled");
	}		
	
	@Test(priority=3)
	
	public void insertEmailToResendPassword() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   log.info("Inserte el email y reenvio");
	   String sentMessage = new String (driver.findElement(By.cssSelector(".overlayloading p")).getText());
	   log.info(sentMessage);
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
		 log.info(SpanishText);
		 Assert.assertEquals(SpanishText,"Revisa tu email.");
 
	}

	@Test(priority=2)
	
	public void insertInvalidEmail() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("banana@cachirula.zunga.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   log.info("Insertar un  invalid email y verificar que el mensaje correcto se muestre");
	   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	   String SpanishText2 = new String( driver.findElement(By.cssSelector(".signup .reject ")).getText());
		 log.info(SpanishText2);
		 System.out.println(SpanishText2);
		 Assert.assertEquals(SpanishText2,"El email ingresado no se encuentra registrado. Por favor vuelve a intentarlo");
 
	}
     }

