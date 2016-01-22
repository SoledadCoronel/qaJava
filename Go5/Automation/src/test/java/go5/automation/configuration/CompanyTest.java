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


public class CompanyTest extends CommonFunctions{


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
        Reporter.log(" Testeando la pagina de Edit Company");
		// Go to the configuration
		driver.findElement(By.cssSelector(".applications .users .configuration")).click();

		// Go to Company Data
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).click();
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).clear();

//Verify that company name can not be blank
		
		Reporter.log(" Testeando que el nombre de la compañia no pueda ser blanco");
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("    ");
		String companyMessage = new String(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) span")).getText());
		System.out.println(companyMessage);
		Assert.assertEquals(companyMessage, "Nombre no puede estar vacío");
		Reporter.log(companyMessage);
		
		
		
//Insert some value at company name	
		
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("Test3333332222222222222");
		
// Select all values the drop-down for Language
		
		Select selectLanguage = new Select(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(3) select"))); 
		
		selectLanguage.selectByValue("pt");
		selectLanguage.selectByValue("en");	
		selectLanguage.selectByValue("es");
		Reporter.log(" Se validan los 3 lenguajes");
//Select a value from drop-down Timezone
		
		Select selectTimeZone = new Select(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(4) select")));
		
		   for(int i=1; i<20; i++){
	           selectTimeZone.selectByIndex(i);  
			 }
		
		selectTimeZone.selectByValue("America/Anchorage");
		 Reporter.log("Se validadn valores del drop-down de Time Zone");
//Save changes
		
		driver.findElement(By.cssSelector(".primary")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Reporter.log(companyMessage);
}
	
	
}
