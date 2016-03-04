package go5.automation.personas;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class ManagePeopleTest {
	
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
	    capability.setCapability("name", "Listado de Personas");
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
	
	public void listadoPersonas() throws Exception { 
	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("signInIdentification")).clear();
 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
 		driver.findElement(By.id("signInPassword")).clear();
 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
 		 driver.findElement(By.cssSelector(".primary")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
         // Go to the configuration
         
 		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
        driver.findElement(By.cssSelector(".menu")).click();
 	
 	// Go to  Users Menu
         Reporter.log("Abriendo administar personas" );  
         //driver.findElement(By.cssSelector(".usermenu")).click();
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
         Reporter.log(driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).getText());
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         //Ordenar por nombre--No se puede terminar, no esta andando
         // Agarrar primer nombre de la tabla
          String firstname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText());
         Reporter.log(firstname);
          //Clickear el ordenar por noombre
         driver.findElement(By.cssSelector(".tables thead tr th:nth-child(2) a")).click();
         //Agarrar el ultimo de la tabla
         String lastname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(10) td:nth-child(2)")).getText());
         Reporter.log(lastname);
         
         
         //Filtrar por User Activos
         
         //Recorrer la tabla users con nth:-child(1n+0)
         
         // Elegir Usuarios Inactivos
         Reporter.log(" Seleccionar usuarios inactivos");
         
         Select userselect= new Select(driver.findElement(By.cssSelector(".peoplemanage .actions select")));
         
         userselect.selectByIndex(3);
         
         //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
         Reporter.log("Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos");
 	
       
         for(int i = 1;i<10;i++)
        	 Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText());
        
                 
	
	}
}	