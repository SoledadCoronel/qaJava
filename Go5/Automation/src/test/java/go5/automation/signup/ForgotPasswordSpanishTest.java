package go5.automation.signup;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ForgotPasswordSpanishTest {
	
	 private WebDriver driver;

	
	 @BeforeClass
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "GOIntegro");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", false);
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	 
	  }  
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	@Test(priority=1)
	
	public void openForgotPasswordPagePortuguese(){
		 
		driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validando reenvio de  password en Español");
		driver.findElement(By.cssSelector(".signup .link")).click();
		if (driver.findElement(By.cssSelector(".primary")).isEnabled())
			System.out.println("El button de  resend password esta enabled");
		
		else
			System.out.println("El button de resend password esta disabled");
		
	}		
	
	@Test(priority=2)
	
	public void insertEmailToResendPasswordPortuguese() throws Exception { 
	
		driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".signup .link")).click();
		driver.findElement(By.id("signInIdentification")).clear();
		System.out.println("Insertar el email y  presionar el  button to resend password");
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   //	   String sentMessage = new String (driver.findElement(By.cssSelector(".overlayloading p")).getText());
	 //  System.out.println(sentMessage);
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
	   System.out.println(SpanishText);
		 Assert.assertEquals(SpanishText,"Revisa tu email.");
		}
	
     }

