package go5.automation.configuration;


import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class CompanyDesignTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
	   openSiteLogin();
	   login("marina.touceda@gointegro.com","Auto1234");
	   
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test
	public void editConfig(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Ir al menu de config");
        Reporter.log(" Testeando la pagina de Diseño de  Company");
		
        // Go to the configuration
 		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
        driver.findElement(By.cssSelector(".menu")).click();

		// Go to Company Design 
        Reporter.log("Abriendo la pagina de diseño de la plataforma" );
        Reporter.log(driver.findElement(By.cssSelector("nav .space:nth-child(2) ol li:nth-child(3)>a")).getText());
        driver.findElement(By.cssSelector("nav .space:nth-child(2) ol li:nth-child(3)>a")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println((driver.findElement(By.cssSelector(".design")).getText()));
        
	}
	
	}
