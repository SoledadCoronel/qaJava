package Go5.Automation;


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



public class ForgotPasswordPortuguese {
	
	 private WebDriver driver;

	
	 @BeforeClass
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "P1");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", true);
	    driver = new RemoteWebDriver(
	    		 new URL("http://matiaspepe1:pFkpdbo5wSzZzFmLXQhM@hub.browserstack.com/wd/hub"),
	    	      capability);
	  }  
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	@Test(priority=1)
	
	public void openForgotPasswordPage(){
		 //org.apache.log4j.BasicConfigurator.configure();
		 driver.get("http://automation4.pla.qa.go5.gointegro.net/authentication/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Validating resending password in Portuguese");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".signup .link")).click();
		if (driver.findElement(By.cssSelector(".primary")).isEnabled())
			System.out.println("Buttom to resend password is enabled");
		
		else
			System.out.println("Buttom to resend password is disabled");
		
	}		
	
	@Test(priority=3)
	
	public void insertEmailToResendPassword() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   System.out.println("Insert email and press button to resend password");
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
	   System.out.println(SpanishText);
		 Assert.assertEquals(SpanishText,"Verifique se o seu e-mail.");
 
	}

	@Test(priority=2)
	
	public void insertInvalidEmail() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("banana@cachirula.zunga.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   System.out.println("Insert invalid email and verify that a proper message is displayed in Portuguese");
	   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	   String SpanishText2 = new String( driver.findElement(By.cssSelector(".signup .reject ")).getText());
	   System.out.println(SpanishText2);
		 System.out.println(SpanishText2);
		 Assert.assertEquals(SpanishText2,"O e-mail inserido não está registrado. Por favor tente novamente");
 
	}
     }

