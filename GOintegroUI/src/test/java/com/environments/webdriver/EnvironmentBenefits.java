package com.environments.webdriver;

/**
 * Created by soledad on 12/08/15.
 */
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentBenefits extends suiteUtility.java.NavigateToBeneficios{
        

    @Test
    public void testEnvironmentBenefits()  {
       
        driver.findElement(By.cssSelector("#environments>li:nth-child(2)>a")).click();
     
        String capturedText = new String(driver.findElement(By.cssSelector(".active>a")).getText());
        System.out.println(capturedText);
  
       
    }
  

}
