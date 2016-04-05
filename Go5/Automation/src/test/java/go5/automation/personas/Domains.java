package go5.automation.personas;



import go5.automation.TestSuite;

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



public class Domains extends TestSuite{

	//private WebDriver driver;

	

		 @BeforeTest // call function to open the browser and login 
		 public void setup () throws Exception{
		   openSiteLogin();
		   login();
		   
		 }
		
		 @AfterTest // call function to close browser 
			
			public void teardown(){
				closeBrowser();
			}

	
		

	@Test
	public void addDomains() throws InterruptedException{
		 org.apache.log4j.BasicConfigurator.configure();
		 Random numero= new Random();
	 	/*
		//Login
			
			driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
		 */
		
        Reporter.log(" Agregando un user Admin, con todos los datos basicos  y sin invitation");
    
        // Go to the configuration
			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	       driver.findElement(By.cssSelector(".menu")).click();
		
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles2    
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	      
	        Reporter.log("Abriendo personas");
	   // Go to Manage people
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	      // Ir al tab de domains
	          
	         driver.findElement(By.cssSelector(".title menu li:nth-child(3) a")).click();
	        
	         
	         // Insertar un dominio invalido
	       /*  driver.findElement(By.cssSelector(".peopledomain input")).click();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(1) input")).sendKeys("Dominio1");
	         driver.findElement(By.cssSelector(".peopledomain .link")).click();
	         Assert.assertEquals(driver.findElement(By.cssSelector(".peopledomain div label:nth-child(1) span")).getText(), "Dominio invalido");
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(1) .delete")).click();
	         driver.findElement(By.cssSelector(".rgroupitem .primary")).click();
	        */
	         
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(1) input")).sendKeys("dominio1.com");
	         driver.findElement(By.cssSelector(".peopledomain .link")).click();
	       //  driver.findElement(By.cssSelector(".peopledomain div label:nth-child(2) input")).clear();
	         //driver.findElement(By.cssSelector(".peopledomain div label:nth-child(2) input")).sendKeys("Dom");
	      //   driver.findElement(By.cssSelector(".peopledomain .link")).click();
	     //    Assert.assertEquals(driver.findElement(By.cssSelector(".peopledomain div label:nth-child(1) span")).getText(), "Dominio invalido");
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(2) input")).clear();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(2) input")).sendKeys("dominio2.com");
	         driver.findElement(By.cssSelector(".peopledomain .link")).click();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(3) input")).clear();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(3) input")).sendKeys("dominio3.com");
	         driver.findElement(By.cssSelector(".peopledomain .link")).click();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(4) input")).clear();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(4) input")).sendKeys("dominio4.com");
	         driver.findElement(By.cssSelector(".peopledomain .link")).click();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(5) input")).clear();
	         driver.findElement(By.cssSelector(".peopledomain div label:nth-child(5) input")).sendKeys("dominio5.com");
	         driver.findElement(By.id("formPrimaryButton")).click();
	         Thread.sleep(1000);
	         
	         
        
        /*  // Verificar la cantidad de elementos en la tabla 
	         
          WebElement htmltable2=driver.findElement(By.cssSelector(".tablefilter tbody"));

          List<WebElement> rows2=htmltable2.findElements(By.tagName("tr"));
          Reporter.log("La cantidad de usuarios en el sitio es",rows2.size());
         
          //Chequear que la cantidad de elementos en la tabla de users es +1
      //    Assert.assertEquals(rows.size()+1,rows2.size());	         
	*/
	}
	
	
}
