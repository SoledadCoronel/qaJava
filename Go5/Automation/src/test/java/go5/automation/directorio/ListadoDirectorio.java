package go5.automation.directorio;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class ListadoDirectorio {
	
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
	    capability.setCapability("name", "Directorio de Personas");
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    driver.get(url);
		 driver.manage().window().maximize();
		 WebElement loginavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("signInIdentification")));
		 
		 
	 }
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
		
	
	@Test
	
	public void listadoPersonas() throws Exception { 
	
		Reporter.log(" Probar Directorio");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("signInIdentification")).clear();
 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
 		driver.findElement(By.id("signInPassword")).clear();
 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
 		 driver.findElement(By.cssSelector(".primary")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
         // Go to the menu (hamburguesita)
        
 		
        driver.findElement(By.cssSelector(".menu")).click();
 	
 	// Go to  Directorio de personas
         Reporter.log("Abriendo directorio de  personas" );  
        
         driver.findElement(By.cssSelector(".igousergroup")).click();
            
         WebElement tablevailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".people")));
         
         //Ordenar por nombre-
         
          //Clickear el ordenar por noombre
         driver.findElement(By.cssSelector(".tables thead tr th:nth-child(2) a")).click();
         Thread.sleep(1000);
      // Agarrar primer nombre de la tabla
         String firstname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText());
        Reporter.log(firstname);
         //Agarrar el ultimo de la tabla
         String secondname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(2) td:nth-child(2)")).getText());
        Reporter.log(secondname);
              
        if (firstname.compareTo(secondname)< 0) 
        Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente");
        else 
        	Reporter.log("Los usuarios estan ordenados en orden alfabetico descendente" );
        
        //Volver a ordenar, en forma descendente
        
        driver.findElement(By.cssSelector(".tables thead tr th:nth-child(2) a")).click();
        Thread.sleep(1000);
     // Agarrar primer nombre de la tabla
        String firstname2= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText());
       Reporter.log(firstname2);
        //Agarrar el ultimo de la tabla
        String secondname2= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(2) td:nth-child(2)")).getText());
       Reporter.log(secondname2);
             
       if (firstname.compareTo(secondname)> 0) 
       Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente");
       else 
       	Reporter.log("Los usuarios estan ordenados en orden alfabetico descendente" );
         
    //Hacer una busqueda
     
            	 
                	 
                Reporter.log(" Hacer una busqueda de un usuario por Nombre");
                driver.findElement(By.cssSelector(".peoplemanage .search .btnsearch")).click();
                driver.findElement(By.cssSelector(".peoplemanage .search input")).sendKeys("AutomationFirstName");
                
                //Chequear q se mueste en la tabla users
                Reporter.log("El nombre del user buscado es AutomationFirstName");
                Reporter.log(" Imprimiendo el resultado del search");
               Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText()); 
	
               
               Reporter.log(" Hacer una busqueda de un usuario por Apellido");
              
              
               driver.findElement(By.cssSelector(".peoplemanage .search .btnsearch")).click();
               driver.findElement(By.cssSelector(".peoplemanage .search input")).clear();
               driver.findElement(By.cssSelector(".peoplemanage .search input")).sendKeys("AutomationLastName");
               
               //Chequear q se mueste en la tabla users
               Reporter.log("El nombre del user buscado es AutomationLastName");
               Reporter.log(" Imprimiendo el resultado del search");
              Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText()); 
	
	
           
	}
}	