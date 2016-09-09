package go5.automation.espacios;

import go5.automation.SetUp;
import go5.pageObjects.AgregarEspacioPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CrearEspacioAC extends SetUp {

	AgregarEspacioPage addespacio = null;
	HomePage home=null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void crearEspacio() throws Exception {

		addespacio = new AgregarEspacioPage(driver);
		home= new HomePage(driver);

		Reporter.log(" Creando un espacio como user admin");

		// Ir a Crear Espacio
		
		Thread.sleep(3000);

		addespacio.goToCrearEspacio();
		
		home.goToMenu();
		Thread.sleep(2000);

		// Cargar formulario del espacio
		addespacio.setNameEspacio("Publico");

		addespacio.setDescriptionEspacio("Espacio del tipo publico");

		// Configuracion del espacio

		// Desactivar
		Reporter.log("Desactivar el espacio");
		addespacio.activarEspacio();		

		// Espacio publico

		addespacio.setEspacioPublico();

		// Grabar el espacio nuevo
		Thread.sleep(3000);
		addespacio.grabarEspacio();

		Thread.sleep(1000);
		Reporter.log("Caso de crear espacio  finalizado correctamente");
		
		
  // Ir a buscar el espacio al sidebar y agregarle personas
		
	}

}
