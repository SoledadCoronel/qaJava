package go5.automation.espacios;

import go5.automation.TestSuite;
import go5.pageObjects.EspacioPage;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrearEspacioEmpresaAdminEspaciosTest extends TestSuite {

	EspacioPage espacio = null;

	@BeforeClass
	public void setup() throws Exception {
		this.setUpMavenAdminEspacios();
	}

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void crearEspacioEmpresa() throws Exception {

		espacio = new EspacioPage(driver);

		Reporter.log(" Verificar que si me logueo como un user Admin de Espacios, no puedo crear un espacio del tipo empresa");

		// Ir a espacios
		espacio.goToEspacios();

		Thread.sleep(1000);

		// Ir a Crear Espacio

		espacio.goToCrearEspacio();

		// Cargar formulario del espacio
		espacio.setNameEspacio("EMPRESA");

		espacio.setDescriptionEspacio("Espacio del tipo empresa");

		// Configuracion del espacio

		// Desactivar
		// Reporter.log("Desactivar el espacio");
		// espacio.activarEspacio();

		// Actividad Social
		// Reporter.log("Desactivar Acitividad Social");
		// espacio.activarActividadSocial();

		// Seleccionar el icono
		// Reporter.log("Seleccionar el icono del espacio");
		// espacio.cambiarIconoBanana();

		try {
			espacio.setEspacioEmpresa();
		} catch (Exception e) {

			Reporter.log("No esta el boton Tipo empresa");
		}

	}

}
