package go5.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class SignupPage {

	// Css

	protected String strPasswordCss ="Auto1234";
	protected String userNameCss = ".signup fieldset:nth-child(1) label:nth-child(4) input";
	protected String userLastNameCss=".signup fieldset:nth-child(1) label:nth-child(5) input";
	protected String inputPasswordCss = ".signup fieldset:nth-child(1) label:nth-child(6) input";
	protected String terminosYcondicionesCss = "input[type='checkbox']";
	protected String terminosYcondicioneslinkCss = ".signup fieldset:nth-child(1) label:nth-child(6) a";
	protected String goButtonCss = ".signup fieldset:nth-child(1) label:last-child .primary";

	//By
	
	By strPassword=By.cssSelector(strPasswordCss);
	By userName=By.cssSelector(userNameCss);
	By lastName=By.cssSelector(userLastNameCss);
	By inputPassword=By.cssSelector(inputPasswordCss);
	By terminosYcondiciones = By.cssSelector(terminosYcondicionesCss);
	By terminosYcondicioneslink = By.cssSelector(terminosYcondicioneslinkCss);
	By goButton = By.cssSelector(goButtonCss);
	
	
	// Driver

	WebDriver driver;

	public SignupPage(WebDriver driver) {

		this.driver = driver;
	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(inputPassword).sendKeys(strPassword);

	}

	// Click on login button

	public void clickgoButton() {

		driver.findElement(goButton).click();
	}

	public void aceptarTerminosYCondiciones() {

		driver.findElement(terminosYcondiciones).click();
	}

	public void clickearTerminosYCondiciones() {
		driver.findElement(terminosYcondicioneslink).click();
	}

	public void registrarse() throws InterruptedException {

		setPassword("Auto1234");
		aceptarTerminosYCondiciones();
		Thread.sleep(1000);
		clickgoButton();
		Thread.sleep(1000);

	}

	public String getUsername() throws InterruptedException {
		Thread.sleep(2000);
		Reporter.log(" Impimir el value");
		Reporter.log(driver.findElement(userName).getAttribute("value"));
		Reporter.log("Imprimir el texto");
		Reporter.log(driver.findElement(userName).getText());

		return (driver.findElement(userName).getAttribute("value"));

	}

}
