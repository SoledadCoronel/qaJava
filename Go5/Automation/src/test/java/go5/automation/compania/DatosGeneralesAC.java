package go5.automation.compania;

import go5.automation.TestSuite;
import go5.pageObjects.CompanyPage;
import go5.pageObjects.MuroSocialPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;





public class DatosGeneralesAC  extends TestSuite{
	
	CompanyPage company=null;
	
	
   @AfterClass // call function to close browser 
	
	public void teardown(){
		this.quitBrowser();
	}
		
	
	@Test
	
	public void companyDataPage() throws Exception { 
	
	company = new CompanyPage(driver);
		  
	
		this.goToConfiguration();
		 this.goToMenu();
		 Thread.sleep(2000);
		 company.irADatosGenerales();
        company.verifyNombreCantBeBlank();
        company.setNombreCompania("Site Automation");
 		company.setIdioma();
 		company.setTimezone();
 		
 
 		 		
 
 		Reporter.log(" Caso de Datos de la Compañia finalizado");
 		
 		
 }
}	