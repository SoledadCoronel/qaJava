package go5.automation.social;

import go5.automation.SetUp;
import go5.pageObjects.HomePage;
import go5.pageObjects.DirectorioPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;
import go5.pageObjects.ProfilePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class MuroSocialProfileAC extends SetUp {

	MuroSocialPage muro = null;
	LoginPage login = null;
	DirectorioPage directorio = null;
	ProfilePage profile = null;
	HomePage home = null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void postearTextoEnElPerfilDeUnUser() throws Exception {

		muro = new MuroSocialPage(driver);
		profile = new ProfilePage(driver);
		login = new LoginPage(driver);
		directorio = new DirectorioPage(driver);
		home = new HomePage(driver);

		Reporter.log(" Ir  a buscar en directorio el user basic y postearle en su profile");
		home.goToDirectorio();

		this.click(searchButton);
		this.sendValue(inputSearch, "User Basic");

		this.click(searchButton);
		Thread.sleep(2000);

		// Aca falla por el search

		directorio.goToFirstProfileUserByNameLink();
		Thread.sleep(2000);
		profile.goToAcerca();
		profile.goToSocial();
		Thread.sleep(4000);		
		muro.postTexto("Posteo en el profile del user basic, como user admin desde directorio");
		Thread.sleep(2000);
		muro.postear();		
		Thread.sleep(2000);
	}

}
