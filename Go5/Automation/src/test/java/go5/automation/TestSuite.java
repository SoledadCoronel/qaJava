package go5.automation;

import go5.pageObjects.LoginPage;
import go5.pageObjects.SignupPlatformPage;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TestSuite {

	// Declaracion de objects

	protected WebDriver driver;
	protected Logger log = Logger.getLogger("automation");
	LoginPage login = null;
	protected JavascriptExecutor js;
	protected SignupPlatformPage signup = null;

	// Declaracion de variables

	protected String strUsername = "marina.touceda@gointegro.com";
	protected String strPassword = "Auto1234";
	protected String strUsernameAdminEspacios = "marina.touceda+023@gointegro.com";
	protected String strUsernameUserBasic = "marina.touceda+022@gointegro.com";
	protected String urlSiteAutomation1 = "http://automation1.pla.qa.go5.gointegro.net/authentication/login";
	protected String urlSignup = "http://signup.qa.go5.gointegro.net/landing";
	protected String urlSiteAutomation2 = "http://automation4.pla.qa.go5.gointegro.net/authentication/login";
	protected String urlSiteAutomation3 = "http://automation5.pla.qa.go5.gointegro.net/authentication/login";
	protected String email = this.generateRandomEmail();
	protected String name = this.generateName();

	// Css

	private String home = ".home";
	protected String goToMenu = ".menu";
	
	protected String goToConfiguration = ".igoconfigurationwhite";

	protected String irAConfigurarCuenta = ".applications .users menu li:last-child li:nth-child(3) a";

	protected String irAGroups = ".igogroups";
	protected String irATitles = ".igotitles";
	protected String searchButton = ".search";
	protected String inputSearch = ".search input";
	protected String firstRow = ".tables tbody tr:nth-child(1) td:nth-child(2)";
	protected String secondRow = ".tables tbody tr:nth-child(2) td:nth-child(2)";
	protected String irAInvitaciones = ".title menu li:nth-child(2) a";
	protected String ordenTitulo = ".tables thead tr th:nth-child(3) a";
	protected String ordenRol = ".tables thead tr th:nth-child(4) a";
	protected String ordenEstado = ".tables thead tr th:nth-child(5) a";
	protected String ordenRegistrado = ".tables thead tr th:nth-child(6) a";
	protected String goToLogoutCss = ".users li:last-child a";
	protected String goToProfileCss = ".users .igouserwhite";

	// By

	By goToLogout = By.cssSelector(goToLogoutCss);
	By goToProfile = By.cssSelector(goToProfileCss);

	// Declaracion de funciones

	public void setUpMaven() throws Exception {

		driver = new FirefoxDriver();
		login = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.openSite(urlSiteAutomation1);

		Reporter.log("Abriendo la aplicacion");

		// this.openSite(urlSiteAutomation2);
		login.loginToGo("marina.touceda@gointegro.com", "Auto1234");
		Reporter.log(" Login como admin exitoso");
		// org.apache.log4j.BasicConfigurator.configure();
	}

	public void setUpMavenSignup() throws Exception {

		driver = new FirefoxDriver();
		this.openSite(urlSignup);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Abriendo la pagina de signup plataforma");

	}

	public void setUpMavenAdminEspacios() throws Exception {

		driver = new FirefoxDriver();
		login = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.openSite(urlSiteAutomation1);

		Reporter.log("Abriendo la aplicacion");

		// this.openSite(urlSiteAutomation2);
		login.loginToGo("marina.touceda+023@gointegro.com", "Auto1234");
		Reporter.log(" Login como admin de espacios exitoso");
	}

	public void setUpMavenUserBasic() throws Exception {

		driver = new FirefoxDriver();
		login = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.openSite(urlSiteAutomation1);

		Reporter.log("Abriendo la aplicacion");

		// this.openSite(urlSiteAutomation2);
		login.loginToGo("marina.touceda+022@gointegro.com", "Auto1234");
		Reporter.log(" Login como usuerio bascio exitoso");
	}

	public void setUpBrowserStack(String browser, String version,
			String platform, String url, String build, String testName)
			throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platform", platform);
		capability.setCapability("browserName", browser);
		capability.setCapability("browserVersion", version);
		capability.setCapability("project", "GOIntegro");
		capability.setCapability("build", build);
		capability.setCapability("debug", false);
		driver = new RemoteWebDriver(
				new URL(
						"http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
				capability);

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		login = new LoginPage(driver);
		driver.manage().window().maximize();
		login.loginToGo("marina.touceda@gointegro.com", "Auto1234");

	}

	public void setUpBrowserStackAdminEspacio(String browser, String version,
			String platform, String url, String build) throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platform", platform);
		capability.setCapability("browserName", browser);
		capability.setCapability("browserVersion", version);
		capability.setCapability("project", "GOIntegro");
		capability.setCapability("build", build);
		capability.setCapability("debug", false);
		capability.setCapability("name", "Administrador de Espacios");
		this.driver = new RemoteWebDriver(
				new URL(
						"http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
				capability);

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login = new LoginPage(driver);
		login.loginToGo("marina.touceda+023@gointegro.com", "Auto1234");

	}

	public void openSite(String site) {

		driver.get(site);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void openSiteMobile() {
		driver.get("http://mobile.uat.go5.gointegro.net/");
		driver.manage().window().maximize();
	}

	public void openSiteLogin() {

		driver.get("http://automation5.pla.qa.go5.gointegro.net/authentication/login");
		driver.manage().window().maximize();
	}

	public WebElement getWhenVisible(By locator, int timeout) {

		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));

		return element;

	}

	public void clickWhenReady(By goButton2, int timeout) {

		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		// element=
		// wait.until(ExpectedConditions.elementToBeClickable(goButton2));

		element = wait
				.until(ExpectedConditions.elementToBeClickable(goButton2));

		element.click();

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement element =
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));

	}

	// To Close Browser--It closes only the browser window that WebDriver is
	// currently controlling.
	public void closeBrowser() {
		driver.close();
	}

	// To quit-- Close all the windows the driver use
	public void quitBrowser() {
		driver.quit();
	}

	public String generateRandomEmail() {

		int rand = (int) (Math.random() * 999999999);
		String email = "qa" + rand + "@gointegro.com";
		return email;
	}

	public String generateName() {

		int rand = (int) (Math.random() * 999999999);
		String name = "qaname" + rand;
		return name;
	}

	public int generatePassword() {

		int rand = (int) (Math.random() * 999999999);
		int password = rand;
		return password;
	}

	// Function to select the 3 available languages
	public void selectLanguage(String language) {
		if (language == "Spanish") {
			driver.findElement(By.id("SignupRequest_language_0")).click();
		} else if (language == "English") {
			driver.findElement(By.id("SignupRequest_language_2")).click();
		} else if (language == "Portuguese") {
			driver.findElement(By.id("SignupRequest_language_1")).click();
		}
	}

	public String cssgoToAPagina(Integer p) {
		String css = ".pagination a:nth-child" + "(" + (p) + ")";

		return css;

	}

	public void goToPagina(Integer pagina) {

		String css = this.cssgoToAPagina(pagina);
		driver.findElement(By.cssSelector(css)).click();
	}

	public void sendValue(String sSelector, String sValue) throws Exception {
		driver.findElement(By.cssSelector(sSelector)).sendKeys(sValue);
	}

	public void click(String sSelector) {
		driver.findElement(By.cssSelector(sSelector)).click();
	}

	public void clear(String sSelector) throws Exception {
		driver.findElement(By.cssSelector(sSelector)).clear();

	}

	public String getText(String sSelector) {
		return (driver.findElement(By.cssSelector(sSelector)).getText());
	}

	public void goToConfiguration() throws Exception {

		this.click(goToConfiguration);

	}

	public void goToProfile() throws Exception {

		this.clickWhenReady(goToProfile, 10);
	}

	public void ordenarPorTitulo() throws Exception {
		this.click(ordenTitulo);
	}

	public void ordenarPorRol() throws Exception {
		this.click(ordenRol);
	}

	public void ordenarPorRegistro() throws Exception {
		this.click(ordenRegistrado);
	}

	public void ordenarPorEstado() throws Exception {
		this.click(ordenEstado);
	}

	public void goToMenu() throws Exception {

		this.click(goToMenu);
	}

	public void goToHome() throws Exception {
		this.click(home);
	}

	public void search(String nombreABuscar) throws Exception {

		WebElement searchavailable = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By
						.cssSelector(searchButton)));
		this.click(searchButton);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement someElement = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector(inputSearch)));

		this.clear(inputSearch);
		this.sendValue(inputSearch, nombreABuscar);
		// driver.findElement(By.cssSelector(inputSearch)).sendKeys(Keys.ENTER);
	}

	public void goToTitles() {
		this.click(irATitles);
	}

	public void logout() throws Exception {
		this.clickWhenReady(goToLogout, 10);
	}

	public void goToInvitations() {
		this.click(irAInvitaciones);
	}

	protected void handleMultipleWindows(String windowTitle) {
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(windowTitle)) {
				return;
			}
		}
	}

}
