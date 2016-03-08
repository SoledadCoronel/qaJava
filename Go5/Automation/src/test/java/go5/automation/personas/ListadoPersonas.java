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




public class ListadoPersonas {
	
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
	
		Reporter.log("Caso de listado de personas");
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
        
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
     /*    //Ordenar por nombre--No se puede terminar, no esta andando
         // Agarrar primer nombre de la tabla
          String firstname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText());
         Reporter.log(firstname);
          //Clickear el ordenar por noombre
         driver.findElement(By.cssSelector(".tables thead tr th:nth-child(2) a")).click();
         //Agarrar el ultimo de la tabla
         String lastname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(10) td:nth-child(2)")).getText());
        Reporter.log(lastname);
    */     
         
         //Filtrados
         
        
         // Elegir Usuarios Inactivos
         Reporter.log(" Seleccionar usuarios inactivos");
         
         Select userselect= new Select(driver.findElement(By.cssSelector(".peoplemanage .actions select")));
         
         userselect.selectByIndex(2);
         
         //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
         Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users inactivos");
 	
       
         for(int i = 1;i<10;i++)
        	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "SIN CHEQUEAR");
        	 Reporter.log("Todos los usuarios de la lista se encuentran desactivados");
        
             
        	  // Elegir Usuarios No Registrados
             Reporter.log(" Seleccionar usuarios no registrados");
                                      
             userselect.selectByIndex(3);
             
             //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
             Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users que no estan registrados");
     	
           
             for(int i = 1;i<10;i++)
            	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(6n)")).getText(), "SIN CHEQUEAR");
            	 Reporter.log("Todos los usuarios de la lista se encuentran en estado no registrado");
            
            	// Elegir Usuarios Activos
                 Reporter.log(" Seleccionar usuarios activos");
                 
                
                 
                 userselect.selectByIndex(1);
                 
                 //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
                 Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users activos");
         	
               
                 for(int i = 1;i<10;i++)
                	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "CHEQUEADO");
                	 Reporter.log("Todos los usuarios de la lista se encuentran activados");
            	 
                	 
                Reporter.log(" Hacer una busqueda de un usuario por Nombre");
                driver.findElement(By.cssSelector(".peoplemanage .search .btnsearch")).click();
                driver.findElement(By.cssSelector(".peoplemanage .search input")).sendKeys("AutomationFirstName");
                
                //Chequear q se mueste en la tabla users
                Reporter.log("El nombre del user buscado es AutomationFirstName");
                Reporter.log(" Imprimiendo el resultado del search");
               Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText()); 
	
               
               Reporter.log(" Hacer una busqueda de un usuario por Apellido");
             
               driver.findElement(By.cssSelector(".peoplemanage .search .btnsearch")).click();
               driver.findElement(By.cssSelector(".peoplemanage .search input")).sendKeys("AutomationLastName");
               
               //Chequear q se mueste en la tabla users
               Reporter.log("El nombre del user buscado es AutomationLastName");
               Reporter.log(" Imprimiendo el resultado del search");
              Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText()); 
	
	
	}
}	