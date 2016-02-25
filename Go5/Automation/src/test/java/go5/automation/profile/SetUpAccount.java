package go5.automation.profile;


import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SetUpAccount  {
	
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
    capability.setCapability("name", "SetUpAccountTest");
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
	
	public void setUpAccount() throws Exception { 
	
		 org.apache.log4j.BasicConfigurator.configure();
		 
		 Logger log = Logger.getLogger("automation");
		
		 //Login
			
			driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
		 
		 
		// Go to the user menu
			driver.findElement(By.cssSelector(".applications .users .user")).click();
	
			
			//Ir a configurar cuenta
			driver.findElement(By.cssSelector(".applications .users .subusers li a[title='Ir a configurar cuenta']")).click();
			
			//driver.findElement(By.cssSelector(".applications .users li:nth-child(3) li:nth-child(3)")).click();
			
			// Ir a Datos Basicos
			
			driver.findElement(By.cssSelector(".title menu li:nth-child(1)")).click();
			
			
			//Ir a Idioma
			 Select selectLanguage= new Select (driver.findElement(By.cssSelector(".content .generaldata label:nth-child(1) select")));
			
			  selectLanguage.selectByIndex(2);
			  driver.findElement(By.cssSelector(".primary")).click();
			  Thread.sleep(1000);
			  
			   log.info(driver.findElement(By.cssSelector(".title menu li:nth-child(2)")).getText());
			  		  
			  selectLanguage.selectByIndex(3);
			  driver.findElement(By.cssSelector(".primary")).click();
			  Thread.sleep(1000);
			  
			  
			   log.info(driver.findElement(By.cssSelector(".title menu li:nth-child(3)")).getText());
			  
			 
			   selectLanguage.selectByIndex(1);
			   driver.findElement(By.cssSelector(".primary")).click();
			   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
			 
			   
			   //Ir a Time Zone
			
			   Select selectTimeZone= new Select (driver.findElement(By.cssSelector(".content .generaldata label:nth-child(2) select")));
			   
			    selectTimeZone.selectByIndex(9);
			    driver.findElement(By.cssSelector(".primary")).click();
				  Thread.sleep(1000);
			    
				
				  selectLanguage.selectByIndex(2); 
			   
			//Ir a Contraseña
			
		//	driver.findElement(By.cssSelector(".title menu li:nth-child(2) a ")).click();
			driver.findElement(By.cssSelector(".title menu li:nth-child(2) a[title='Ir a Contraseña']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector(".content .generaldata label:nth-child(1) input")).sendKeys("1234");
			Assert.assertEquals(driver.findElement(By.cssSelector(".generaldata label span")).getText(),"La contraseña es invalida.");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
			
			//Ir a Notificaciones
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".title menu li:nth-child(3) a[title='Ir a Notificaciones']")).click();
		
			
			
	}	
	
	
		
     }

