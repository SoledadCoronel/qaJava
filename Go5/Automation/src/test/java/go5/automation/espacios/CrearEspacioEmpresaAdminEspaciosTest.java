package go5.automation.espacios;

import go5.automation.SetUp;
import go5.pageObjects.AgregarEspacioPage;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrearEspacioEmpresaAdminEspaciosTest extends SetUp {

	AgregarEspacioPage addespacio = null;

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

		addespacio = new AgregarEspacioPage(driver);

		Reporter.log(" Verificar que si me logueo como un user Admin de Espacios, no puedo crear un espacio del tipo empresa");

		// Ir a Crear Espacio

		addespacio.goToCrearEspacio();

		// Cargar formulario del espacio
		addespacio.setNameEspacio("EMPRESA");

		addespacio.setDescriptionEspacio("Espacio del tipo empresa");

		try {
			addespacio.setEspacioEmpresa();
		} catch (Exception e) {

			Reporter.log("No esta el boton Tipo empresa");
		}

	}

}
