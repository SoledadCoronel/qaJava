package go5.automation.personas;

import go5.automation.TestSuite;

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




public class ListadoPersonasFilters extends TestSuite {
	
	String irAPagina= new String("a[title='Ir a la página 4']");
	String searchButton = new String(".actions .search .btnsearch");
	String inputSearch = new String(".actions .search input");
	String orden =new String (".tables thead tr th:nth-child(2) a");
	 String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
	 String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
		

	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build);
	 }
	   

	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
	
	@Test
	
	public void listadoPersonasFilters() throws Exception { 
	
	
       
         // Go to the configuration
         
 		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
        driver.findElement(By.cssSelector(".menu")).click();
 	
 	// Go to  Users Menu
         Reporter.log("Abriendo administar personas" );  
         //driver.findElement(By.cssSelector(".usermenu")).click();
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
        
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
           
       
         //Filtrados
         
        
         // Elegir Usuarios Inactivos
         Reporter.log(" Seleccionar usuarios inactivos");
         
         Select userselect= new Select(driver.findElement(By.cssSelector(".actions fieldset:nth-child(1) label:nth-child(1) select")));
         
         userselect.deselectAll();
        
        
         userselect.selectByIndex(3);
         
        
         
         //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
         Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users inactivos");
 	
       
         for(int i = 1;i<10;i++)
        	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "SIN CHEQUEAR");
        	 Reporter.log("Todos los usuarios de la lista se encuentran desactivados");
        
             
        	  // Elegir Usuarios No Registrados
             Reporter.log(" Seleccionar usuarios no registrados");
                                      
             userselect.selectByIndex(4);
             
             //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
             Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users que no estan registrados");
     	
           
             for(int i = 1;i<10;i++)
            	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(6n)")).getText(), "SIN CHEQUEAR");
            	 Reporter.log("Todos los usuarios de la lista se encuentran en estado no registrado");
            
            	// Elegir Usuarios Activos
                 Reporter.log(" Seleccionar usuarios activos");
                 
                
                 
                 
                 userselect.deselectAll();
                 userselect.selectByIndex(2);
                 //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
                 Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users activos");
         	
               
                 for(int i = 1;i<10;i++)
                	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "CHEQUEADO");
                	 Reporter.log("Todos los usuarios de la lista se encuentran activados");
           	 
              
	
	}
}	