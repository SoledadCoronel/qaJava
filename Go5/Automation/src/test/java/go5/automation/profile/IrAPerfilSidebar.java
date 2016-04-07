package go5.automation.profile;


import go5.automation.TestSuite;


import java.util.Random;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class IrAPerfilSidebar extends TestSuite {
	
 private WebDriver driver;

	

	
 @BeforeClass
  @Parameters(value={"browser","version","platform","url","build"})
  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
	this.setUpBrowserStack(browser, version, platform, url,build);
	
	
 }
   

 @AfterClass // call function to close browser 
	
	public void teardown(){
		this.quitBrowser();
	}
		
	@Test
	
	public void editProfile() throws Exception { 
	
		
		 
		 Random numero= new Random();
		
		
	        //Abrir el menu
		 this.goToMenu();
	        
		 
		 
		// Go to the user menu
			driver.findElement(By.cssSelector(".igouser")).click();
	
			 Reporter.log("Ir a Perfil Desde el sidebar");
			
			
			//Editar perfil
			 
			 Reporter.log("Editar perfil");
			driver.findElement(By.cssSelector(".data h2 a")).click();
			
			//Insertar datos laborales
			Reporter.log("Editando datos laborales");
			
			 driver.findElement(By.cssSelector(".labordata label:nth-child(2) input")).clear();
		    driver.findElement(By.cssSelector(".labordata label:nth-child(2) input")).sendKeys("RandomId" + numero.nextInt());
  	         
	         driver.findElement(By.cssSelector(".labordata label:nth-child(3) input" )).sendKeys("10/10/10");
	         driver.findElement(By.cssSelector(".labordata label:nth-child(4) select ")).click();
	         
	         driver.findElement(By.cssSelector(".labordata label:nth-child(4) select ")).sendKeys("full-time");
	         
	       
	         //Reṕorta a 
	         driver.findElement(By.cssSelector(".labordata label:nth-child(6) input")).clear();
	         driver.findElement(By.cssSelector(".labordata label:nth-child(6) input")).sendKeys("Test Test");
	         
	         //Telefono
	         driver.findElement(By.cssSelector(".labordata label:nth-child(7) input")).clear();
	           driver.findElement(By.cssSelector(".labordata label:nth-child(7) input")).sendKeys("+541147511234");
	          driver.findElement(By.cssSelector(".labordata label:nth-child(8) input")).clear();
	          driver.findElement(By.cssSelector(".labordata label:nth-child(8) input")).sendKeys("+541147511234");
	         
	        /*  //Direccion
	          driver.findElement(By.cssSelector(".labordata label:nth-child(9) input")).clear();
	          driver.findElement(By.cssSelector(".labordata label:nth-child(9) input")).sendKeys("Alv. Thomas 198");
	         */ //Fin Datos laborales
	          
	          //Datos Personales
	          
	          Reporter.log("Editando datos personales");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(2) select")).sendKeys("RUT");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(3) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(3) input")).sendKeys("asasddsdsadsads");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(4) input")).sendKeys("11/11/11");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).click();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).sendKeys("female");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(6) select")).sendKeys("single");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(7) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(7) input")).sendKeys("fakee5555mail@gointegro.com");
	        //    driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).clear();
	           // driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).sendKeys("+541147511234");
	          //  driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).clear();
	          //  driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).sendKeys("+541147511234");
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(10) input")).clear();
	            driver.findElement(By.cssSelector(".personaldata label:nth-child(10) input")).sendKeys("Mi Casa 123");
	            
	            
	            //Redes Sociales
	            Reporter.log("Editando redes  sociables");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).clear();
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).sendKeys("invaild data");
	            Assert.assertEquals("El campo debe tener un formato de url valido", driver.findElement(By.cssSelector(".socialdata label:nth-child(2) span")).getText(), "Validacion del campo linkedin");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).clear();
	            
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(2) input")).sendKeys("http://linkedin.com/in/username");
	           
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).clear();
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).sendKeys("invaild data");
	            Assert.assertEquals("El campo debe tener un formato de url valido", driver.findElement(By.cssSelector(".socialdata label:nth-child(3) span")).getText(), "Validacion del campo twitter");
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).clear();
	            driver.findElement(By.cssSelector(".socialdata label:nth-child(3) input")).sendKeys("http://twitter.com/username");
	          //  driver.findElement(By.cssSelector(".socialdata label:nth-child(4) input")).clear();
	         //   driver.findElement(By.cssSelector(".socialdata label:nth-child(4) input")).sendKeys("http://facebook.com/username"); 
	 		
	     
	            // Grabar el nuevo usuario creado
	            Reporter.log("Grabando perfil editado");
	        Thread.sleep(2000);
	         driver.findElement(By.cssSelector(".primary")).click();    
	         Reporter.log("Edicion de profile fue exitoso");
	         
	        
	
	}	
	
	
		
     }

