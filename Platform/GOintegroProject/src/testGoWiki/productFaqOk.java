package testGoWiki;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.fail;


public class productFaqOk {
	
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
	  public void productFaqs() throws Exception {
		    // Inicia el test
		    // Se ingresan credenciales
		    driver.get(baseUrl + "/");
		    driver.findElement(By.id("_username")).clear();
		    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
		    driver.findElement(By.id("_password")).clear();
		    driver.findElement(By.id("_password")).sendKeys("coquito25");
		    driver.findElement(By.name("_submit")).click();
	    driver.get(baseUrl + "/app/articles/5669");
	    driver.findElement(By.cssSelector("a[title=\"Product FAQ\"] > span.app-name")).click();
	    String capturedText = new String(driver.findElement(By.cssSelector(".titleEditable>h3>p")).getText());

	    //Se setea el texto de validaci—n esperado
	    String expectedText = "Que formatos de video soporta la plataforma?";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("productFAQOk  [OK]");
	    }
	    else {
	    	System.out.println("productFAQOk  [FAIL]");
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


	  

	  

	  
	  /*@Test
	  public void testCorporateOperations() throws Exception {
		driver.get(baseUrl + "/app/articles/12644");
	    driver.findElement(By.cssSelector("a[title=\"Corporate Operations\"] > span.app-name")).click();
	    String capturedText = new String(driver.findElement(By.cssSelector(".titleEditable>h3>p")).getText());

	    //Se setea el texto de validaci—n esperado
	    String expectedText = "Descripci—n general";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("corporateOperations  [OK]");
	    }
	    else {
	    	System.out.println("corporateOperations  [FAIL]");
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
}*/
