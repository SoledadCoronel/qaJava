package go5.automation.signup;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class ForgotPasswordBS extends ForgotPasswordAC{
	
		

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
			    capability.setCapability("name", "Test de Forgot Password");
			   
			    driver = new RemoteWebDriver(
			    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
			    	      capability);
	    
			    driver.get(url);
				 driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 
				 
}

}