package go5.automation.compania;

import go5.automation.SetUp;
import go5.pageObjects.BrandingPage;
import go5.pageObjects.DatosGeneralesPage;
import go5.pageObjects.HomePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BrandingColorsAC extends SetUp {

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
		home.goToMenu();
		Thread.sleep(2000);
		branding.changeColorPlatform();
		Thread.sleep(2000);
		branding.changeColorText();		
		branding.guardar();
		Thread.sleep(2000);
		branding.restablecerInterfaz();
		branding.guardar();
				
	}
}
