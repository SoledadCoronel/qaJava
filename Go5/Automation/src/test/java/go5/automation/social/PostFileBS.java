package go5.automation.social;

import go5.automation.SetUp;
import go5.pageObjects.EspaciosPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.MuroSocialPage;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PostFileBS {

	LoginPage login = null;
	private WebDriver driver;
	MuroSocialPage muro = null;
	EspaciosPage espacio = null;

	private String iconoEmpresa = ".igospacebicycle";
	protected String textAreaPostcss = ".postbox fieldset:nth-child(1) label:nth-child(4) div";

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
		capability.setCapability("name", "Post File");

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
		Thread.sleep(3000);
	}

	@AfterClass
	// call function to close browser
	public void teardown() {
		driver.quit();
	}

	By textPost = By.cssSelector(textAreaPostcss);

	@Test
	public void postFile() throws Exception {

		muro = new MuroSocialPage(driver);
		espacio = new EspaciosPage(driver);

		Reporter.log(" Entrar a un espacio y postear");

		// Go to hamburguesita

		// Ir a espacios
		// Tengo q ir a un espacio
		espacio.clickEspacioSidebar(iconoEmpresa);
		Thread.sleep(4000);
		espacio.clickEspacioSidebar(iconoEmpresa);
		muro.postFile();
		Thread.sleep(2000);
		muro.postear();
		Thread.sleep(4000);
	}

}
