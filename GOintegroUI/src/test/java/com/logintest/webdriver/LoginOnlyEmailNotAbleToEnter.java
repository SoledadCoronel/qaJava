package com.logintest.webdriver;

/**
 * Created by soledad on 12/08/15.
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginOnlyEmailNotAbleToEnter {

   FirefoxDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setup() throws Exception { 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://gocauto1.p2-stage.gointegro.com/auth/signin"); 
       
    }

    @Test
    // Verify that the Login button is disabled 
    
    public void testLogin() throws Exception {
    	 driver.findElement(By.cssSelector("input[id=_username]")).sendKeys("automation@gointegro.com");
         
        driver.findElement(By.cssSelector(".login_submit.disabled"));
             
       
        
    }

    @AfterMethod
	public void tearDown() throws Exception {
        driver.quit();
               
    }
}
