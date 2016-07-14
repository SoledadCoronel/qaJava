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
       public void createSpace() throws Exception{
    	//Init pages
    	   
    	   login = new LoginPage(driver);
    	   base = new BasePage(driver);
    	   space= new EspacioPage(driver);
    	  String strIcono=".igospacebanana";
    	 //Test  
    	/*   WebDriverWait wait = new WebDriverWait(driver, 20);
           
           wait.until(ExpectedConditions.elementToBeClickable(By.tagName("BUTTON")));
         
           List<AndroidElement> textFieldsList = driver.findElementsByTagName("INPUT");
           textFieldsList.get(0).sendKeys("marina.touceda@gointegro.com");
           textFieldsList.get(1).sendKeys("Auto1234");
           Thread.sleep(3000);
           
           List<AndroidElement> dynamicTextFieldsList = driver.findElementsByTagName("INPUT");
           
           dynamicTextFieldsList.get(2).sendKeys("Automation1");
           
           WebElement button = driver.findElementByTagName("BUTTON");
           button.click();
           
           Thread.sleep(3000);
           wait.until(ExpectedConditions.elementToBeClickable(By.tagName("h1")));

           WebElement title = driver.findElement(By.tagName("h1"));
           assertEquals("Actividad social", title.getText());
    	   */
    	   login.loginToGoAsAdminEspacios("Automation4");
    	  base.goToMenu();
    	  Thread.sleep(3000);
    	   space.crearEspacio();
    	   Thread.sleep(4000);
           space.setNameEspacio("Mobile");
           space.setDescriptionEspacio("Espacio mobile");
           space.cambiarIcono(strIcono);
           driver.hideKeyboard();
           Thread.sleep(3000);
           space.grabarEspacio();
        
       }
}
    	 
    	  
    	   
    	   
    	   
       

