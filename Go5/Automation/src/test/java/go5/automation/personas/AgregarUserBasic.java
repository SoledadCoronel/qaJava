package go5.automation.personas;




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

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class AgregarUserBasic {


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
	    capability.setCapability("name", "Agregar User Basic");
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
	public void addUserBasicDataTest() throws InterruptedException{
		
		 org.apache.log4j.BasicConfigurator.configure();
		 Random numero= new Random();
		 Logger log = Logger.getLogger("automation");
	 	
		 //Login
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".session .primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
		 
		
        Reporter.log(" Agregando un user Basic,en estado desactivado, con los datos basicos y sin invitation");
		
		       
		
	 	  // Go to the configuration
	 			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	 	       driver.findElement(By.cssSelector(".menu")).click();
	 		
	 		// Go to  Users Menu
	 	        Reporter.log("Abriendo administar personas" );  
	 	       
	 	        
	 	    // Go to Titles    
	 	        
	 	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	 	      
	 	       
	 	   // Go to Manage people
	 	        
	 	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	 	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
         // Obtener la cantidad de usuarios antes de agregar user
         
         
         WebElement htmltable=driver.findElement(By.cssSelector(".tablefilter tbody"));

         List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
         log.info("La cantidad de usuarios antes de agregar uno nuevo,en el sitio es:" + rows.size());
          
         
               
                 
         //Add a  user    
	     driver.findElement(By.cssSelector(".content .title a")).click();
	    
	     
	     
	     //Lo creo desactivado
	     
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(2) input:nth-child(2)")).click();
	     Reporter.log(" Se le carga el nombre, el mail y el rol");
	     //Poner el nombre
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(4) input")).sendKeys("Basic" + numero.nextInt());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(5) input")).sendKeys("User"+ numero.nextDouble());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(6) input")).sendKeys("basicuser"+numero.nextInt()+"@gointegro.com");
	     
	     //Seleccionar el rol
	      
	     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
	 		
	        selectRol.selectByIndex(2);
	     	
	 		
	     // Grabar el nuevo usuario creado
	        Thread.sleep(2000);
	         driver.findElement(By.cssSelector(".content .addpeople fieldset:nth-child(4) .secondary")).click();    
	        
	                 
	        
	
	  // Verificar que vuelva al listado de personas 
	          
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	          Reporter.log("Volviendo a la tabla de usuarios");
	          driver.findElement(By.cssSelector(".tablefilter")).isDisplayed();
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         
	   
	         // Verificar la cantidad de elementos en la tabla 
	         
	          WebElement htmltable2=driver.findElement(By.cssSelector(".tablefilter tbody"));

	          List<WebElement> rows2=htmltable2.findElements(By.tagName("tr"));
	          log.info("La cantidad de usuarios es ."+ rows2.size());
	         
	                  	         
	          //Chequear que la cantidad de elementos en la tabla de users es +1
	        //  Assert.assertEquals(rows.size()+1,rows2.size());	         
              
	   /*    
	       // Verificar que el usuario figura como no registrado (TO DO)
		          
	          WebElement htmltable=driver.findElement(By.cssSelector(".tablefilter tbody"));

	          List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	          log.info(rows.size());
	         
	 
	          for(int rnum=0;rnum<rows.size();rnum++)

	          {
	        	  
	        	  List<WebElement> columns=rows.get(rnum).findElements(By.tagName("th"));
	        	  
	        	  log.info(columns.size());
	        	  //log.info("Number of columns:"+columns.size());
	        	  for(int cnum=0;cnum<columns.size();cnum++)
	        		  log.info(driver.findElement(By.cssSelector(".tablefilter tbody tr:nth-child(cnum)")).getText());
	        	  	//	  log.info(columns.get(cnum).getText());
	        	  }
	          */
	          }         
	}          
	     
	
	
