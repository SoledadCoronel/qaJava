package com.registration.webdriver;

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

public class Registration {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    static int rand = (int) (Math.random() * 999999999);
    String mail = "qa" + rand + "@gointegro.com";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRegOk() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        //driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        //driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("firstNameUser");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("lastNameUser");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("document")).clear();
        driver.findElement(By.id("document")).sendKeys("23566988");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
        //new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        //new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        //new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("submitRegistration")).click();
        System.out.println("RegistracionOk  [OK]");
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

