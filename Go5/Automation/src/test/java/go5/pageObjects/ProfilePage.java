package go5.pageObjects;

import go5.automation.SetUp;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class ProfilePage extends SetUp {

	// Css

	// Profile

	protected String irAProfile = ".last .igouserwhite";
	private String goToAcercaCss = ".igotitleswhite";
	private String goToSocialCss = ".title .igosocialswhite";
	protected String goToProfileSidebar = ".igowithoutimage";
	private String datosPerfilCss = ".data";
	private String linkSupervisor = "small a ";

	// Edit Profile

	protected String editProfileCss = ".data:first-child a";
	protected String grabarUser = ".last .primary";
	protected String editFoto = "#photoFileDrop";

	private String confirmar = ".active .primary";
	private String cancelar = ".active .optional";
	private String selectPictureOrCamera = "#photoFileDrop";

	//Picture
	private String inputPictureProfileCss="form.dotmenu label input";
	
	// Datos Laborales

	protected String idEmpleadoCss = ".labordata label:nth-child(2) input";
	protected String fechaIngresoCss = ".labordata label:nth-child(3) input";
	protected String tipoEmpleoCss = ".labordata label:nth-child(4) select";
	protected String tituloCss = ".labordata label:nth-child(5) select";
	protected String abrirReportaACss = ".labordata label:nth-child(6) ";
	protected String listaReportaACss = ".list li:nth-child(n)";
	protected String telFijoLaboralCss = ".labordata label:nth-child(7) input";
	protected String telMovilLaboralCss = ".labordata label:nth-child(8) input";
	protected String direccionLaboralCss = ".labordata label:nth-child(9) input";

	// Grupos

	protected String gruposCss = ".  ";

	// Datos Personales

	protected String tipoDocumentoCss = ".personaldata label:nth-child(2) select";
	protected String documentoCss = ".personaldata label:nth-child(3) input";
	protected String fechaNacimientoCss = ".personaldata label:nth-child(4) input";
	protected String generoCss = ".personaldata label:nth-child(5) select";
	protected String estadoCivilCss = ".personaldata label:nth-child(6) select";
	protected String mailPersonalCss = ".personaldata label:nth-child(7) input";
	protected String telefonoFIjoCss = ".personaldata label:nth-child(8) input";
	protected String telefonoMovilCss = ".personaldata label:nth-child(9) input";
	protected String direccionPersonalCss = ".personaldata label:nth-child(10) input";

	// Redes Sociales

	protected String linkedinCss = ".socialdata label:nth-child(2) input";
	protected String twitterCss = ".socialdata label:nth-child(3) input";
	protected String facebookCss = ".socialdata label:nth-child(4) input";

	// Social

	protected String textAreaPostcss = ".postbox fieldset:nth-child(1) label:nth-child(4) div";

	// Variables

	private String emailUser = "address a:first-child";
	private String miEmail = "marina.touceda@gointegro.com";
	private String telefonoMovilHeader = "address a:nth-child(3)";
	private String telefonoFijoHeader = "address a:nth-child(4)";

	SoftAssert sa = new SoftAssert();

	// References

	By goToMiPerfil = By.cssSelector(irAProfile);
	By goToSocial = By.cssSelector(goToSocialCss);
	By goToAcerca=By.cssSelector(goToAcercaCss);
	By goToMiPerfilSidebar = By.cssSelector(goToProfileSidebar);
	By datosProfile = By.cssSelector(datosPerfilCss);

	// Edit Profile

	By editProfile = By.cssSelector(editProfileCss);
	
	//Picture
	By pictureProfile=By.cssSelector(inputPictureProfileCss);
	
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

	// Redes Sociales

	By linkedin = By.cssSelector(linkedinCss);
	By facebook = By.cssSelector(facebookCss);
	By twitter = By.cssSelector(twitterCss);

	// Social

	By textAreaPost = By.cssSelector(textAreaPostcss);

	// Driver

	WebDriver driver;

	// Function Random

	Random numero = new Random();

	// Constructor

	public ProfilePage(WebDriver driver) {

		this.driver = driver;
	}

	public String cssLink(String url) {

		String css = "a[href^=" + (url) + "]";
		return css;
	}

	// a[href^="http://twitter.com/username"]

	public void goToTwitter() {

		String css = this.cssLink("\"http://twitter.com/username\"");

		// driver.findElement(By.cssSelector(css)).click();
		Reporter.log("Verificando link de twiter");
		Reporter.log("El link cargado de twitter es :");
		Reporter.log(driver.findElement(By.cssSelector(css)).getText());

	}

	public void goToFacebook() {
		String css = this.cssLink("\"http://facebook.com/username\"");
		// driver.findElement(By.cssSelector(css)).click();

		Reporter.log("Verificando link de facebook");
		Reporter.log("El link cargado de facebook es :");
		Reporter.log(driver.findElement(By.cssSelector(css)).getText());

	}

	public void goToProfile() {
		Reporter.log("Ir a Profile");
		driver.findElement(goToMiPerfil).click();
		WebElement profilePage = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(datosProfile));
	}

	public void goToProfileSideBar() throws InterruptedException {

		// Go to the user menu
		Reporter.log("Ir a Perfil Desde el sidebar");
		driver.findElement(goToMiPerfilSidebar).click();
		WebElement profilePage = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions
						.presenceOfElementLocated(datosProfile));
	}

	public void editarProfile() {
		Reporter.log("Editar perfil");
		driver.findElement(editProfile).click();
		WebElement editForm = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(idEmpleado));
	}

	public void grabarUsuario() {
		Reporter.log("Grabando el profile");
		driver.findElement(By.cssSelector(grabarUser)).click();

	}

	public void goToSupervisor() {

		// Go to the user menu
		Reporter.log("Ir a Perfil del supervisor desde el profile del user");
		driver.findElement(By.cssSelector(linkSupervisor)).click();
	}

	public void agregarDatosLaborales() {
		// Insertar datos laborales
		Reporter.log("Editando datos laborales");

		driver.findElement(idEmpleado).clear();
		driver.findElement(idEmpleado).sendKeys("RandomId" + numero.nextInt());

		driver.findElement(fechaIngreso).sendKeys("10/10/10");
		driver.findElement(tipoEmpleo).click();
		driver.findElement(tipoEmpleo).sendKeys("part-time");

	}

	public void agregarTelefonos() throws InterruptedException {

		// Telefono
		Reporter.log("Editando telefono");
		driver.findElement(telefonoFijo).clear();
		driver.findElement(telefonoFijo).sendKeys("1147511234");
		Thread.sleep(7000);
		driver.findElement(telefonoMovil).clear();
		driver.findElement(telefonoMovil).sendKeys("1147511234");
	}

	public void agregarDatosPersonales() {
		// Datos Personales

		Reporter.log("Editando datos personales");
		driver.findElement(tipoDocumento).sendKeys("RUT");
		driver.findElement(documento).clear();
		driver.findElement(documento).sendKeys("11111111111");
		driver.findElement(fechaNacimiento).sendKeys("11/11/11");
		driver.findElement(genero).sendKeys("female");
		driver.findElement(estadoCivil).sendKeys("single");
		driver.findElement(mailPersonal).clear();
		driver.findElement(mailPersonal)
				.sendKeys("fakee5555mail@gointegro.com");
		driver.findElement(telefonoFijo).clear();
		driver.findElement(telefonoFijo).sendKeys("1147511234");
		driver.findElement(telefonoMovil).clear();
		driver.findElement(telefonoMovil).sendKeys("1147511234");
		driver.findElement(direccionPersonal).clear();
		driver.findElement(direccionPersonal).sendKeys("Mi Casa 123");

	}

	public void agregarRedesSociales() {

		Reporter.log("Editando redes  sociables");

		driver.findElement(linkedin).clear();
		driver.findElement(linkedin)
				.sendKeys("http://linkedin.com/in/username");

		driver.findElement(twitter).clear();
		driver.findElement(twitter).sendKeys("http://twitter.com/username");

		driver.findElement(facebook).clear();
		driver.findElement(facebook).sendKeys("http://facebook.com/username");
	}

	public void cancelarSubirFoto() throws InterruptedException {

		//js = (JavascriptExecutor) driver;
		driver.findElement(By.cssSelector(selectPictureOrCamera)).click();
		//WebElement element = driver.findElement(pictureProfile);
		//js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);

		// Agarrar el elemento para cargar el file y pasarle el path

		WebElement subirFile = driver.findElement(pictureProfile);

		File file = new File("src/test/resources/Girasol.jpeg");
		subirFile.sendKeys(file.getAbsolutePath());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(confirmar)).click();
		Reporter.log(" El subir foto ha sido cancelado");
	}

	public void cargarFoto() throws InterruptedException {

		js = (JavascriptExecutor) driver;
		// ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		driver.findElement(By.cssSelector(selectPictureOrCamera)).click();
		WebElement element = driver.findElement(By.id("sarasa"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block')",
				element);

		// Agarrar el elemento para cargar el file y pasarle el path

		WebElement subirFile = driver.findElement(By.id("sarasa"));

		File file = new File("src/test/resources/Girasol.jpeg");
		subirFile.sendKeys(file.getAbsolutePath());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(confirmar)).click();
		Reporter.log(" Foto cargada exitosamente");
	}

	public void verifyemaildisplayedAtHeader() {

		Reporter.log("El email q se muestra es :");

		Assert.assertEquals(miEmail,
				driver.findElement(By.cssSelector(emailUser)).getText());

		Reporter.log(miEmail);
	}

	public void verifyPhonesDisplayedAtHeader() {

		driver.findElement(By.cssSelector(telefonoFijoHeader)).isDisplayed();
		driver.findElement(By.cssSelector(telefonoMovilHeader)).isDisplayed();
		Reporter.log("Los telefonos fijos y moviles se muestran en los datos del profile");
	}

	public void goToSocial() {
		driver.findElement(goToSocial).click();
	//	WebElement profilePage = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(textAreaPost));
	}

	public void goToAcerca(){
		driver.findElement(goToAcerca).click();
		
	}
}
