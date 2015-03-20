package testUserProfile;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChangeDocumentOk {
	
	  // Se declaran las variables
	  private WebDriver driver;
	  private String baseUrl;


	  @Test
	  public void testChangeDocOk() throws Exception {
		  
		// Se setean las variables
		driver = new FirefoxDriver();
		baseUrl = "http://platform.p2-test.gointegro.net/#data-edit-modal";
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
	    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/aside[1]/div[1]/div/ul/li[1]/a")).click();	    

	    // Se modifica el DNI
	    driver.findElement(By.id("document")).sendKeys("12345678");
	    driver.findElement(By.id("saveProfileData")).click();
 	   	System.out.println("ChangeDocumentOk  [OK]");
	    driver.quit();
	  }
}
