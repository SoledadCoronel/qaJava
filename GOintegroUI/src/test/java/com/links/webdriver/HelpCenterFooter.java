package com.links.webdriver;

/**
 * Created by soledad on 12/08/15.
 */
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class HelpCenterFooter  {

	
	WebDriver driver =  new FirefoxDriver();

	@BeforeTest
	public void setup (){
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.get("https://gocauto1.p2-stage.gointegro.com/auth/signin"); 	
	}
		
	
    @Test

    public void testHelpCenterFooter() throws Exception {
        
        driver.findElement(By.cssSelector("footer .pull-left:nth-child(2) a:nth-child(2)")).click();
    if (driver.findElement(By.cssSelector("footer .pull-left:nth-child(2) a:nth-child(2)")).isDisplayed())
    	System.out.print("Help Center Link is present");
        
           }
@AfterTest
public void tearDown (){
	driver.quit();
}
}
