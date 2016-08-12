package go5.automation.espacios;

import go5.automation.SetUp;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.AgregarEspacioPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class EditarEspacioAC extends SetUp {

	EspacioPage espacio = null;
	AgregarEspacioPage addspace = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void editarEspacio() throws Exception {

		espacio = new EspacioPage(driver);
		addspace = new AgregarEspacioPage(driver);

		Reporter.log(" Editando un espacio como user admin");

		// Ir a espacios
		Thread.sleep(5000);
		espacio.goToEspacios();

		Thread.sleep(5000);

		// Ir a Editar un Espacio

		addspace.editarEspacio();
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
