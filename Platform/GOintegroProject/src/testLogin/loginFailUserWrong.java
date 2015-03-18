package testLogin;

// Se importan librer’as necesarias
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

// Se declara la clase del test
public class LoginFailUserWrong {
	
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
	// Se ingresan credenciales 
    driver.get(baseUrl + "/auth/signin");
    
    // Se setea idioma espa–ol
    driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
    driver.findElement(By.linkText("Espa–ol")).click();
    driver.findElement(By.id("_username")).clear();
    driver.findElement(By.id("_username")).sendKeys("mailFail@gointegro.com");
    driver.findElement(By.id("_password")).clear();
    driver.findElement(By.id("_password")).sendKeys("coquito25");
    driver.findElement(By.name("_submit")).click();
    
    // Se captura el texto de la validaci—n
    String capturedText = new String(driver.findElement(By.className("error-login")).getText());
    
    // Se setea el texto de validaci—n esperado
    String expectedText = "Usuario y/o contrase–a incorrectos";
    
    // Se valida que el texto es el esperado
    if(capturedText.equals(expectedText)) {
    	System.out.println("loginFailUserWrong  [OK]");
        driver.quit();
    }
    else {
    	System.out.println("loginFailUserWrong  [FAIL]");
        driver.quit();
    }
 }	
}
