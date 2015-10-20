package com.helpcenter.webdriver;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

@Test
public class HelpCenterSentForm extends suiteUtility.java.OpenSiteAuto1 {

 
	public void fillingForm () {
// Validate that the help center form can be sent
		
	 driver.findElement(By.cssSelector("footer .pull-left:nth-child(2) a:nth-child(2)")).click();
	
	 //Fill the form 
	 
	 driver.findElement(By.cssSelector("input[id=name")).sendKeys("Mel");
	driver.findElement(By.cssSelector("input[id=surname")).sendKeys("Gibson");
   driver.findElement(By.cssSelector("input[id=document]")).sendKeys("222222222");
   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
   driver.findElement(By.cssSelector("input[id=email]")).sendKeys("automation@gointegro.com");;
   driver.findElement(By.cssSelector("#reason")).click();;
   driver.findElement(By.cssSelector("#reason")).sendKeys("Issue");	   
   driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
   driver.findElement(By.cssSelector("#issueType")).click();
   driver.findElement(By.cssSelector("#issueType")).sendKeys("Discount");
    
   driver.findElement(By.cssSelector("#issue")).sendKeys("Testing Help Center");
   driver.findElement(By.cssSelector("#description")).sendKeys("Testing the Description of the Help Center form");
   driver.findElement(By.cssSelector("button[id=submit]")).click();
   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);   
   
   // Validate message has been sent
      System.out.println(driver.findElement(By.className("alert")).getText());
   String stringToValidate= new String (driver.findElement(By.className("alert")).getText());
  
   
   Assert.assertEquals("Message successfully sent.", stringToValidate);
	}
}



	
   

