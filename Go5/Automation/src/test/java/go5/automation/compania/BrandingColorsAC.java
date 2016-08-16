package go5.automation.compania;

import go5.automation.SetUp;
import go5.pageObjects.CompanyPage;
import go5.pageObjects.HomePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BrandingColorsAC extends SetUp {

	CompanyPage company= null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		driver.quit();
	}

	@Test
	public void verifyColors() throws Exception {


		home = new HomePage(driver);
		company = new CompanyPage(driver);

		// Ir a Imageb
		home.goToConfiguration();
		home.goDisenio();
		company.restablecerInterfaz();
		Thread.sleep(4000);
		company.verifyColors();
		Thread.sleep(4000);
		company.changeColorHeader();
		Thread.sleep(4000);
		company.changeColorContrast();
		Thread.sleep(4000);
		
	}
}
