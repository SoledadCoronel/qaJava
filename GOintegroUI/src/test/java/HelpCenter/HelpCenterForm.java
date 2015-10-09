package HelpCenter;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class HelpCenterForm extends com.links.webdriver.HelpCenterFooterUserLogged {

    @Test

    public void testMandatoryFieldDocument() throws Exception {
    	
    	// Validate that the field document is present and that should be mandatory
    	 
    	driver.findElement(By.cssSelector("input[id=document]"));
    	driver.findElement(By.cssSelector("button[id=submit]")).click();
    	if(driver.getPageSource().contains("El campo documento es obligatorio"))
    	{
    	System.out.println("Validation Text for --Documento-- is Present");
    	}
    	else
    	{
    	System.out.println("Validation Text ---Documento ---is not Present");
    	}
    	
    } 
   	@Test
    	 
   	    public void testMandatoryFieldEmail () {
   	// Validate that the field email is present and that should be mandatory
   		
   		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
   		driver.findElement(By.cssSelector("input[id=document]")).sendKeys("222222222");
    	driver.findElement(By.cssSelector("input[id=email]"));
    	driver.findElement(By.cssSelector("button[id=submit]")).click();
    	if(driver.getPageSource().contains("El campo documento es obligatorio"))
    	{
    	System.out.println("Validation Text for--- Email--- is Present");
    	}
    	else
    	{
    	System.out.println("Validation Text for ---Email ---is not Present");
    	}
   	}
    	
    	@Test
   	 
   	    public void testMandatoryFieldMotivoDelCaso () {
   	// Validate that the field reason is present and that should be mandatory
   		
   		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
   		driver.findElement(By.cssSelector("input[id=document]")).clear();
   		driver.findElement(By.cssSelector("input[id=document]")).sendKeys("222222222");
   		driver.findElement(By.cssSelector("input[id=email]")).clear();
    	driver.findElement(By.cssSelector("input[id=email]")).sendKeys("automation@gointegro.com");;
    	driver.findElement(By.cssSelector("#reason"));
    	driver.findElement(By.cssSelector("button[id=submit]")).click();

 	   // Validate message text
 	  WebDriverWait wait = new WebDriverWait(driver, 10);
 	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".help-center fieldset div:nth-child(6) div:nth-child(1) .data-error")));
 	   
 	  String actual= new String (driver.findElement(By.cssSelector(".help-center fieldset div:nth-child(6) div:nth-child(1) .data-error")).getText());
 	  System.out.print(actual ); 
 	  Assert.assertEquals(actual,"El asunto es obligatorio.");
    	}
    	
    
	@Test
  	 
	    public void testMandatoryFieldTipoDeCaso () {
	// Validate that the field type of issue motive  is present and that should be mandatory
		
		driver.findElement(By.cssSelector("input[id=document]")).clear();
	   driver.findElement(By.cssSelector("input[id=document]")).sendKeys("222222222");
	   driver.findElement(By.cssSelector("input[id=email]")).clear();
	   driver.findElement(By.cssSelector("input[id=email]")).sendKeys("automation@gointegro.com");;
	   driver.findElement(By.cssSelector("#reason")).click();;
	   driver.findElement(By.cssSelector("#reason")).sendKeys("Consulta");	   
	   driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
	   driver.findElement(By.cssSelector("#issueType"));
	   driver.findElement(By.cssSelector("button[id=submit]")).click();
	   
	   
	   // Validate message text
	   if(driver.getPageSource().contains("El campo documento es obligatorio"))
   	{
   	System.out.println("Validation Text for --Documento-- is Present");
   	}
   	else
   	{
   	System.out.println("Validation Text ---Documento ---is not Present");
   	}
	}
   	
	@Test
 	 
    public void testMandatoryfieldAsunto () {
// Validate that the field type of issue motive  is present and that should be mandatory
	
	
   driver.findElement(By.cssSelector("input[id=document]")).sendKeys("222222222");
   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
   driver.findElement(By.cssSelector("input[id=email]")).sendKeys("automation@gointegro.com");;
   driver.findElement(By.cssSelector("#reason")).click();;
   driver.findElement(By.cssSelector("#reason")).sendKeys("Consulta");	  
    driver.findElement(By.cssSelector("#issueType")).click();
    driver.findElement(By.cssSelector("#issueType")).sendKeys("Descuento");
   driver.findElement(By.cssSelector("#issueType"));
   driver.findElement(By.cssSelector("button[id=submit]")).click();
 
   // Validate message text
   WebDriverWait wait = new WebDriverWait(driver, 10);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".help-center fieldset div:nth-child(6) .data-error")));
   
  String actual= new String (driver.findElement(By.cssSelector(".help-center fieldset div:nth-child(6) .data-error")).getText());
  System.out.print(actual ); 
  Assert.assertEquals(actual,"El asunto es obligatorio.");
	}

	@Test
	 
    public void testMandatoryfieldDescripcion () {
// Validate that the field type of description  is present and that should be mandatory
	
	
   driver.findElement(By.cssSelector("input[id=document]")).sendKeys("222222222");
   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
   driver.findElement(By.cssSelector("input[id=email]")).sendKeys("automation@gointegro.com");;
   driver.findElement(By.cssSelector("#reason")).click();;
   driver.findElement(By.cssSelector("#reason")).sendKeys("Consulta");	   
   driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
   driver.findElement(By.cssSelector("#issueType")).click();
   driver.findElement(By.cssSelector("#issueType")).sendKeys("Descuento");
   //driver.findElement(By.id("issue")).sendKeys("Testing Help Center");
   driver.findElement(By.cssSelector("#description"));
   driver.findElement(By.cssSelector("button[id=submit]")).click();
   
    // Verify validation text
   
   WebDriverWait wait = new WebDriverWait(driver, 10);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".help-center fieldset div:nth-child(7) .data-error")));
   
  String stringValidation= new String (driver.findElement(By.cssSelector(".help-center fieldset div:nth-child(7) .data-error")).getText());
  System.out.println("Imprimiendo texto de validacion");
  System.out.print(stringValidation ); 
  
  Assert.assertEquals(stringValidation,"La descripción es obligatoria.");
   

	}
	
}



	
   

