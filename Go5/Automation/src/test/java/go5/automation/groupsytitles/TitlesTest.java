package go5.automation.groupsytitles;

import go5.automation.SetUp;
import go5.pageObjects.HomePage;
import go5.pageObjects.TitlesPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TitlesTest extends SetUp {

	HomePage home = null;
	TitlesPage titles = null;

	@BeforeClass
	public void setUp() throws Exception {

		this.setUpMaven();
	}

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void addTitle() throws Exception {

		home = new HomePage(driver);
		titles = new TitlesPage(driver);

		// Ir a Config
		home.goToConfiguration();
		Thread.sleep(3000);

		home.goToTitulos();

		Reporter.log(" Agregar , editar y borrar Tiers y ");

		// Go to Titles2
		Reporter.log("Abriendo titulos");
		driver.findElement(By.cssSelector(".igotitleswhite")).click();

		// Se agrega un Tier
		Reporter.log("Se agrega un tier");
		titles.addATitle("Testing titles");
		titles.addASubtitle("Testing subtitle");
	}
}
