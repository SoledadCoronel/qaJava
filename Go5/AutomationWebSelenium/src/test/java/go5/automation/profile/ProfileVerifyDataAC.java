package go5.automation.profile;

import go5.automation.SetUp;
import go5.pageObjects.HomePage;
import go5.pageObjects.ProfilePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfileVerifyDataAC extends SetUp {

	ProfilePage profile = null;
	HomePage home =null;

	@AfterClass
	// call function to close browser
	public void teardown() {
		driver.quit();
	}

	@Test
	public void verifyDataPofile() throws Exception {

		profile = new ProfilePage(driver);
		home = new HomePage(driver);

		// Go to the user menu

		// Ir a ver perfil
		profile.goToProfileSideBar();
		Thread.sleep(1000);
       home.goToMenu();
		profile.verifyemaildisplayedAtHeader();
		profile.verifyPhonesDisplayedAtHeader();
		Thread.sleep(1000);
		//profile.goToTwitter();	
		//profile.goToFacebook();
		profile.goToSupervisor();

	}

}
