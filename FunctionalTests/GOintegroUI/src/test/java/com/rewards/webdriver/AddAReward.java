package com.rewards.webdriver;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class AddAReward extends suiteUtility.java.NavigateToCatalago {

 @Test
//Add a reward
 
	public void addAReward () {
		
	   driver.findElement(By.cssSelector("ul li:nth-child(3) a .app-name")).click();
	   
	   driver.findElement(By.cssSelector(".item-grid li:nth-child(1) .item")).click();// Select an item from list 
	   
	   driver.findElement(By.cssSelector("div:nth-child(2) .btn.call-to-action.button-skin.addToCart")).click();
      
	   driver.findElement(By.cssSelector(".btn.btn-primary.confirmation-btn")).click();//Confirm add to cart
	   
	   driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.confirmation-btn")).click(); // Confirm transaction
	   
	   String messagesuccessful = new String (driver.findElement(By.cssSelector(".text-block>h2")).getText());
	   System.out.print(messagesuccessful);//Print message successful
	   
	   
	 //    driver.findElement(By.cssSelector("h2 a ...")).click();
 }	

}
     
   





	
   

