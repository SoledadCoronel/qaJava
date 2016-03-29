package go5.automation.personas;



import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class AgregarUserAdminAllFields {

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
	    capability.setCapability("name", "Agregar Admin all fields ");
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
	public void addUserAdminAllFields() throws InterruptedException{
		
		 Random numero= new Random();
	 	
		 //Login
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(2) input")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.cssSelector(".session label:nth-child(3) input")).clear();
			driver.findElement(By.cssSelector(".session label:nth-child(3) input")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".session .primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
       ;
    
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

        
         
         //Add a  user   
	         Reporter.log("Abriendo formulario de Agregar un nuevo user");
	     driver.findElement(By.cssSelector(".content .title a")).click();
	    
	     
	     
	     //Lo creo activado
	     Reporter.log("Creando user en estado activo");
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(2) input:nth-child(1)")).click();
	     
	     //Poner el nombre
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(4) input")).sendKeys("Random Name" + numero.nextInt());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(5) input")).sendKeys("Random Lastname"+ numero.nextDouble());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(6) input")).sendKeys("randomemail"+numero.nextInt()+"@gointegro.com");
	     
	     //Seleccionar el rol
	      
	     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
	 		
	        selectRol.selectByIndex(1);
	     	
	      //Agrandar el form para agregar mas datos  
	        
	        driver.findElement(By.cssSelector(".content .addpeople fieldset:nth-child(2) .secondary")).click();
	        
	        //Fill in todos los datos
	        
	        //Datos Laborales 
	        
	         Reporter.log("Cargando Datos Laborales");
	         driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(2) input")).sendKeys("RandomId" + numero.nextInt());
	                       	         
	         driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(3) input" )).sendKeys("10/10/10");
	         driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(4) select ")).click();
	         
	         driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(4) select ")).sendKeys("full-time");
	         
	        // driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(5) select ")).sendKeys("106");
	         
	         //Reṕorta a 
	       //  driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(6) input")).sendKeys("Test Test");
	         
	         //Telefono
	         driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(7) input")).clear();
	          driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(7) input")).sendKeys("+541147511234");
	          driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(8) input")).clear();
	          driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(8) input")).sendKeys("+541147511234");
	         //Direccion
	          driver.findElement(By.cssSelector(".content .hide .labordata label:nth-child(9) input")).sendKeys("Alv. Thomas 198");
	          //Fin Datos laborales
	          
	          //Datos Personales
	          Reporter.log("Cargando Datos Personales");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(2) select")).sendKeys("RUT");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(3) input")).sendKeys("46214482");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(4) input")).sendKeys("11/11/11");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).click();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).sendKeys("female");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(6) select")).sendKeys("single");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(7) input")).sendKeys("fakeemail@gointegro.com");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).sendKeys("+541147511234");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).sendKeys("+541147511234");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(10) input")).sendKeys("Mi Casa 123");
	            
	            
	            //Redes Sociales
	            Reporter.log("Cargando y validando Redes Sociales");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).sendKeys("invaild data");
	            Assert.assertEquals("El campo debe tener un formato de url valido", driver.findElement(By.cssSelector(".socialdata label:nth-child(2) span")).getText(), "Validacion del campo linkedin");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).clear();
	            
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).sendKeys("http://linkedin.com/in/username");
	           
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).sendKeys("invaild data");
	            Assert.assertEquals("El campo debe tener un formato de url valido", driver.findElement(By.cssSelector(".socialdata label:nth-child(3) span")).getText(), "Validacion del campo twitter");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).clear();
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).sendKeys("http://twitter.com/username");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(4) input")).sendKeys("http://facebook.com/username"); 
	 		
	     
	            // Grabar el nuevo usuario creado
	        Thread.sleep(2000);
	         driver.findElement(By.cssSelector(".secondary")).click();    
	        
	       
	
	  // Verificar que vuelva al listado de personas  
	          
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	       driver.findElement(By.cssSelector(".tablefilter")).isDisplayed();
          Reporter.log(" El usuario Admin se agrego correctamente"); 
	          
        /*  // Verificar la cantidad de elementos en la tabla 
	         
          WebElement htmltable2=driver.findElement(By.cssSelector(".tablefilter tbody"));

          List<WebElement> rows2=htmltable2.findElements(By.tagName("tr"));
          Reporter.log("La cantidad de usuarios en el sitio es",rows2.size());
         
          //Chequear que la cantidad de elementos en la tabla de users es +1
      //    Assert.assertEquals(rows.size()+1,rows2.size());	         
	*/
	}
	
	
}
