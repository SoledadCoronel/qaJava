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

public class ConfigurarCuentaPage extends SetUp {

	// Css

	// Profile

	protected String goToConfigurarCuentaCss = ".igosetting";
	protected String goToIrAGeneralCss =".igotitleswhite";
	private String selectIdiomaCss=".basicdata label:nth-child(2) select";
	private String selectTimeZoneCss=".basicdata label:nth-child(3) select";
	private String goToPasswordCss=".igopasswordwhite";
	private String cambiarPasswordCss=".basicdata label:nth-child(3) input";
	private String confirmarPasswordCss=".basicdata label:nth-child(4) input";
	private String gurdarCss=".basicdata .primary";
	
		
	//Variables
	
	private String strPassword = "Auto1234";
	
	

	// References
	By goToConfigurarCuenta = By.cssSelector(goToConfigurarCuentaCss);
	By goToIrAGeneral =By.cssSelector(goToIrAGeneralCss);
	By selectIdioma=By.cssSelector(selectIdiomaCss);
	By selectTimeZone=By.cssSelector(selectTimeZoneCss);
	By goToPassword=By.cssSelector(goToPasswordCss);
	By cambiarPassword=By.cssSelector(cambiarPasswordCss);
	By confirmarPassword= By.cssSelector(confirmarPasswordCss);
	By guardar=By.cssSelector(gurdarCss);

	
	
	
	//Driver
	
	WebDriver driver;

		
	
	
	// Constructor

	public ConfigurarCuentaPage(WebDriver driver) {

		this.driver = driver;
	}
	

	public void goToConfigurarCuenta() {
		Reporter.log("Ir a Configurar Cuenta");
		driver.findElement(goToConfigurarCuenta).click();
		WebElement configPage = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(selectIdioma));
	}

	public void goToPassword()  {

		// Go to the user menu
		Reporter.log("Ir al tab contraseña de configurar cuenta en profile");
		driver.findElement(goToPassword).click();
		WebElement passwordPage = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(cambiarPassword));
	}
	
	

	public void guardar () throws InterruptedException {
		Reporter.log("Grabando... ");
		driver.findElement(guardar).click();
		Thread.sleep(2000);
	}

	public void setPassword(){
		driver.findElement(cambiarPassword).sendKeys(strPassword);
		driver.findElement(confirmarPassword).sendKeys(strPassword);
		
	}
}
