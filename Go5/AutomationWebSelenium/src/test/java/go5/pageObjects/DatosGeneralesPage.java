package go5.pageObjects;

import go5.automation.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class DatosGeneralesPage extends SetUp {

	// Css

	private String goToRestablecerInterfazCss = ".restores";
	private String confirmarInterfazCss = ".modal:nth-child(6) .primary";
	private String cancelarInterfazCss = ".modal:nth-child(6) .optional";
	private String nombreCompania = "fieldset label:nth-child(1) input";
	private String selectIdioma = "fieldset label:nth-child(3) select";
	private String selectTimezone = "fieldset label:nth-child(4) select";
	private String errorCompanyBlack = "fieldset label:nth-child(1) strong";
	private String guardarCambiosCss = ".basicdata .primary";

	// References

	By error = By.cssSelector(errorCompanyBlack);
	By goToRestablecerInterfaz = By.cssSelector(goToRestablecerInterfazCss);
	By okRestablecerInterfaz = By.cssSelector(confirmarInterfazCss);
	By guardarCambios = By.cssSelector(guardarCambiosCss);
	By cancelaRestablecerInterfaz = By.cssSelector(cancelarInterfazCss);

	// Driver

	WebDriver driver;

	// Constructor

	public DatosGeneralesPage(WebDriver driver) {

		this.driver = driver;
	}

	public void setNombreCompania(String nombre) {
		Reporter.log("Insertando nombre de la compania");
		driver.findElement(By.cssSelector(nombreCompania)).clear();
		driver.findElement(By.cssSelector(nombreCompania)).sendKeys(nombre);
	}

	public void verifyNombreCantBeBlank() {
		this.setNombreCompania("                  ");
		String companyMessage = new String(driver.findElement(error).getText());
		Reporter.log(companyMessage);
		Assert.assertEquals(companyMessage, "El campo es requerido");
	}

	public void setIdioma() {

		// Select all values the drop-down for Language
		Reporter.log(" Verificar el drop-down de lenguajes");
		Select selectLanguage = new Select(driver.findElement(By
				.cssSelector(selectIdioma)));

		selectLanguage.selectByValue("pt");
		selectLanguage.selectByValue("en");
		selectLanguage.selectByValue("es");
	}

	public void setTimezone() {
		// Select a value from drop-down Timezone
		Reporter.log(" Verificar el drop-down de timezone ");
		Select selectTimeZone = new Select(driver.findElement(By
				.cssSelector(selectTimezone)));

		for (int i = 1; i < 5; i++) {
			selectTimeZone.selectByIndex(i);
		}

		selectTimeZone.selectByValue("America/Anchorage");

	}

}
