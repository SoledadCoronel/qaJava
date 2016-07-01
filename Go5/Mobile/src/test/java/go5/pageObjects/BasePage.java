package go5.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;


public class BasePage {

  // Driver
    protected WebDriver driver;
   
    
    //Declaracion de css
    protected String menuCss= ".menu";
    protected String goToDirectorioCss=".igousergroupwhite";
    protected String irAProfileCss=".igouserwhite";
    protected String logoutCss=".space:last-child li:last-child a";
    
  
    //Navegabilidad
    
    protected String goBackCss="header .back";
    
   // Bys
    By menu =By.cssSelector(menuCss);
    By goToDirectorio=By.cssSelector(goToDirectorioCss);
    By irAProfile= By.cssSelector(irAProfileCss);
    By logout=By.cssSelector(logoutCss);
    By goBack=By.cssSelector(goBackCss);
    
    
    // Constructor
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    
    //Functions
    
    
    public void goToMenu(){
    	driver.findElement(menu).click();
    
    
    }
    	
    public void goToDirectorio(){
    	driver.findElement(goToDirectorio).click();
    //	 WebDriverWait wait = new WebDriverWait(driver, 20);
         
      //   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".content")));
    }
   
    public void goToProfile(){
    
    	driver.findElement(By.cssSelector(irAProfileCss)).click();
    	
    }
    
    public void goBack() throws InterruptedException{
    	driver.findElement(goBack).click();
    	Thread.sleep(3000);
    }
    
    
    public void logout () throws InterruptedException{
    	this.goToMenu();
    	Thread.sleep(3000);
    	driver.findElement(By.cssSelector(logoutCss)).click();
    
    }
    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }


    public void swipeLeftToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.01);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.9);
        swipeObject.put("endY", 0.6);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeFirstCarouselFromRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.2);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.2);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void performTapAction(WebElement elementToTap) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 360); // in pixels from left
        tapObject.put("y", (double) 170); // in pixels from top
        tapObject.put("element", Double.valueOf(((RemoteWebElement) elementToTap).getId()));
        js.executeScript("mobile: tap", tapObject);
    }
}
