package com.logintest.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class Logout extends suiteUtility.java.LoginStageGoc {

         


    @Test
    public void testLogout()  {
    	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	 driver.findElement(By.cssSelector("a[id=drop3]")).click();
         driver.findElement(By.linkText("Cerrar sesión")).click();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.findElement(By.cssSelector("a[id=_submit]")).isDisplayed();
        
        
    
        }
    }
	     
    
    

