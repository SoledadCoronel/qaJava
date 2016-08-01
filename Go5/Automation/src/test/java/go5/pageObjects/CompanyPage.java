package go5.pageObjects;



import go5.automation.TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


    
    
    public class CompanyPage extends TestSuite{

    	//Css
    	
    	private String headerCss="header h1";
    	private String datosGenerales = ".igocompanydata";
    	private String design= ".igodesign";
    	private String colorPlataformaBlanco=".white";
    	private String colorPlataformaRojo=".red";
    	
    	private String goToRestablecerInterfazCss=".restores";
    	private String confirmarInterfazCss=".modal:nth-child(6) .primary";
    	private String cancelarInterfazCss=".modal:nth-child(6) .optional";
        private String nombreCompania=".generaldata fieldset label:nth-child(1) input";
        private String selectIdioma = ".generaldata fieldset label:nth-child(3) select";
        private String selectTimezone = ".generaldata fieldset label:nth-child(4) select";
        private String errorCompanyBlack=".generaldata fieldset label:nth-child(1) span";
        private String guardarCambiosCss=".design fieldset:nth-child(5) .primary";
        
        
        //Colors
        
        private String colorNegroContrasteCss=".design fieldset:nth-child(3) .colorpicker .black";
        private String getColorNegroCss=".design fieldset:nth-child(3) .colorpicker .black a";
        private String colorBlancoContrasteCss="";
        private String colorCelesteCss=".skyblue";
        private String nombreColorCelesteCss=".skyblue a";
    	
        
        
        
        //References
        By header = By.cssSelector(headerCss);
        By error= By.cssSelector(errorCompanyBlack);
    	
    	By goToRestablecerInterfaz=By.cssSelector(goToRestablecerInterfazCss);
    	By okRestablecerInterfaz=By.cssSelector(confirmarInterfazCss);
    	By guardarCambios=By.cssSelector(guardarCambiosCss);
    	By cancelaRestablecerInterfaz=By.cssSelector(cancelarInterfazCss);
    	
    	
   
    	//Colours
    	
    	By colorNegroContraste=By.cssSelector(colorNegroContrasteCss);
    	By getColorNegro=By.cssSelector(getColorNegroCss);
    	By celeste= By.cssSelector(colorCelesteCss);
    	By nombreCeleste=By.cssSelector(colorCelesteCss);
    	
    	
    	//Driver
    	
    	WebDriver driver;
    	
  //Constructor
    	    
    	  public CompanyPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
         public void goToDatosGenerales(){
        	 Reporter.log("Abriendo la pagina de Datos de la Compania");
        	 driver.findElement(By.cssSelector(datosGenerales)).click();
         }
         
         public void irADesign(){
        	 Reporter.log("Abriendo la pagina de diseño de la plataforma" );
        	 driver.findElement(By.cssSelector(design)).click();
         }
    	    
         public void setNombreCompania(String nombre){
        	 Reporter.log("Insertando nombre de la compania");
        	 driver.findElement(By.cssSelector(nombreCompania)).clear();
        	 driver.findElement(By.cssSelector(nombreCompania)).sendKeys(nombre);
         }
         
         public void verifyNombreCantBeBlank(){
        	     this.setNombreCompania("                  ");	
        	 String companyMessage = new String (driver.findElement(error).getText());
        	 		Reporter.log(companyMessage);
        	 	Assert.assertEquals(companyMessage, "El campo es requerido");	 
         }
         
         
         public void setIdioma(){
     		
        	 // Select all values the drop-down for Language
        	 		Reporter.log(" Verificar el drop-down de lenguajes");
        	 		Select selectLanguage = new Select(driver.findElement(By.cssSelector(selectIdioma))); 
        	 		
        	 		selectLanguage.selectByValue("pt");
        	 		selectLanguage.selectByValue("en");	
        	 		selectLanguage.selectByValue("es");
         }
      
         public void setTimezone(){
        	//Select a value from drop-down Timezone
      		Reporter.log(" Verificar el drop-down de timezone ");
      		Select selectTimeZone = new Select(driver.findElement(By.cssSelector(selectTimezone)));
     		
     		   for(int i=1; i<5; i++){
     	           selectTimeZone.selectByIndex(i);  
     			 }
     		
     		selectTimeZone.selectByValue("America/Anchorage");

         }
    	  
         public void restablecerInterfaz() throws InterruptedException{
        	
        	 //Restablecer interfaz   
        	
       	 driver.findElement(goToRestablecerInterfaz).click(); 
       	 System.out.println("Clickeo en restablecer Interfaz");
       	 WebDriverWait wait = new WebDriverWait(driver, 15);
       	 wait.until(ExpectedConditions.elementToBeClickable(okRestablecerInterfaz));
       //	 wait.until(ExpectedConditions.elementToBeClickable(okRestablecerInterfaz));
       	 System.out.println("Wait until confirmar es clickeable");
       	Thread.sleep(3000);
            //Click en el popup de restorear
         driver.findElement(okRestablecerInterfaz).click();
         wait.until(ExpectedConditions.elementToBeClickable(guardarCambios));
           Thread.sleep(4000);
             
         }
   
      public void verifyColors(){
    	// Verify list of colors in branding
          Reporter.log(" Veirificando que esten todos los colores disponibles");

Assert.assertEquals("white",(driver.findElement(By.cssSelector(colorPlataformaBlanco)).getText()));

Assert.assertEquals("red",(driver.findElement(By.cssSelector(colorPlataformaRojo)).getText()));

Assert.assertEquals("lightgrey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(2)")).getText()));

Assert.assertEquals("grey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(3)")).getText()));

Assert.assertEquals("darkgrey",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(4)")).getText()));

Assert.assertEquals("black",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(5)")).getText()));

Assert.assertEquals("yellow",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(6)")).getText()));

Assert.assertEquals("orange",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(7)")).getText()));



Assert.assertEquals("green",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(9)")).getText()));

Assert.assertEquals("skyblue",(driver.findElement(By.cssSelector(".design .colorpicker li:nth-child(10)")).getText()));
      }
    
     
      
      
      public void changeColorHeader() throws InterruptedException{
    		//Change header color
  		
      	
          // Clickeo en Disenio
       Reporter.log(" Cambiando el color del header");
         
         
       
	 // Verify that the selected color has been changed in the header
       
          Reporter.log(" Verificando que el color del header se haya cambiado");
          
       //Select skyblue colour
          driver.findElement(celeste).click();
       
     String colorSelected =driver.findElement(nombreCeleste).getCssValue("background-color");
     Reporter.log(colorSelected);
      
     String colorHeader = new String(driver.findElement(By.tagName("header")).getCssValue("background-color"));
     Reporter.log(colorHeader);
  
     //Compare the header color against the selected, converted to hexadecimal
     
   Reporter.log("El color seleccionado en branding se muestra correctamente en el header");
    Assert.assertEquals(colorSelected, colorHeader, "El color seleccionado en branding se muestra correctamente en el header" );
       
             
      }
      
     
      
      
      public void changeColorContrast() throws InterruptedException{
    		// Change Contrast Color(){
  		
    	     Reporter.log(" Cambiando el color del contraste ");
    	      	       	        
    	        
    		 // Verify that the selected color has been changed in the header
    	        
    	        //Select black color for letters
    	      driver.findElement(colorNegroContraste).click();
    	      String colorSelectedIs=driver.findElement(getColorNegro).getCssValue("backgorund-color");
    	      Reporter.log("El color seleccionado para la letra es :" );
    	      Reporter.log(colorSelectedIs);    	       
    	      Thread.sleep(3000);
    	      String colorHeaderIs = driver.findElement(header).getCssValue("color");
    	      Reporter.log("El color que esta en la letra en el header es :");
    	      Reporter.log(colorHeaderIs);
    	       	     
    	      //Compare the header color against the selected, converted to hexadecimal
    	        	  
    	     Assert.assertEquals(colorSelectedIs, colorHeaderIs, "El color seleccionado de contraste de texto se muestra correctamente en el header" );
    	     Reporter.log(" El caso de branding-colors finalizo correctamente");       
      }
      }
  
    
    

