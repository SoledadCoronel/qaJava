package testPostActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommentPostOk {


	  public WebDriver driver;
	  public String baseUrl;
	  public StringBuffer verificationErrors = new StringBuffer();
	

	public void testComment() throws Exception {
		  
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
		    // Se ingresa un comentario con \n para que tome el ENTER
		    driver.findElement(By.cssSelector(".comment-area.mention")).sendKeys("test comment\n");

		    
		   // Se verifica presencia de cruz Eliminar comentario
		    driver.findElement(By.cssSelector(".close.comment-delete"));
	    	System.out.println("CommentPostOk  [OK]");
		    driver.quit();
	  }

}
