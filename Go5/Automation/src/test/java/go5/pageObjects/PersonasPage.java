package go5.pageObjects;


import java.util.List;

import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


  
    
    
    public class PersonasPage extends TestSuite {

    	//Css
    	
    	protected String irAPersonas= new String(".igoadmin");
    	
    	protected  String inputNombreUser= new String(".basicdata label:nth-child(4) input");
    	protected  String inputLastnameUser=new String (".basicdata label:nth-child(5) input");
    	protected  String inputemailUser =new String ("basicdata label:nth-child(6) input");
    	protected  String tablaPersonas = new String (".tablefilter tbody");
    	protected  String crearUser = new String (".content .title a");
    	protected  String estadoDesactivado = new String (".basicdata label:nth-child(2) input:nth-child(2)");
    	protected String  desplegarCampos = new String (".addpeople .secondary");
    	protected String  savePerson = new String (".container .addpeople .primary");   	
    	 protected String editfirstRow= new String (".tables tbody tr:nth-child(1) td:nth-child(7) a");
    	protected  String irAPagina= new String("a[title='Ir a la página 4']");
    	protected	String searchButton = new String(".actions .search .btnsearch");
    	protected	String inputSearch = new String(".actions .search input");
    	protected	String orden =new String (".tables thead tr th:nth-child(2) a");
    	protected	 String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
    	protected	 String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
    	 
    	  WebDriver driver;
    
     
  
    	    public PersonasPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
    	   
    	    public void goToPersonas() throws Exception{
    	    	WebElement personasavailable = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(irAPersonas)));
    	    	this.click(irAPersonas);
			}
    	    
    	    
    	    public void setRandomUserName() throws Exception{
        	  this.sendValue(inputNombreUser, name);
       	    }
  
    	    public void setRandomLastName() throws Exception{
    	       	this.sendValue(inputLastnameUser, name);
    	        }
    	    
    	    public void setRandomEmail() throws Exception{
    	       	 this.sendValue(inputemailUser, email);
    	     	    }
    
    	       	   
    	   
    	    public void setEstadoDesactivado() throws Exception{
      	    	this.click(estadoDesactivado);
      	    	    }
       
    	  public void contarPersonasTabla(){
    	    //Hay que modificarla....
    	    // Obtener la cantidad de usuarios antes de agregar user
	         
            
	         WebElement htmltable=driver.findElement(By.cssSelector(tablaPersonas));

	        List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	         Reporter.log("La cantidad de usuarios en la tabla es:",rows.size());
    
    	  }
    
        
    	  public void editPersonaenListadoPersonas() throws Exception{
    		  Thread.sleep(1000);
    		 
    	    	 this.click(editfirstRow);
    	    	 Thread.sleep(1000);
    	    	 this.click(desplegarCampos);
    	    	 Thread.sleep(1000);
    	    	 this.click(savePerson);
    	  }
    	  
    	  public void agregarPersona() throws Exception{
   
            this.click(crearUser);
            setRandomUserName();
            setRandomLastName();
            setRandomEmail();
            setEstadoDesactivado();
       
    	  }
            
            public  void elegirUsuarios(Integer index){
            // Elegir Usuarios Inactivos
            Reporter.log(" Seleccionar usuarios ");
            
            Select userselect= new Select(driver.findElement(By.cssSelector(".actions fieldset:nth-child(1) label:nth-child(1) select")));
            
            userselect.deselectAll();
           
           
            userselect.selectByIndex(index);
    	  }
   
    
     public void verificarUsuariosInactivos(){
    	 //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
         Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users inactivos");
 	
       
         for(int i = 1;i<10;i++)
        	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "SIN CHEQUEAR");
        	 Reporter.log("Todos los usuarios de la lista se encuentran desactivados");
     }
    }


