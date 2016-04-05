package go5.automation.groupsytitles;



import go5.automation.TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TitlesTest extends TestSuite{

	@BeforeClass
	 
	 public void setUp() throws Exception {
		 
		this.openSite(urlSiteAutomation1);
		this.login();
		 }
	  

	@AfterClass // call function to close browser 
		
		public void teardown(){
			this.quitBrowser();
	}

  @Test
  public void addTitle() throws Exception{
    
	       
     
    
        Reporter.log(" Agregar , editar y borrar Tiers y ");
    
        // Go to the configuration
        this.goToConfiguration();
        this.goToMenu();
     
     
         
          
      // Go to Titles2    
            Reporter.log("Abriendo titulos");
            this.goToGroups();
            this.goToTitles();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         
      // Se agrega un Tier
          Reporter.log("Se agrega un tier");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("QATOBEDELETED");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.ENTER);
   /*       
    // Se edita cambiandole el nombre al Tier
          Reporter.log("Se le cambia el nombre al tier");
          Thread.sleep(2000);
          WebElement edittier = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .edit")));
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .edit")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) input")).clear();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) input")).sendKeys("QA - EDITADO");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) input")).sendKeys(Keys.ENTER);
 */
    // Se elimina un Tier sin jobtitles
          Reporter.log("Se elimina un Tier sin jobtitles");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .delete")).click();
          Thread.sleep(1000);
          driver.findElement(By.cssSelector(".modal.active .mconfirmation a")).click();   
      
    // Se crea nuevamente un Tier   
          Reporter.log("Se crea nuevamente un Tier");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("QA");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.ENTER);
          
      // Se agrega un jobtitle al Tier
          Reporter.log("Se agrega un jobtitle al Tier");
          
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree .showadd a")).click();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys("SENIOR");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys(Keys.ENTER);
          
      // Se elimina un Tier con jobtitle asociado
          Reporter.log("Se elimina un Tier con jobtitle asociado");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .delete")).click();
          Thread.sleep(1000);
          driver.findElement(By.cssSelector(".modal.active .mconfirmation a")).click(); 
          
      // Se crea nuevamente un Tier   
           Reporter.log("Se crea nuevamente un Tier");                                                                                                                                                                                                   
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(1) a")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys("QANEWTIER");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(1) label:nth-child(2) input")).sendKeys(Keys.ENTER);
         
         
       // Se agrega un jobtitle al Tier
          Reporter.log("Se agrega un jobtitle al Tier");
          
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree .showadd a")).click();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys("SENIOR");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .additem.active input")).sendKeys(Keys.ENTER);
    
     /*     
      // Se edita cambiandole el nombre al jobtitle
          
          Reporter.log("Se edita el jobtitle");
           WebElement editJobtitle = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) .edit")));
                  
           // Thread.sleep(2000);
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) .edit")).click();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) label input")).clear();
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) label input")).sendKeys("SENIOR EDITADO");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) ul:nth-child(2) li:nth-child(1) label input")).sendKeys(Keys.ENTER);
    
    // Eliminar un jobtitle
         Reporter.log(" Se elimina el jobtitle");
          WebElement deleteJobtitle = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree.active .delete")));
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) .subtree.active .delete")).click();
          driver.findElement(By.cssSelector(".modal.active .mconfirmation .primary")).click();
          
    // Se elimina el Tier vacío
          Reporter.log(" Se elimina el Tier Vacio");
          driver.findElement(By.cssSelector(".groupsform fieldset:nth-child(2) label:nth-child(1) .delete")).click();
          Thread.sleep(1000);
          driver.findElement(By.cssSelector(".modal.active .mconfirmation a")).click();
      */
  }
}

