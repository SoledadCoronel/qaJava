package suiteUtility.java;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateToProfile extends suiteUtility.java.LoginAutomation1{
    
    
    @Before 
    
    public void goToProfile() throws Exception { 
                  
       
    	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
         
         
                
         
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-default")));
         
    }    
  	  
}


