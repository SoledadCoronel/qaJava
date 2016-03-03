package go5.automation.personas;



import go5.automation.CommonFunctions;


import java.util.concurrent.TimeUnit;


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


public class Groups extends CommonFunctions{

	//private WebDriver driver;

	

		 @BeforeTest // call function to open the browser and login 
		 public void setup () throws Exception{
		   openSiteLogin();
		   login("marina.touceda@gointegro.com","Auto1234");
		   
		 }
		
		 @AfterTest // call function to close browser 
			
			public void teardown(){
				closeBrowser();
			}

	
		

	@Test
	public void addUserAdmin() throws InterruptedException{
		
	 	/*
		//Login
			
			driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
		 */
		
		  // Go to the configuration
			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	       driver.findElement(By.cssSelector(".menu")).click();
		
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles    
	        
	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	      
	        Reporter.log("Abriendo titulos");
	   
	  	  
	         // Go to Grupos
	  	        
	  	        driver.findElement(By.cssSelector(".space:nth-child(3) ol li:nth-child(4) a")).click();
	  	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         
	  	       //Agregar un Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
	  	         //Insertar un nombre de Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("TestGrupoToBeDeleted");
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.RETURN);
	  	         
	  	         //Borrar Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .delete")).click();
	  	         driver.findElement(By.cssSelector(".mconfirmation a")).click();
	  	         Thread.sleep(1000);

	
	  	     //Agregar Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
	  	         //Insertar un nombre de Grupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("TestGrupo1");
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.RETURN);
	  	         
	  	         //Agregar un Subgrupo
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree .showadd a")).click();
	  	         
	  	         driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys("Subgrupo1");
	  	         driver.findElement(By.cssSelector(".additem.active input")).sendKeys(Keys.RETURN);
	  	         
	  	         
	  	  // Go to a user and verify that the field group is present
	  	         //Go to Administrar
	  	         
	  	    // Go to Manage people
	 	        
	 	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	 	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);     
	
	 	    //Agarrar el primer user de la tabla y editarlo
	 	         
	 	          driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td a ")).click();
	 	          
	 	         //Agrandar el form para agregar mas datos  
	 		        
	 		        driver.findElement(By.cssSelector(".addpeople fieldset:nth-child(2) .secondary")).click();
	 		        
	 		       Select selectGroups=new  Select(driver.findElement(By.cssSelector(".groupsdata select"))); 
	 		 		
	 		 	  selectGroups.selectByIndex(1);
	 		 	  
	 		 	  // Grabar el  usuario editado
	 		        Thread.sleep(1000);
	 		         driver.findElement(By.cssSelector(".container .addpeople .primary")).click();    
	 		        
	}
	
	
}
