package com.goWiki.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.fail;

public class ProductFaqs {

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
    public void testProductFaqs() throws Exception {
        // Inicia el test
        // Se ingresan credenciales
        driver.get(baseUrl);
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        driver.get(baseUrl + "/app/articles/5669");
        driver.findElement(By.cssSelector("a[title=\"Product FAQ\"] > span.app-name")).click();
        String capturedText = new String(driver.findElement(By.cssSelector(".titleEditable>h3>p")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "Que formatos de video soporta la plataforma?";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testProductFaq  [OK]");
        }
        else {
            System.out.println("testProductFaq  [FAIL]");
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
