package go5.automation.compania;

import go5.automation.SetUp;
import go5.pageObjects.BrandingPage;
import go5.pageObjects.DatosGeneralesPage;
import go5.pageObjects.HomePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BrandingFotosAC extends SetUp {

	BrandingPage branding= null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		driver.quit();
	}

	@Test
	public void verifyColors() throws Exception {


		home = new HomePage(driver);
		branding = new BrandingPage(driver);

		// Ir a Imageb
		home.goToConfiguration();
		home.goDisenio();
		branding.restablecerInterfaz();
		Thread.sleep(2000);
		branding.changeColorPlatform();
		/*
		company.changeColorHeader();
		Thread.sleep(4000);
		company.changeColorContrast();
		Thread.sleep(4000);
		*/
	}
}
