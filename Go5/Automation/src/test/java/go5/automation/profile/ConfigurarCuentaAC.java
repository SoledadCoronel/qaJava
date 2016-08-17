package go5.automation.profile;

import go5.automation.SetUp;
import go5.pageObjects.ConfigurarCuentaPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

public class ConfigurarCuentaAC extends SetUp {

	HomePage home = null;
	ConfigurarCuentaPage config = null;
	

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void configurarCuenta() throws Exception {

		home = new HomePage(driver);
		config = new ConfigurarCuentaPage(driver);

		// Ir a Datos Basicos

		home.goToUserMenu();
		Thread.sleep(1000);
		config.goToConfigurarCuenta();
		config.changeLanguageToEnglish();
		config.guardar();
		Thread.sleep(2000);
		// Ir a Contraseña
		
		

		config.goToPassword();
		config.setPassword();
		config.guardar();
		Thread.sleep(2000);
		config.verifyLanguageChanged();
		Thread.sleep(2000);
		config.goToIrAGeneral();
		config.changeLanguageToSpanish();
		config.guardar();
		Thread.sleep(2000);
	}

}
