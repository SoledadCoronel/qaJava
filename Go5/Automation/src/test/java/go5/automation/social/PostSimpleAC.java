package go5.automation.social;

import go5.automation.SetUp;
import go5.pageObjects.EspaciosPage;
import go5.pageObjects.HomePage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class PostSimpleAC extends SetUp {

	MuroSocialPage muro = null;
	EspaciosPage espacio = null;
	LoginPage login = null;
	HomePage home = null;

	private String iconoEmpresa = ".igospaceadmin";
	private String iconoCallCenter = ".igospacecallcenter";
	private String link = "https://gointegrotech.atlassian.net/browse/FRONT-823";

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test(description = "Creo un post con usuario admin, lo likeo.Respondo como usuario basico,likeo y respondo")
	public void postearylikear() throws Exception {

		muro = new MuroSocialPage(driver);
		espacio = new EspaciosPage(driver);
		login = new LoginPage(driver);
		home = new HomePage(driver);

		Reporter.log(" Entrar a un espacio y postear");

		// Ir a espacios
		// Tengo q ir a un espacio
		Thread.sleep(3000);
		espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(4000);
		muro.postTexto("Posteo como usuario admin para probar los likes ");
		muro.postLink(link);
		Thread.sleep(6000);
		muro.postear();
		Thread.sleep(2000);
		Reporter.log("Like el post creado como user admin");
		muro.likearPost();
		Thread.sleep(2000);
		

	}

}
