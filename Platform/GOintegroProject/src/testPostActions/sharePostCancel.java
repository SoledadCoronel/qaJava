package testPostActions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharePostCancel {

	  private WebDriver driver;
	  private String baseUrl;

	  public void sharePostCnl() throws Exception {
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
		    // Se comparte el post posteado anteriormente
		    driver.navigate().refresh();
		    driver.findElement(By.linkText("Compartir")).click();
		    // Se cancela el compartir post
		    driver.findElement(By.cssSelector(".btn.btn-secondary.pull-left")).click();
		    System.out.println("sharePostCancel  [OK]");
		    driver.quit();
		  }
}
