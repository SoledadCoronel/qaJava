package go5.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

  
    
    
    public class HomePage {

    	//Css
    	
    	private String goToConfigurationCss=".igoconfigurationwhite";
    	private String goToMenuCss=".menu";
    	private String ayudaLinkCss="igohelpwhite";
    	private String goToDatosGeneraleCss="igocompanydata";
    	private String goToDisenioCss="igodesign";
    	private String goToAdministrarPersonasCss=".igoadminwhite";
    	private String goToTitulosCss=".igotitles";
    	private String goToGruposCss="igogroups";
    	private String personasTableCss=".tables";
    	private String userMenuCss=".usermenu";
    
    	By goToConfiguration=By.cssSelector(goToConfigurationCss);
    	By goToMenu=By.cssSelector(goToMenuCss);
    	By goToDatosGenerales=By.cssSelector(goToDatosGeneraleCss);
    	By goToDisenio= By.cssSelector(goToDisenioCss);
    	By goToAdministrarPersonas =By.cssSelector(goToAdministrarPersonasCss);
    	By goToTitulos =By.cssSelector(goToTitulosCss);
    	By goToGrupos=By.cssSelector(goToGruposCss);
    	By personasTable=By.cssSelector(personasTableCss);
    	By ayudaLink=By.cssSelector(ayudaLinkCss);
    	By userMenu=By.cssSelector(userMenuCss);
    	
    	
    	
    	  WebDriver driver;
    
     
  
    	    public HomePage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
    public void goToConfiguration(){
    	driver.findElement(goToConfiguration).click();
    	WebElement sidebar = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(userMenu));
    }
    	    
    	public void goToMenu(){
    		 Reporter.log("Abriendo menu" );  
    		driver.findElement(goToMenu).click();
    	}
    	    
   public  void goToAdministrar(){
	   Reporter.log("Abriendo administar personas" );  
	   driver.findElement(goToAdministrarPersonas).click();
		 WebElement insertPassword = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(personasTable));
   }
    
   public void goToTitulos(){
	   Reporter.log("Abriendo titulos" );  
	   driver.findElement(goToTitulos).click();
	   
   }
   public void goToGrupos(){
	   Reporter.log("Abriendo grupos" );  
	   driver.findElement(goToGrupos).click();
	   
   }
   
   public void goDatosGenerales(){
	   Reporter.log("Abriendo datos generales" );  
	   driver.findElement(goToDatosGenerales).click();
	   
   }
   public void goDisenio(){
	   Reporter.log("Abriendo pagina de disenio" );  
	   driver.findElement(goToDisenio).click();
    }
   
    public void goToAyuda(){
    	 Reporter.log("Abriendo la auyda" );  
    	driver.findElement(ayudaLink).click();
    }
    
    }



