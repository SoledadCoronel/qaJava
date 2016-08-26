package go5.automation.espacios;

import go5.automation.SetUp;
import go5.pageObjects.EspaciosPage;
import go5.pageObjects.AgregarEspacioPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class EditarEspacioAC extends SetUp {

	EspaciosPage espacio = null;
	AgregarEspacioPage addspace = null;
	HomePage home=null;
	String strusername = "admin";

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void editarEspacio() throws Exception {

		espacio = new EspaciosPage(driver);
		addspace = new AgregarEspacioPage(driver);
		home= new HomePage(driver);

		Reporter.log(" Editando un espacio como user admin");

		// Ir a espacios
		Thread.sleep(2000);
		home.goToEspacios();

		Thread.sleep(2000);

		// Ir a Editar un Espacio

		espacio.goToEditEspacio();
		addspace.setNameEspacio("Editado");

		// Activar o Desactivar el espacio

		addspace.activarEspacio();
		addspace.activarActividadSocial();

		// espacio.cambiarIconoOso();

		// Si es de tipo empresa, no aparece la opcion de cambiar el tipo
		// espacio.setEspacioPrivado();
		addspace.grabarEspacio();
		Thread.sleep(1000);		
		Reporter.log("Caso de editar espacio finalizado correctamente");

	}

}
