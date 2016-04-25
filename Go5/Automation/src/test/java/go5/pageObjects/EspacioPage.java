package go5.pageObjects;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;


    
    
    public class EspacioPage {

    	//Css
    	
    	private String crearEspacio = new String (".title .primary");
    	private String espacioPublico = new String (".spaceformtype .igounlock");
    	private String espacioPrivado = new String (".spaceformtype .igolock");
    	private String espacioEmpresa = new String (".spaceformtype .igocompany");
    	private String nombreEspacio = new String (".spacecreate fieldset:nth-child(1) label:nth-child(1) input");
    	private String descripcionEspacio= new String (".spacecreate fieldset:nth-child(1) label:nth-child(2) input");
    	private String activarEspacio = new String (".spaceformconfig label:nth-child(2) span");
    	private String activadadSocial = new String (".spaceformconfig label:nth-child(3) span");
    	private String cambiarIcono = new String (".igospaceadmin");
    	
    	//private String confirmarIcono = new String ("active .mconfirmation .primary");
    	protected String irASpaces = new String ("nav div:nth-child(4) li:nth-child(1) a");
   
    	protected String grabarEspacio= new String (".spacecreate .primary");
    	protected String ordenTipo = new String (".tables thead tr th:nth-child(1) a");
    	protected String ordenNombre = new String (".tables thead tr th:nth-child(2) a");
    	protected String ordenDescripcion = new String (".tables thead tr th:nth-child(3) a");
    	protected String ordenMiembros = new String (".tables thead tr th:nth-child(4) a");
    	protected String ordenEstado = new String (".tables thead tr th:nth-child(5) a");
    	protected String ordenTitulo = new String (".tables thead tr th:nth-child(3) a");
    	
    	protected String editfourthRow= new String(".tables tbody tr:nth-child(4) td:nth-child(5) a"); 
    	protected String firstType= new String(".tables tbody tr:nth-child(1) td:nth-child(1)");
    	protected String firstSpace = new String (".tables tbody tr:nth-child(1) td:nth-child(2) a");
    	protected String firstState = new String (".tables tbody tr:nth-child(1) td:nth-child(5) a");
    	protected  String firstName = new String (".tables tbody tr:nth-child(1) td:nth-child(2) a");
    	protected String secondName = new String(".tables tbody tr:nth-child(2) td:nth-child(2) a");
    	
    	WebDriver driver;
    
     
  //Constructor
    	    
    	  public EspacioPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
         public void crearEspacio(){
        	 driver.findElement(By.cssSelector(crearEspacio)).click();
         }
    	    
    	    public void setNameEspacio(String name){
    	    	driver.findElement(By.cssSelector(nombreEspacio)).clear();
    	    	driver.findElement(By.cssSelector(nombreEspacio)).sendKeys(name);
    	    }
    	    
    	   
    	    public void setDescriptionEspacio(){
    	    	
    	    	driver.findElement(By.cssSelector(descripcionEspacio)).sendKeys("Descripcion Del Espacio");
    	    }
    	    
  
    	    public void setEspacioPublico () throws Exception{
    	   	 Reporter.log("Seleccionando un tipo de espacio Publico:");
    	   	driver.findElement(By.cssSelector(espacioPublico)).click();
    	   	 }
    	    
    	    public void setEspacioEmpresa () throws Exception{
       	   	 Reporter.log("Seleccionando un tipo de espacio Publico:");
       	   	driver.findElement(By.cssSelector(espacioEmpresa)).click();
       	   	 }
    	  
    	    public void setEspacioPrivado () throws Exception{
          	   	 Reporter.log("Seleccionando un tipo de espacio Publico:");
          	   	driver.findElement(By.cssSelector(espacioPrivado)).click();
          	   	 }
  
    	    
      public void goToEspacios(){
    	  driver.findElement(By.cssSelector(irASpaces)).click();
    	    }
    
      
       public void activarEspacio(){
    	   driver.findElement(By.cssSelector(activarEspacio)).click();
       }
   
       public void activarActividadSocial(){
    	   driver.findElement(By.cssSelector(activadadSocial)).click();
       }
        
       public void cambiarIcono() throws InterruptedException{
    	
    	   driver.findElement(By.cssSelector(cambiarIcono)).click();
    	
	          driver.findElement(By.cssSelector(".igospacetool")).click();
	          Thread.sleep(1000);
	         driver.findElement(By.cssSelector(".active .mconfirmation .primary")).click();
    	   
    	  /* 
    	   driver.findElement(By.cssSelector(cambiarIcono)).click();
    	   driver.findElement(By.cssSelector(iconoEye)).click();
    	   driver.findElement(By.cssSelector(confirmarIcono)).click();
       */
       }
       
       public void cambiarIconoUmbrella() throws InterruptedException{
	       
    	   driver.findElement(By.cssSelector(cambiarIcono)).click();
	          driver.findElement(By.cssSelector(".igospaceumbrella")).click();
	          Thread.sleep(1000);
	         driver.findElement(By.cssSelector(".active .mconfirmation .primary")).click();
       }
      public void grabarEspacio(){
    	  driver.findElement(By.cssSelector(grabarEspacio)).click();
      }

      public void grabarEspacioEmpresaInactivo(){
    	  driver.findElement(By.cssSelector(".active .mconfirmation .optional")).click();
      }
	public void editarEspacio() {
		 //Agarro el cuarto elemento de la lista y lo tomo para editarlo 
		
		driver.findElement(By.cssSelector(editfourthRow)).click();
	}
	
		public void ordenarPorTipo(){
			driver.findElement(By.cssSelector(ordenTipo)).click();
			driver.findElement(By.cssSelector(ordenTipo)).click();
			Reporter.log("El primer valor del tipo de espacio es:");				
			Reporter.log(this.getTypeFirstRow());
						
		}
	
		public void ordenarPorNombreEspacio(){
			driver.findElement(By.cssSelector(ordenNombre)).click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Reporter.log("El primer nombre de la tabla es :");				
			Reporter.log(driver.findElement(By.cssSelector(firstName)).getText());
			Reporter.log("El segundo nombre de la tabla es :");
			Reporter.log(driver.findElement(By.cssSelector(secondName)).getText());
			verificarOrden();
		}
	
		
		public void ordenarPorEstado(){
			driver.findElement(By.cssSelector(ordenEstado)).click();
			Reporter.log("El valor del primer estado es :");
			Reporter.log(driver.findElement(By.cssSelector(firstState)).getText());
		}
    
		

		public String getTypeFirstRow() {
			//Ver q el primero de la lista sea tipo empresa
		 return (driver.findElement(By.cssSelector(firstType)).getText());
			
		}

		public void verificarOrdenDefault() {
		
			Reporter.log("Verificar que el primer tipo de espacio es de empresa");
			Assert.assertEquals(this.getTypeFirstRow(),"company","El primero es empresa");
			Reporter.log("El valor del tipo de espacio es:");				
			Reporter.log(this.getTypeFirstRow());
		
		}
	
		 public   String getFirstNameSpace(){
	         
	    	
			return driver.findElement(By.cssSelector(firstName)).getText();
	     }
	   
	    
	     
	     public  String  getSecondName(){
	         
	   	  return driver.findElement(By.cssSelector(secondName)).getText();
	    }
	       	     
	    
	     public  void verificarOrden(){
	    	 
	    	 
	        if (this.getFirstNameSpace().compareTo(this.getSecondName())<0)
	    	             
	       Reporter.log("Los espacios estan ordenados alfabeticamente por orden ascendente( de la A la Z,");
	       else 
	       	Reporter.log("La pagina esta ordenada alfabeticamente por orden descencdente ( de la Z a la A " );
    }
    
    }

