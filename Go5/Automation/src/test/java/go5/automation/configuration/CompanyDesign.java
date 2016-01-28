package go5.automation.configuration;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class CompanyDesign {
	
	 private WebDriver driver;

	
	 @BeforeClass
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "Inprogress");
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
		
	
	@Test
	
	public void gotoDesign(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
       Reporter.log(" Testeando la pagina de Diseño de  Company");
		
       // Go to the configuration
       Reporter.log(driver.findElement(By.cssSelector(".applications .users .configuration")).getText());
		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
		Reporter.log(driver.findElement(By.cssSelector(".menu")).getText());
       driver.findElement(By.cssSelector(".menu")).click();

		// Go to Company Design 
       Reporter.log("Abriendo la pagina de diseño de la plataforma" );
       Reporter.log(driver.findElement(By.cssSelector("nav .space:nth-child(2) ol li:nth-child(3)>a")).getText());
       driver.findElement(By.cssSelector("nav .space:nth-child(2) ol li:nth-child(3)>a")).click();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      // System.out.println((driver.findElement(By.cssSelector(".design")).getText()));
       
    // Go to  Users Menu
       Reporter.log("Abriendo administar personas" );  
       //driver.findElement(By.cssSelector(".usermenu")).click();
       driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
       Reporter.log(driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).getText());
       driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
       
}	