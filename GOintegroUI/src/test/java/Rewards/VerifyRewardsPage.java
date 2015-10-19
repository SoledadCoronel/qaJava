package Rewards;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class VerifyRewardsPage extends suiteUtility.java.LoginAutomation1 {

	
@Before
 // Open Catalogo

    public void openCatalog (){
   driver.findElement(By.cssSelector(".app-name")).click();
   
   WebDriverWait wait = new WebDriverWait(driver, 10);
   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".alert.alert-warning .inline-block")));
}

	
		
@Test 
//Validate that all links are present

 public void testLinks (){
	
	System.out.println("Los links presentes son :  ");
	// Verify all the links on the page
	driver.findElement(By.linkText("Destacados")).click();
	String link1 = new String (driver.findElement(By.linkText("Destacados")).getText());
	System.out.println(link1);
	driver.findElement(By.linkText("Mayor Valor")).click();
	String link2 = new String (driver.findElement(By.linkText("Mayor Valor")).getText());
	System.out.println(link2);
	driver.findElement(By.linkText("Menor Valor")).click();
	String link3 = new String (driver.findElement(By.linkText("Menor Valor")).getText());
	System.out.println(link3);
	driver.findElement(By.linkText("Items A-Z")).click();
	String link4 = new String (driver.findElement(By.linkText("Items A-Z")).getText());
	System.out.println(link4);
	driver.findElement(By.linkText("Items Z-A")).click();
	String link5 = new String (driver.findElement(By.linkText("Items Z-A")).getText());
	System.out.println(link5);
}

@Test
//Validate ProperOrder 

   public void testAlphabeticOrder (){
	
	
	
	driver.findElement(By.linkText("Items A-Z")).click();
	
	String descriptionOne = new String (driver.findElement(By.cssSelector(".item-grid li:nth-child(1) a")).getText());
		System.out.println(descriptionOne);
		Assert.assertEquals("¿A qué estación vamos? | Junior Express", "¿A qué estación vamos? | Junior Express");
		
	      }	


@Test
//Validate that amount of points are present in the page

  public void getCurrentPOints (){
	

String getPoints = new String(driver.findElement(By.cssSelector(".alert.alert-warning .inline-block ")).getText());

System.out.println(getPoints);
}

	}
     
   





	
   

