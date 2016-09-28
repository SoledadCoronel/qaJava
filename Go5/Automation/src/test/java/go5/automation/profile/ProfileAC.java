package go5.automation.profile;

import go5.automation.SetUp;
import go5.pageObjects.HomePage;
import go5.pageObjects.ProfilePage;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ProfileAC extends SetUp {

	ProfilePage profile = null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		driver.quit();
	}

	@Test
	public void editProfile() throws Exception {

		profile = new ProfilePage(driver);
		home = new HomePage(driver);

		// Go to the user menu
		home.goToUserMenu();

		// Ir a ver perfil
		profile.goToProfile();

		// Editar perfil

		profile.editarProfile();

		// Insertar datos laborales
		profile.agregarDatosLaborales();

		// Telefono
		profile.agregarTelefonos();

		// Datos Personales

		profile.agregarDatosPersonales();

		profile.agregarRedesSociales();
		Thread.sleep(5000);

		profile.grabarUsuario();
		
	}

}
