package testPostActions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LikePostOk {

	  private WebDriver driver;
	  private String baseUrl;

	
	  public void likePost() throws Exception {
		  
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
			    driver.quit();
		    }
		    else {
		    	System.out.println("likePostOk  [FAIL]");
			    driver.quit();
		    }
		  }  
}
