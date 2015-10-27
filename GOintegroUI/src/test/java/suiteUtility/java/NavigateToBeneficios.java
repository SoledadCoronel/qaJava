package suiteUtility.java;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateToBeneficios extends suiteUtility.java.LoginAutomation1{
    
    
    @Test 
    
    public void goToBenefitsPage() throws Exception { 
                  
       
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         
         driver.findElement(By.cssSelector("#environments li:nth-child(2) a[data-bindattr-975='975']")).click();
                
         
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".app-title")));
         driver.findElement(By.cssSelector(".app-title"));
         
    }    
  	  
}


