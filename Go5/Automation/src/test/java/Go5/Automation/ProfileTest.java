package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ProfileTest extends CommonFunctions{


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
	public void GoToProfile(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Ir al menu de usuario");
		
		// Go to the user menu
				driver.findElement(By.cssSelector(".applications .users .user")).click();
		//Get the user name
			String username= new String(driver.findElement(By.cssSelector(".applications .active .users .active li")).getText());
				log.info(" El nombre del usuario es  : ");
				log.info(username);
		
	}
	
	
}
