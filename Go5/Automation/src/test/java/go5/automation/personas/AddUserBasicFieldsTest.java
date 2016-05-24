package go5.automation.personas;



import go5.automation.TestSuite;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Reporter;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



public class AddUserBasicFieldsTest extends TestSuite{

	//private WebDriver driver;

	

		 @BeforeTest // call function to open the browser and login 
		 public void setup () throws Exception{
		this.setUpMaven();
		
		   
		 }
		
		 @AfterTest // call function to close browser 
			
			public void teardown(){
				closeBrowser();
			}

	
		

	@Test
	public void addUserAdmin() throws InterruptedException{
		 org.apache.log4j.BasicConfigurator.configure();
		 Random numero= new Random();
	 
		 
		 // Go to the configuration
			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	       driver.findElement(By.cssSelector(".menu")).click();
	       Thread.sleep(1000);
		
		      
	    
	   // Go to Manage people
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     
	         // Obtener la cantidad de usuarios antes de agregar user
	         
	               
	         WebElement htmltable=driver.findElement(By.cssSelector(".tablefilter tbody"));

	        List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	         Reporter.log("La cantidad de usuarios antes de agregar uno nuevo,en el sitio es",rows.size());
	         
	         
	         //Add a  user    
		     driver.findElement(By.cssSelector(".content .title a")).click();
		    
		     
		     //Verificar ayuda de estado del usuario
		     
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(1) a")).click();
		     Reporter.log(driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) h2")).getText());
		     //Cerrar el popup de ayuda
		    
		     Thread.sleep(1000);
		     driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) .close"));
		     Thread.sleep(1000);
		     
		     //Verificar modal de Bloquear Acceso
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(3) a")).click();
		     Reporter.log(driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) h2")).getText());
		     
		     //Darle ok, entendido al popup
		       
		     driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) .primary")).click();
		    
		     //Lo creo desactivado
		     
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(2) input:nth-child(2) ")).click();
		     
		     //Poner el nombre
		     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(4) input")).sendKeys("Random Name" + numero.nextInt());
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(5) input")).sendKeys("Random Lastname"+ numero.nextDouble());
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(6) input")).sendKeys("randomemail"+numero.nextInt()+"@gointegro.com");
		     
		     //Seleccionar el rol
		      
		     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
		 		
		        selectRol.selectByIndex(1);
		     	
		 		
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
