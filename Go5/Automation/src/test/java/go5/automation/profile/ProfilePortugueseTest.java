package go5.automation.profile;


import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ProfilePortugueseTest extends CommonFunctions{

	protected final WebDriver driver= new FirefoxDriver();
	
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
	public void GoToProfilePortuguese(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Go to the User menu and verify portuguese language");
		
		// Go to the user menu
				driver.findElement(By.cssSelector(".applications .users .user")).click();
		//Get the user name
			String username= new String(driver.findElement(By.cssSelector(".applications .active .users .active li")).getText());
				log.info(" The username is : ");
				log.info(username);
		// To add :Get the value of profile in portuguese
	}
	
	
}
