package go5.pageObjects;

import go5.automation.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EspaciosPage extends SetUp {

	// Go To Spaces
	
	protected String goToRecomendadosCss = ".igotitleswhite";
	private String goToMisEspaciosCss = ".igopasswordwhite";
	


	// Order

	protected String ordenNombreEspaciosCss =	".igocaretdown";
	
	
	//Espacios
	protected String editfourthRowCss =".tables tbody tr:nth-child(4) td:nth-child(5) a";
	protected String firstTypeCss = ".tables  tr:nth-child(1) td:nth-child(3)";
	protected String firstSpaceCss = ".tables tbody tr:nth-child(1) td:nth-child(2) a";
	protected String firstNameCss = ".tables tbody tr:nth-child(1) td:nth-child(2) a";
	protected String secondNameCss = ".tables tbody tr:nth-child(2) td:nth-child(2) a";

	// Search Spaces
	protected String buscarEspacioCss = ".btnsearch";
	protected String inputSearchCss = ".search input";
	private String textPostCss=".posttext";

	// References

	// By
	By goToMisEspacios = By.cssSelector(goToMisEspaciosCss);
	By goToRecomendados = By.cssSelector(goToRecomendadosCss);
	
	// Order

	By ordenNombreEspacios= By.cssSelector(ordenNombreEspaciosCss);
		
	//Espacios
	By editfourthRow = By.cssSelector(editfourthRowCss);
	By firstType = By.cssSelector(firstTypeCss);
	By firstSpace = By.cssSelector(firstSpaceCss);
	By firstName = By.cssSelector(firstNameCss);
	By secondName = By.cssSelector(secondNameCss);

	// Search Spaces
	By buscarEspacio = By.cssSelector(buscarEspacioCss);
	By inputSearch = By.cssSelector(inputSearchCss);
	
	By textPost=By.cssSelector(textPostCss);
	

	// Driver

	protected WebDriver driver;

	// Constructor

	public EspaciosPage(WebDriver driver) {

		this.driver = driver;
	}

	public void goToMisEspacios() {
		driver.findElement(goToMisEspacios).click();
		// Wait until recomendados appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(goToRecomendados));

	}
	public void goToRecomendados() {
		driver.findElement(goToRecomendados).click();
		// Wait until recomendados appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(goToRecomendados));

	}

	public void ordenarPorNombreEspacio() throws InterruptedException {
		driver.findElement(ordenNombreEspacios).click();

		Reporter.log("El primer nombre de la tabla es :");
		Reporter.log(driver.findElement(firstName).getText());
		Reporter.log("El segundo nombre de la tabla es :");
		Reporter.log(driver.findElement(secondName).getText());
		verificarOrden();
	}

	public String getTypeFirstRow() {
		// Ver q el primero de la lista sea tipo empresa
		return (driver.findElement(firstType).getText());

	}

	public String getFirstNameSpace() {

		return driver.findElement(firstName).getText();
	}

	public String getSecondName() {

		return driver.findElement(secondName).getText();
	}

	public void verificarOrden() {

		if (this.getFirstNameSpace().compareTo(this.getSecondName()) < 0)

			Reporter.log("Los espacios estan ordenados alfabeticamente por orden ascendente( de la A la Z,");
		else
			Reporter.log("La pagina esta ordenada alfabeticamente por orden descencdente ( de la Z a la A ");
	}

	public void buscarEspacio(String espacio) {

		Reporter.log("Buscar un espacio en el listado de Espacios");
		driver.findElement(buscarEspacio).click();
		driver.findElement(inputSearch).clear();
		driver.findElement(inputSearch).sendKeys(espacio);
		driver.findElement(inputSearch).sendKeys(Keys.ENTER);
		Reporter.log(" El nombre a buscar es :..");
		Reporter.log(espacio);
		Reporter.log("El nombre encontrado es ..");
		Reporter.log(driver.findElement(firstSpace).getText());

	}

	public void clickEspacioSidebar(String iconoEspacio) {

		Reporter.log("Clickear un espacio pasandole el icono");
		driver.findElement(By.cssSelector(iconoEspacio)).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textPost));

	}
	
	public void goToEditEspacio(){
		driver.findElement(editfourthRow).click();
	}
}
