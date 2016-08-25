package go5.automation.espacios;

import go5.automation.SetUp;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListadoEspaciosUserBasicAC extends SetUp {

	EspacioPage espacio = null;
	HomePage home=null;

	@BeforeClass
	// call function to open the browser and login
	public void setup() throws Exception {

		this.setUpMavenUserBasic();
	}

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void listarEspacios() throws Exception {

		espacio = new EspacioPage(driver);
		home = new HomePage(driver);

		Reporter.log(" Listado de espacios ");

		// Ir a espacios

		home.goToEspacios();

		// Ordenar espacios

	  // verificar que no este el boton de editar el espacio

	}

}
