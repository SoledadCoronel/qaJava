package go5.automation.people;



import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Titles {

  private WebDriver driver;
  
   @BeforeClass
    @Parameters(value={"browser","version","platform","url"})
    public void setUp(String browser, String version, String platform,String url) throws Exception {
      DesiredCapabilities capability = new DesiredCapabilities();
      capability.setCapability("platform",platform);
      capability.setCapability("browserName", browser);
      capability.setCapability("browserVersion", version);
      capability.setCapability("project", "GOIntegro");
      capability.setCapability("build", "1.0");
      capability.setCapability("debug", false);
      capability.setCapability("name", "AddUserAdminWithAllFields");
      driver = new RemoteWebDriver(
           new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
              capability);
      driver.get(url);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }  
  
   @AfterClass // call function to close browser 
    
    public void teardown(){
      driver.quit();
    }



  @Test
  public void addTitle() throws InterruptedException{
    
    //Login
      
      driver.findElement(By.id("signInIdentification")).clear();
      driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
      driver.findElement(By.id("signInPassword")).clear();
      driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
       driver.findElement(By.cssSelector(".primary")).click();
           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          
     
    
        Reporter.log(" Agregando un user Admin, con todos los datos basicos  y sin invitation");
    
        // Go to the configuration
      driver.findElement(By.cssSelector(".applications .users .configuration")).click();
          driver.findElement(By.cssSelector(".menu")).click();
    
    // Go to  Users Menu
          Reporter.log("Abriendo administar personas" );  
         
          
      // Go to Titles    
          driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3)")).click();
          Reporter.log("Abriendo titulos");
     
        
      // Go to Title
          driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(3) a")).click();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         
      // Se agrega un Tier
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("QA");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.ENTER);
          
    // Se edita cambiandole el nombre al Tier
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .edit")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) input")).clear();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) input")).sendKeys("QA - EDITADO");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) input")).sendKeys(Keys.ENTER);
 
    // Se elimina un Tier sin jobtitles
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .delete")).click();
          Thread.sleep(1000);
          driver.findElement(By.cssSelector(".modal.active .mconfirmation a")).click();   
      
    // Se crea nuevamente un Tier                                                                                                                                                                                                                  
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("QA");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.ENTER);
          
      // Se agrega un jobtitle al Tier   
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree.active .showadd.active .optional")).click();
          Thread.sleep(1000);
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys("SENIOR");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys(Keys.ENTER);
          
      // Se elimina un Tier con jobtitle asociado
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .delete")).click();
          Thread.sleep(1000);
          driver.findElement(By.cssSelector(".modal.active .mconfirmation a")).click(); 
          
      // Se crea nuevamente un Tier                                                                                                                                                                                                                  
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("QA");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.ENTER);
          
    // Se agrega el jobtitle nuevamente  
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree.active .showadd.active .optional")).click();
          Thread.sleep(2000);
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys("SENIOR");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys(Keys.ENTER);
          
      // Se edita cambiandole el nombre al jobtitle
          Thread.sleep(2000);
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) .edit")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) label input")).clear();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) label input")).sendKeys("SENIOR EDITADO");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) label input")).sendKeys(Keys.ENTER);
          
    // Eliminar un jobtitle
          Thread.sleep(2000);
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree.active .delete")).click();
          driver.findElement(By.cssSelector(".modal.active .mconfirmation .primary")).click();
          
    // Se elimina el Tier vacío
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .delete")).click();
          Thread.sleep(1000);
          driver.findElement(By.cssSelector(".modal.active .mconfirmation a")).click();
      
  }
}

