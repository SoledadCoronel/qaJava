package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ProfileEnglishTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
		this.openSitePortuguese();
	   login("marina.touceda@gointegro.com","Auto1234");
	   
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test(priority=1)
	public void goToProfileEnglish(){
		 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Go to the User menu and verify the English language");
		
		// Go to the user menu
				driver.findElement(By.cssSelector(".applications .users .user")).click();
		//Get the user name
			String username= new String(driver.findElement(By.cssSelector(".applications .active .users .active li")).getText());
				log.info(" The username is : ");
				log.info(username);
		// To add :Get the value of profile in english
	}
	
	
}
