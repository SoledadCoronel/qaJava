package go5.automation.compania;

import go5.automation.SetUp;
import go5.pageObjects.BrandingPage;
import go5.pageObjects.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BrandingFotosAC extends SetUp {

	BrandingPage branding = null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		driver.quit();
	}

	@Test
	public void brandingPictures() throws Exception {

		home = new HomePage(driver);
		branding = new BrandingPage(driver);

		// Ir a Imagen
		home.goToConfiguration();
		home.goDisenio();
		Thread.sleep(2000);
		branding.loadLogoPicture();
		Thread.sleep(2000);
		branding.loadBackgroundPicture();
		Thread.sleep(2000);
		
	}
}
