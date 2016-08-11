package go5.automation.espacios;

import go5.automation.SetUp;
import go5.pageObjects.AgregarEspacioPage;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CrearEspacioAC extends SetUp {

	AgregarEspacioPage addespacio = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void crearEspacio() throws Exception {

		addespacio = new AgregarEspacioPage(driver);

		Reporter.log(" Creando un espacio como user admin");

		

		// Ir a Crear Espacio
      
		 addespacio.goToCrearEspacio();
	
		// Cargar formulario del espacio
		addespacio.setNameEspacio("Publico");

		addespacio.setDescriptionEspacio("Espacio del tipo publico");

		// Configuracion del espacio

		// Desactivar
		Reporter.log("Desactivar el espacio");
		addespacio.activarEspacio();

		// Seleccionar el icono
		Reporter.log("Seleccionar el icono del espacio");
		// espacio.cambiarIconoBasket();

		/*
		 * //Verificar ayuda del tipo de espacio
		 * 
		 * Reporter.log("Verificando modal de ayuda en Tipo de Espacio");
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement
		 * element = driver.findElement(By.linkText("Ayuda"));
		 * Thread.sleep(1000); js.executeScript("scroll(250, 0)");
		 * 
		 * //js.executeScript(
		 * "arguments[0].setAttribute('style', 'display: block; position: relative; height: 300px; width: 300px; opacity: 1; visiblity: visible')"
		 * ,element);
		 * 
		 * 
		 * driver.findElement(By.cssSelector("a[title='Muestra la ayuda']")).click
		 * ();
		 * driver.findElement(By.cssSelector(".spaceformtype .help")).click();
		 * 
		 * 
		 * //Cerrar el popup
		 * driver.findElement(By.cssSelector(".active .minformation .primary"
		 * )).click();
		 */
		// Seleccionar el tipo de espacio

		// Espacio publico

		addespacio.setEspacioPublico();

		// Grabar el espacio nuevo

		addespacio.grabarEspacio();

		Thread.sleep(1000);
		Reporter.log("Caso de crear espacio  finalizado correctamente");

	}

}
