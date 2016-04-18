package go5.pageObjects;



import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


    
    
    public class ProfilePage {

    	//Css
    	
    	
		    		protected String irAProfile = new String (".applications .users .subusers li a[title='Ir a ver perfil']");
		     	 	protected String editarProfile= new String (".data h2 a");
		    	   	protected String agrandarForm = new String (".addpeople fieldset:nth-child(2) .secondary");
		    	   	protected String grabarUser = new String (".container .addpeople .primary");    	    	    	
		    	   	protected String reportaA = new String (".labordata label:nth-child(6) input");
		    	   	protected String idEmpleado = new String (".labordata label:nth-child(2) input");
		           	protected String fechaIngreso = new String (".labordata label:nth-child(3) input");    	
		           	protected String tipoEmpleo = new String (".labordata label:nth-child(4) select ");    	
		           	protected String telefonoFIjo = new String (".labordata label:nth-child(7) input");
		           	protected String telefonoMovil= new String (".labordata label:nth-child(8) input");	
		           	protected String numeroDocumento = new String (".personaldata label:nth-child(3) input");
		           	protected String fechaNacimiento = new String (".personaldata label:nth-child(4) input");
    	           protected String emailProfile = new String (".personaldata label:nth-child(7) input");
    	           protected String direccionProfile = new String (".personaldata label:nth-child(10) input");
    	           protected String irACerrarSesion= new String ("a[title='Cierra la sesión");
    	           protected String linkedin= new String (".socialdata label:nth-child(2) input");
    	           protected String twitter = new String (".socialdata label:nth-child(3) input");
    	           protected String facebook= new String (".socialdata label:nth-child(4) input");
    	
    	           WebDriver driver;
    	 Random numero= new Random();
     
  //Constructor
    	    
    	  public ProfilePage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
          	    
    	   
    	 
    	    
      public void goToProfiles(){
    	  Reporter.log("Ir a Profile");
       	  driver.findElement(By.cssSelector(irAProfile)).click();
    	    }
    
      
      public void editarProfile(){
    	  Reporter.log("Editar perfil");
          	  driver.findElement(By.cssSelector(editarProfile)).click();
      }
		
      public void agrandarForm(){
    	  Reporter.log("Agrandar Forml");
          	  driver.findElement(By.cssSelector(editarProfile)).click();
      }
	
      
	        
      public void grabarUsuario (){
    	  Reporter.log("Grabando el profile");
    	  driver.findElement(By.cssSelector(grabarUser)).click();
    	  
      }
   public void goToProfileSideBar(){
   
 
      // Go to the user menu
   Reporter.log("Ir a Perfil Desde el sidebar");	
   
   driver.findElement(By.cssSelector(".igouser")).click();
   }
   
   
   public void editarDatosLaborales(){
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
    }
    
    
    