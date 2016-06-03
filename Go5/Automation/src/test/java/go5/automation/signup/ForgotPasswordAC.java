package go5.automation.signup;


import go5.automation.TestSuite;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;



public class ForgotPasswordAC extends TestSuite{
	
		  
	
	 
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	private String inputemail= "signInIdentification";
	private String linkForgotPassword =".signup .link";
	 
	 @Test
	
		public void testForgotPassword() throws Exception { 
		WebElement forgotlink = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".signup .link")));
		driver.findElement(By.cssSelector(".signup .link")).click();
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("banana@cachirula.zunga.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	Reporter.log("Insertar un   email invalido y verificar que el mensaje correcto se muestre");
	   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	   String SpanishText2 = new String( driver.findElement(By.cssSelector(".signup .reject ")).getText());
	   Reporter.log(SpanishText2);
		 Assert.assertEquals(SpanishText2,"El email ingresado no se encuentra registrado. Por favor vuelve a intentarlo");
	
	// Insertar un email valido y verificar texto que se envio la contraseña
		
		 Reporter.log("Insertar un email valido y verificar texto que se envio la contraseña");
		 // Funtion to obtain link in the page
		 
		 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) { $('.primary').after('<a class=\"forgot-pass-link\" href=\"/authentication/reset-password/'+$.parseJSON(xhr.responseText).data.id+'\">Forgot Link!</a>'); });");
		
		driver.findElement(By.id("signInIdentification")).clear();
		Reporter.log("Insertar el email y  presionar el  button to resend password");
		driver.findElement(By.id("signInIdentification")).sendKeys("forgotpassword@gointegro.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
	   Reporter.log(SpanishText);
	   Assert.assertEquals(SpanishText,"Revisa tu email.");
	   Reporter.log(" Token enviado exitosamente");
		 
		 // Ir a la pagina para recuperar la contraseña
	   Reporter.log("Ir a la pagina para recuperar la contraseña");
		 driver.findElement(By.cssSelector(".forgot-pass-link")).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.findElement(By.id("passwordIdentification")).sendKeys("12345");
		 Reporter.log(driver.findElement(By.cssSelector(".reject span")).getText());
		 driver.findElement(By.id("passwordIdentification")).sendKeys("Auto1234");
		 driver.findElement(By.cssSelector(".primary")).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Reporter.log( driver.findElement(By.cssSelector(".signup p")).getText());
		 Reporter.log("Contraseña recuperdad exitosamente");
	}
	
     }
