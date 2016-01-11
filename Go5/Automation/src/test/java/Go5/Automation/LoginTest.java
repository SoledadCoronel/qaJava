package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginTest {

	private WebDriver driver= new FirefoxDriver();
	Logger log = Logger.getLogger("automation");

	 @BeforeClass // call function to open the browser and load url
	 public void setup (){
		 driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		 driver.manage().window().maximize();
	 }
		public void login(String sUsername,String sPassword) throws Exception { 
		 	
	 		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 		driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys(sUsername);
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys(sPassword);
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  	}
	 
	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.close();
		}

	@Test(priority=3)
	public void validatePage(){
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Validating login page");
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".link"));
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("El login button esta enabled");
		}
		else
				log.info("El login button esta disbled");
		
			
	}
	@Test(priority=4)
	public void testProperLogin() throws Exception { 
	
 	  	log.info("Probar el  login");
		this.login("marina.touceda@gointegro.com","Auto1234");
		log.info("Login successfull");
 
	}
	
	@Test(priority=1)
	public void testLoginWithBlankUser() throws Exception { 
	
		
		 org.apache.log4j.BasicConfigurator.configure();
 	  	log.info("Probar el login con el campo user vacio ");
		this.login("  ","Auto1234");
		// Verify if the button is disabled 
		
		
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("El login button esta enabled");
		}
		else
				log.info("El login button esta disabled");
	
		log.info("El login fallo porque el campo usuario estaba en blanco");
	}
	
	@Test(priority=2)
	public void testLoginWithBlankPassword() throws Exception { 
	
		org.apache.log4j.BasicConfigurator.configure();
 	  	log.info("Probar el login con  blank password");
		this.login("marina.touceda@gointegro.com"," ");
		// Verify if the button is disabled 
		
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("El login button esta enabled");
		}
		else
				log.info("El login button esta disabled");
	
		log.info("El loguin fallo porque el password estaba vacio");
	}
}
