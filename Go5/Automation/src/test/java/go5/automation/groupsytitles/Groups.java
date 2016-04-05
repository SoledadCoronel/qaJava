package go5.automation.groupsytitles;



import go5.automation.TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;


public class Groups extends TestSuite{

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
	public void addGroups() throws Exception{
		
	 
		

		  // Go to the configuration
		 this.goToConfiguration();
		 this.goToMenu();	
		// Go to  Users Menu
	        Reporter.log("Abriendo administar personas" );  
	       
	        
	    // Go to Titles2    
	       
	        Reporter.log("Abriendo titulos");
	 	     this.goToTitles();
	      
	      
	      
	  	  
	         // Go to Grupos
	  	        Reporter.log("Abriendo Grupos");
	  	        this.goToGroups();
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
	 	         
	 	         this.click(firstRow);
	 	         
	 	     //     driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td a ")).click();
	 	          
	 	         //Agrandar el form para agregar mas datos  
	 		        
	 		        driver.findElement(By.cssSelector(".addpeople fieldset:nth-child(2) .secondary")).click();
	 		        
	 		       Select selectGroups=new  Select(driver.findElement(By.cssSelector(".groupsdata select"))); 
	 		 		
	 		 	  selectGroups.selectByIndex(1);
	 		 	  
	 		 	  // Grabar el  usuario editado
	 		        Thread.sleep(1000);
	 		         driver.findElement(By.cssSelector(".container .addpeople .primary")).click();    
	 		        
	}
	
	
}
