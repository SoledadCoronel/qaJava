package testUserProfile;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkUserProfileOk {
	
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
	    
	    // Se ingresa al profile del usuario
	    driver.findElement(By.xpath(".//*[@id='drop3']/span")).click();
	    driver.findElement(By.linkText("Mi Perfil")).click();
	     
	    // Se verifica profile
	    driver.findElement(By.id("user-name")).getText();
	    // Se verifica presencia de texto usuario
	    String capturedTextLink = new String(driver.findElement(By.id("user-name")).getText());
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Soledad Coronel";
	    
	    // Se valida que el texto es el esperado
	    if(capturedTextLink.equals(expectedText)) {
	    	System.out.println("LinkUserProfileOK  [OK]");
		    driver.quit();
	    }
	    else {
	    	System.out.println("LinkUserProfileOk  [FAIL]");
		    driver.quit();
	    }
	  }
}
