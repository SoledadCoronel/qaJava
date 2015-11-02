package com.postActions.webdriver;

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
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class postActionsSuite {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.get(baseUrl);
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testA() throws Exception {

        driver.get(baseUrl + "/");
        // Se ingresa un post
        driver.findElement(By.id("post-text-input")).clear();
        driver.findElement(By.id("post-text-input")).sendKeys("test post con mention @Soledad Coronel");
        driver.findElement(By.name("post-text")).click();
        // Se verifica presencia de link Eliminar
        String capturedTextLink = new String(driver.findElement(By.linkText("Eliminar")).getText());
        // Se setea el texto de validación esperado
        String expectedText = "Eliminar";

        // Se valida que el texto es el esperado
        if(capturedTextLink.equals(expectedText)) {
            System.out.println("testPost  [OK]");
            driver.quit();
        }
        else {
            System.out.println("testPost  [FAIL]");
            driver.quit();
        }
    }

    @Test
    public void testB() throws Exception {

        driver.get(baseUrl + "/");
        // Se presiona Me gusta sobre el post

        driver.navigate().refresh();
        driver.findElement(By.linkText("Me gusta")).click();
        // Se verifica presencia de link Ya no me gusta
        String capturedTextLink = new String(driver.findElement(By.linkText("Ya no me gusta")).getText());
        // Se setea el texto de validación esperado
        String expectedText = "Ya no me gusta";

        // Se valida que el texto es el esperado
        if (capturedTextLink.equals(expectedText)) {
            System.out.println("testLikePost  [OK]");
            driver.quit();
        } else {
            System.out.println("testLikePost  [FAIL]");
            driver.quit();
        }
    }

    @Test
    public void testC() throws Exception {

        driver.get(baseUrl + "/");
        // Inicia el test
        // Se comparte el post posteado anteriormente
        driver.navigate().refresh();
        driver.findElement(By.linkText("Compartir")).click();
        // Se cancela el compartir post
        driver.findElement(By.cssSelector(".btn.btn-secondary.pull-left")).click();
        System.out.println("testSharePostCancel  [OK]");
        driver.quit();
    }

    @Test
    public void testD() throws Exception {

        driver.get(baseUrl + "/");
        // Inicia el test
        // Se comparte el post posteado anteriormente
        driver.navigate().refresh();
        driver.findElement(By.linkText("Compartir")).click();
        // Se ingresa comentario en textarea
        driver.findElement(By.xpath(".//*[@id='sharepost']/div[2]/div[2]/div[2]/textarea")).clear();
        driver.findElement(By.xpath(".//*[@id='sharepost']/div[2]/div[2]/div[2]/textarea")).sendKeys("post compartido");
        driver.findElement(By.id("share-btn")).click();
        System.out.println("testSharePostOk  [OK]");
        driver.quit();
    }

    @Test
    public void testE() throws Exception {

        driver.get(baseUrl + "/");

        // Inicia el test
        // Se ingresa un comentario con \n para que tome el ENTER
        driver.findElement(By.cssSelector(".comment-area.mention")).sendKeys("test comment\n");


        // Se verifica presencia de cruz Eliminar comentario
        driver.findElement(By.cssSelector(".close.comment-delete"));
        System.out.println("testCommentPost  [OK]");
        driver.quit();
    }

    @Test
    public void testF() throws Exception {

        driver.get(baseUrl + "/");

        // Inicia el test
        // Se elimina comentario
        driver.findElement(By.cssSelector(".close.comment-delete")).click();
        System.out.println("testDeleteComment  [OK]");
        driver.quit();
    }

    @Test
    public void testG() throws Exception {

        driver.get(baseUrl + "/");
        // Inicia el test
        // Se elimina el post posteado anteriormente
        driver.navigate().refresh();
        driver.findElement(By.linkText("Eliminar")).click();
        // Se cancela eliminaci�n del post
        driver.findElement(By.xpath("html/body/div[5]/div[3]/button[2]")).click();

        // Se verifica presencia de link Eliminar
        String capturedTextLink = new String(driver.findElement(By.linkText("Eliminar")).getText());
        // Se setea el texto de validaci�n esperado
        String expectedText = "Eliminar";

        // Se valida que el texto es el esperado
        if(capturedTextLink.equals(expectedText)) {
            System.out.println("testDeletePostCancel  [OK]");
            driver.quit();
        }
        else {
            System.out.println("testDeletePostCancel  [FAIL]");
            driver.quit();
        }
    }

    @Test
    public void testH() throws Exception {

        driver.get(baseUrl + "/");

        // Inicia el test
        // Se elimina el post posteado anteriormente
        driver.navigate().refresh();
        driver.findElement(By.linkText("Eliminar")).click();
        // Se confirma eliminación
        driver.findElement(By.cssSelector(".btn.btn-primary.confirm-delete")).click();
        System.out.println("testDeletePost  [OK]");
        driver.quit();
    }

    @Test
    public void testI() throws Exception {

        driver.get(baseUrl + "/");

        // Inicia el test
        // Se postea un link
        driver.findElement(By.linkText("Vínculo")).click();
        driver.findElement(By.name("link")).clear();
        driver.findElement(By.name("link")).sendKeys("www.gointegro.com");
        driver.findElement(By.id("post-link-input")).clear();
        driver.findElement(By.id("post-link-input")).sendKeys("test post link");
        Thread.sleep(1000);
        driver.findElement(By.name("post-link")).click();
        System.out.println("testPostLink  [OK]");
        driver.quit();
    }

    @Test
    public void testJ() throws Exception {

        driver.get(baseUrl + "/");

        // Inicia el test
        // Se elimina el post posteado anteriormente
        driver.navigate().refresh();
        driver.findElement(By.linkText("Eliminar")).click();
        // Se confirma eliminación
        driver.findElement(By.cssSelector(".btn.btn-primary.confirm-delete")).click();
        System.out.println("testPostLinkDelete  [OK]");
    }

    @After
    public void tearDown ()throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
