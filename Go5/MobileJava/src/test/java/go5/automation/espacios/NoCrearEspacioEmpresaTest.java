package go5.automation.espacios;



//driver


import go5.automation.driver.AndroidSetup;







//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages


import org.testng.Reporter;

import go5.pageObjects.LoginPage;
import go5.pageObjects.BasePage;
import go5.pageObjects.EspacioPage;



public class NoCrearEspacioEmpresaTest  extends AndroidSetup{
 
    
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
    	   
    	  login.loginToGoAsAdminEspacios("Automation5");
    	  base.goToMenu();
    	  Thread.sleep(3000);
    	space.crearEspacio();
    	        
	          try{
	        space.setEspacioEmpresa();
	     		     }    
	     		    		 catch (Exception e) {

	     		    		    System.out.println("No esta el boton de crear Empresa");
	     		    			 Reporter.log("No esta el boton Tipo empresa");
	     		    		 }
    	 
    	 
    	  
    	   
    	   
    	   
       }
       
}

