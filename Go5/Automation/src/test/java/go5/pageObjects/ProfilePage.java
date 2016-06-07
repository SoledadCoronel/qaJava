package go5.pageObjects;



import go5.automation.TestSuite;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;


    
    
    public class ProfilePage extends TestSuite{

    	//Css
    	
    	
		    		protected String irAProfile = ".subusers li:nth-child(2) a";
		    		protected String editFoto = "#photoFileDrop";
		     	 	protected String editarProfile=".data h2 a";
		    	   	protected String agrandarForm = ".addpeople fieldset:nth-child(2) .secondary";
		    	   	protected String grabarUser = ".container .addpeople .primary";    	    	    	
		    	   	protected String reportaA =".labordata label:nth-child(6) input";
		    	   	protected String idEmpleado = ".labordata label:nth-child(2) input";
		           	protected String fechaIngreso = ".labordata label:nth-child(3) input";    	
		           	protected String tipoEmpleo = ".labordata label:nth-child(4) select ";    	
		           	protected String telefonoFIjo = ".labordata label:nth-child(7) input";
		           	protected String telefonoMovil= ".labordata label:nth-child(8) input";	
		           	protected String numeroDocumento = ".personaldata label:nth-child(3) input";
		           	protected String fechaNacimiento =".personaldata label:nth-child(4) input";
    	           protected String emailProfile = ".personaldata label:nth-child(7) input";
    	           protected String direccionProfile = ".personaldata label:nth-child(10) input";
    	           protected String linkedin= ".socialdata label:nth-child(2) input";
    	           protected String twitter = ".socialdata label:nth-child(3) input";
    	           protected String facebook= ".socialdata label:nth-child(4) input";
    	          private String linkSupervisor = ".data p:nth-child(5) a ";
    	          private String emailUser= ".data address p:first-child a";
    	          private String miEmail= "marina.touceda@gointegro.com";
    	          private String telefonoMovilHeader =".data address p:nth-child(2) strong";
    	          private String telefonoFijoHeader = ".data address p:last-child strong";
    	          private String confirmar = ".active .primary";
    	          private String cancelar =".active .optional";
    	          private String inputFotoProfile ="sarasa";
    	          private String selectPictureOrCamera=".igocamera a";
    	          SoftAssert sa= new SoftAssert();
    	           WebDriver driver;
    	           
    	           
    	 Random numero= new Random();
     
  //Constructor
    	    
    	  public ProfilePage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
         
    	    
    	  public  String cssLink (String url)  {
			 
    		  String css = "a[href^="+ (url)+"]";
			   return css
					   ;
    	  }
    	  
    	//  a[href^="http://twitter.com/username"]
    	     	  
    	  public void goToTwitter(){
				
  			String css= this.cssLink("\"http://twitter.com/username\"");
  			  			
  			//  driver.findElement(By.cssSelector(css)).click();
  			  Reporter.log("Verificando link de twiter");
  			 Reporter.log("El link cargado de twitter es :");
  			 Reporter.log( driver.findElement(By.cssSelector(css)).getText());
  			
  			
  	            
    	  }
    	
    	  public void goToFacebook(){
    		  String css =this.cssLink("\"http://facebook.com/username\"");
    		//  driver.findElement(By.cssSelector(css)).click();
    		  
    		  Reporter.log("Verificando link de facebook");
    		  Reporter.log("El link cargado de facebook es :");
    		  Reporter.log( driver.findElement(By.cssSelector(css)).getText());
    		  
    	  }
    	  public void goToProfile(){
    	  Reporter.log("Ir a Profile");
    	  driver.findElement(By.cssSelector(".subusers li:nth-child(2) a")).click();
       	    }
    
      
      public void editarProfile(){
    	  Reporter.log("Editar perfil");
          	  driver.findElement(By.cssSelector(editarProfile)).click();
      }
		
      public void agrandarForm(){
    	  Reporter.log("Agrandar Form");
          	  driver.findElement(By.cssSelector(agrandarForm)).click();
      }
	
      
	        
      public void grabarUsuario (){
    	  Reporter.log("Grabando el profile");
    	  driver.findElement(By.cssSelector(grabarUser)).click();
    	  
      }
   public void goToProfileSideBar() throws InterruptedException{
   
 
      // Go to the user menu
   Reporter.log("Ir a Perfil Desde el sidebar");	
  Thread.sleep(1000);
   driver.findElement(By.cssSelector(".igouser")).click();
   }
   
   public void goToSupervisor() {
	   
	   	      // Go to the user menu
	   Reporter.log("Ir a Perfil del supervisor desde el profile del user");	
		   driver.findElement(By.cssSelector(linkSupervisor)).click();
	   }
   
   public void agregarDatosLaborales(){
		//Insertar datos laborales
		Reporter.log("Editando datos laborales");
		
		 driver.findElement(By.cssSelector(idEmpleado)).clear();
	    driver.findElement(By.cssSelector(idEmpleado)).sendKeys("RandomId" + numero.nextInt());
	         
        driver.findElement(By.cssSelector(fechaIngreso )).sendKeys("10/10/10");
        driver.findElement(By.cssSelector(tipoEmpleo)).click();
        driver.findElement(By.cssSelector(tipoEmpleo)).sendKeys("part-time");
       
   }
	
			public void agregarTelefono(){
			
		     //Telefono
				Reporter.log("Editando telefono");
				driver.findElement(By.cssSelector(telefonoFIjo)).clear();
				driver.findElement(By.cssSelector(telefonoFIjo)).sendKeys("+541147511234");
	    
	          // driver.findElement(By.cssSelector(".labordata label:nth-child(7) input")).sendKeys("+541147511234");
	          driver.findElement(By.cssSelector(telefonoMovil)).clear();
	          driver.findElement(By.cssSelector(telefonoMovil)).sendKeys("+541147511234");
			}
    
   
			public void agregarDatosPersonales(){
    	//Datos Personales
         
         Reporter.log("Editando datos personales");
           driver.findElement(By.cssSelector(".personaldata label:nth-child(2) select")).sendKeys("RUT");
           driver.findElement(By.cssSelector(numeroDocumento)).clear();
           driver.findElement(By.cssSelector(numeroDocumento)).sendKeys("asasddsdsadsads");
           driver.findElement(By.cssSelector(fechaNacimiento)).sendKeys("11/11/11");
           driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).click();
           driver.findElement(By.cssSelector(".personaldata label:nth-child(5) select")).sendKeys("female");
           driver.findElement(By.cssSelector(".personaldata label:nth-child(6) select")).sendKeys("single");
           driver.findElement(By.cssSelector(".personaldata label:nth-child(7) input")).clear();
           driver.findElement(By.cssSelector(emailProfile)).sendKeys("fakee5555mail@gointegro.com");
       //    driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).clear();
          // driver.findElement(By.cssSelector(".personaldata label:nth-child(8) input")).sendKeys("+541147511234");
         //  driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).clear();
         //  driver.findElement(By.cssSelector(".personaldata label:nth-child(9) input")).sendKeys("+541147511234");
           driver.findElement(By.cssSelector(direccionProfile)).clear();
           driver.findElement(By.cssSelector(direccionProfile)).sendKeys("Mi Casa 123");
           
     }
    
     public void agregarRedesSociales(){
    	
         Reporter.log("Editando redes  sociables");
         
         driver.findElement(By.cssSelector(linkedin)).clear();
       driver.findElement(By.cssSelector(linkedin)).sendKeys("http://linkedin.com/in/username" );
              
     
         driver.findElement(By.cssSelector(twitter)).clear();
              driver.findElement(By.cssSelector(twitter)).sendKeys("http://twitter.com/username");
              
        driver.findElement(By.cssSelector(facebook)).clear();
      driver.findElement(By.cssSelector(facebook)).sendKeys("http://facebook.com/username"); 
     }
    
    public void cancelarSubirFoto() throws InterruptedException{
    	
    	
    	 js=  (JavascriptExecutor) driver;
    	 driver.findElement(By.cssSelector(selectPictureOrCamera)).click();
    	   WebElement element = driver.findElement(By.id("sarasa"));
		  js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);
	          
	      //Agarrar el elemento para cargar el file y pasarle el path 
	       
	        WebElement subirFile = driver.findElement(By.id("sarasa"));
	               
	        File file= new File("src/test/resources/Girasol.jpeg");
	        subirFile.sendKeys(file.getAbsolutePath());
	        Thread.sleep(2000);
	        driver.findElement(By.cssSelector(confirmar)).click();
		   
		    Reporter.log(" El subir foto ha sido cancelado");
    
    }
    	
   
     
     public void cargarFoto() throws InterruptedException {
    	
    	 js=  (JavascriptExecutor) driver;
    	  ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
    	 driver.findElement(By.cssSelector(selectPictureOrCamera)).click();
    	   WebElement element = driver.findElement(By.id("sarasa"));
		  js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);
	          
	      //Agarrar el elemento para cargar el file y pasarle el path 
	       
	        WebElement subirFile = driver.findElement(By.id("sarasa"));
	               
	        File file= new File("src/test/resources/Girasol.jpeg");
	        subirFile.sendKeys(file.getAbsolutePath());
	        Thread.sleep(2000);
	        driver.findElement(By.cssSelector(confirmar)).click();
		    Reporter.log(" Foto cargada exitosamente");
    }
    
    
    public void verifyemaildisplayedAtHeader(){
    	
    	Reporter.log("El email q se muestra es :");	
  	
    	Assert.assertEquals(miEmail, driver.findElement(By.cssSelector(emailUser)).getText());
  	
  	Reporter.log(miEmail);
    }
    
    
    public void verifyPhonesDisplayedAtHeader(){
    	
    	driver.findElement(By.cssSelector(telefonoFijoHeader)).isDisplayed();
    	driver.findElement(By.cssSelector(telefonoMovilHeader)).isDisplayed();
    	Reporter.log("Los telefonos fijos y moviles se muestran en los datos del profile");
    }
  
  
    }
    
    
    