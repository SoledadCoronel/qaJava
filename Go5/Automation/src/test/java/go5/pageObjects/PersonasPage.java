package go5.pageObjects;


import java.util.List;

import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;


  
    
    
    public class PersonasPage extends TestSuite {

    	//Css
    	
    	protected static String irAPersonas= new String("nav .space:nth-child(3) ol li:nth-child(2) a");
    	
    	protected static String inputNombreUser= new String(".basicdata label:nth-child(4) input");
    	protected static String inputLastnameUser=new String (".basicdata label:nth-child(5) input");
    	protected static String inputemailUser =new String ("basicdata label:nth-child(6) input");
    	protected static String tablaPersonas = new String (".tablefilter tbody");
    	protected static String crearUser = new String (".content .title a");
    	protected static String estadoDesactivado = new String (".basicdata label:nth-child(2) input:nth-child(2)");
    	   	
    	
    	
    	  WebDriver driver;
    
     
  
    	    public PersonasPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
    	   
    	    public void goToPersonas() throws Exception{
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
    
        public void agregarPersona() throws Exception{
   
            this.click(crearUser);
            setRandomUserName();
            setRandomLastName();
            setRandomEmail();
            setEstadoDesactivado();
        }
    }


