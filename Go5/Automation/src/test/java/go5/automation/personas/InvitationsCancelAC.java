package go5.automation.personas;

import go5.automation.SetUp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

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

public class InvitationsCancelAC extends SetUp {

	String tabla = new String(".tables");
	protected String strPassword = new String("Auto1234");

	HomePage home = null;
	InvitationsPage invitations = null;
	AdministrarPersonasPage admin = null;
	AgregarUserPage adduser = null;

	@AfterClass
	// call function to close browser
	public void teardown() {

		js.executeScript("localStorage.clear();");
		this.quitBrowser();
	}

	public int verificarTabla() {
		// Verificar que hay un elemento en la tabla
		WebElement htmltable = driver.findElement(By
				.cssSelector(".tables tbody"));

		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		Reporter.log("Imprimiendo la cantidad de inivtaciones pendientes...");
		return rows.size();

	}

	@Test
	public void invitattionResendwithAnAdminUser() throws Exception {

	     int countinvites=0;
	     int countinvitesaftercancel;
		home = new HomePage(driver);
		admin=new AdministrarPersonasPage(driver);
		adduser = new AgregarUserPage(driver);
		invitations= new InvitationsPage(driver);
		js = (JavascriptExecutor) driver;

		Reporter.log("Crear un user, y cancelar el invite");

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
		// Cuento la cantidad de inivtes despues de agregar un user
		countinvites=verificarTabla();
		System.out.println(" Imprimiendo la cant de invites despues de agregar a una persona");
		System.out.println(countinvites);
		
		// Presiono boton reenviar del primer elemento de la tabla
		
		 invitations.cancelInvite();
		 Thread.sleep(4000);
		 countinvitesaftercancel=(verificarTabla());
			System.out.println(" Imprimiendo la cant de invites despues de cancelar el invite");
		 System.out.println(countinvitesaftercancel);
		
		 // Aserteo la cantidad de invites contra despues de cancelar -1
		 
	     Assert.assertEquals(countinvitesaftercancel, (countinvites -1));
		
		Reporter.log("La invitacion se cancelo exitosamente");

	}
}
