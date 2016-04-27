package go5.automation.profile;


import go5.automation.TestSuite;
import go5.pageObjects.ProfilePage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class CargarFotoProfile extends TestSuite {
	
	 ProfilePage profile =null;
	
 @BeforeClass
  
  public void setUp() throws Exception {
	this.setUpMaven();
	
 }
   

 @AfterClass // call function to close browser 
	
	public void teardown(){
	this.quitBrowser();
	}
		
	@Test
	
	public void setUpPictureProfile() throws Exception { 
	
		 profile = new ProfilePage(driver);  
		 
		 
		// Go to the user menu
		
		
		this.goToMenu();
		
		this.goToMenuUsuario();
		
				
		profile.editarProfile();
	
	 profile.cargarFoto();		
				
			
	
	}	
	
	
		
     }

