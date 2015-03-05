package testLogin;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class recoverPwdFailInvalidCaptcha {
	
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
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("soledad.coronel@gointegro.com");
	    
	    Thread.sleep(1000);
	    driver.findElement(By.id("forgotPasswordSubmit")).click();
	    Thread.sleep(1000);
	    // Se captura el texto de la validaci—n
	    String capturedText = new String(driver.findElement(By.cssSelector(".alert-custom.alert-error.hide.captcha_error")).getText());
	    
	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Captcha inv‡lido";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("recoverPwdFailInvalidCaptcha  [OK]");
	    }
	    else 
	    	System.out.println("recoverPwdFailInvalidCaptcha  [FAIL]");
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
