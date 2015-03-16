package testPostActions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class postOk {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://platform.p2-test.gointegro.net/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testPost() throws Exception {
	    driver.get(baseUrl + "/");
	    // Inicia el test
	    // Se ingresan credenciales
	    driver.findElement(By.id("_username")).clear();
	    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
	    driver.findElement(By.id("_password")).clear();
	    driver.findElement(By.id("_password")).sendKeys("coquito25");
	    driver.findElement(By.name("_submit")).click();
	    // Se ingresa un post
	    driver.findElement(By.id("post-text-input")).clear();
	    driver.findElement(By.id("post-text-input")).sendKeys("test post");
	    driver.findElement(By.name("post-text")).click();
	    // Se verifica presencia de link Eliminar
	    String capturedTextLink = new String(driver.findElement(By.linkText("Eliminar")).getText());
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Eliminar";
	    
	    // Se valida que el texto es el esperado
	    if(capturedTextLink.equals(expectedText)) {
	    	System.out.println("postOk  [OK]");
	    }
	    else {
	    	System.out.println("postOk  [FAIL]");
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
