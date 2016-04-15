package go5.automation.personas;



import go5.automation.TestSuite;
import go5.pageObjects.LoginPage;
import go5.pageObjects.PersonasPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AddUserAC extends TestSuite{

	// Declarion pagina de Personas
	
	PersonasPage personas = null;
	

	
	@BeforeClass
	   public void setup() throws Exception{
		this.setUpMaven();
        personas= new PersonasPage(driver);
		
	 }
	
		 @AfterClass // call function to close browser 
			
			public void teardown(){
				closeBrowser();
			}

	
		

	@Test
	public void agregarPersonaPOM() throws Exception{
		
	 
		log.info("Ir al menu de config");
        Reporter.log(" Testeando la pagina de Administrar personas");
		
        // Go to the configuration
        this.goToConfiguration();
		this.goToMenu();
	      
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles2    
	        this.goToTitles();
	       
	        log.info(driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).getText());
	        Reporter.log("Abriendo personas");
	   // Go to Manage people
	   //     this.click(irAPersonas);
	       personas.goToPersonas();
	        System.out.println("Poniendo nombre");
		      
	      personas.setRandomUserName();
	      System.out.println("Poniendo nombre");
	      
	      personas.setRandomLastName();
	      System.out.println("Poniendo apellidonombre"); 
	       		    
		     
		     //Verificar ayuda de estado del usuario
		     
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(1) a")).click();
		     Reporter.log(driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) h2")).getText());
		     //Cerrar el popup de ayuda
		    
		 ;
		     driver.findElement(By.cssSelector("#modal-container .modal:nth-child(4) .close"));
		     
		     
		     //Verificar modal de Bloquear Acceso
		     driver.findElement(By.cssSelector(".basicdata label:nth-child(3) a")).click();
		     Reporter.log(driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) h2")).getText());
		     
		     //Darle ok, entendido al popup
		       
		     driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) .primary")).click();
		    
		     
		     
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
