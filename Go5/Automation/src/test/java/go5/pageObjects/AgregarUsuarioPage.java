package go5.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class AgregarUsuarioPage extends TestSuite {

	// Css

	protected String estadoActivadoCss = ".statedata label:nth-child(2) input:nth-child(1)";
	protected String estadoDesactivadoCss = ".statedata label:nth-child(2) input:nth-child(2)";
	protected String bloquearAccesoCss = ".statedata label:nth-child(3) input";

	protected String inputNombreUserCss = ".primarydata label:nth-child(2) input";
	protected String inputLastnameUserCss = ".primarydata label:nth-child(3) input";
	protected String inputemailUserCss = ".primarydata label:nth-child(4) input";
	protected String selectRolCss = ".primarydata label:nth-child(5) select";

	protected String desplegarCamposCss = ".addpeople fieldset:nth-child(4) .link";
    protected String agregarPersonaYEnviarInvitacionCss=".addpeople fieldset:nth-child(4) .primary";
	protected String agregarPersonaSinInvitacionCss = ".optional";

	
	
	protected String groupsSelect = ".groupsdata select";
	protected String grabarSinEnviarInvite = ".optional";

	// Modales

	protected String clickayudaEstadoPersona = "basicdata label:nth-child(1) a";
	protected String modalEstadoPersona0 = "#modal-container .modal:nth-child(4) h2";
	protected String cerrarModal = "#modal-container .modal:nth-child(4) .close";
	protected String clickmodalBloquearAcceso = ".basicdata label:nth-child(3) a";
	protected String modalBloquearAcceso = "#modal-container .modal:nth-child(6) h2";
	protected String okEntendidoModal = "#modal-container .modal:nth-child(6) .primary";

	
	//References
	
	 By activo=By.cssSelector(estadoActivadoCss);
	 By desactivado=By.cssSelector(estadoDesactivadoCss);
	 By bloquearAcceso=By.cssSelector(bloquearAccesoCss);
	 By inputNombre=By.cssSelector(inputNombreUserCss);
	 By inputLastName=By.cssSelector(inputLastnameUserCss);
	 By inputEmail=By.cssSelector(inputemailUserCss);
	 By selectRol=By.cssSelector(selectRolCss);
	 By desplegarCampos=By.cssSelector(desplegarCamposCss);
	 By agregarSinInvite=By.cssSelector(agregarPersonaSinInvitacionCss);
	 By agregarConInvite=By.cssSelector(agregarPersonaYEnviarInvitacionCss);
	 
	
	
	//Driver
	WebDriver driver;

	public AgregarUsuarioPage(WebDriver driver) {

		this.driver = driver;
	}

	// Set user name in textbox


	

	public void setRandomUserName() throws Exception {
		driver.findElement(inputNombre).sendKeys(name);
		
	}

	public void setRandomLastName() throws Exception {
		driver.findElement(inputLastName).sendKeys(name);
	}

	public void setRandomEmail() throws Exception {
		driver.findElement(inputEmail).sendKeys(email);

	}

	public void setEstadoActivo() throws InterruptedException {
		driver.findElement(activo).click();

	}

	public void setEstadoDesactivado() throws Exception {
		driver.findElement(desactivado).click();
	}

		
	
	public void agregarPersona() throws Exception {

		
		setRandomUserName();
		setRandomLastName();
		setRandomEmail();
		setEstadoDesactivado();

	}

	public void selectRol() {
		// Seleccionar el rol admin

		Select selectRoldropdown = new Select(driver.findElement(selectRol));

		selectRoldropdown.selectByIndex(1);
	}

	public void setGrupo() {

		// Select all values the drop-down for Language
		Reporter.log(" Tomar un grupo");
		Select selectGroup = new Select(driver.findElement(By
				.cssSelector(groupsSelect)));

		selectGroup.selectByIndex(1);

	}

	public void grabarUsuarioSinInvite() {
		driver.findElement(By.cssSelector(grabarSinEnviarInvite)).click();
	}

	public void elegirUsuarios(Integer index) {
		// Elegir Usuarios ( Activos es 1,2 es Inactivos, y 3 es No registrados

		Select userselect = new Select(driver.findElement(By
				.cssSelector(".filters select")));

		userselect.deselectByIndex(index);
		userselect.selectByIndex(index);
	}

	public void verificarUsuariosInactivos() {
		// Reocorrer la tabla y verificar que todos los usuarios mostrados sean
		// los users inactivos
		Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users inactivos");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)"))
							.getText(), "SIN CHEQUEAR");
		Reporter.log("Todos los usuarios de la lista se encuentran desactivados");
	}

	public void filtrarUsuariosActivos() {
		Reporter.log("Reocorrer la lista de usuarios y filtrar los users activos");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)"))
							.getText(), "CHEQUEADO");
		Reporter.log("Todos los usuarios de la lista se encuentran activados");

	}

	

	public String crearUserAdminReturningmail() throws Exception {

		// Devuelve el mail para despues poder loguearme
		//this.click(crearUser);

		// Lo creo activado
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".basicdata label:nth-child(2)"))
				.click();

		// Poner el nombre

		this.sendValue(".basicdata label:nth-child(4) input", name);

		this.sendValue(".basicdata label:nth-child(5) input", name);
		this.sendValue(".basicdata label:nth-child(6) input", email);

		// Seleccionar el rol admin

		Select selectRol = new Select(driver.findElement(By
				.cssSelector(".basicdata label:nth-child(7) select")));

		selectRol.selectByIndex(1);

		// Grabar el nuevo usuario creado
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector(".content .addpeople fieldset:nth-child(4) .primary"))
				.click();

		// Verificar que vuelva al listado de personas

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info(driver.findElement(By.cssSelector(".tablefilter"))
				.isDisplayed());
		return email;
	}

	public void verificarUsuariosNoRegistrados() {

		Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users que no estan registrados");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(6n)"))
							.getText(), "SIN CHEQUEAR");
		Reporter.log("Todos los usuarios de la lista se encuentran en estado no registrado");
	}

	public void verificarUsuariosActivos() {
		Reporter.log("Reocorrer la lista de usuarios y verificar que todos los usuarios mostrados sean los users activos");

		for (int i = 1; i < 10; i++)
			Assert.assertEquals(
					driver.findElement(
							By.cssSelector(".tables tbody tr:nth-child(n) td:nth-child(5n)"))
							.getText(), "CHEQUEADO");
		Reporter.log("Todos los usuarios de la lista se encuentran activados");
	}
}
