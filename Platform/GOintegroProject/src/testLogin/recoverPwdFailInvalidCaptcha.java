package testLogin;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RecoverPwdFailInvalidCaptcha {
	
	private WebDriver driver;
	private String baseUrl;
	
	@Test
	public void recoverPwd() throws Exception {
		
		driver = new FirefoxDriver();
		baseUrl = "http://platform.p2-test.gointegro.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		driver.get(baseUrl + "/auth/signin");
		
		// Se setea idioma espa–ol
	    driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
	    driver.findElement(By.linkText("Espa–ol")).click();
		driver.findElement(By.id("forgotPasswordButton")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("soledad.coronel@gointegro.com");
	    
	    Thread.sleep(1000);
	    driver.findElement(By.id("forgotPasswordSubmit")).click();
	    Thread.sleep(1000);
	    // Se captura el texto de la validaci—n
	    String capturedText = new String(driver.findElement(By.cssSelector(".alert-custom.alert-error.hide.captcha_error")).getText());
	    Thread.sleep(1000);
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Captcha inv‡lido";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("recoverPwdFailInvalidCaptcha  [OK]");
		    driver.quit();
	    }
	    else 
	    	System.out.println("recoverPwdFailInvalidCaptcha  [FAIL]");
	    	driver.quit();
	}
}
