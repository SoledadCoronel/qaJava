package com.verification.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerificationClose {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    // Iniciando el test
    public void testVerificationClose() throws Exception {
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma espa�ol
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();
        //Thread.sleep(1000);

        driver.findElement(By.id("signupButton")).click();
        driver.findElement(By.id("_verificationValue1")).clear();
        driver.findElement(By.id("_verificationValue1")).sendKeys("28123138");
        driver.findElement(By.id("verificationSubmit")).click();
        Thread.sleep(2000);
        // Se captura el texto
        String capturedText = new String(driver.findElement(By.cssSelector(".alert-custom.alert-error.hide.verification_error")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "El usuario ya se encuentra registrado o no corresponde a la plataforma.";

        //Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testVerificationClose  [OK]");
        }
        else {
            System.out.println("testVerificationClose  [FAIL]");
        }
        // Se presiona Cerrar
        driver.findElement(By.xpath(".//*[@id='verificationModal']/div[1]/button")).click();
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
