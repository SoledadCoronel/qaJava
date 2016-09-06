package go5.automation.compania;




import go5.pageObjects.BrandingPage;
import go5.pageObjects.HomePage;
import go5.pageObjects.LoginPage;
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


public class BrandingFotosBS {

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
	     capability.setCapability("name", "Branding pictures");
	    
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
	 BrandingPage branding = null;
		HomePage home = null;

		@AfterClass
		// call function to close browser
		public void teardown() {
			driver.quit();
		}

		@Test
		public void brandingPictures() throws Exception {

			home = new HomePage(driver);
			branding = new BrandingPage(driver);

			// Ir a Imagen
			home.goToConfiguration();
			home.goDisenio();
			Thread.sleep(2000);
			branding.loadLogoPicture();
			Thread.sleep(2000);
			branding.loadBackgroundPicture();
			Thread.sleep(2000);
			branding.restablecerInterfaz();
			
		
	 }
	 
}
