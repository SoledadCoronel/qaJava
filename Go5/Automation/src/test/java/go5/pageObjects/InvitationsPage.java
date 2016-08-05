package go5.pageObjects;


import go5.automation.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class InvitationsPage extends TestSuite {

	// Css

	// Modales

	String resendCss = ".tables tr:nth-child(1) td:nth-child(6) .link";
	String resendModalCss = ".active .primary";
	String cancelCss = ".tables tr:nth-child(1) td:nth-child(5) .link";
	String cancelarModalCss = ".active .primary";
	String tablaCss = ".tables";

	// References
	By resend = By.cssSelector(resendCss);
	By resendModal = By.cssSelector(resendModalCss);
	By cancel = By.cssSelector(cancelCss);
	By cancelModal = By.cssSelector(cancelarModalCss);
	By tabla = By.cssSelector(tablaCss);

	// Driver
	WebDriver driver;

	public InvitationsPage(WebDriver driver) {

		this.driver = driver;
	}

	// Set user name in textbox

	public void resendInivte() throws Exception {
		driver.findElement(resend).click();
		Thread.sleep(3000);
		driver.findElement(resendModal).click();
		Reporter.log(" La invitacion se reenvio correctamente");

	}

	public void cancelInvite() throws Exception {
		driver.findElement(cancel).click();
		Thread.sleep(3000);
		driver.findElement(cancelModal).click();
	}
    public void countListInvitations(){
    	// Contar la cantidad de invitaciones pendientes
    	
    }
}
