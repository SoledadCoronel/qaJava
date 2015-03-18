package testLogin;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RecoverPwdCancel {
	
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
	    driver.findElement(By.xpath(".//*[@id='forgotPasswordModal']/div[2]/button[2]")).click();
	    // Se captura el texto de la validaci—n
	    String capturedText = new String(driver.findElement(By.id("forgotPasswordButton")).getText());
	    
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "ÀOlvid— su contrase–a?";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("recoverPwdFailCancel  [OK]");
			  driver.quit();
	    }
	    else 
	    	System.out.println("recoverPwdFailCancel  [FAIL]");
		  driver.quit();
	}
}
	

