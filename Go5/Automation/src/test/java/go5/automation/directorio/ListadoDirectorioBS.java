package go5.automation.directorio;

import go5.automation.CommonFunctions;


import java.util.concurrent.TimeUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class ListadoDirectorioBS extends CommonFunctions{
	
			
		 @BeforeClass
		  @Parameters(value={"browser","version","platform","url","build"})
		  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
			this.setUpBrowserStack(browser, version, platform, url,build);
			
			
		 }
		   

		 @AfterClass // call function to close browser 
			
			public void teardown(){
				driver.quit();
			}
	 
	 public void ordenar() throws Exception{
		 this.click(orden);
	 }
	
	@Test (groups={"Listado"})
	
	public void listadoDirectorio() throws Exception { 
	
			
		// Go to the menu (hamburguesita)
         this.click(irAMenu);
 		
       	
 	// Go to  Directorio de personas
	
         Reporter.log("Abriendo directorio de  personas" );  
        this.click(".igouser");
         Thread.sleep(1000);
         this.click(".igousergroup");
         Thread.sleep(1000);
          
        // WebElement tablevailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".people")));
         
      
         //Verificar que el orden default sea alfabetico
       
        
      // Agarrar primer nombre de la tabla
         String firstname= this.getText(firstRow);
           Reporter.log(firstname);
         //Agarrar el ultimo de la tabla
         String secondname= this.getText(secondRow);
        Reporter.log(secondname);
              
        if (firstname.compareTo(secondname)< 0) 
        Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente, que es el default de la pagina");
        else 
        	Reporter.log("La pagina no esta ordenada alfabeticamente por default" );
        
        //Volver a ordenar, en forma descendente
        
        this.click(orden);
         Thread.sleep(1000);
     // Agarrar primer nombre de la tabla
        String firstname2= this.getText(firstRow);
       Reporter.log(firstname2);
        //Agarrar el ultimo de la tabla
        String secondname2= this.getText(secondRow);
       Reporter.log(secondname2);
        //Compare     
       if (firstname.compareTo(secondname)< 0) 
       Reporter.log("Los usuarios estan ordenados alfabeticamente por orden descendente");
       else 
       	Reporter.log("Los usuarios estan ordenados en orden alfabetico ascendente" );
       
       
     //Verificar Paginado
       Reporter.log("Seleccionar otra pagina del listado");
      this.click(irAPagina);
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      
       //Volver a ordenar, en forma descendente
       Reporter.log("Probando ordenamiento en otra pagina del listado");
      this.ordenar();
       
       Thread.sleep(1000);
    // Agarrar primer nombre de la tabla
       String firstname3= this.getText(firstRow);
      Reporter.log(firstname2);
       //Agarrar el ultimo de la tabla
       String secondname3= this.getText(secondRow);
      Reporter.log(secondname2);
            
      if (firstname.compareTo(secondname)< 0) 
      Reporter.log("Los usuarios estan ordenados alfabeticamente por orden descendente");
      else 
      	Reporter.log("Los usuarios estan ordenados en orden alfabetico ascendente" );
        
         
    //Hacer una busqueda
     
      			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);                	 
                Reporter.log(" Hacer una busqueda de un usuario por Nombre");
                this.click(searchButton);
                this.sendValue(inputSearch, secondname3);
               
                
                //Chequear q se muestre en la tabla users
                Reporter.log("El nombre del user buscado es:");
                Reporter.log(secondname3);
                Thread.sleep(1000);
                Reporter.log(" Imprimiendo el resultado del search:");
               Reporter.log(this.getText(".tables tbody tr:nth-child(1) td:nth-child(2)")); 
	
               
               Reporter.log(" Hacer una busqueda de un usuario por Apellido");
              
               this.click(searchButton);
               this.clear(inputSearch);
               this.sendValue(inputSearch, "AutomationLastName");
                            
               //Chequear q se mueste en la tabla users
               Reporter.log("El nombre del user buscado es AutomationLastName");
               Thread.sleep(1000);
               Reporter.log(" Imprimiendo el resultado del search");
               Reporter.log(this.getText(firstRow));
              
               //Ir al profile del user buscado
               this.click(firstRow);
              
             
              
           
	}
}	