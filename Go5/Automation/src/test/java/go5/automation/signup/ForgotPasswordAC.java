package go5.automation.signup;


import go5.automation.TestSuite;
import go5.pageObjects.ForgotPasswordPage;

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

	private String fakeEmail="banana@cachirula.zunga.com";
	private String validEmail="forgotpassword@gointegro.com";
	ForgotPasswordPage forgot=null; 
	
	
	
	
	
	@Test
	
		public void invalidEmail() throws Exception { 
		
		 
		 //Init Forgot Page
		 forgot= new ForgotPasswordPage(driver);
	
	//Test de email invalido
		 Reporter.log("Insertar un   email invalido y verificar que el mensaje correcto se muestre");
		 
		 
		 forgot.openForgotPage();
		 forgot.insertEmail(fakeEmail);
		 forgot.clickGo();
		 Thread.sleep(5000);
	
			
		//Insertar un email valido y verificar texto que se envio la contraseña
		
		 Reporter.log("Insertar un email valido y verificar texto que se envio la contraseña");
		 // Funtion to obtain link in the page
		 
		 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) { $('.primary').after('<a class=\"forgot-pass-link\" href=\"/authentication/reset-password/'+$.parseJSON(xhr.responseText).data.id+'\">Forgot Link!</a>'); });");
		
		 
		 forgot.insertEmail(validEmail);
		//forgot.createForgotLink();
		 forgot.clickGo();
		 forgot.verifyEmailSent();
		 Thread.sleep(5000);
		 forgot.goToRestorePassword();
			
	}
	
     }

