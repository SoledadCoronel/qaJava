package go5.automation.personas;

import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class ListadoPersonas extends CommonFunctions {
			 	 
	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build);
	 }
	   

	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
		
	
	@Test
	
	public void listadoPersonas() throws Exception { 
			
		       
         // Go to the configuration
         
		this.click(strCssConfiguration);
		this.click(irAMenu);
        
 	
 	// Go to  Users Menu
         Reporter.log("Abriendo administar personas" );  
      
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
        
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         //Ordenar por nombre-
         
          //Clickear el ordenar por noombre
         driver.findElement(By.cssSelector(".tables thead tr th:nth-child(2) a")).click();
         Thread.sleep(1000);
      // Agarrar primer nombre de la tabla
         String firstname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText());
        Reporter.log(firstname);
         //Agarrar el ultimo de la tabla
         String secondname= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(2) td:nth-child(2)")).getText());
        Reporter.log(secondname);
              
        if (firstname.compareTo(secondname)< 0) 
        Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente");
        else 
        	Reporter.log("Los usuarios estan ordenados en orden alfabetico descendente" );
        
        //Volver a ordenar, en forma descendente
        
        driver.findElement(By.cssSelector(".tables thead tr th:nth-child(2) a")).click();
        Thread.sleep(1000);
     // Agarrar primer nombre de la tabla
        String firstname2= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText());
       Reporter.log(firstname2);
        //Agarrar el ultimo de la tabla
        String secondname2= new String(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(2) td:nth-child(2)")).getText());
       Reporter.log(secondname2);
             
       if (firstname.compareTo(secondname)> 0) 
       Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente");
       else 
       	Reporter.log("Los usuarios estan ordenados en orden alfabetico descendente" );
         
    //Hacer una busqueda
     
            	 
                	 
                Reporter.log(" Hacer una busqueda de un usuario por Nombre");
                driver.findElement(By.cssSelector(".actions .search .btnsearch")).click();
                driver.findElement(By.cssSelector(".actions .search input")).sendKeys("AutomationFirstName");
                
                //Chequear q se mueste en la tabla users
                Reporter.log("El nombre del user buscado es AutomationFirstName");
                Reporter.log(" Imprimiendo el resultado del search");
               Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText()); 
	
               
               Reporter.log(" Hacer una busqueda de un usuario por Apellido");
              
              
               driver.findElement(By.cssSelector(".actions .search .btnsearch")).click();
               driver.findElement(By.cssSelector(".actions .search input")).clear();
               driver.findElement(By.cssSelector(".actions .search input")).sendKeys("AutomationLastName");
               
               //Chequear q se mueste en la tabla users
               Reporter.log("El nombre del user buscado es AutomationLastName");
               Reporter.log(" Imprimiendo el resultado del search");
              Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(1) td:nth-child(2)")).getText()); 
	
	
           
	}
}	