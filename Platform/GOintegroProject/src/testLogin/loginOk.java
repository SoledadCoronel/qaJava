package testLogin;

// Se importan librer’as necesarias
import java.util.concurrent.TimeUnit;
import org.junit.*;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

// Se declara la clase del test
public class LoginOk {
  // Se declaran las variables
  private WebDriver driver;
  private String baseUrl;


  @Test
  public void testLogin() throws Exception {
	  
	// Se setean las variables
	driver = new FirefoxDriver();
	baseUrl = "http://platform.p2-test.gointegro.net/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// Inicia el test
    driver.get(baseUrl + "/auth/signin");
    driver.findElement(By.id("_username")).clear();
    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
    driver.findElement(By.id("_password")).clear();
    driver.findElement(By.id("_password")).sendKeys("coquito25");
    driver.findElement(By.name("_submit")).click();
    
    // Se captura el texto de la validaci—n
    Thread.sleep(1000);
    String capturedText = new String(driver.findElement(By.className("post-text")).getText());

    // Se setea el texto de validaci—n esperado
    String expectedText = "Publicar";
    
    // Se valida que el texto es el esperado
    if(capturedText.equals(expectedText)) {
    	System.out.println("loginOK  [OK]");
	    driver.quit();
    }
    else {
    	System.out.println("loginOK  [FAIL]");
	    driver.quit();
    }
  }
}
