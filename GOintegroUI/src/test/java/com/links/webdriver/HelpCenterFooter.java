package com.links.webdriver;

/**
 * Created by soledad on 12/08/15.
 */
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelpCenterFooter {

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

    public void testHelpCenterFooter() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma espa�ol
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.cssSelector("footer .pull-left:nth-child(2) a:nth-child(2)")).click();

        String capturedText = new String(driver.findElement(By.className("app-title")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Centro de Ayuda";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testHelpCenterFooter  [OK]");
        }
        else {
            System.out.println("testHelpCenterFooter  [FAIL]");
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
