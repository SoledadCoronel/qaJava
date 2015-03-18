package testPostActions;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharePostOk {

	  private WebDriver driver;
	  private String baseUrl;

	  public void sharePost() throws Exception {
		 
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
		    // Se ingresa comentario en textarea
		    driver.findElement(By.xpath(".//*[@id='sharepost']/div[2]/div[2]/div[2]/textarea")).clear();
		    driver.findElement(By.xpath(".//*[@id='sharepost']/div[2]/div[2]/div[2]/textarea")).sendKeys("post compartido");
		    driver.findElement(By.id("share-btn")).click();
		    System.out.println("sharePostOk  [OK]");
		    driver.quit();
		  }
	  
}
