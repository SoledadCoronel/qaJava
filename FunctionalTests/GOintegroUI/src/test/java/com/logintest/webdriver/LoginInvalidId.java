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

public class LoginInvalidId {

    // Se declaran las variables
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
	public void setUp() throws Exception {
        driver = new FirefoxDriver();
    	        baseUrl ="https://gocauto2.p2-stage.gointegro.com";
        driver.get(baseUrl);
        driver.get(baseUrl + "/auth/signin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    // insert an invalid user and check error thrown
    
    public void testLogin() throws Exception {
        
        driver.findElement(By.cssSelector("input[id=_username]")).sendKeys("zaraza");
        driver.findElement(By.cssSelector("a[id=_submit]")).click();
        driver.findElement(By.cssSelector("#error-login")).isDisplayed();
                         
       
    }

    @AfterMethod
	public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }
}
