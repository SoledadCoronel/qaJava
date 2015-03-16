package testPostActions;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class deletePostCancel {
	
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
	  public void deletePostCnl() throws Exception {
	    driver.get(baseUrl + "/");
	    // Inicia el test
	    // Se ingresan credenciales
	    driver.findElement(By.id("_username")).clear();
	    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
	    driver.findElement(By.id("_password")).clear();
	    driver.findElement(By.id("_password")).sendKeys("coquito25");
	    driver.findElement(By.name("_submit")).click();
	    // Se elimina el post posteado anteriormente
	    driver.navigate().refresh();
	    driver.findElement(By.linkText("Eliminar")).click();
	    // Se cancela eliminaci—n del post
	    driver.findElement(By.cssSelector(".btn.btn-secondary")).click();
	    
	    // Se verifica presencia de link Eliminar
	    String capturedTextLink = new String(driver.findElement(By.linkText("Eliminar")).getText());
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Eliminar";
	    
	    // Se valida que el texto es el esperado
	    if(capturedTextLink.equals(expectedText)) {
	    	System.out.println("deletePostCancel  [OK]");
	    }
	    else {
	    	System.out.println("deletePostCancel  [FAIL]");
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
