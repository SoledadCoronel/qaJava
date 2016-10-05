package go5.automation.social;




import go5.pageObjects.LoginPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class PostPictureBS extends PostPictureAC {
	
	
	
	@BeforeClass
	@Parameters(value = { "browser", "version", "platform", "url" })
	public void setUp(String browser, String version, String platform,
			String url) throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platform", platform);
		capability.setCapability("browserName", browser);
		capability.setCapability("browserVersion", version);
		capability.setCapability("project", "GOIntegro");
		capability.setCapability("build", "13.0");
		capability.setCapability("name", "Postear una picture");

		driver = new RemoteWebDriver(
				new URL(
						"http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
				capability);

		((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login = new LoginPage(driver);
		login.loginToGo("marina.touceda@gointegro.com", "Auto1234");
		Thread.sleep(2000);
}
}
	