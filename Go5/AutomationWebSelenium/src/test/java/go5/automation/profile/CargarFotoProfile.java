package go5.automation.profile;

import go5.automation.SetUp;
import go5.pageObjects.HomePage;
import go5.pageObjects.ProfilePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CargarFotoProfile extends SetUp {

	ProfilePage profile = null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test(testName = "Cambiar la foto de perfil del usuario")
	public void setUpPictureProfile() throws Exception {

		profile = new ProfilePage(driver);
		home = new HomePage(driver);

		// Go to the user menu

		home.goToUserMenu();
		profile.goToProfile();
		home.goToMenu();
		profile.editarProfile();
		profile.cargarFoto();
		profile.cancelarSubirFoto();
		Thread.sleep(2000);
		profile.cargarFoto();
		Thread.sleep(4000);
	}

}
