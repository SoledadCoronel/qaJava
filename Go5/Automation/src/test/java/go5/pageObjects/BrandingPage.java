package go5.pageObjects;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BrandingPage  {

	// Generic Css

	private String headerCss = "header h1";
	private String goToRestablecerInterfazCss = ".design fieldset:nth-child(5) a";
	private String confirmarInterfazCss = ".active .primary";
	private String cancelarInterfazCss = ".active .optional";
	private String guardarCambiosCss = ".design fieldset:nth-child(5) .primary";

	// Platform Logo

	private String platformLogoPictureId = "logoFilePicker";
	private String okPictureCss = ".active .mconfirmation .primary";

	// Platform Colors

	private String colorPickerCss = "#designColorPicker";
	private String colorPlataformaRojoCss = ".design .colorpicker .red";
	private String colorRojoHexa = "rgba(255, 51, 51, 1)";
	private String colorPlataformaVerdeCss = ".design .colorpicker .green";
	private String colorPlataformaYellowCss = ".design .colorpicker .yellow";

	// Text Contrast Colors

	private String sampleCss = ".design fieldset:nth-child(3) .sample";
	private String colorNegroContrasteCss = ".design fieldset:nth-child(3) .black";
	private String colorNegroHexa = "rgba(0, 0, 0, 1)";
	private String getColorNegroCss = ".design fieldset:nth-child(3) .colorpicker .black a";
	private String colorBlancoContrasteCss = ".design fieldset:nth-child(3) .white";

	// Background Image

	private String backgroundPictureId = "loginBgFilePicker";

	// References
	By header = By.cssSelector(headerCss);
	By goToRestablecerInterfaz = By.cssSelector(goToRestablecerInterfazCss);
	By okRestablecerInterfaz = By.cssSelector(confirmarInterfazCss);
	By guardarCambios = By.cssSelector(guardarCambiosCss);
	By cancelaRestablecerInterfaz = By.cssSelector(cancelarInterfazCss);

	// Colours

	// Platform
	By colorPickerPlatform = By.cssSelector(colorPickerCss);
	By colorPlataformaRojo = By.cssSelector(colorPlataformaRojoCss);
	By colorPlataformaVerde = By.cssSelector(colorPlataformaVerdeCss);
	By colorPlataformaYellow = By.cssSelector(colorPlataformaYellowCss);

	// Text Contrast
	By colorNegroContraste = By.cssSelector(colorNegroContrasteCss);
	By colorBlancoContraste = By.cssSelector(colorBlancoContrasteCss);
	By getColorNegro = By.cssSelector(getColorNegroCss);
	By sample = By.cssSelector(sampleCss);

	// Pictures

	By loadLogoPicture = By.id(platformLogoPictureId);
	By loadBackgroundPicture = By.id(backgroundPictureId);
	By okPicture = By.cssSelector(okPictureCss);

	// Driver

	WebDriver driver;
	
	// Constructor

	public BrandingPage(WebDriver driver) {

		this.driver = driver;
	}

	public void restablecerInterfaz() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		Reporter.log("Clickeo en restablecer Interfaz");
		driver.findElement(goToRestablecerInterfaz).click();
		Thread.sleep(2000);
		//WebElement okPopup = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(okRestablecerInterfaz));
		// Click en el popup de restorear
		driver.findElement(okRestablecerInterfaz).click();
	}

	public void verifyColors() {
		// Verify list of colors in branding
		Reporter.log(" Veirificando que esten todos los colores disponibles");
		driver.findElement(colorPlataformaRojo).click();
		driver.findElement(colorPickerPlatform).getAttribute(colorPlataformaRojoCss);

	}

	public void changeColorPlatform() {

		Reporter.log(" Cambiando el color de la plataforma a rojo");
		driver.findElement(colorPlataformaRojo).click();
		String colorHeader = new String(driver.findElement(By.tagName("header")).getCssValue("background-color"));
		Assert.assertEquals(colorRojoHexa, colorHeader);
		Reporter.log("El color seleccionado en branding se muestra correctamente en el header");
	}

	public void changeColorText() {

		Reporter.log(" Cambiando el color de las letras ");
		driver.findElement(colorNegroContraste).click();
		String colortext = driver.findElement(header).getCssValue("color");
		Reporter.log("El color que esta en la letra en el header es :");
		Reporter.log(colortext);
		Assert.assertEquals(colorNegroHexa, colortext);

		Reporter.log(" El caso de branding-colors finalizo correctamente");
	}

	public void guardar() {
		driver.findElement(guardarCambios).click();
	}

	public void loadLogoPicture() throws InterruptedException {
		// function to make visible the button logoFilePicker, as it is set to
		// class "off"
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(loadLogoPicture);
		js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);
		// Agarrar el elemento para cargar el file y pasarle el path
		WebElement upload = driver.findElement(loadLogoPicture);
		File file = new File("src/test/resources/Girasol.jpeg");
		Reporter.log(file.getAbsolutePath());
		upload.sendKeys(file.getAbsolutePath());
		Thread.sleep(3000);
		driver.findElement(okPicture).click();
		Reporter.log("Foto cargada exitosamente");
		this.guardar();
	}
		
	public void loadBackgroundPicture() throws InterruptedException{
			Reporter.log("Cargando foto para el backgroud de la plataforma");

		// function to make visible the button loginBgFilePicker, as it is set
		// to class "off"
			JavascriptExecutor js = (JavascriptExecutor) driver;	
		WebElement elementbackground = driver.findElement(loadBackgroundPicture);
		js.executeScript("arguments[0].setAttribute('style', 'display:block')",elementbackground);

		// Agarrar el elemento para cargar el file y pasarle el path

		// Agarrar el elemento para cargar el file y pasarle el path

		File filebackground = new File("src/test/resources/Background.jpg");

		Reporter.log(filebackground.getAbsolutePath());
		elementbackground.sendKeys(filebackground.getAbsolutePath());
		Thread.sleep(3000);
		driver.findElement(okPicture).click();
		Reporter.log("Foto cargada exitosamente");
		Thread.sleep(2000);
		this.guardar();
	
	}
}
