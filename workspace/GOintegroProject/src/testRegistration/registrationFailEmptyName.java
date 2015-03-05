package testRegistration;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class registrationFailEmptyName {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://godemo.p2-test.gointegro.net/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testRegistracionOk() throws Exception {
		// Iniciando el test
	    driver.get(baseUrl + "/auth/signin");
	    driver.findElement(By.id("signupButton")).click();
	    
	    // Se ingresan los datos del usuario
	    driver.findElement(By.id("name")).sendKeys("");
	    driver.findElement(By.id("surname")).clear();
	    driver.findElement(By.id("surname")).sendKeys("surnameUser");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
	    driver.findElement(By.id("document")).clear();
	    driver.findElement(By.id("document")).sendKeys("25123456");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("integro1234");
	    driver.findElement(By.id("repeatPassword")).clear();
	    driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
	    new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
	    new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
	    new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
	    driver.findElement(By.id("termsAndConditions")).click();
	    driver.findElement(By.id("submitRegistration")).click();

	    Thread.sleep(1000);
	    String capturedText = new String(driver.findElement(By.id("nameError")).getText());

	    //Se setea el texto de validaci—n esperado
	    String expectedText = "El nombre no puede estar vac’o.";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("registrationFailEmptyName  [OK]");
	    }
	    else {
	    	System.out.println("registrationFailEmptyName  [FAIL]");
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
