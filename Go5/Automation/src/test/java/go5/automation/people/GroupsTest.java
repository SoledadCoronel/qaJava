package go5.automation.people;




import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;


public class GroupsTest {

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
	    capability.setCapability("name", "Groups ");
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
	public void addUserAdmin() throws InterruptedException{
			 	
		//Login
			
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
	        
	       
	        
	    // Go to Titles    
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	      
	        Reporter.log("Abriendo Grupos");
	   
	  	  
	         // Go to Grupos
	  	        
	  	        driver.findElement(By.cssSelector(".space:nth-child(3) ol li:nth-child(4) a")).click();
	  	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
                 Reporter.log("Agregando un grupo");
	  	       //Agregar un Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
	  	         //Insertar un nombre de Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("TestGrupoToBeDeleted");
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.RETURN);
	  	         
	  	         //Borrar Grupo
	  	         Reporter.log("Borrando un grupo");
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .delete")).click();
	  	         driver.findElement(By.cssSelector(".mconfirmation a")).click();
	  	         Thread.sleep(1000);

	
	  	     //Agregar Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
	  	         //Insertar un nombre de Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("TestGrupo1");
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.RETURN);
	  	         
	  	         //Agregar un Subgrupo
	  	         Reporter.log("Agregando un subgrupo");
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree .showadd a")).click();
	  	         
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys("Subgrupo1");
	  	         driver.findElement(By.cssSelector(".additem.active input")).sendKeys(Keys.RETURN);
	  	         
	  	         
	  	  // Go to a user and verify that the field group is present
	  	         //Go to Administrar
	  	         
	  	    // Go to Manage people
	 	        
	 	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	 	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);     
	
	 	    //Agarrar el primer user de la tabla y editarlo
	 	          Reporter.log(" Editar un usuario y agregarle el grupo creado");
	 	          driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td a ")).click();
	 	          
	 	         //Agrandar el form para agregar mas datos  
	 		        
	 		        driver.findElement(By.cssSelector(".addpeople fieldset:nth-child(2) .secondary")).click();
	 		        
	 		       Select selectGroups=new  Select(driver.findElement(By.cssSelector(".groupsdata select"))); 
	 		 		
	 		 	  selectGroups.selectByIndex(1);
	 		 	  
	 		 	  // Grabar el  usuario editado
	 		        Thread.sleep(1000);
	 		         driver.findElement(By.cssSelector(".container .addpeople .primary")).click();
	 		         Reporter.log(" Grupo agregado al usuario exitosamente");
	 		        
	}
	
	
}
