package com.spaces.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class NewPublicSpace {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    static int rand = (int) (Math.random() * 999999999);
    String nameSpace = "Nuevo espacio publico" + rand + " - AUTOMATICO";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testNewPublicSpace() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        driver.findElement(By.cssSelector("button[name=\"Nuevo espacio\"]")).click();
        driver.findElement(By.id("workspace-name")).clear();
        driver.findElement(By.id("workspace-name")).sendKeys(nameSpace);
        driver.findElement(By.id("workspace-description")).clear();
        driver.findElement(By.id("workspace-description")).sendKeys(nameSpace);
        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);


        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.cssSelector(".app-title")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Editar espacio";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testNewPublicSpace  [OK]");
        }
        else
            System.out.println("testNewPublicSpace  [FAIL]");
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
