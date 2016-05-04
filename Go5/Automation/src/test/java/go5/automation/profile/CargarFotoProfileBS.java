package go5.automation.profile;



import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import go5.pageObjects.LoginPage;




public class CargarFotoProfileBS extends CargarFotoProfile {
	
	 LoginPage login =null;
	
 @BeforeClass
  @Parameters(value={"browser","version","platform","url","build"})
  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
	   DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "GOIntegro");
	    capability.setCapability("build", build);
	    capability.setCapability("debug", false);
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);

	    driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		 login= new LoginPage(driver);
		 login.loginToGo("marina.touceda@gointegro.com","Auto1234");
	
 }
 
  
}