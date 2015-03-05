package testRegistration;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class registrationFailPwdConfirm {
	
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
	    driver.findElement(By.id("name")).sendKeys("firstNameUser");
	    driver.findElement(By.id("surname")).clear();
	    driver.findElement(By.id("surname")).sendKeys("surnameUser");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
	    driver.findElement(By.id("document")).clear();
	    driver.findElement(By.id("document")).sendKeys("25123123");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("integro1234");
	    driver.findElement(By.id("repeatPassword")).clear();
	    driver.findElement(By.id("repeatPassword")).sendKeys("integro123*");
	    new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
	    new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
	    new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
	    driver.findElement(By.id("termsAndConditions")).click();
	    driver.findElement(By.id("submitRegistration")).click();
	    

	    Thread.sleep(1000);
	    String capturedText = new String(driver.findElement(By.id("repeatPasswordError")).getText());

	    //Se setea el texto de validaci�n esperado
	    String expectedText = "Las contrase�as ingresadas no coinciden.";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("registrationFailPwdConfirm  [OK]");
	    }
	    else {
	    	System.out.println("registrationFailPwdConfirm  [FAIL]");
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