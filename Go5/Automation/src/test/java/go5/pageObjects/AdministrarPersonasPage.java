package go5.pageObjects;


import java.util.List;

import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

  
    
    
    public class AdministrarPersonasPage extends TestSuite {

    	//Css
    	
    	protected String goToPersonas= ".";
    	
    	protected  String inputNombreUser= ".basicdata label:nth-child(4) input";
    	protected  String inputLastnameUser=".basicdata label:nth-child(5) input";
    	protected  String inputemailUser =".basicdata label:nth-child(6) input";
    	protected  String tablaPersonas = ".tablefilter tbody";
    	protected  String crearUser = ".content .title a";
    	protected  String estadoDesactivado = ".basicdata label:nth-child(2) input:nth-child(2)";
    	protected  String estadoActivado = ".basicdata label:nth-child(2) input:nth-child(1)";
    	
    	protected String  desplegarCampos = ".addpeople .secondary";
    	protected String  savePerson = ".container .addpeople .primary";   	
    	 protected String editfirstRow=".tables tbody tr:nth-child(1) td:nth-child(7) a";
       	protected	String searchButton = ".actions .search .btnsearch";
    	protected	String inputSearch =".actions .search input";
    	protected	String orden =".tables thead tr th:nth-child(2) a";
    	protected	 String firstRow= ".tables tbody tr:nth-child(1) td:nth-child(2)";
    	protected	 String secondRow= ".tables tbody tr:nth-child(2) td:nth-child(2)"; 
    	protected String groupsSelect= ".groupsdata select";
    	protected String grabarSinEnviarInvite= ".container .addpeople .secondary";
    	protected String selectRol=".basicdata label:nth-child(7) select";
    	
    	//Modales
    	
    	protected String clickayudaEstadoPersona="basicdata label:nth-child(1) a";
    	protected String modalEstadoPersona0="#modal-container .modal:nth-child(4) h2";
    	protected String cerrarModal="#modal-container .modal:nth-child(4) .close";
	    protected String clickmodalBloquearAcceso=".basicdata label:nth-child(3) a";
	    protected String modalBloquearAcceso="#modal-container .modal:nth-child(6) h2";
	    protected String okEntendidoModal="#modal-container .modal:nth-child(6) .primary";
	    
    	 
    	  WebDriver driver;
    
     
  
    	    public AdministrarPersonasPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
    	   
    	    public void goToPersonas(){
    	    	
    	    	 driver.findElement(By.cssSelector(".igoadmin")).click();
    	    	
			}
    	    
    	    
    	    public void setRandomUserName() throws Exception{
        	  driver.findElement(By.cssSelector(inputNombreUser)).sendKeys(name);
    	    	
       	    }
  
    	    public void setRandomLastName() throws Exception{
    	    	 driver.findElement(By.cssSelector(inputLastnameUser)).sendKeys(name);
    	        }
    	    
    	    public void setRandomEmail() throws Exception{
    	    	 driver.findElement(By.cssSelector(inputemailUser)).sendKeys(email); 
    	    	
    	     	    }
        	       	   
    	   
    	   public void setEstadoActivo() throws InterruptedException{
    		  driver.findElement(By.cssSelector(estadoActivado)).click();

    		  
    		   
    	   }
    	    public void setEstadoDesactivado() throws Exception{
    	    	driver.findElement(By.cssSelector(estadoDesactivado)).click();
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
    	  
    	  public void editFirstPerson(){
    		  this.click(editfirstRow);
    	  }
    	  
    	  public void inactivarUsuario() throws Exception{
    		  Reporter.log(driver.findElement(By.cssSelector(".tables tbody tr td:nth-child(7)")).getText());
 	         Reporter.log("clickear usuario inactivo");
 	         this.click(".tables tbody tr td:nth-child(7)");
 	         Thread.sleep(1000);
 	         this.click(".basicdata label:nth-child(2) input:nth-child(2)");
 	         Reporter.log("Grabando usuario");
 	         this.click(".container .addpeople .primary");
    		 
    		  
    	  }
    	  
    	  public void agregarPersona() throws Exception{
   
            this.click(crearUser);
            setRandomUserName();
            setRandomLastName();
            setRandomEmail();
            setEstadoDesactivado();
       
    	  }
    	  
       	  public void selectRol(){
       		 //Seleccionar el rol admin
		      
			     Select selectRoldropdown = new Select(driver.findElement(By.cssSelector(selectRol))); 
			 		
			        selectRoldropdown.selectByIndex(1);
       	  }
    	  
    	  
            public void setGrupo() {
                         		
               	 // Select all values the drop-down for Language
               	 		Reporter.log(" Tomar un grupo");
               	 		Select selectGroup= new Select(driver.findElement(By.cssSelector(groupsSelect)));
               	 		
               	 		selectGroup.selectByIndex(1);
               	 		           	 		
            	
		}

            public void grabarUsuarioSinInvite(){
            	driver.findElement(By.cssSelector(grabarSinEnviarInvite)).click();
            }
            
			public  void elegirUsuarios(Integer index){
            // Elegir Usuarios ( Activos es 1,2 es Inactivos, y 3 es No registrados
              
            	
            Select userselect= new Select(driver.findElement(By.cssSelector(".filters select")));
                   
           userselect.deselectByIndex(index);
               userselect.selectByIndex(index);
    	  }
   
   
     public void verificarUsuariosInactivos(){
    	 //Reocorrer la tabla y verificar que todos los usuarios mostrados sean los users inactivos
         Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users inactivos");
 	
       
         for(int i = 1;i<10;i++)
        	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "SIN CHEQUEAR");
        	 Reporter.log("Todos los usuarios de la lista se encuentran desactivados");
     }
     
    public void filtrarUsuariosActivos(){
    	 Reporter.log("Reocorrer la lista de usuarios y filtrar los users activos");
         
         for(int i = 1;i<10;i++)
        	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "CHEQUEADO");
        	 Reporter.log("Todos los usuarios de la lista se encuentran activados");	
    
    }
     
     
     
     public  void selectUserActive() throws Exception{
    	 Reporter.log("select los usuarios de activos");
    	 this.elegirUsuarios(1);
    	 this.verificarUsuariosActivos();
    	  	 
    	//editar el primero de la lista de activos que ya se que es activo para desactivar
    	 this.click(editfirstRow);
    	//quedarme con el nombre de ese usuario activo , buscarlo y ver que este inactivo
    	 
    	  }
     
     
    
     public void verificarUsuariosNoRegistrados(){
    	 
    	 Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users que no estan registrados");
          
         for(int i = 1;i<10;i++)
             	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(6n)")).getText(), "SIN CHEQUEAR");
        	 Reporter.log("Todos los usuarios de la lista se encuentran en estado no registrado");
     }
      public void verificarUsuariosActivos(){
    	   Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users activos");
            
           for(int i = 1;i<10;i++)
          	Assert.assertEquals(driver.findElement(By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)")).getText(), "CHEQUEADO");
          	 Reporter.log("Todos los usuarios de la lista se encuentran activados");
      }
    }


