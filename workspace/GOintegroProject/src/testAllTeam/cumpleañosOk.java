package testAllTeam;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cumplea–osOk {
	
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
	  public void cumplea–os() throws Exception {
		// Inicia el test
		// Se ingresan credenciales
		driver.get(baseUrl + "/auth/signin");
		driver.findElement(By.id("_username")).clear();
		driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
		driver.findElement(By.id("_password")).clear();
		driver.findElement(By.id("_password")).sendKeys("coquito25");
		driver.findElement(By.name("_submit")).click();
	    driver.findElement(By.cssSelector("a[title=\"Cumplea–os\"] > span.app-name")).click();
	    Thread.sleep(2000);
	    // se valida captura el texto del link V’nculo
	    String capturedText = new String(driver.findElement(By.xpath(".//*[@id='celebration-header']/header/span")).getText());

	    // Se setea el texto de validaci—n esperado
	    String expectedText = "Cumplea–os";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("cumplea–osOk  [OK]");
	    }
	    else {
	    	System.out.println("cumplea–osOk  [FAIL]");
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
