package testLogin;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class recoverPwdClose {
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	  driver = new FirefoxDriver();
	  baseUrl = "http://platform.p2-test.gointegro.net/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void recoverPwd() throws Exception {
		driver.get(baseUrl + "/auth/signin");
		driver.findElement(By.id("forgotPasswordButton")).click();
	    driver.findElement(By.xpath(".//*[@id='forgotPasswordModal']/div[1]/button")).click();
	    // Se captura el texto de la validaci—n
	    String capturedText = new String(driver.findElement(By.id("forgotPasswordButton")).getText());
	    
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "ÀOlvid— su contrase–a?";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("recoverPwdFailCancel  [OK]");
	    }
	    else 
	    	System.out.println("recoverPwdFailCancel  [FAIL]");
	}

	    
		@After
		public void tearDown() throws Exception {
		  driver.quit();
		  String verificationErrorString = verificationErrors.toString();
		  if (!"".equals(verificationErrorString)) {
		    fail(verificationErrorString);
		  }
		}

}
