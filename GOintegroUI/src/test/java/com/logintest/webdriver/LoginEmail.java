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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginEmail {

    // Se declaran las variables
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
	public void setUp() throws Exception {
       driver = new FirefoxDriver();
    	//System.setProperty("webdriver.chrome.driver", "D:/home/marinatouceda/ChromeDriver");
    	//driver = new ChromeDriver();
        baseUrl ="https://test.p2-stage.gointegro.com";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws Exception {

        driver.get(baseUrl + "/auth/signin");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[id=_username]")).sendKeys("marinatouceda@gointegro.com");
        driver.findElement(By.cssSelector("input[id=_password]")).sendKeys("integro15");
        driver.findElement(By.cssSelector("a[id=_submit]")).click();
          
               
              
        // Se captura el texto de la validación
        Thread.sleep(1000);
        String textToVerify = new String (driver.findElement(By.cssSelector("a[title=Inicio]")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Inicio";

        // Se valida que el texto es el esperado
        if(textToVerify.equals(expectedText)) {
            System.out.println("testLogin  [OK]");
        }
        else {
            System.out.println("testLogin  [FAIL]");
        }
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
