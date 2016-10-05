package go5.automation.signup;

import go5.pageObjects.SignupPlatformPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class CreatePlatformSpanishBS extends CreatePlatformSpanishAC{


	@BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	 public void setUpSignup(String browser, String version, String platform,String url,String build) throws Exception {
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
	   	  Reporter.log("Abriendo la pagina de signup plataforma");
}
}