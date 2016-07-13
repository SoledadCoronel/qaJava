package go5.automation.espacios;



//driver
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import go5.automation.driver.AndroidSetup;






//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages



import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import go5.pageObjects.*;





public class CrearEspacioUserBasicTest  extends AndroidSetup{
 
     private String wrongEmail= "cualquiera@gointegro.com";
     private String numericEmail= "11212232";
     private String validEmail="marina.touceda@gointegro.com";
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

