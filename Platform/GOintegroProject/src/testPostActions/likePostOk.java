package testPostActions;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class likePostOk {
	
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
	  public void likePost() throws Exception {
	    driver.get(baseUrl + "/");
	    // Inicia el test
	    // Se ingresan credenciales
	    driver.findElement(By.id("_username")).clear();
	    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
	    driver.findElement(By.id("_password")).clear();
	    driver.findElement(By.id("_password")).sendKeys("coquito25");
	    driver.findElement(By.name("_submit")).click();
	    // Se presiona Me gusta sobre el post
	    driver.navigate().refresh();
	    driver.findElement(By.linkText("Me gusta")).click();
	    // Se verifica presencia de link Ya no me gusta
	    String capturedTextLink = new String(driver.findElement(By.linkText("Ya no me gusta")).getText());
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Ya no me gusta";
	    
	    // Se valida que el texto es el esperado
	    if(capturedTextLink.equals(expectedText)) {
	    	System.out.println("likePostOk  [OK]");
	    }
	    else {
	    	System.out.println("likePostOk  [FAIL]");
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
