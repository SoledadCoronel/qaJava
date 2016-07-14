package go5.automation.espacios;


//driver

import static org.junit.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import go5.automation.driver.AndroidSetup;




//junit
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Pages


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import go5.pageObjects.LoginPage;
import go5.pageObjects.BasePage;
import go5.pageObjects.EspacioPage;







public class CrearEspacioPublicoTest  extends AndroidSetup{
 
   //Declarate Pages
	
     LoginPage login=null;
     BasePage page=null;
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
       public void createSpace() throws Exception{
    	//Init pages
    	   
    	   login = new LoginPage(driver);
    	   page = new BasePage(driver);
    	   space= new EspacioPage(driver);
    	  String strIcono=".icons .igospacebanana";
    
    	   login.loginToGoAsAdminEspacios("Automation4");
    	   page.goToMenu();
    	  Thread.sleep(3000);
    	   space.crearEspacio();
    	   Thread.sleep(4000);
           space.setNameEspacio("Mobile");
           space.setDescriptionEspacio("Espacio mobile");
           
           space.cambiarIcono(strIcono);
           Thread.sleep(3000);
           space.grabarEspacio();
           Thread.sleep(2000);
           page.goToMenu();
           page.goToVerMas();
           Thread.sleep(3000);
           space.buscarEspacio("Mobile");
           
          
        
           
           
       }
}
    	 
    	  
    	   
    	   
    	   
       

