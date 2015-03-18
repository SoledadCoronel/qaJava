package testPostActions;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PostOk {
	
	  public WebDriver driver;
	  public String baseUrl;
	  public StringBuffer verificationErrors = new StringBuffer();

	
	  public void testPost() throws Exception {
		  
		    driver = new FirefoxDriver();
		    baseUrl = "http://platform.p2-test.gointegro.net/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
			    driver.quit();
		    }
		    else {
		    	System.out.println("postOk  [FAIL]");
			    driver.quit();
		    }
		  }

}
