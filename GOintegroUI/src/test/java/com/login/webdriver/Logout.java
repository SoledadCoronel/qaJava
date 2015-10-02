package com.login.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Logout {

    // Se declaran las variables
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testLogout() throws Exception {

        // Se setean las variables
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Se loguea el usuario
        driver.get(baseUrl + "/auth/signin");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se cierra sesión del usuario
        driver.findElement(By.xpath(".//*[@id='drop3']/span")).click();
        driver.findElement(By.linkText("Cerrar sesión")).click();

        // Se verifica presencia de botón login
        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.id("_submit")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Log In";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("LogoutOk  [OK]");
        }
        else {
            System.out.println("LogoutOk  [FAIL]");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
