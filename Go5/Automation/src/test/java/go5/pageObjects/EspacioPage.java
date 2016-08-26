package go5.pageObjects;

import go5.automation.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EspacioPage extends SetUp {

	// Go To Spaces
	
	private String goToConfigurationCss = ".configuration";
	private String goToHorizontalmenuCss=".horizontalmenu";
	private String goToLeaveSpaceCss=".dotmenu li:first-child a";	
	private String goToSocialCss = ".igosocialswhite ";
	private String goToMembersCss=".space .igouserwhite";
	private String listMembersCss=".list";
	private String textPostCss=".posttext";
	
	

	// By
	By goToConfiguration = By.cssSelector(goToConfigurationCss);
	By goToHorizontalmenu= By.cssSelector(goToHorizontalmenuCss);
	By goToLeaveSpace= By.cssSelector(goToLeaveSpaceCss);	
	By goToSocial = By.cssSelector(goToSocialCss);
	By goToMembers=By.cssSelector(goToMembersCss);
	By listMembers= By.cssSelector(listMembersCss);
	By textPost=By.cssSelector(textPostCss);
	
	// Driver

	protected WebDriver driver;

	// Constructor

	public EspacioPage(WebDriver driver) {

		this.driver = driver;
	}

	public void goToMembers 
	() {
		driver.findElement(goToMembers).click();
		// Wait until recomendados appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(listMembers));

	}
	
	public void goToSocial() {
		driver.findElement(goToSocial).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textPost));
	
	}
	public void goToHorizontalMenu(){
		driver.findElement(goToHorizontalmenu).click();
	}
		public void leaveSpace(){
			this.goToHorizontalMenu();
			driver.findElement(goToLeaveSpace).click();
		}
	
}
