package Rewards;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

@Test
public class AddAReward extends suiteUtility.java.GoToCatalago {

 @Test
//Add a reward
 
	public void addAReward () {
		
	   driver.findElement(By.cssSelector(".app-name")).click();
	   driver.findElement(By.cssSelector(".item-grid li:nth-child(1) .item")).click();
	   
	   driver.findElement(By.cssSelector("div:nth-child(2) .btn.call-to-action.button-skin.addToCart")).click();
       driver.findElement(By.cssSelector(".app-name")).click();
 }	

}
     
   





	
   

