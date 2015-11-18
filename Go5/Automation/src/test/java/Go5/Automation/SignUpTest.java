package Go5.Automation;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class SignUpTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteSignUp();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
	 }

	 @Test (priority=1)
	 // Verify that the language is being changed when you select the different languages
	 
	 public void verifyTextSpanish(){
		
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.switchTo().frame("iframe");
		 driver.findElement(By.id("SignupRequest_language_0")).click();
		 String SpanishText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 
		 System.out.println(SpanishText);
		 Assert.assertEquals(SpanishText,"Completa la siguiente información para obtener tu propia plataforma de GOintegro");
		 driver.findElement(By.id("SignupRequest_language_1")).click();
		 String PortugueseText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 System.out.println(PortugueseText);
		 Assert.assertEquals(PortugueseText,"Preencha as seguintes informações para sua própria plataforma GOintegro");
		 driver.findElement(By.id("SignupRequest_language_2")).click();
		 String EnglishText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 System.out.println(EnglishText);
		 Assert.assertEquals(EnglishText, "Complete the following information for your own platform GOintegro");
	 }
	 
	 
	@Test (priority=3)
	public void signup() throws Exception { 
	
 	     
		
		//driver.switchTo().frame("iframe");
		driver.findElement(By.id("SignupRequest_email")).clear();
		driver.findElement(By.id("SignupRequest_email")).sendKeys("mailcorporativo1@gointegro.com");
		driver.findElement(By.id("SignupRequest_language_0")).click();
		driver.findElement(By.id("submit_button")).submit();
       // driver.findElement(By.cssSelector(".message"));
 
	}

	
}
