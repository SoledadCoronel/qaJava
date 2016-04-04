package go5.automation.pages;

	
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

	 
	public class LoginPage {
	 		
		@FindBy(how = How.CSS,using=".session label:nth-child(2) input")
		private WebElement inputMail;
	 
		@FindBy(how = How.CSS, using=".session label:nth-child(3) input")
		private WebElement inputPassword;
		
		@FindBy(how = How.CSS, using=".session .primary")
		private WebElement botonGo;
		

	
		 public void loginObjectFactory(String sUsername,String sPassword) throws Exception { 
			 	
			 inputMail.clear();
			 inputMail.sendKeys(sUsername);
			 inputPassword.clear();
			 inputPassword.sendKeys(sPassword);
			 botonGo.click();
			 throw new IllegalStateException("El loguin fallo");
			  
			
		  	}
	}
