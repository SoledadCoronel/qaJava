package go5.automation.compania;

import go5.automation.TestSuite;
import go5.pageObjects.CompanyPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;





public class DatosGeneralesAC  extends TestSuite{
	
	 private WebDriver driver;
   CompanyPage company=null;
   private String datosGenerales = new String (".igocompanydata");
	private String design= new String (".igodesign");
   private String nombreCompania= new String (".generaldata fieldset label:nth-child(1) input");
   private String selectIdioma = new String (".generaldata fieldset label:nth-child(3) select");
   private String selectTimezone = new String (".generaldata fieldset label:nth-child(4) select");
	
   @AfterClass // call function to close browser 
	
	public void teardown(){
		this.quitBrowser();
	}
		
	
	@Test
	
	public void companyDataPage() throws Exception { 
	
	company = new CompanyPage(driver);
		  
		this.goToConfiguration();
		  this.goToMenu();
	        		
		
         

 		// Go to Company Data
		  
		 // company.irADatosGenerales();
		  Reporter.log("Abriendo la pagina de Datos de la Compania");
     	 driver.findElement(By.cssSelector(datosGenerales)).click();
		
 		
 		

 //Verify that company name can not be blank
 		Reporter.log("Verificar que el nombre de la compañia no pueda ser blanco");
 		//  company.setNombreCompania("      ");
 	//	driver.findElement(By.cssSelector("..generaldata fieldset label:nth-child(1) input")).sendKeys("    ");
 	//	String companyMessage = new String(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) span")).getText());
 	//	Reporter.log(companyMessage);
 	//	Assert.assertEquals(companyMessage, "El campo es requerido");
 	//	company.setNombreCompania("Automation Site");
 		Reporter.log("Insertando nombre de la compania");
   	 driver.findElement(By.cssSelector(nombreCompania)).clear();
   	 driver.findElement(By.cssSelector(nombreCompania)).sendKeys("sdsdasdsadsadsd");
 	//		company.setIdioma();
 		//	company.setTimezone();
 		
 
 		 		
 
 		Reporter.log(" Caso de Datos de la Compañia finalizado");
 		
 		
 }
}	