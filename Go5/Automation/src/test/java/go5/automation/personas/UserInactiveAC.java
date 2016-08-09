package go5.automation.personas;

import go5.automation.TestSuite;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import go5.pageObjects.HomePage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.AdministrarPersonasPage;

public class UserInactiveAC extends TestSuite {

	AdministrarPersonasPage personas = null;
	HomePage home = null;
	LoginPage login = null;

	private String estadoDesactivado = (".basicdata label:nth-child(2) input:nth-child(2)");
	private String estadoActivado = (".basicdata label:nth-child(2) input:nth-child(1)");
	private String bloquearAcceso = (".basicdata label:nth-child(3) input");
	private String searchButton = ".actions .search .btnsearch";

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	private void buscarAInactiveUser() throws Exception {
		// Go to the configuration
		home.goToConfiguration();

		// Go to Manage people
		home.goToAdministrar();
		// WebElement someElement = (new WebDriverWait(driver,
		// 20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputSearch)));
		this.click(searchButton);
		this.sendValue(inputSearch, "Inactive");
		driver.findElement(By.cssSelector(inputSearch)).sendKeys(Keys.ENTER);
		this.click(searchButton);
		Thread.sleep(2000);

		Reporter.log("clickear usuario inactivo");
		// personas.editFirstPerson();
		this.click(".tables tbody tr td:nth-child(7) a");
		Thread.sleep(3000);
	}

	@Test
	public void activateUser() throws Exception {

		personas = new AdministrarPersonasPage(driver);
		home = new HomePage(driver);
		login = new LoginPage(driver);

		Reporter.log(" Activar el user User Inactive y uncheck block access");

		this.buscarAInactiveUser();
		// personas.setEstadoActivo();
		// Activarlo
		this.click(estadoActivado);

		// Le saco el bloqueo de acceso

		// this.click(bloquearAcceso);
		this.click(".basicdata label:nth-child(3) input ");
		Reporter.log("Grabando usuario");
		this.click(".container .addpeople .primary");

		home.goToLogout();
		Thread.sleep(3000);
		login.loginToGo("marina.touceda+058@gointegro.com", "Auto1234");
		Thread.sleep(2000);
		home.goToHome();		
		home.goToLogout();	
	}

	@Test(dependsOnMethods = { "activateUser" })
	public void blockAccessUser() throws Exception {

		personas = new AdministrarPersonasPage(driver);

		login = new LoginPage(driver);

		Reporter.log(" Probar que un usuario con bloqueo de acceso no se puede loguear");

		login.loginToGo("marina.touceda@gointegro.com", "Auto1234");
		Thread.sleep(1000);

		this.buscarAInactiveUser();

		// Bloquear acceso e Inactivar
		this.click(bloquearAcceso);
		this.click(estadoDesactivado);
		// this.click(".basicdata label:nth-child(3) input ");
		Thread.sleep(2000);
		Reporter.log("Grabando usuario");
		this.click(".container .addpeople .primary");

	    home.goToLogout();
		Thread.sleep(3000);
		login.loginToGo("marina.touceda+058@gointegro.com", "Auto1234");
		Thread.sleep(2000);
		Reporter.log(driver.findElement(By.cssSelector("p.reject")).getText());

	}
}
