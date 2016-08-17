package go5.automation.compania;

import go5.automation.SetUp;
import go5.pageObjects.DatosGeneralesPage;
import go5.pageObjects.HomePage;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DatosGeneralesAC extends SetUp {

	DatosGeneralesPage company = null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void companyDataPage() throws Exception {

		company = new DatosGeneralesPage(driver);
		home = new HomePage(driver);

		home.goToConfiguration();
		home.goDatosGenerales();		
		company.verifyNombreCantBeBlank();
		company.setNombreCompania("Site Automation");
		company.setIdioma();
		company.setTimezone();

		Reporter.log(" Caso de Datos de la Compañia finalizado");

	}
}