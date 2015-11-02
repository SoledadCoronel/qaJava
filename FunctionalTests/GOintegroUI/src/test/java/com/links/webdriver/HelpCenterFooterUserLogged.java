package com.links.webdriver;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class HelpCenterFooterUserLogged extends suiteUtility.java.LoginAutomation1 {

  
    @Test

    public void testHelpCenterForm() throws Exception {
        
    	driver.findElement(By.linkText("Centro de Ayuda"));
    	driver.findElement(By.linkText("Centro de Ayuda")).click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(By.cssSelector("input[id=issue]"));
    	
    }
}
