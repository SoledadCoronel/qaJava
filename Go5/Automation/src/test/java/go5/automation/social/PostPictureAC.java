package go5.automation.social;


import go5.automation.SetUp;
import go5.pageObjects.EspaciosPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class PostPictureAC extends SetUp {

	MuroSocialPage muro = null;
	EspaciosPage espacio = null;
	LoginPage login = null;
	// js javascriptExecutor =null;

	private String iconoEmpresa = ".igospacebicycle";
	protected String textAreaPostcss = ".postbox fieldset:nth-child(1) label:nth-child(4) div";

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	By textPost = By.cssSelector(textAreaPostcss);

	@Test
	public void postearUnaPicture() throws Exception {

		muro = new MuroSocialPage(driver);
		espacio = new EspaciosPage(driver);
		js = (JavascriptExecutor) driver;

		Reporter.log(" Entrar a un espacio y postear");

		// Go to hamburguesita

		// Ir a espacios
		// Tengo q ir a un espacio
		espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(4000);		
		espacio.clickEspacioSidebar(iconoEmpresa);
		muro.postPicture();
		Thread.sleep(3000);
		muro.postear();
		Thread.sleep(3000);
		muro.eliminarPost();
		Thread.sleep(3000);

	}

}
