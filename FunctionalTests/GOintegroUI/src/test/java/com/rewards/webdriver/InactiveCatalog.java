package com.rewards.webdriver;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class InactiveCatalog extends suiteUtility.java.LoginAutomation1 {

 @Test
//Verify that a user can not access to an inactive catalog
 
	public void accesToAnInactiveCatalog () {
		
	
	 //WebDriverWait wait = new WebDriverWait(driver, 10);
     //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul li:nth-child(4) a .app-name")));
	 
     driver.findElement(By.xpath(".//*[@id='environmentHome']/header/span"));
     
     driver.findElement(By.cssSelector("ul li:nth-child(4) a .app-name")).click();
	 String message = new String (driver.findElement(By.cssSelector(".alert.alert-block.alert-error.fade.in>p")).getText());
	 System.out.println(message);
	 Assert.assertEquals(message, "No tienes permiso para acceder a este recurso o el mismo se encuentra desactivado.");
	 
 }	

}
     
   





	
   

