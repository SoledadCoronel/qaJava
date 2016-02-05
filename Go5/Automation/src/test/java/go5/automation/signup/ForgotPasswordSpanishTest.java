package go5.automation.signup;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ForgotPasswordSpanishTest {
	
	 private WebDriver driver;

	
	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url"})
	  public void setUp(String browser, String version, String platform,String url) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "GOIntegro");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", false);
	    capability.setCapability("name", "Forgot Password ");
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 }
	 
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	@Test
	
		public void testForgotPassword() throws Exception { 
	
		driver.findElement(By.cssSelector(".signup .link")).click();
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("banana@cachirula.zunga.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	Reporter.log("Insertar un  invalid email y verificar que el mensaje correcto se muestre");
	   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	   String SpanishText2 = new String( driver.findElement(By.cssSelector(".signup .reject ")).getText());
	   Reporter.log(SpanishText2);
		 System.out.println(SpanishText2);
		 Assert.assertEquals(SpanishText2,"El email ingresado no se encuentra registrado. Por favor vuelve a intentarlo");
	
	// Insertar un email valido y verificar texto que se envio la contraseña
	
				
		driver.findElement(By.id("signInIdentification")).clear();
		Reporter.log("Insertar el email y  presionar el  button to resend password");
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
	   System.out.println(SpanishText);
		 Assert.assertEquals(SpanishText,"Revisa tu email.");
		}
	
     }

