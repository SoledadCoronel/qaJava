package com.links.webdriver;

/**
 * Created by soledad on 12/08/15.
 */

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TermsAndConditions {

    // Se declaran las variables
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // Se setean las variables
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testTermsAndConditions() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma espa�ol
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.cssSelector("footer .pull-left:nth-child(2) a:nth-child(1)")).click();

        String capturedText = new String(driver.findElement(By.xpath("//div[@id='termsAndConditionsModal']/div[2]")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Ser empleado de GoIntegro";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testTermsAndConditions  [OK]");
        }
        else {
            System.out.println("testTermsAndConditions  [FAIL]");
        }
        // Se cierra la ventana modal
        driver.findElement(By.xpath("//div[@id='termsAndConditionsModal']/div[3]/button")).click();
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
