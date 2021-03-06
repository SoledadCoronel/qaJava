package go5.automation.directorio;

import go5.automation.SetUp;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import go5.pageObjects.DirectorioPage;
import go5.pageObjects.HomePage;

public class ListadoDirectorioAB extends SetUp {

	// Css
	String firstRow = ".tables tbody tr:nth-child(1) td:nth-child(2)";
	String secondRow = ".tables tbody tr:nth-child(2) td:nth-child(2)";

	// Uso de la pagina Directorio

	DirectorioPage directorio = null;
	HomePage home=null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void listadoDirectorio() throws Exception {

		// Inicializar pagina de Directorio

		directorio = new DirectorioPage(driver);
		home= new HomePage(driver);

		// Go to Directorio de personas
		Thread.sleep(3000);
		home.goToDirectorio();
		Thread.sleep(3000);
		home.goToMenu();

		// Ver si esta ordenado por default cuando carga la pagina
		Reporter.log("Ver si esta ordenado por default cuando carga la pagina");
		directorio.verificarOrden();

		// Volver a ordenar, en forma descendente

		Reporter.log("Verificar que esta en orden descendiente despues de apretar ordenar en Nombre");
		directorio.verificarOrden();

		// Hacer una busqueda
	
		Reporter.log(" Hacer una busqueda de un usuario por Nombre");
		this.search("Automation");

		// Chequear q se muestre en la tabla users
		Reporter.log("El nombre del user buscado es:Automation");
		Thread.sleep(2000);
		Reporter.log(" Imprimiendo el resultado del search:");
		Reporter.log(directorio.getFirstName());

	

		

	}
}