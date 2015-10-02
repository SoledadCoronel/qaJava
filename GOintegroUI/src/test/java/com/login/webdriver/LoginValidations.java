package com.login.webdriver;

/**
 * Created by soledad on 12/08/15.
 */

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginValidations {

    // Se declaran las variables
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testLoginWrongPassword() throws Exception {

        // Se setean las variables
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Iniciando el test
        // Se ingresan credenciales
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma espa�ol
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("cualquierpwd");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.className("error-login")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Usuario y/o contraseña incorrectos";

        // Se valida que el texto es el esperado
        if (capturedText.equals(expectedText)) {
            System.out.println("testLoginWrongPassword  [OK]");
        } else {
            System.out.println("testLoginWrongPassword  [FAIL]");
        }
    }

    @Test
    public void testLoginWrongUser() throws Exception {

        // Se setean las variables
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Inicia el test
        // Se ingresan credenciales
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma espa�ol
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("FailUser");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.className("error-login")).getText());

        // Se setea el texto de validaci�n esperado
        String expectedText = "Usuario y/o contraseña incorrectos";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testLoginWrongUser  [OK]");
        }
        else {
            System.out.println("testLoginWrongUser  [FAIL]");
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
