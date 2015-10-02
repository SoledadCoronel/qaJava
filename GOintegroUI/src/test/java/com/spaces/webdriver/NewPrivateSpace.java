package com.spaces.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewPrivateSpace {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    static int rand = (int) (Math.random() * 999999999);
    String nameSpace = "Nuevo espacio privado" + rand + " - AUTOMATICO";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testNewPrivateSpace() throws Exception {

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
        driver.findElement(By.id("private")).click();
        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);


        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.cssSelector(".app-title")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Editar espacio";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testNewPrivateSpace  [OK]");
        }
        else
            System.out.println("testNewPrivateSpace  [FAIL]");
    }

    //Los datos se guardaron correctamente

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
