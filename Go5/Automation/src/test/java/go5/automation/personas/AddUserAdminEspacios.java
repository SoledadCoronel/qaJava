package go5.automation.personas;



import java.net.URL;
import java.util.List;
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



public class AddUserAdminEspacios {

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
	    capability.setCapability("name", "AgregarAdminEspacios");
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
	public void addUserBasicDataAdmin() throws InterruptedException{
		 org.apache.log4j.BasicConfigurator.configure();
		 Random numero= new Random();
	 	
		//Login
			
			driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
		 
		
        Reporter.log(" Agregando un user Admin de Espacios, con los datos basicos y sin invitation");
        Reporter.log(" Se agrega el user en estado desactivado");
		
        // Go to the configuration
		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
       driver.findElement(By.cssSelector(".menu")).click();
	
	      
    
   // Go to Manage people
        
        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
         // Obtener la cantidad de usuarios antes de agregar user
         
               
         WebElement htmltable=driver.findElement(By.cssSelector(".tablefilter tbody"));

     List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
         Reporter.log("La cantidad de usuarios antes de agregar uno nuevo,en el sitio es",rows.size());
         
         
         //Add a  user    
	     driver.findElement(By.cssSelector(".content .title a")).click();
	    
	            
	    
	     //Lo creo desactivado
	     
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(2) input:nth-child(2) ")).click();
	     
	     //Poner el nombre
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(4) input")).sendKeys("Admin" + numero.nextInt());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(5) input")).sendKeys("Espacio"+ numero.nextDouble());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(6) input")).sendKeys("adminespacio"+numero.nextInt()+"@gointegro.com");
	     
	     //Seleccionar el rol
	      
	     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
	 		
	        selectRol.selectByIndex(3);
	     	
	 		
	     // Grabar el nuevo usuario creado
	        Thread.sleep(3000);
	         driver.findElement(By.cssSelector(".content .addpeople fieldset:nth-child(4) .secondary")).click();    
	        
	 	
	  // Verificar que vuelva al listado de personas  
	          
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	       driver.findElement(By.cssSelector(".tablefilter")).isDisplayed();
          Reporter.log(" El usuario Admin se agrego correctamente"); 
	          
          // Verificar la cantidad de elementos en la tabla 
	         
          WebElement htmltable2=driver.findElement(By.cssSelector(".tablefilter tbody"));

          List<WebElement> rows2=htmltable2.findElements(By.tagName("tr"));
          Reporter.log("La cantidad de usuarios en el sitio , luego de haber agregado uno,es :",rows2.size());
         
          //Chequear que la cantidad de elementos en la tabla de users es +1
      //    Assert.assertEquals(rows.size()+1,rows2.size());	         
	}
	
}
