package Go5.Automation;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack extends CommonFunctions {  
  
  private WebDriver driver;  


  @BeforeClass
     public void setUp(String browser, String version, String platform) throws Exception {
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability("platform",platform);
    capability.setCapability("browserName", browser);
    capability.setCapability("browserVersion", version);
    capability.setCapability("project", "P1");
    capability.setCapability("build", "2.0");
    //capability.setCapability("device","Samsung Galaxy S5");
    driver = new RemoteWebDriver(
      new URL("http://marina157:MftFShNNBHfybCP6NyQL@hub.browserstack.com/wd/hub"),
      capability);
  }  

  public void login(String sUsername,String sPassword) throws Exception { 
	 	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys(sUsername);
		driver.findElement(By.id("signInPassword")).clear();
		driver.findElement(By.id("signInPassword")).sendKeys(sPassword);
		 driver.findElement(By.cssSelector(".primary")).click();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
  
  
  
  @Test
  public void testSimple() throws Exception {
	
	  driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
	  this.login("marina.touceda@gointegro.com","Auto1234");
	  System.out.println("Login to Go");
    	  
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Test
	public void testLoginWithBlankUser() throws Exception { 
	
	  driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		 org.apache.log4j.BasicConfigurator.configure();
	  	log.info("Try a login with blank user ");
		this.login("  ","Auto1234");
		// Verify if the button is disabled 
		
		
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("The login button is enabled");
		}
		else
				log.info("The login button is disbled");
	
		log.info("Login fails due to user blank");
		 driver = new Augmenter().augment(driver);
		    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    try {
		      FileUtils.copyFile(srcFile, new File("Screenshot.png"));
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
	  @AfterClass  
  public void tearDown() throws Exception {  
    driver.quit();  
  }
}