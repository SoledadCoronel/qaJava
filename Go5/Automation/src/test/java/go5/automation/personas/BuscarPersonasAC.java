package go5.automation.personas;

import go5.automation.SetUp;
import go5.pageObjects.AdministrarPersonasPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BuscarPersonasAC extends SetUp {

	AdministrarPersonasPage personas = null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void listarEspacios() throws Exception {

		personas = new AdministrarPersonasPage(driver);
		home = new HomePage(driver);

		Reporter.log(" Buscar persona ");

		// Go to the configuration
		home.goToConfiguration();
		home.goToMenu();
		home.goToAdministrar();
		// Buscar
		this.search("Inactive");
		Thread.sleep(2000);

	}

}
