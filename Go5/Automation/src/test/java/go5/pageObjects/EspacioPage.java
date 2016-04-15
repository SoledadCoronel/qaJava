package go5.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    	private String activarSocial = new String (".spaceformconfig label:nth-child(3) span");
    	private String cambiarIcono = new String ("spaceformconfig label:nth-child(4) .igotrophy");
    	private String iconoEye = new String (".igoeye");
    	private String confirmarIcono = new String ("active .mconfirmation .primary");
    	protected String irASpaces = new String ("nav div:nth-child(4) li:nth-child(1) a");
    //	protected String irASpaces = new String ("a[title='Ir a listar espacios']");
    	protected String grabarEspacio= new String (".spacecreate .primary");
    	protected String ordenTipo = new String (".tables thead tr th:nth-child(1) a");
    	protected String ordenNombre = new String (".tables thead tr th:nth-child(2) a");
    	protected String ordenDescripcion = new String (".tables thead tr th:nth-child(3) a");
    	protected String ordenMiembros = new String (".tables thead tr th:nth-child(4) a");
    	protected String ordenEstado = new String (".tables thead tr th:nth-child(5) a");
    	protected String ordenTitulo = new String (".tables thead tr th:nth-child(3) a");
    	protected String ordenRol = new String (".tables thead tr th:nth-child(4) a");
    	protected String ordenRegistrado = new String (".tables thead tr th:nth-child(6) a");	
    	protected String editfourthRow= new String(".tables tbody tr:nth-child(4) td:nth-child(5) a"); 
    	protected String firstType= new String(".tables tbody tr:nth-child(1) td:nth-child(1)");
    	
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
   
       public void activarSocial(){
    	   driver.findElement(By.cssSelector(activarSocial)).click();
       }
    
       public void cambiarIcono(){
    	       
    	   driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(4) .igotrophy")).click();
	          driver.findElement(By.cssSelector(".igoeye")).click();
	         driver.findElement(By.cssSelector(".active .mconfirmation .primary")).click();
    	   
    	  /* 
    	   driver.findElement(By.cssSelector(cambiarIcono)).click();
    	   driver.findElement(By.cssSelector(iconoEye)).click();
    	   driver.findElement(By.cssSelector(confirmarIcono)).click();
       */
       }
       
       public void cambiarIconoPhone(){
	       
    	   driver.findElement(By.cssSelector(".spaceformconfig label:nth-child(4) .igotrophy")).click();
	          driver.findElement(By.cssSelector(".igophone")).click();
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
		}
	
		public void ordenarPorNombre(){
			driver.findElement(By.cssSelector(ordenNombre)).click();
		}
		public void ordenarPorRol(){
			driver.findElement(By.cssSelector(ordenRol)).click();
		}
		public void ordenarPorEstado(){
			driver.findElement(By.cssSelector(ordenEstado)).click();
		}
    
		public void ordenarPorRegistrado(){
			driver.findElement(By.cssSelector(ordenRegistrado)).click();
		}

		public void verificarOrdenDefault() {
			//Ver q el primero de la lista sea tipo empresa
		System.out.println(driver.findElement(By.cssSelector(firstType)).getClass());
			
		}
    }
    
    

