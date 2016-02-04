package go5.automation.home;


import go5.automation.CommonFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.URISyntaxException;



public class HomeTest extends CommonFunctions{


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
	public void EnterTheHomePage() throws AWTException{
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Login into GoIntegro and check the menu is present");
		
		
		  // Go to the configuration
        
				driver.findElement(By.cssSelector(".applications .users .configuration")).click();
		       driver.findElement(By.cssSelector(".menu")).click();
			/*
			// Go to  Users Menu
		        Reporter.log("Abriendo administar personas" );  
		        //driver.findElement(By.cssSelector(".usermenu")).click();
		        Reporter.log("Abriendo titulos");
		       */ 
		     // Go to Company Design 
		        Reporter.log("Abriendo la pagina de diseño de la plataforma" );
		        // Primero hay que clickear en otro si no no anda!!Clickeo titles
		        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
		        
		        Reporter.log(driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).getText());
		        // Clickeo en Disenio
		        
		        driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
		        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}     
		    @Test(priority=2)
		    public void testLogoFile(){
		       
		     // Load a logo  
		       		         
		        
		     //function to make visible the button logoFilePicker, as it is set to class "off"
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        WebElement element = driver.findElement(By.id("logoFilePicker"));
		        js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);
		      
		        //Agarrar el elemento para cargar el file y pasarle el path 
		        
		         WebElement upload= driver.findElement(By.id("logoFilePicker"));
		         
		         upload.sendKeys("/home/marinatouceda/Escritorio/Girasol.jpeg");
		          
		          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		          driver.findElement(By.cssSelector(".cutpictures .primary")).click();
		          
		       
		    //Save changes
		          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		          driver.findElement(By.cssSelector(".primary")).click();
		    }
		   
		        
		
		       @Test (priority=3)
		       public void testBackgroundFile() {
		        // Load background file
		        
		       
		        //function to make visible the button loginBgFilePicker, as it is set to class "off"
			        
			        JavascriptExecutor js2 = (JavascriptExecutor) driver;
			        WebElement elementbackground = driver.findElement(By.id("loginBgFilePicker"));
			        js2.executeScript("arguments[0].setAttribute('style', 'display:block')",elementbackground);
			      
			        //Agarrar el elemento para cargar el file y pasarle el path 
			          
			        	  
			        
			       elementbackground.sendKeys("/home/marinatouceda/Escritorio/NanuDisney.jpeg");
			  
			       
			    //Save changes on the page
			          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			          driver.findElement(By.cssSelector(".primary")).click(); 
		       }
		       
			     
		       
			@Test(priority=4)
			public void restoreInterface(){
				 // Vuelvo a clikear en Diseño
		          
			       // Primero hay que clickear en otro si no no anda!!Clickeo titles
				        driver.findElement(By.cssSelector("nav .space:nth-child(3) ol li:nth-child(2) a")).click();
			          
			          driver.findElement(By.cssSelector(".space:nth-child(2) li:nth-child(3) a")).click();
				        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);     
			         
			        			
			       //Restablecer interfaz   
                        driver.findElement(By.cssSelector("div .container .design fieldset:nth-child(5) a")).click();
                        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                       //Click en el popup de restorear
                        driver.findElement(By.cssSelector(".modal .rgroupitem .primary")).click();
                    
		          
			}
	}

