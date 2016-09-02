package go5.pageObjects;



import go5.automation.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class AgregarUserPage extends SetUp {

	// Css

	protected String estadoActivadoCss = ".statedata label:nth-child(2) input:nth-child(1)";
	protected String estadoDesactivadoCss = ".statedata label:nth-child(2) input:nth-child(2)";
	protected String bloquearAccesoCss = ".statedata label:nth-child(3) input";

	protected String inputNombreUserCss = ".primarydata label:nth-child(1) input";
	protected String inputLastnameUserCss = ".primarydata label:nth-child(2) input";
	protected String inputemailUserCss = ".primarydata label:nth-child(3) input";
	protected String selectRolCss = ".primarydata label:nth-child(4) select";

	protected String desplegarCamposCss = ".addpeople fieldset:nth-child(4) .link";
    protected String agregarPersonaYEnviarInvitacionCss=".addpeople fieldset:nth-child(4) .primary";
	protected String agregarPersonaSinInvitacionCss = ".optional";

	
	protected String personasCss=".tables";
	protected String groupsSelectCss = ".groupsdata select";
	
	// Datos Laborales

		protected String idEmpleadoCss = ".labordata label:nth-child(1) input";
		protected String fechaIngresoCss = ".labordata label:nth-child(2) input";
		protected String tipoEmpleoCss = ".labordata label:nth-child(3) select";
		protected String tituloCss = ".labordata label:nth-child(4) select";
		protected String abrirReportaACss = ".labordata label:nth-child(5) ";
		protected String listaReportaACss = ".list li:nth-child(n)";
		protected String telFijoLaboralCss = ".labordata label:nth-child(7) input";
		protected String telMovilLaboralCss = ".labordata label:nth-child(8) input";
		protected String direccionLaboralCss = ".labordata label:nth-child(9) input";
	
		// Datos Personales

		protected String tipoDocumentoCss = ".personaldata label:nth-child(1) select";
		protected String documentoCss = ".personaldata label:nth-child(2) input";
		protected String fechaNacimientoCss = ".personaldata label:nth-child(3) input";
		protected String generoCss = ".personaldata label:nth-child(4) select";
		protected String estadoCivilCss = ".personaldata label:nth-child(5) select";
		protected String mailPersonalCss = ".personaldata label:nth-child(6) input";
		protected String telefonoFIjoCss = ".personaldata label:nth-child(7) input";
		protected String telefonoMovilCss = ".personaldata label:nth-child(8) input";
		protected String direccionPersonalCss = ".personaldata label:nth-child(9) input";

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
	 By groupsSelect=By.cssSelector(groupsSelectCss);
	 

		// Datos Laborales
		By idEmpleado = By.cssSelector(idEmpleadoCss);
		By fechaIngreso = By.cssSelector(fechaIngresoCss);
		By tipoEmpleo = By.cssSelector(tipoEmpleoCss);
		By titulo = By.cssSelector(tituloCss);
		By direccion = By.cssSelector(direccionLaboralCss);
		By abrirReportaA = By.cssSelector(abrirReportaACss);
		By listaReportaA = By.cssSelector(listaReportaACss);
		By telFijoLaboral = By.cssSelector(telFijoLaboralCss);
		By telMovilLaboral = By.cssSelector(telMovilLaboralCss);

		// Datos Personales
		By tipoDocumento = By.cssSelector(tipoDocumentoCss);
		By documento = By.cssSelector(documentoCss);
		By genero = By.cssSelector(generoCss);
		By fechaNacimiento = By.cssSelector(fechaNacimientoCss);
		By estadoCivil = By.cssSelector(estadoCivilCss);
		By mailPersonal = By.cssSelector(mailPersonalCss);
		By telefonoFijo = By.cssSelector(telefonoFIjoCss);
		By telefonoMovil = By.cssSelector(telefonoMovilCss);
		By direccionPersonal = By.cssSelector(direccionPersonalCss);
	
	//Driver
	WebDriver driver;

	public AgregarUserPage(WebDriver driver) {

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
	
	public void selectRolBasic() {
		// Seleccionar el rol basic

		Select selectRoldropdown = new Select(driver.findElement(selectRol));

		selectRoldropdown.selectByIndex(2);
	}
	
	public void selectRolAdminEspacios() {
		// Seleccionar el rol basic

		Select selectRoldropdown = new Select(driver.findElement(selectRol));

		selectRoldropdown.selectByIndex(3);
	}
	

	public void setGrupo() {

		// Select all values the drop-down for Language
		Reporter.log(" Tomar un grupo");
		Select selectGroup = new Select(driver.findElement(groupsSelect));
		selectGroup.selectByIndex(1);

	}

	public void grabarUsuarioSinInvite() {
	driver.findElement(agregarSinInvite).click();
	}
 
	
	public void grabarUsuarioConInvite(){
		driver.findElement(agregarConInvite).click();
	//	WebElement personasTable=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(personas));
		}

	public void goToDesplegarCampos(){
		driver.findElement(desplegarCampos).click();
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
		
	      Thread.sleep(3000);
		  this.grabarUsuarioConInvite();

		
		return email;
	}

	public String agregarBasicConInvite() throws Exception {

		// Devuelve el mail para despues poder loguearme
		
		 

		// Lo creo activado
		   driver.findElement(activo).click();

		// Poner el nombre
           this.setRandomUserName();
           this.setRandomLastName();
           this.setRandomEmail();

		// Seleccionar el rol basci
           this.selectRolBasic();
	      
		// Grabar el nuevo usuario creado
		
	      Thread.sleep(3000);
		  this.grabarUsuarioConInvite();

		
		return email;
	}
	
	public String agregarAdminEspacios() throws Exception  {

		// Devuelve el mail para despues poder loguearme
		
		 

		// Lo creo activado
		   driver.findElement(activo).click();

			// Poner el nombre
           this.setRandomUserName();
           this.setRandomLastName();
           this.setRandomEmail();

		// Seleccionar el rol basci
           this.selectRolAdminEspacios();
	      
		// Grabar el nuevo usuario creado
		
	      Thread.sleep(3000);
		  this.grabarUsuarioConInvite();

		return email;
	}
}
