package go5.automation.configuration;


import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ConfTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
	   openSiteLogin();
	   login("marina.touceda@gointegro.com","Auto1234");
	   
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test(priority=1)
	public void editConfig(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Ir al menu de config");
		 // Go to the configuration
		driver.findElement(By.cssSelector(".applications .users .configuration")).click();
 // Go to Company Data
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).click();
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).clear();
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(1) input")).sendKeys("Test222222222222222");
		
		/* Select a value from the drop-down for Language
		
		Select select = new Select(driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(3) option"))); 
		select.deselectAll();
		select.selectByValue("pt");
		*/
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(3) option")).click();
		
		WebElement option=driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(3) option"));
		option.sendKeys("pt");
		
		//Select a value from drop-down Timezone
		
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(4) option")).click();
		
		driver.findElement(By.cssSelector(".companydata fieldset label:nth-child(4) option")).sendKeys("America/Anchorage");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".primary")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
	
	
}
