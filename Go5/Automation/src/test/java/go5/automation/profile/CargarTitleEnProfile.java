package go5.automation.profile;



import java.net.URL;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CargarTitleEnProfile  {
	
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
    capability.setCapability("name", "Cargar Title en Profile");
    driver = new RemoteWebDriver(
    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
    	      capability);
    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
    
    driver.get(url);
	 driver.manage().window().maximize();
	 WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("signInIdentification")));
  }  

 @AfterClass // call function to close browser 
	
	public void teardown(){
		driver.quit();
	}
		
	@Test
	
	public void setUpPictureProfile() throws Exception { 
	
		
		
		
		
		 //Login
			
			driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
		 
		 
		// Go to the user menu
			driver.findElement(By.cssSelector(".applications .users .user")).click();
	
			 Reporter.log(" Ir a perfil y carga al usuario logueado un title ");
			//Ir a ver perfil
			driver.findElement(By.cssSelector(".applications .users .subusers li a[title='Ir a ver perfil']")).click();
			
			
			//Editar perfil
			 
			 Reporter.log("Editar perfil");
			driver.findElement(By.cssSelector(".data h2 a")).click();
			
			 //Agrandar el form para agregar mas datos  
		        
		        driver.findElement(By.cssSelector(".addpeople fieldset:nth-child(2) .secondary")).click();
		        
		        driver.findElement(By.cssSelector(".labordata label:nth-child(5) select")).click();
		        
		        driver.findElement(By.cssSelector(".labordata label:nth-child(5) select")).click();
		       
		        
		        //Reṕorta a 
		         driver.findElement(By.cssSelector(".labordata label:nth-child(6) input")).clear();
		         driver.findElement(By.cssSelector(".labordata label:nth-child(6) input")).sendKeys("Test Test");
		        
		       Select selectTitles=new  Select(driver.findElement(By.cssSelector(".labordata label:nth-child(5) select"))); 
		 		selectTitles.selectByVisibleText("SENIOR2");
		 	  selectTitles.selectByIndex(3);
		 	  /// Ir a la opcion 
		 	  
		 	//  driver.findElement(By.cssSelector(".labordata label:nth-child(5) select optgroup option:nth-child(1)")).click();
		 	 // css para ir al valor .labordata label:nth-child(5) select optgroup option:nth-child(2)
		 	  // Grabar el  usuario editado
		        Thread.sleep(1000);
		         driver.findElement(By.cssSelector(".container .addpeople .primary")).click();
		         Reporter.log(" Grupo agregado al usuario exitosamente");	
		        
		      
		         
		       Reporter.log(" Title cargado exitosamente");
		   
	
	
	
	}	
	
	
		
     }

