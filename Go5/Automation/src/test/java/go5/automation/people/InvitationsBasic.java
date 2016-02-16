package go5.automation.people;




import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class InvitationsBasic {

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
	    capability.setCapability("name", "Invitations con Cancel");
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
	public void inviteCancel() throws InterruptedException{
		 org.apache.log4j.BasicConfigurator.configure();
		 Random numero= new Random();
		 Logger log = Logger.getLogger("automation");
		
		 //Login
			
			driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".primary")).click();
			
        // Go to the configuration
			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	       driver.findElement(By.cssSelector(".menu")).click();
		
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	        //driver.findElement(By.cssSelector(".usermenu")).click();
	        Reporter.log("Abriendo titulos");
	        
	    // Go to Titles    
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	        log.info(driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).getText());
	        Reporter.log("Abriendo personas");
	   // Go to Manage people
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    
         
         //Add a  user    
	     driver.findElement(By.cssSelector(".content .title a")).click();
	    
	     
	     
	     //Lo creo activado
	     
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(2)")).click();
	     
	     //Poner el nombre
	     
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(4) input")).sendKeys("Random Name" + numero.nextInt());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(5) input")).sendKeys("Random Lastname"+ numero.nextDouble());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(6) input")).sendKeys("randomemail"+numero.nextInt()+"@gointegro.com");
	     
	     //Seleccionar el rol
	      
	     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
	 		
	        selectRol.selectByIndex(2);
	     	
	 		
	     // Grabar el nuevo usuario creado
	        Thread.sleep(3000);
	         driver.findElement(By.cssSelector(".content .addpeople fieldset:nth-child(4) .primary")).click();    
	        
	
	
	  // Verificar que vuelva al listado de personas 
	          
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         log.info(driver.findElement(By.cssSelector(".tablefilter")).isDisplayed());
         
	      	
	         // Ir al tab de invitaciones pendientes
	          
	         driver.findElement(By.cssSelector(".title menu li:nth-child(2) a")).click();
	         log.info(driver.findElement(By.cssSelector(".tables")).isDisplayed());
	         
	         // Verificar que hay un elemento en la tabla 
	         	     	         
	          WebElement htmltable=driver.findElement(By.cssSelector(".tables tbody"));

	          List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	          log.info("Imprimiendo la cantidad de inivtaciones pendientes...");
	          log.info(rows.size());
	          Assert.assertEquals(rows.size(),1);	         
	         
	       //Cancelar la invitacion
	       
	          log.info(" Cancelndo la invitacion...");
	          driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(5)")).click();
	          log.info(driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) p")).getText());
	          driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) .primary")).click();
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          
	          // Verificar que hay un elemento menos en la tabla 
	          
	          driver.findElement(By.cssSelector(".title menu li:nth-child(1) a")).click();
	          driver.findElement(By.cssSelector(".title menu li:nth-child(2) a")).click();
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	         
	          WebElement tableEmpty=driver.findElement(By.cssSelector(".tables tbody"));

	          List<WebElement> rowsE=tableEmpty.findElements(By.tagName("tr"));
	          log.info("Imprimiendo la cantidad de invitaciones pendientes despues de cancelar la invitacion:..");
	          log.info(rowsE.size());
	          Assert.assertEquals(rowsE.size(),0);	 
	}
	
}
