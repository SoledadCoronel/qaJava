package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class Login extends CommonFunctions{


	

	public void login() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".primary")).click();
 
	}

	
}
