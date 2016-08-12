package go5.pageObjects;

import go5.automation.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EspacioPage extends SetUp {

	// Go To Spaces
	
	private String goToEspaciosCss = "article .space:last-child li:last-child a";// to find it with jquery on chrome use $('.space li:last-child a')
	protected String goToRecomendadosCss = ".title menu li:first-child a";

	// Order

	protected String ordenNombre =	".tables thead tr th:nth-child(2) a";
	protected String ordenDescripcion = ".tables thead tr th:nth-child(3) a";
	protected String ordenMiembros =	".tables thead tr th:nth-child(4) a";

	protected String ordenTitulo = ".igocaretdown";

	//
	protected String editfourthRow =".tables tbody tr:nth-child(4) td:nth-child(5) a";
	protected String firstType = ".tables  tr:nth-child(1) td:nth-child(3)";
	protected String firstSpace = ".tables tbody tr:nth-child(1) td:nth-child(2) a";
	protected String firstState = ".tables tbody tr:nth-child(1) td:nth-child(5) a";
	protected String firstName = ".tables tbody tr:nth-child(1) td:nth-child(2) a";
	protected String secondName = ".tables tbody tr:nth-child(2) td:nth-child(2) a";

	// Search Spaces
	protected String buscarEspacio = ".actions .btnsearch";
	protected String inputSearch = ".actions .search input";

	// References

	// By
	By goToEspacios = By.cssSelector(goToEspaciosCss);
	By goToRecomendados = By.cssSelector(goToRecomendadosCss);

	// Driver

	protected WebDriver driver;

	// Constructor

	public EspacioPage(WebDriver driver) {

		this.driver = driver;
	}

	public void goToEspacios() {
		driver.findElement(goToEspacios).click();
		// Wait until recomendados appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(goToRecomendados));

	}

	public void ordenarPorNombreEspacio() throws InterruptedException {
		driver.findElement(By.cssSelector(ordenNombre)).click();

		Reporter.log("El primer nombre de la tabla es :");
		Reporter.log(driver.findElement(By.cssSelector(firstName)).getText());
		Reporter.log("El segundo nombre de la tabla es :");
		Reporter.log(driver.findElement(By.cssSelector(secondName)).getText());
		verificarOrden();
	}

	public void ordenarPorEstado() throws InterruptedException {
		driver.findElement(By.cssSelector(ordenEstado)).click();
		Reporter.log("El valor del primer estado es :");
		Reporter.log(driver.findElement(By.cssSelector(firstState)).getText());
	}

	public String getTypeFirstRow() {
		// Ver q el primero de la lista sea tipo empresa
		return (driver.findElement(By.cssSelector(firstType)).getText());

	}

	public void verificarOrdenDefault() {

		Reporter.log("Verificar que el primer tipo de espacio es de empresa");
		Assert.assertEquals(this.getTypeFirstRow(), "company",
				"El primero es empresa");
		Reporter.log("El valor del tipo de espacio es:");
		Reporter.log(this.getTypeFirstRow());

	}

	public String getFirstNameSpace() {

		return driver.findElement(By.cssSelector(firstName)).getText();
	}

	public String getSecondName() {

		return driver.findElement(By.cssSelector(secondName)).getText();
	}

	public void verificarOrden() {

		if (this.getFirstNameSpace().compareTo(this.getSecondName()) < 0)

			Reporter.log("Los espacios estan ordenados alfabeticamente por orden ascendente( de la A la Z,");
		else
			Reporter.log("La pagina esta ordenada alfabeticamente por orden descencdente ( de la Z a la A ");
	}

	public void buscarEspacio(String espacio) {

		Reporter.log("Buscar un espacio en el listado de Espacios");
		driver.findElement(By.cssSelector(buscarEspacio)).click();
		driver.findElement(By.cssSelector(inputSearch)).clear();
		driver.findElement(By.cssSelector(inputSearch)).sendKeys(espacio);
		driver.findElement(By.cssSelector(inputSearch)).sendKeys(Keys.ENTER);
		Reporter.log(" El nombre a buscar es :..");
		Reporter.log(espacio);
		Reporter.log("El nombre encontrado es ..");
		Reporter.log(driver.findElement(By.cssSelector(firstSpace)).getText());

	}

	public void clickEspacioSidebar(String iconoEspacio) {

		Reporter.log("Clickear un espacio pasandole el icono");
		driver.findElement(By.cssSelector(iconoEspacio)).click();
		

	}
}
