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

public class AgregarEspacioPage extends SetUp {

	// Css Define Space

	private String crearEspacioCss = ".igospaces a";
	private String nombreEspacioCss = ".first label:nth-child(1) input";
	private String descripcionEspacioCss = ".first label:nth-child(2) input";

	// Space type
	private String espacioPublicoCss = ".type label:nth-child(3) input";
	private String espacioPrivadoCss = ".type label:nth-child(4) input";
	private String espacioEmpresaCss = ".type label:nth-child(2) input";
	private String activarEspacioCss = ".config label:nth-child(2) .active";
	private String activadadSocialCss = ".config label:nth-child(3) span";

	// Icons

	private String cambiarIconoCss = ".igopuzzle";
	private String iconoOsoCss = ".igospacebear";
	private String iconoBasketCss = ".igospacebasket";
	private String iconoBananaCss = ".igospacebanana";
	private String grabarIconoCss = ".active .mconfirmation .primary";

	// Save Space

	protected String grabarEspacioCss = ".spacecreate .primary";
	protected String grabarEspacioEmpresaInactivoCss = ".active .mconfirmation .optional";


	// References

	// By

	By crearEspacio = By.cssSelector(crearEspacioCss);
	By nombreDeEspacio = By.cssSelector(nombreEspacioCss);
	By descripcionEspacio = By.cssSelector(descripcionEspacioCss);

	// Space type

	By espacioPublico = By.cssSelector(espacioPublicoCss);
	By espacioPrivado = By.cssSelector(espacioPrivadoCss);
	By espacioEmpresa = By.cssSelector(espacioEmpresaCss);
	By activarEspacio = By.cssSelector(activarEspacioCss);
	By activadadSocial = By.cssSelector(activadadSocialCss);

	// Icons

	By cambiarIcono = By.cssSelector(cambiarIconoCss);
	By grabarIcono = By.cssSelector(grabarIconoCss);

	// Save Space

	By grabarEspacio = By.cssSelector(grabarEspacioCss);
	By grabarEspacioEmpresaInactivo = By
			.cssSelector(grabarEspacioEmpresaInactivoCss);

	// Driver

	protected WebDriver driver;

	// Constructor

	public AgregarEspacioPage(WebDriver driver) {

		this.driver = driver;
	}

	public void goToCrearEspacio() {
		driver.findElement(crearEspacio).click();

	}

	public void setNameEspacio(String name) {
		driver.findElement(nombreDeEspacio).clear();
		driver.findElement(nombreDeEspacio).sendKeys(name);

	}

	public void setDescriptionEspacio(String description) {

		driver.findElement(descripcionEspacio).sendKeys(description);
	}

	public void setEspacioPublico() throws Exception {
		Reporter.log("Seleccionando un tipo de espacio Publico:");
		driver.findElement(espacioPublico).click();
	}

	public void setEspacioEmpresa() throws Exception {
		Reporter.log("Seleccionando un tipo de espacio Empresa:");
		driver.findElement(espacioEmpresa).click();
	}

	public void setEspacioPrivado() throws Exception {
		Reporter.log("Seleccionando un tipo de espacio Privado:");
		driver.findElement(espacioPrivado).click();
	}

	public void activarEspacio() {
		Reporter.log("Clickear Espacio activo");
		driver.findElement(activarEspacio).click();
	}

	public void activarActividadSocial() {
		Reporter.log("Clickear Actividad Social");
		driver.findElement(activadadSocial).click();
	}

	public void cambiarIcono(String icono) throws InterruptedException {

		Reporter.log("Seleccionar Icono");
		driver.findElement(cambiarIcono).click();
		this.clickWhenReady(grabarIcono, 10);

	}

	public void grabarEspacio() {
		Reporter.log("Grabando espacio");
		driver.findElement(grabarEspacio).click();
	}

	public void grabarEspacioEmpresaInactivo() {
		driver.findElement(grabarEspacioEmpresaInactivo).click();
	}

	public void editarEspacio() {
		// Agarro el cuarto elemento de la lista y lo tomo para editarlo

	//	driver.findElement(By.cssSelector(editfourthRow)).click();
	}

	public void cambiarIconoOso() throws InterruptedException {
		cambiarIcono(iconoOsoCss);
	}

	public void cambiarIconoBasket() throws InterruptedException {
		cambiarIcono(iconoBasketCss);
	}

}
