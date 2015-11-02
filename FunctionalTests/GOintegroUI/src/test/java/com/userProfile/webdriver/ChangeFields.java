package com.userProfile.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChangeFields {

    // Se declaran las variables
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
    public void testChangeBirthdate() throws Exception {

        // Se loguea el usuario
        driver.get(baseUrl + "/auth/signin");
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se ingresa al profile del usuario
        driver.findElement(By.id("drop3")).click();
        //driver.findElement(By.xpath(".//*[@id='user-menu']/ul/li[3]/ul/li[1]/a")).click();
        driver.findElement(By.cssSelector("#user-menu .profile-pic li:nth-child(1) a")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/header/div[2]/div[2]/div/button")).click();
        driver.findElement(By.linkText("Editar mis datos")).click();

        driver.findElement(By.id("birthdate")).click();
        //driver.findElement(By.xpath("html/body/div[5]/div[1]/table/tbody/tr[1]/td[4]")).click();
        //driver.findElement(By.id("birthdate")).sendKeys("1980-09-23");
        driver.findElement(By.cssSelector(".datepicker tr:nth-child(1) td:nth-child(7)")).click();
        driver.findElement(By.id("saveProfileData")).click();
        System.out.println("testChangeBirthdate  [OK]");
    }

    @Test
    public void testChangeDocumentCancel() throws Exception {

        // Se loguea el usuario
        driver.get(baseUrl + "/auth/signin");
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se ingresa al profile del usuario
        driver.findElement(By.id("drop3")).click();
        driver.findElement(By.xpath(".//*[@id='user-menu']/ul/li[3]/ul/li[1]/a")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/header/div[2]/div[2]/div/button")).click();
        driver.findElement(By.linkText("Editar mis datos")).click();

        // Se cancela modificación
        driver.findElement(By.id("cancelProfileData")).click();
        System.out.println("testChangeDocumentCancel  [OK]");
    }

    @Test
    public void testChangeDocument() throws Exception {

        // Se loguea el usuario
        driver.get(baseUrl + "/auth/signin");
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se ingresa al profile del usuario
        driver.findElement(By.id("drop3")).click();
        driver.findElement(By.xpath(".//*[@id='user-menu']/ul/li[3]/ul/li[1]/a")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/header/div[2]/div[2]/div/button")).click();
        driver.findElement(By.linkText("Editar mis datos")).click();

        // Se modifica el DNI
        driver.findElement(By.id("document")).clear();
        driver.findElement(By.id("document")).sendKeys("28123138");
        driver.findElement(By.id("saveProfileData")).click();
        System.out.println("testChangeDocument  [OK]");
    }

    @Test
    public void testLinkUserProfile() throws Exception {

        // Se loguea el usuario
        driver.get(baseUrl + "/auth/signin");
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se ingresa al profile del usuario
        driver.findElement(By.id("drop3")).click();
        driver.findElement(By.xpath(".//*[@id='user-menu']/ul/li[3]/ul/li[1]/a")).click();
        Thread.sleep(1000);

        // Se verifica profile
        driver.findElement(By.id("user-name")).getText();
        // Se verifica presencia de texto usuario
        String capturedTextLink = new String(driver.findElement(By.id("user-name")).getText());
        // Se setea el texto de validación esperado
        String expectedText = "Romina Conte";

        // Se valida que el texto es el esperado
        if(capturedTextLink.equals(expectedText)) {
            System.out.println("testLinkUserProfile  [OK]");
        }
        else {
            System.out.println("testLinkUserProfile  [FAIL]");
        }
    }

    @Test
    public void testNotificationsSettings() throws Exception {

        // Se loguea el usuario
        driver.get(baseUrl + "/auth/signin");
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);

        // Se ingresa al profile del usuario
        driver.findElement(By.id("drop3")).click();
        driver.findElement(By.xpath(".//*[@id='user-menu']/ul/li[3]/ul/li[1]/a")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/header/div[2]/div[2]/div/button")).click();
        driver.findElement(By.linkText("Configuración de notificaciones")).click();
        Thread.sleep(1000);
        // Se captura el texto de la validación
        String capturedText = new String(driver.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/div[2]/form/fieldset/span[1]")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "¿Desea recibir notificaciones a su mail?";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testNotificationsSettings  [OK]");
        }
        else {
            System.out.println("testNotificationsSettings  [FAIL]");
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
