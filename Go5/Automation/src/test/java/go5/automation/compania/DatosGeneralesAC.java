package go5.automation.compania;

import go5.automation.SetUp;
import go5.pageObjects.CompanyPage;
import go5.pageObjects.HomePage;
import go5.pageObjects.MuroSocialPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;





public class DatosGeneralesAC  extends SetUp{
	
	CompanyPage company=null;
	HomePage home =null;
	
	
   @AfterClass // call function to close browser 
	
	public void teardown(){
		this.quitBrowser();
	}
		
	
	@Test
	
	public void companyDataPage() throws Exception { 
	
	company = new CompanyPage(driver);
	home = new HomePage(driver);
		  
		home.goToConfiguration();
		home.goToMenu();		
		company.goToDatosGenerales();
        company.verifyNombreCantBeBlank();
        company.setNombreCompania("Site Automation");
 		company.setIdioma();
 		company.setTimezone();
 		
 
 		 		
 
 		Reporter.log(" Caso de Datos de la Compañia finalizado");
 		
 		
 }
}	