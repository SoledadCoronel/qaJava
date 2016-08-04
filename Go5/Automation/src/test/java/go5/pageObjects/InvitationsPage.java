package go5.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class InvitationsPage extends TestSuite {

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

	
	protected String personasCss=".tables";
	protected String groupsSelect = ".groupsdata select";
	
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
	 By personas = By.cssSelector(personasCss);
	 
	
	
	//Driver
	WebDriver driver;

	public InvitationsPage(WebDriver driver) {

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

	public void selectRolAdmin() {
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
	driver.findElement(agregarSinInvite).click();
	}
 
	
	public void grabarUsuarioConInvite(){
		driver.findElement(agregarConInvite).click();
		WebElement personasTable=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(personas));
		}

	

	public String agregarAdminConInvite() throws Exception {

		// Devuelve el mail para despues poder loguearme
		
		 

		// Lo creo activado
		   driver.findElement(activo).click();

		// Poner el nombre
           this.setRandomUserName();
           this.setRandomLastName();
           this.setRandomEmail();

		// Seleccionar el rol admin

	      this.selectRolAdmin();

		// Grabar el nuevo usuario creado
		
		  this.grabarUsuarioConInvite();

		
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
