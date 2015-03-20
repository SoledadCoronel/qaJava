package testUserProfile;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NotificationsSettingsOk {
	
	  // Se declaran las variables
	  private WebDriver driver;
	  private String baseUrl;


	  @Test
	  public void NotificationsSettings() throws Exception {
		  
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
	    Thread.sleep(1000);
	     
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/aside[1]/div[1]/div/button")).click();
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/aside[1]/div[1]/div/ul/li[2]/a")).click(); 
	    
	    // Se captura el texto de la validaci—n
	    String capturedText = new String(driver.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/div[2]/form/fieldset/span[1]")).getText());
	    	    
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "ÀDesea recibir notificaciones a su mail?";
	    	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	   //System.out.println(capturedText);
	    	   System.out.println("NotificationsSettingsOk  [OK]");
	    	   driver.quit();
	    	   }
	    	   else {
	    	   System.out.println("NotificationsSettingsOk  [FAIL]");
	    	   driver.quit();
	    	   }
	  }
}
