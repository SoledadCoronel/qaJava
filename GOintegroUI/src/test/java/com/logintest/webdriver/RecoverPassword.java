package com.logintest.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RecoverPassword {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testRecoverPasswordClose() throws Exception {

        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();
        driver.findElement(By.id("forgotPasswordButton")).click();
        driver.findElement(By.xpath(".//*[@id='forgotPasswordModal']/div[1]/button")).click();
        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.id("forgotPasswordButton")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "¿Olvidó su contraseña?";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testRecoverPasswordClose  [OK]");
        }
        else
            System.out.println("testRecoverPasswordClose  [FAIL]");
    }

    @Test
    public void testRecoverPasswordCancel() throws Exception {

        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();
        driver.findElement(By.id("forgotPasswordButton")).click();
        driver.findElement(By.xpath(".//*[@id='forgotPasswordModal']/div[2]/button[2]")).click();
        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.id("forgotPasswordButton")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "¿Olvidó su contraseña?";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testRecoverPasswordCancel  [OK]");
        }
        else
            System.out.println("testRecoverPasswordCancel  [FAIL]");
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
