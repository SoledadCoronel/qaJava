package go5.automation.signup;

import go5.automation.SetUp;
import go5.pageObjects.CreatePlatformPage;
import go5.pageObjects.LoginPage;

import go5.pageObjects.SignupPlatformPage;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreatePlatformSpanishAC extends SetUp {

	private String email = this.generateRandomEmail();
	private String companyName = this.generateName();
	SignupPlatformPage signup = null;
	CreatePlatformPage pl = null;
	LoginPage login = null;

	@AfterTest
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test(description = " Ingreso el mail en signup, clickeo en plataforma y me registro")
	public void createPlatform() throws Exception {
		signup = new SignupPlatformPage(driver);
		pl = new CreatePlatformPage(driver);
		login = new LoginPage(driver);

		Reporter.log("Abro la pagina de Ingresar mail y elegir idioma");
		signup.createPlatformEspanish(email);
		Thread.sleep(4000);
		// WebElement compania =
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("CreateAccount_company")));
		pl.registrarse(companyName);
		// Verificar que se puede loguear
		Thread.sleep(4000);
		login.loginToGo(email, strPassword);
		Thread.sleep(5000);
		Reporter.log("El caso de creacion de plataforma termino con exito");
	}
}
