package go5.pageObjects;

import java.util.List;

import go5.automation.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AdministrarPersonasPage extends SetUp {

	// Css

	protected String agregarUsuarioCss = ".data .primary";
	protected String invitacionesPendientesCss=".title menu li:nth-child(2) a";
	protected String listadoPersonasCss=".title menu li:nth-child(2) a";
	protected String listaInvitacionesCss=".tables";
	protected String dominiosCss=".title menu li:nth-child(3) a";
	protected String listaDominiosCss=".peopledomain";
	protected String tablaPersonasCss = ".open article .peoplemanage";
	protected String selectUserCss = ".filters select";
	protected String editPersonCss = " tbody tr:nth-child(n) td:nth-child(7) a";
	protected String editfirstRowCss = " tbody tr:nth-child(1) td:nth-child(7) a";
	protected String searchButtonCss = ".btnsearch";
	protected String searchInputCss = ".search input";
	protected String ordenByNameCss = "thead tr th:nth-child(2) a";
	protected String firstRowCss = "tbody tr:nth-child(1) td:nth-child(2)";
	protected String secondRowCss = "tbody tr:nth-child(2) td:nth-child(2)";

	private String linkHelpCss = "igohelpwhite";
	private String formEditPersonCss = ".igogroups";
	protected String inputNombreUserCss = ".primarydata label:nth-child(2) input";
	
	//Driver
	
	WebDriver driver;

	// By

	By agregarUsuario = By.cssSelector(agregarUsuarioCss);
	By listado= By.cssSelector(listadoPersonasCss);
	By invitaciones=By.cssSelector(invitacionesPendientesCss);
	By listaInvitaciones= By.cssSelector(listaInvitacionesCss);
	By listaDominios=By.cssSelector(listaDominiosCss);
	By dominios=By.cssSelector(dominiosCss);
	By tablaPersonas = By.cssSelector(tablaPersonasCss);
	By selectUsers = By.cssSelector(selectUserCss);
	By editPerson = By.cssSelector(editPersonCss);
	By editFirstPerson = By.cssSelector(editfirstRowCss);
	By ordenByName = By.cssSelector(ordenByNameCss);
	By firstRow = By.cssSelector(firstRowCss);
	By secondRow = By.cssSelector(secondRowCss);
	By help = By.cssSelector(linkHelpCss);
	By formEditPerson = By.cssSelector(formEditPersonCss);
	By searchButton = By.cssSelector(searchButtonCss);
	By searchInput = By.cssSelector(searchInputCss);
	By inputName=By.cssSelector(inputNombreUserCss);

	
	//Methods
	
	
	public AdministrarPersonasPage(WebDriver driver) {

		this.driver = driver;
	}

	
	
	public void goToagregarPersona(){
		driver.findElement(agregarUsuario).click();
		WebElement formuPerson = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(inputName));
	}
	
	public void goToInvitacionesPendientes(){
		driver.findElement(invitaciones).click();
	//	WebElement inviteList = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(listaInvitaciones));
	}
	
	public void goToDominios(){
		driver.findElement(dominios).click();
		WebElement domains = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(listaDominios));
	}
	
	
	public void contarPersonasTabla() {
		// Hay que modificarla....
		// Obtener la cantidad de usuarios antes de agregar user

		WebElement htmltable = driver.findElement(tablaPersonas);

		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		Reporter.log("La cantidad de usuarios en la tabla es:", rows.size());

	}

	public void goToEditFromListPersons(Integer index) {

		// Probar si anda o si hay que pasarle un numero especifico
		driver.findElement(editPerson).click();
	}

	public void editFirstPersonFromList() {
		driver.findElement(editFirstPerson).click();
		WebElement formuPerson = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(formEditPerson));
	}

	public void elegirUsuarios(Integer index) throws InterruptedException {
		// Elegir Usuarios ( Activos es 1,2 es Inactivos, y 3 es No registrados

		Select userselect = new Select(driver.findElement(selectUsers));

		// userselect.deselectByIndex(index);
		userselect.selectByIndex(index);
		Thread.sleep(3000);
	}

	public void verificarUsuariosInactivos() {
		// Reocorrer la tabla y verificar que todos los usuarios mostrados sean
		// los users inactivos
		Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users inactivos");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)"))
							.getText(), "Sin chequear");
		Reporter.log("Todos los usuarios de la lista se encuentran desactivados");
	}

	public void filtrarUsuariosActivos() {
		Reporter.log("Reocorrer la lista de usuarios y filtrar los users activos");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)"))
							.getText(), "Chequeado");
		Reporter.log("Todos los usuarios de la lista se encuentran activados");

	}

	public void ordenarPorNombre() {
		driver.findElement(ordenByName).click();
	}

	public void searchForAPerson(String strUserToSearch) {
		driver.findElement(searchButton).click();
		driver.findElement(searchInput).sendKeys(strUserToSearch);

	}

	public void verificarUsuariosNoRegistrados() {

		Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users que no estan registrados");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(6n)"))
							.getText(), "Sin chequear");
		Reporter.log("Todos los usuarios de la lista se encuentran en estado no registrado");
	}

	public void verificarUsuariosActivos() {
		Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users activos");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)"))
							.getText(), "Chequeado");
		Reporter.log("Todos los usuarios de la lista se encuentran activados");
	}
}
