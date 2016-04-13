package go5.automation.personas;

import go5.automation.TestSuite;
import go5.pageObjects.DirectorioPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class ListadoPersonasAB extends TestSuite {
			 	 
	
	 DirectorioPage directorio = null;

	 @AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
		}
		
	
	@Test
	

	public void listadoPersonas() throws Exception { 
			
		       
         // Go to the configuration
         
		 this.goToConfiguration();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 this.goToMenu();
	
        
 	
 	// Go to  Users Menu
         Reporter.log("Abriendo administar personas" );  
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
        
         driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         //Ordenar por nombre-
         
           this.ordenar();
           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      // Agarrar primer nombre de la tabla
         String firstname= new String(driver.findElement(By.cssSelector(firstRow)).getText());
        Reporter.log(firstname);
         //Agarrar el ultimo de la tabla
         String secondname= new String(driver.findElement(By.cssSelector(secondRow)).getText());
        Reporter.log(secondname);
              
        if (firstname.compareTo(secondname)< 0) 
        Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente");
        else 
        	Reporter.log("Los usuarios estan ordenados en orden alfabetico descendente" );
        
        //Volver a ordenar, en forma descendente
        
        this.ordenar();
        Thread.sleep(1000);
     // Agarrar primer nombre de la tabla
        String firstname2= new String(driver.findElement(By.cssSelector(firstRow)).getText());
       Reporter.log(firstname2);
        //Agarrar el ultimo de la tabla
        String secondname2= new String(driver.findElement(By.cssSelector(secondRow)).getText());
       Reporter.log(secondname2);
             
       if (firstname.compareTo(secondname)> 0) 
       Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente");
       else 
       	Reporter.log("Los usuarios estan ordenados en orden alfabetico descendente" );
         
    //Hacer una busqueda
     
            	 
                	 
                Reporter.log(" Hacer una busqueda de un usuario por Nombre");
                 this.search(firstname2);
	               
                
                //Chequear q se mueste en la tabla users
                Reporter.log("El nombre del user buscado es :");
                Reporter.log(firstname2);
                Reporter.log(" Imprimiendo el resultado del search");
                 Reporter.log(firstname2);
             
               
               Reporter.log(" Hacer una busqueda de un usuario por Apellido");
              
               this.search(secondname2);
            
               //Chequear q se mueste en la tabla users
               Reporter.log("El nombre del user buscado es :");
               Reporter.log(secondname2);
               Reporter.log(" Imprimiendo el resultado del search");
               Reporter.log(secondname2);
	}
}	