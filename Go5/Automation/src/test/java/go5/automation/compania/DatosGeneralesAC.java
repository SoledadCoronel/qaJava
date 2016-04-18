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
	
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}
		
	
	@Test
	
	public void companyDataPage() throws Exception { 
	
	company = new CompanyPage(driver);
		  
		this.goToConfiguration();
		  this.goToMenu();
	        		
		
         

 		// Go to Company Data
		  
		  company.irADatosGenerales();
		  
		
 		
 		

 //Verify that company name can not be blank
 		Reporter.log("Verificar que el nombre de la compañia no pueda ser blanco");
 		  company.setNombreCompania("      ");
 	//	driver.findElement(By.cssSelector("..generaldata fieldset label:nth-child(1) input")).sendKeys("    ");
 		String companyMessage = new String(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) span")).getText());
 		Reporter.log(companyMessage);
 		Assert.assertEquals(companyMessage, "El campo es requerido");
 		company.setNombreCompania("Automation Site");
 	
 			company.setIdioma();
 			company.setTimezone();
 		
 
 		 		
 
 		Reporter.log(" Caso de Datos de la Compañia finalizado");
 		
 		
 }
}	