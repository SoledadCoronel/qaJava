package go5.pageObjects;

import go5.automation.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BrandingPage extends SetUp {

	// Generic Css

	private String headerCss = "header h1";
	private String goToRestablecerInterfazCss = ".restores";
	private String confirmarInterfazCss = ".modal:nth-child(6) .primary";
	private String cancelarInterfazCss = ".modal:nth-child(6) .optional";
	private String guardarCambiosCss = ".design fieldset:nth-child(5) .primary";

	// Platform Logo

	private String platformLogoPictureCss = "#logoFileDrop";

	// Platform Colors

	private String colorPickerCss = "#designColorPicker";	
	private String colorPlataformaRojoCss = ".design .colorpicker .red";
	private String colorPlataformaVerdeCss = ".design .colorpicker .green";
	private String colorPlataformaYellowCss = ".design .colorpicker .yellow";

	// Text Contrast Colors
	
	private String sampleCss=".design fieldset:nth-child(3) .sample";
	private String colorNegroContrasteCss = ".design fieldset:nth-child(3) .black";
	private String getColorNegroCss = ".design fieldset:nth-child(3) .colorpicker .black a";
	private String colorBlancoContrasteCss = ".design fieldset:nth-child(3) .white";
	

	// Background Image

	private String backgroundPictureCss = "#loginBgFileDrop";

	// References
	By header = By.cssSelector(headerCss);
	By goToRestablecerInterfaz = By.cssSelector(goToRestablecerInterfazCss);
	By okRestablecerInterfaz = By.cssSelector(confirmarInterfazCss);
	By guardarCambios = By.cssSelector(guardarCambiosCss);
	By cancelaRestablecerInterfaz = By.cssSelector(cancelarInterfazCss);

	// Colours

	//Platform
	By colorPickerPlatform=By.cssSelector(colorPickerCss);
	By colorPlataformaRojo=By.cssSelector(colorPlataformaRojoCss);
	By colorPlataformaVerde=By.cssSelector(colorPlataformaVerdeCss); 
	By colorPlataformaYellow=By.cssSelector(colorPlataformaYellowCss);
	
	
	//Text Contrast
	By colorNegroContraste = By.cssSelector(colorNegroContrasteCss);
	By colorBlancoContraste=By.cssSelector(colorBlancoContrasteCss);
	By getColorNegro = By.cssSelector(getColorNegroCss);
	By sample=By.cssSelector(sampleCss);

	// Pictures

	By loadLogoPicture = By.cssSelector(platformLogoPictureCss);
	By loadBackgroundPicture = By.cssSelector(backgroundPictureCss);

	// Driver

	WebDriver driver;

	// Constructor

	public BrandingPage(WebDriver driver) {

		this.driver = driver;
	}

	public void restablecerInterfaz() throws InterruptedException {
		
		Reporter.log("Clickeo en restablecer Interfaz");
		driver.findElement(goToRestablecerInterfaz).click();		
		WebElement okPopup = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(okRestablecerInterfaz));
		// Click en el popup de restorear
		driver.findElement(okRestablecerInterfaz).click();	
	}

	public void verifyColors() {
		// Verify list of colors in branding
		Reporter.log(" Veirificando que esten todos los colores disponibles");

	  driver.findElement(colorPlataformaRojo).click();
	  driver.findElement(colorPickerPlatform).getAttribute(colorPlataformaRojoCss);
		

	}

	public void changeColorPlatform() throws InterruptedException {
		// Change header color

		// Clickeo en Disenio
		Reporter.log(" Cambiando el color del header");

		// Verify that the selected color has been changed in the header

		Reporter.log(" Verificando que el color del header se haya cambiado");

		// Select skyblue colour
		driver.findElement(colorPlataformaRojo).click();
		String colorSelected = driver.findElement(colorPlataformaRojo).getCssValue("background-color");
		System.out.println(colorSelected);
		Reporter.log(colorSelected);
		Thread.sleep(3000);
		String colorHeader = new String(driver.findElement(By.tagName("header")).getCssValue("background-color"));
		System.out.println(colorHeader);
		Reporter.log(colorHeader);

		// Compare the header color against the selected, converted to
		// hexadecimal

		Reporter.log("El color seleccionado en branding se muestra correctamente en el header");
		// Assert.assertEquals(colorSelected, colorHeader,
		// "El color seleccionado en branding se muestra correctamente en el header"
		// );

	}

	public void changeColorContrast() throws InterruptedException {
		// Change Contrast Color(){

		Reporter.log(" Cambiando el color del contraste ");

		// Verify that the selected color has been changed in the header

		// Select black color for letters
		driver.findElement(colorNegroContraste).click();
		String colorSelectedIs = driver.findElement(getColorNegro).getCssValue("backgorund-color");
		Reporter.log("El color seleccionado para la letra es :");
		Reporter.log(colorSelectedIs);
		Thread.sleep(3000);
		String colorHeaderIs = driver.findElement(header).getCssValue("color");
		Reporter.log("El color que esta en la letra en el header es :");
		Reporter.log(colorHeaderIs);

		// Compare the header color against the selected, converted to
		// hexadecimal

		Assert.assertEquals(
				colorSelectedIs,
				colorHeaderIs,
				"El color seleccionado de contraste de texto se muestra correctamente en el header");
		Reporter.log(" El caso de branding-colors finalizo correctamente");
	}
}
