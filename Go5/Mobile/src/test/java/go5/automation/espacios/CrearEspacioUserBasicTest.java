package go5.automation.espacios;



//driver


import go5.automation.driver.AndroidSetup;






//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages


import go5.pageObjects.LoginPage;
import go5.pageObjects.BasePage;
import go5.pageObjects.EspacioPage;



public class CrearEspacioUserBasicTest  extends AndroidSetup{
 
    
     LoginPage login=null;
     BasePage base=null;
     EspacioPage space=null;


   
    @Before
    
    public void setUp() throws Exception {
        
        prepareAndroidForAppium();
       
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

   
       @Test
       public void createSpace() throws InterruptedException{
    	//Init pages
    	   
    	   login = new LoginPage(driver);
    	   base = new BasePage(driver);
    	   space= new EspacioPage(driver);
    	
    	 //Test  
    	   
    	  login.loginToGoAsUSerBasic();
    	  base.goToMenu();
    	  Thread.sleep(3000);
    	  try{
    			 space.crearEspacio();
    			     }    
    			    		 catch (Exception e) {

    			    		     System.out.println("No esta el boton Crear Espacio para un user basico");
   			    		
    			    		 }
    	 
    	 
    	  
    	   
    	   
    	   
       }
       
}

