package go5.automation.profile;



import go5.pageObjects.HomePage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.ProfilePage;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CargarFotoProfileBS {

	 LoginPage login =null;
	 private WebDriver driver;

		
	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url"})
	  public void setUp(String browser, String version, String platform,String url) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "GOIntegro");
	    capability.setCapability("build", "13.0");
	     capability.setCapability("name", "Cargar foto profile");
	    
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	    
	  ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
	    driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 login= new LoginPage(driver);
		 login.loginToGo("marina.touceda@gointegro.com","Auto1234");
	 }
	
		
	 ProfilePage profile = null;
		HomePage home = null;

		@AfterClass
		// call function to close browser
		public void teardown() {
			driver.quit();
		}

		@Test(testName = "Cambiar la foto de perfil del usuario")
		public void setUpPictureProfile() throws Exception {

			profile = new ProfilePage(driver);
			home = new HomePage(driver);

			// Go to the user menu

			home.goToUserMenu();
			profile.goToProfile();
			home.goToMenu();
			profile.editarProfile();
			profile.cargarFoto();			
			Thread.sleep(4000);
		}
	 
}
