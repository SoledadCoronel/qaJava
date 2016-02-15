package go5.automation.people;


import go5.automation.CommonFunctions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class AddUserBasicData extends CommonFunctions{


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
	public void addUserBasic() throws InterruptedException{
		 org.apache.log4j.BasicConfigurator.configure();
		 Random numero= new Random();
	 	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	 	log.info("Ir al menu de config");
        
		
	 	  // Go to the configuration
	 			driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	 	       driver.findElement(By.cssSelector(".menu")).click();
	 		
	 		// Go to  Users Menu
	 	        Reporter.log("Abriendo administar personas" );  
	 	        //driver.findElement(By.cssSelector(".usermenu")).click();
	 	        Reporter.log("Abriendo titulos");
	 	        
	 	    // Go to Titles    
	 	        
	 	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
	 	        log.info(driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).getText());
	 	        Reporter.log("Abriendo personas");
	 	   // Go to Manage people
	 	        
	 	        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
	 	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
         // Obtener la cantidad de usuarios antes de agregar user
         
         
         WebElement htmltable=driver.findElement(By.cssSelector(".tablefilter tbody"));

         List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
         log.info("Cantidad de users antes de agregar otro:");
         log.info(rows.size());
          Reporter.log("La cantidad de usuarios antes de agregar uno nuevo,en el sitio es",rows.size());
         
               
                 
         //Add a  user    
	     driver.findElement(By.cssSelector(".content .title a")).click();
	    
	     
	     
	     //Lo creo activado
	     
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(2)")).click();
	     
	     //Poner el nombre
	     
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(4)")).sendKeys("Random Name" + numero.nextInt());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(5)")).sendKeys("Random Lastname"+ numero.nextDouble());
	     driver.findElement(By.cssSelector(".basicdata label:nth-child(6)")).sendKeys("randomemail"+numero.nextInt()+"@gointegro.com");
	     
	     //Seleccionar el rol
	      
	     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
	 		
	        selectRol.selectByIndex(2);
	     	
	 		
	     // Grabar el nuevo usuario creado
	        Thread.sleep(2000);
	         driver.findElement(By.cssSelector(".content .addpeople fieldset:nth-child(4) .secondary")).click();    
	        
	 // Verificar mensaje
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         
	          log.info(driver.findElement(By.cssSelector(".content .overlayloading .loading")).getText());
	
	  // Verificar que vuelva al listado de personas 
	          
	          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	         log.info(driver.findElement(By.cssSelector(".tablefilter")).isDisplayed());
	         
	         
	   
	         // Verificar la cantidad de elementos en la tabla 
	         
	          WebElement htmltable2=driver.findElement(By.cssSelector(".tablefilter tbody"));

	          List<WebElement> rows2=htmltable2.findElements(By.tagName("tr"));
	          log.info("La cantidad de usuarios en el sitio es");
	          log.info(rows2.size());
	         
	         
	          //Chequear que la cantidad de elementos en la tabla de users es +1
	          Assert.assertEquals(rows.size()+1,rows2.size());	         
              
	   /*    
	       // Verificar que el usuario figura como no registrado (TO DO)
		          
	          WebElement htmltable=driver.findElement(By.cssSelector(".tablefilter tbody"));

	          List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	          log.info(rows.size());
	         
	 
	          for(int rnum=0;rnum<rows.size();rnum++)

	          {
	        	  
	        	  List<WebElement> columns=rows.get(rnum).findElements(By.tagName("th"));
	        	  
	        	  log.info(columns.size());
	        	  //log.info("Number of columns:"+columns.size());
	        	  for(int cnum=0;cnum<columns.size();cnum++)
	        		  log.info(driver.findElement(By.cssSelector(".tablefilter tbody tr:nth-child(cnum)")).getText());
	        	  	//	  log.info(columns.get(cnum).getText());
	        	  }
	          */
	          }         
	}          
	     
	
	
