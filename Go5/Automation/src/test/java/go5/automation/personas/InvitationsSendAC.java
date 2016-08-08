package go5.automation.personas;

import go5.automation.TestSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import go5.pageObjects.AdministrarPersonasPage;
import go5.pageObjects.AgregarUserPage;
import go5.pageObjects.HomePage;
import go5.pageObjects.InvitationsPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.SignupPage;

public class InvitationsSendAC extends TestSuite {

	String tabla = new String(".tables");
	protected String strPassword = new String("Auto1234");
	protected String irAProfile = new String(".subusers li:nth-child(2) a");
	SignupPage signup = null;
	LoginPage login = null;
	HomePage home = null;
	InvitationsPage invitations =null;
	AdministrarPersonasPage admin=null;
	AgregarUserPage adduser = null;

	@AfterClass
	// call function to close browser
	public void teardown() {

		js.executeScript("localStorage.clear();");
		this.quitBrowser();
	}

	public void verificarTabla() {
		// Verificar que hay un elemento en la tabla

		WebElement htmltable = driver.findElement(By
				.cssSelector(".tables tbody"));

		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		Reporter.log("Imprimiendo la cantidad de inivtaciones pendientes...",
				rows.size());
	}

	@Test
	public void invitattionResendwithAnAdminUser() throws Exception {

		signup = new SignupPage(driver);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		admin=new AdministrarPersonasPage(driver);
		adduser = new AgregarUserPage(driver);
		invitations= new InvitationsPage(driver);
		js = (JavascriptExecutor) driver;

		Reporter.log("Crear un user, reenviarle la invitacion y registrarlo");

		home.goToConfiguration();

		// Go to Users Menu

		home.goToAdministrar();
		
		
		admin.goToagregarPersona();
		
		Thread.sleep(3000);

		// Add a user
		String name = new String (adduser.agregarAdminConInvite());

		// Ir al tab de invitaciones pendientes
		Thread.sleep(7000);
	    
		admin.goToInvitacionesPendientes();

		//this.verificarTabla();

		js.executeScript("$(document).ajaxComplete(function( event, xhr, settings ) {  if(settings.url.indexOf('http://api.qa.go5.gointegro.net/invitations') != -1 && settings.type == 'PATCH') { localStorage.setItem('invitationUrl', '/registration/invitation/'+$.parseJSON(xhr.responseText).data.id); } });");

		// Reenviar la invitacion

		// Presiono boton reenviar del primer elemento de la tabla
		invitations.resendInivte();
		
	// Desloguearse del usuario admin
		
		home.goToLogout();

		
		/// Open window with the new token
		js.executeScript("window.location = localStorage.getItem('invitationUrl');");
		Thread.sleep(2000);

		// Ir a regsitrase con ese token
		Reporter.log("Ir a regsitrase con ese token");
		signup.registrarse();
		Reporter.log("Comprobar loguearse a la aplicacion con ese user nuevo registrado");
		// Comprobar loguearse a la aplicacion con ese user nuevo registrado
		login.loginToGo(name, strPassword);
		
		home.goToUserMenu();
		Reporter.log("Ir al perfil del usuario logueado");
		
	}

}
