package suiteUtility.java;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateToCatalago extends suiteUtility.java.LoginAutomation1{
    
    
    @Before 
    
    public void goToCatalogoPage() throws Exception { 
                  
       
    	 driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
         
         driver.findElement(By.cssSelector("ul li:nth-child(3) a .app-name")).click();
                
         
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-default")));
         
    }    
  	  
}


