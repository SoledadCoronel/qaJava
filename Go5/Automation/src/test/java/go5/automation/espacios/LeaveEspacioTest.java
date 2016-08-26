package go5.automation.espacios;

import go5.automation.SetUp;
import go5.pageObjects.EspacioPage;
import go5.pageObjects.HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeaveEspacioTest extends SetUp {

	EspacioPage espacio = null;
	HomePage home = null;

	@BeforeClass
	// call function to open the browser and login
	public void setup() throws Exception {
		this.setUpMaven();

	}

	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void leaveSpace() throws Exception {

		espacio = new EspacioPage(driver);
		home = new HomePage(driver);

		Reporter.log(" Ir a un espacio e irse");
		home.goToSpaceUmbrella();
		Thread.sleep(3000);
		//espacio.goToMembers();
		Thread.sleep(2000);
		espacio.leaveSpace();

	}

}
