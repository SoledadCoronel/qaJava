package com.rewards.webdriver;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class VerifyAvailablePoints extends suiteUtility.java.NavigateToCatalago {

 @Test
//Verify that a user can not access to an inactive catalog
 
	public void verifypoints () {
		
	   driver.findElement(By.cssSelector("ul li:nth-child(3) a .app-name")).click();
	   //Wait until the catalog is loaded
	   
	   WebDriverWait wait = new WebDriverWait(driver, 10);
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".item-grid li:nth-child(1) .item")));
	 
       //Verify that the available points are present in the page
            
	 String message = new String (driver.findElement(By.cssSelector(".alert.alert-warning .inline-block>strong")).getText());
	  System.out.print(message);
	  
	 
	      
 }	

}
     
   





	
   

