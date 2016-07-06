package go5.pageObjects;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;


    
    
    public class ConfiguracionPage {

    	//Css
    	
    	private String datosBasicoscss = ".basicata";
    	
        
        private String selectIdiomacss = ".basicdata fieldset label:nth-child(1) select";
        private String selectTimezonecss = ".basicdata fieldset label:nth-child(2) select";
       
    	
        //References
        By selectIdioma=By.cssSelector(selectIdiomacss);
        By selectTimeZone=By.cssSelector(selectTimezonecss);
       
        protected WebDriver driver;
    
     
  //Constructor
    	    
    	  public ConfiguracionPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
      
         
         
         public void setIdioma(){
     		
        	 // Select all values the drop-down for Language
        	 		Reporter.log(" Verificar el drop-down de lenguajes");
        	 		Select selectLanguage = new Select(driver.findElement(selectIdioma)); 
        	 		
        	 		selectLanguage.selectByValue("pt");
        	 		selectLanguage.selectByValue("en");	
        	 		selectLanguage.selectByValue("es");
         }
      
         public void setTimezone(){
        	//Select a value from drop-down Timezone
      		Reporter.log(" Verificar el drop-down de timezone ");
      		
      		
      		Select selectTZ= new Select(driver.findElement(selectTimeZone));
      		     		     		
     		selectTZ.selectByValue("America/Anchorage");

         }
    	  
         public void restablecerInterfaz(){
        	 //Restablecer interfaz   
             driver.findElement(By.cssSelector("div .container .design fieldset:nth-child(5) a")).click();
             driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            //Click en el popup de restorear
             driver.findElement(By.cssSelector("#modal-container .modal:nth-child(6) .primary")).click();
             driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
         }
   
      public void verifyColors(){
    	// Verify list of colors in branding
          Reporter.log(" Veirificando que esten todos los colores disponibles");

Assert.assertEquals("white",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(1)")).getText()));

Assert.assertEquals("lightgrey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(2)")).getText()));

Assert.assertEquals("grey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(3)")).getText()));

Assert.assertEquals("darkgrey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(4)")).getText()));

Assert.assertEquals("black",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(5)")).getText()));

Assert.assertEquals("yellow",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(6)")).getText()));

Assert.assertEquals("orange",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(7)")).getText()));

Assert.assertEquals("red",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(8)")).getText()));

Assert.assertEquals("green",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(9)")).getText()));

Assert.assertEquals("skyblue",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10)")).getText()));
      }
    
      public void changeColorHeader() throws InterruptedException{
    		//Change header color
  		
      	
          // Clickeo en Disenio
       Reporter.log(" Cambiando el color del header");
          
          driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
       
       
       
	 // Verify that the selected color has been changed in the header
       
          Reporter.log(" Verificando que el color del header se haya cambiado");
          
       //Select black colour
       driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10)")).click();
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     String colorSelected = new String (driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10) a")).getCssValue("background-color"));
     Reporter.log(colorSelected);
   
     //Save changes for colour
     driver.findElement(By.cssSelector(".primary")).click();
		Thread.sleep(4000);
     String colorHeader = new String(driver.findElement(By.tagName("header")).getCssValue("background-color"));
     Reporter.log(colorHeader);
  
     //Compare the header color against the selected, converted to hexadecimal
     
   Reporter.log("El color seleccionado en branding se muestra correctamente en el header");
    Assert.assertEquals(colorSelected, colorHeader, "El color seleccionado en branding se muestra correctamente en el header" );
       
             
      }
      
      public void changeColorContrast() throws InterruptedException{
    		// Change Contrast Color(){
  		
    	     Reporter.log(" Cambiando el color del contraste ");
    	    	
    	           // Clickeo en Disenio
    	           
    	           driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
    	           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	        
    	        
    	        
    	        
    		 // Verify that the selected color has been changed in the header
    	        
    	        //Select black colour for letters
    	        driver.findElement(By.cssSelector(".design fieldset:nth-child(3) .colorpicker .black")).click();
    	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	       
    	      String colorSelected2 = new String (driver.findElement(By.cssSelector(".design fieldset:nth-child(3) .colorpicker .black a")).getCssValue("background-color"));
    	      Reporter.log("El color seleccionado para la letra es :" );
    	      Reporter.log(colorSelected2);
    	      
    	   
    	     Thread.sleep(5000);
    	      driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    	      String colorHeader2 = new String(driver.findElement(By.cssSelector("header h1")).getCssValue("color"));
    	      Reporter.log("El color que esta en la letra en el header es :");
    	      Reporter.log(colorHeader2);
    	   
    	      Reporter.log(" El caso de branding-colors finalizo correctamente");
    	      //Compare the header color against the selected, converted to hexadecimal
    	      
    	  
    	     Assert.assertEquals(colorSelected2, colorHeader2, "El color seleccionado de contraste de texto se muestra correctamente en el header" );
    	        }
      }
  
    
    

