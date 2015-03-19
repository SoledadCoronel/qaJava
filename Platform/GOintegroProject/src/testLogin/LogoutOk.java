package testLogin;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogoutOk {

	  // Se declaran las variables
	  private WebDriver driver;
	  private String baseUrl;


	  @Test
	  public void testLogout() throws Exception {
		  
		// Se setean las variables
		driver = new FirefoxDriver();
		baseUrl = "http://platform.p2-test.gointegro.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Se loguea el usuario
	    driver.get(baseUrl + "/auth/signin");
	    driver.findElement(By.id("_username")).clear();
	    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
	    driver.findElement(By.id("_password")).clear();
	    driver.findElement(By.id("_password")).sendKeys("coquito25");
	    driver.findElement(By.name("_submit")).click();
	    Thread.sleep(1000);
	    
	    // Se cierra sesi—n del usuario
	    //.//*[@id='drop3']/span
	    driver.findElement(By.xpath(".//*[@id='drop3']/span")).click();
	    driver.findElement(By.linkText("Cerrar sesi—n")).click();
	    
	    // Se verifica presencia de bot—n login
	    // Se captura el texto de la validaci—n
	    String capturedText = new String(driver.findElement(By.id("_submit")).getText());
	    	    
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Log In";
	    	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	   System.out.println("LogoutOk  [OK]");
	    	   driver.quit();
	    	   }
	    	   else {
	    	   System.out.println("LogoutOk  [FAIL]");
	    	   driver.quit();
	    	   }
	  }
}
