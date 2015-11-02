package com.recognition.webdriver;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class VerifyRecognitionPage extends suiteUtility.java.LoginAutomation1 {

	
@Before
 // Open Recognition Page

    public void openCatalog (){
   driver.findElement(By.cssSelector("ul li:nth-child(5) a .app-name")).click();
   
   WebDriverWait wait = new WebDriverWait(driver, 10);
   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-xs-6 h1>span")));
}


@Test
//Validate that amount of points are present in the page

  public void getCurrentPOints (){
	

String getPoints = new String(driver.findElement(By.cssSelector(".alert h2 >strong")).getText());

System.out.println(getPoints);
}

	}
     
   





	
   

