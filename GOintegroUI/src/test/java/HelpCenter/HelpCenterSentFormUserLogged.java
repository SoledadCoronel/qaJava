package HelpCenter;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

@Test
public class HelpCenterSentFormUserLogged extends com.links.webdriver.HelpCenterFooterUserLogged {

 
	public void fillingForm () {
// Validate that the help center form can be sent
	
	
   driver.findElement(By.cssSelector("input[id=document]")).sendKeys("222222222");
   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
   driver.findElement(By.cssSelector("input[id=email]")).sendKeys("automation@gointegro.com");;
   driver.findElement(By.cssSelector("#reason")).click();;
   driver.findElement(By.cssSelector("#reason")).sendKeys("Consulta");	   
   driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
   driver.findElement(By.cssSelector("#issueType")).click();
   driver.findElement(By.cssSelector("#issueType")).sendKeys("Descuento");
    
   driver.findElement(By.cssSelector("#issue")).sendKeys("Testing Help Center");
   driver.findElement(By.cssSelector("#description")).sendKeys("Testing the Description of the Help Center form");
   driver.findElement(By.cssSelector("button[id=submit]")).click();
   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);   
   
   // Validate message has been sent
      System.out.println(driver.findElement(By.className("alert")).getText());
   String stringToValidate= new String (driver.findElement(By.className("alert")).getText());
  
   
   Assert.assertEquals("Su mensaje fue enviado exitósamente.", stringToValidate);
	}
}



	
   

