package testEnvironment;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class environmentRecognitionFALLA {
	
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
	  public void testEnvironment() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("_username")).clear();
	    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
	    driver.findElement(By.id("_password")).clear();
	    driver.findElement(By.id("_password")).sendKeys("coquito25");
	    driver.findElement(By.name("_submit")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='environments']/li[3]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='horiz-menu']/ul/li[2]/a/span")).click();
	    Thread.sleep(3000);
	    String capturedText = new String(driver.findElement(By.id("form_buscar_colaboradores")).getText());

	    //Se setea el texto de validaci�n esperado
	    String expectedText = "Crear Nominaci�n";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("environmentRecognition  [OK]");
	    }
	    else {
	    	System.out.println("environmentRecognition  [FAIL]");
	    }
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