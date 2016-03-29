package go5.automation.profile;


import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class IrAPerfilSidebar  {
	
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
    capability.setCapability("name", "Editar Perfil desde el sidebar");
    driver = new RemoteWebDriver(
    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
    	      capability);
    driver.get(url);
	 driver.manage().window().maximize();
	 WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".session label:nth-child(2) input")));
  }  

 @AfterClass // call function to close browser 
	
	public void teardown(){
		driver.quit();
	}
		
	@Test
	
	public void editProfile() throws Exception { 
	
		
		 
		 Random numero= new Random();
		
		 //Login
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".session .primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        		
	        
		 
		 
		// Go to the user menu
			driver.findElement(By.cssSelector(".igouser")).click();
	
			 Reporter.log("Ir a Perfil Desde el sidebar");
			
			
			//Editar perfil
			 
			 Reporter.log("Editar perfil");
			driver.findElement(By.cssSelector(".data h2 a")).click();
			
			//Insertar datos laborales
			Reporter.log("Editando datos laborales");
			
			 driver.findElement(By.cssSelector(".labordata label:nth-child(2) input")).clear();
		    driver.findElement(By.cssSelector(".labordata label:nth-child(2) input")).sendKeys("RandomId" + numero.nextInt());
  	         
	         driver.findElement(By.cssSelector(".labordata label:nth-child(3) input" )).sendKeys("10/10/10");
	         driver.findElement(By.cssSelector(".labordata label:nth-child(4) select ")).click();
	         
	         driver.findElement(By.cssSelector(".labordata label:nth-child(4) select ")).sendKeys("full-time");
	         
	       
	         //Reṕorta a 
	         driver.findElement(By.cssSelector(".labordata label:nth-child(6) input")).clear();
	         driver.findElement(By.cssSelector(".labordata label:nth-child(6) input")).sendKeys("Test Test");
	         
	         //Telefono
	         driver.findElement(By.cssSelector(".labordata label:nth-child(7) input")).clear();
	           driver.findElement(By.cssSelector(".labordata label:nth-child(7) input")).sendKeys("+541147511234");
	          driver.findElement(By.cssSelector(".labordata label:nth-child(8) input")).clear();
	          driver.findElement(By.cssSelector(".labordata label:nth-child(8) input")).sendKeys("+541147511234");
	         
	        /*  //Direccion
	          driver.findElement(By.cssSelector(".labordata label:nth-child(9) input")).clear();
	          driver.findElement(By.cssSelector(".labordata label:nth-child(9) input")).sendKeys("Alv. Thomas 198");
	         */ //Fin Datos laborales
	          
	          //Datos Personales
	          
	          Reporter.log("Editando datos personales");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(2) select")).sendKeys("RUT");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(3) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(3) input")).sendKeys("asasddsdsadsads");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(4) input")).sendKeys("11/11/11");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).click();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).sendKeys("female");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(6) select")).sendKeys("single");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(7) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(7) input")).sendKeys("fakee5555mail@gointegro.com");
	        //    driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).clear();
	           // driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).sendKeys("+541147511234");
	          //  driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).clear();
	          //  driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).sendKeys("+541147511234");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(10) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(10) input")).sendKeys("Mi Casa 123");
	            
	            
	            //Redes Sociales
	            Reporter.log("Editando redes  sociables");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).clear();
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).sendKeys("invaild data");
	            Assert.assertEquals("El campo debe tener un formato de url valido", driver.findElement(By.cssSelector(".socialdata label:nth-child(2) span")).getText(), "Validacion del campo linkedin");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).clear();
	            
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).sendKeys("http://linkedin.com/in/username");
	           
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).clear();
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).sendKeys("invaild data");
	            Assert.assertEquals("El campo debe tener un formato de url valido", driver.findElement(By.cssSelector(".socialdata label:nth-child(3) span")).getText(), "Validacion del campo twitter");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).clear();
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).sendKeys("http://twitter.com/username");
	          //  driver.findElement(By.cssSelector(".socialdata label:nth-child(4) input")).clear();
	         //   driver.findElement(By.cssSelector(".socialdata label:nth-child(4) input")).sendKeys("http://facebook.com/username"); 
	 		
	     
	            // Grabar el nuevo usuario creado
	            Reporter.log("Grabando perfil editado");
	        Thread.sleep(2000);
	         driver.findElement(By.cssSelector(".primary")).click();    
	         Reporter.log("Edicion de profile fue exitoso");
	         
	         //Logout
	         driver.findElement(By.cssSelector(".applications .users .user")).click();
	         
	     	driver.findElement(By.cssSelector("a[title='Cierra la sesión']")).click();
	     	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}	
	
	
		
     }

