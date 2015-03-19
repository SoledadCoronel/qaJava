package testPostActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PostLinkOk {

	  public WebDriver driver;
	  public String baseUrl;
	  
	  public void testPostLink() throws Exception {
		  
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
		    // Se postea un link
		    driver.findElement(By.linkText("V’nculo")).click();
		    driver.findElement(By.name("link")).clear();
		    driver.findElement(By.name("link")).sendKeys("www.gointegro.com");
		    driver.findElement(By.id("post-link-input")).clear();
		    driver.findElement(By.id("post-link-input")).sendKeys("test post link");
		    Thread.sleep(1000);
		    driver.findElement(By.name("post-link")).click();
	    	System.out.println("postLinkOk  [OK]");
		    driver.quit();
		  }
}
