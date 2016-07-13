package go5.automation.espacios;


//driver

import go5.automation.driver.AndroidSetup;





//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages



import go5.pageObjects.*;


//Utils




public class CrearEsapcioTest  extends AndroidSetup{
  
    
    EspacioPage space=null;
    LoginPage login=null;
    BasePage page=null;

   
    @Before
    
    public void setUp() throws Exception {
        
        prepareAndroidForAppium();
       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void editProfileUser() throws Exception {
    
    	// Init pages
    	
   
   	 login = new LoginPage(driver);
   	 page =new BasePage(driver);
   	 space= new EspacioPage(driver);
       
   
       // Test
     login.loginToGoAsUSerBasic();
     Thread.sleep(5000);
     page.goToMenu();
     Thread.sleep(2000);
   
			
		    // Ir a Crear space 
		    
		 	space.crearEspacio();
		 	Thread.sleep(3000);
		   		       
		      //Cargar formulario del space
		 	
		 	space.setNameEspacio("Publico Mobile");
		 	
		 	space.setDescriptionEspacio("Espacio creado desde mobile publico");
		     
		 	 		 
		 	
	       //Configuracion del space
	          
	          //Desactivar
	       
	          space.activarEspacio();
	
	     
	          //Seleccionar el icono
	        
	       //   space.cambiarIconoBasket();
	      
	  
	     
	           //space publico
	          
	          space.setEspacioPublico();
	   
	           
	           //Grabar el space nuevo
	          space.grabarEspacio();
	                   
	           Thread.sleep(1000);
	             
	
	}	
	
	
		
     }

