package go5.pageObjects;




import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


    
    
    public class EspacioPage extends TestSuite{

    	
    	 //Go To Spaces
        protected String goToEspaciosCss = ".igospaces a";
        protected String goToRecomendadosCss=".title menu li:first-child a";
    	
        //Css Define Space
    	
    	private String crearEspacioCss = ".igospaces a";
    	private String nombreEspacioCss =".first label:nth-child(1) input";
    	private String descripcionEspacioCss=".first label:nth-child(2) input";
    	
    	//Space type
    	private String espacioPublicoCss = ".type label:nth-child(3) input";
    	private String espacioPrivadoCss = ".type label:nth-child(4) input";
    	private String espacioEmpresaCss = ".type label:nth-child(2) input";    	  
    	private String activarEspacioCss =  ".config label:nth-child(2) .active";
    	private String activadadSocialCss = ".config label:nth-child(3) span";
    	
    	//Icons
    	
    	private String cambiarIconoCss = ".igopuzzle";
    	private String iconoOsoCss= ".igospacebear";
    	private String iconoBasketCss= ".igospacebasket";
    	private String iconoBananaCss= ".igospacebanana";
    	private String grabarIconoCss=".active .mconfirmation .primary";
    
      
    	//Save Space
    	
       	protected String grabarEspacioCss=".spacecreate .primary";
       	protected String grabarEspacioEmpresaInactivoCss=".active .mconfirmation .optional";
    	
       	//Order
       
    	protected String ordenNombre = new String (".tables thead tr th:nth-child(2) a");
    	protected String ordenDescripcion = new String (".tables thead tr th:nth-child(3) a");
    	protected String ordenMiembros = new String (".tables thead tr th:nth-child(4) a");
    	
    	
    	protected String ordenTitulo = ".igocaretdown";
    	
       //   	
    	protected String editfourthRow= new String(".tables tbody tr:nth-child(4) td:nth-child(5) a"); 
    	protected String firstType= ".tables  tr:nth-child(1) td:nth-child(3)";
    	protected String firstSpace = ".tables tbody tr:nth-child(1) td:nth-child(2) a";
    	protected String firstState = ".tables tbody tr:nth-child(1) td:nth-child(5) a";
    	protected  String firstName = ".tables tbody tr:nth-child(1) td:nth-child(2) a";
    	protected String secondName = ".tables tbody tr:nth-child(2) td:nth-child(2) a";
        
    	//Search Spaces
    	protected String buscarEspacio= ".actions .btnsearch";
        protected String inputSearch =".actions .search input";
        
       
      // By 
        By goToEspacios=By.cssSelector(goToEspaciosCss);
        By goToRecomendados= By.cssSelector(goToRecomendadosCss);
        By crearEspacio=By.cssSelector(crearEspacioCss);
        By nombreDeEspacio=By.cssSelector(nombreEspacioCss);
        By descripcionEspacio=By.cssSelector(descripcionEspacioCss);
        
      //Space type
        
        By espacioPublico = By.cssSelector(espacioPublicoCss);
    	By espacioPrivado = By.cssSelector(espacioPrivadoCss);
    	By espacioEmpresa = By.cssSelector(espacioEmpresaCss);    	  
    	By activarEspacio = By.cssSelector(activarEspacioCss);
    	By activadadSocial= By.cssSelector(activadadSocialCss);
        
    	
    	
    	//Icons
    	
    	By cambiarIcono = By.cssSelector(cambiarIconoCss);
    	By grabarIcono=By.cssSelector(grabarIconoCss);
    	
    	
    	//Save Space
    	 
    	By grabarEspacio=By.cssSelector(grabarEspacioCss);
    	By grabarEspacioEmpresaInactivo= By.cssSelector(grabarEspacioEmpresaInactivoCss);
    	
    	//Driver
    	
    	WebDriver driver;
    
     
  //Constructor
    	    
    	  public EspacioPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
    	  public void goToEspacios(){
    		  driver.findElement(goToEspacios).click();
    		  //Wait until recomendados appear
    		   WebDriverWait wait = new WebDriverWait(driver, 10);
    		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(goToRecomendados));
    		  
    	  }
    	  
    	    
         public void crearEspacio(){
        	 driver.findElement(crearEspacio).click();
        	
         }
    	    
    	    public void setNameEspacio(String name){
    	    	driver.findElement(nombreDeEspacio).clear();
    	    	driver.findElement(nombreDeEspacio).sendKeys(name);
    	    	   	    
    	    }
    	    
    	   
    	    public void setDescriptionEspacio(String description){
    	    	
    	    	driver.findElement(descripcionEspacio).sendKeys(description);
    	    }
    	    
  
    	    public void setEspacioPublico () throws Exception{
    	   	 Reporter.log("Seleccionando un tipo de espacio Publico:");
    	   	driver.findElement(espacioPublico).click();
    	   	 }
    	    
    	    public void setEspacioEmpresa () throws Exception{
       	   	 Reporter.log("Seleccionando un tipo de espacio Empresa:");
       	   		driver.findElement(espacioEmpresa).click();
       	   	 }
    	  
    	    public void setEspacioPrivado () throws Exception{
          	   	 Reporter.log("Seleccionando un tipo de espacio Privado:");
          	   	driver.findElement(espacioPrivado).click();
          	   	 }
  
    	       
      
       public void activarEspacio(){
    	   Reporter.log("Clickear Espacio activo");
    	   driver.findElement(activarEspacio).click();
       }
   
       public void activarActividadSocial(){
    	   Reporter.log("Clickear Actividad Social");
    	   driver.findElement(activadadSocial).click();
       }
        
       public void cambiarIcono(String icono) throws InterruptedException{
    	
    	   Reporter.log("Seleccionar Icono");
    	   driver.findElement(cambiarIcono).click();
    	   this.clickWhenReady(grabarIcono, 10);
    	    	   
    	       }
          
      public void grabarEspacio(){
    	  Reporter.log("Grabando espacio");
    	  driver.findElement(grabarEspacio).click();
      }

      public void grabarEspacioEmpresaInactivo(){
    	driver.findElement(grabarEspacioEmpresaInactivo).click(); 
      }
	
      
      
      public void editarEspacio() {
		 //Agarro el cuarto elemento de la lista y lo tomo para editarlo 
		
		driver.findElement(By.cssSelector(editfourthRow)).click();
	}
	
			
		public void ordenarPorNombreEspacio() throws InterruptedException{
			driver.findElement(By.cssSelector(ordenNombre)).click();
			
						Reporter.log("El primer nombre de la tabla es :");				
			Reporter.log(driver.findElement(By.cssSelector(firstName)).getText());
			Reporter.log("El segundo nombre de la tabla es :");
			Reporter.log(driver.findElement(By.cssSelector(secondName)).getText());
			verificarOrden();
		}
	
		
		public void ordenarPorEstado() throws InterruptedException{
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
	       	     
	    public void cambiarIconoBanana() throws InterruptedException{
	    	
	    	cambiarIcono(iconoBananaCss);
	    }
	     
	    public void cambiarIconoOso() throws InterruptedException{
	    	cambiarIcono(iconoOsoCss);
	    	    }
	     
	    public void cambiarIconoBasket() throws InterruptedException{
	    	cambiarIcono(iconoBasketCss);
	    }
	  
	    public  void verificarOrden(){
	    	 
	    	 
	        if (this.getFirstNameSpace().compareTo(this.getSecondName())<0)
	    	             
	       Reporter.log("Los espacios estan ordenados alfabeticamente por orden ascendente( de la A la Z,");
	       else 
	       	Reporter.log("La pagina esta ordenada alfabeticamente por orden descencdente ( de la Z a la A " );
    }

		public void buscarEspacio(String espacio) {
			
			Reporter.log("Buscar un espacio en el listado de Espacios");
			driver.findElement(By.cssSelector(buscarEspacio)).click();
			driver.findElement(By.cssSelector(inputSearch)).clear();
			driver.findElement(By.cssSelector(inputSearch)).sendKeys(espacio);
			driver.findElement(By.cssSelector(inputSearch)).sendKeys(Keys.ENTER);
			Reporter.log(" El nombre a buscar es :..");
			Reporter.log(espacio);
			Reporter.log("El nombre encontrado es ..");
			Reporter.log(driver.findElement(By.cssSelector(firstSpace)).getText());
			
		}
		
		public void clickEspacioSidebar(String iconoEspacio) {
			
		
		Reporter.log("Clickear un espacio pasandole el icono");
			driver.findElement(By.cssSelector(iconoEspacio)).click();
			    
    }
    }
