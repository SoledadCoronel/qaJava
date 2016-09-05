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
    	private String goToHomeCss=".igohome";
    	private String goToMenuCss=".menu";
    	private String ayudaLinkCss="igohelpwhite";
	private String goToDatosGeneraleCss =".igocompanydata";
    	private String goToDisenioCss=".igodesign";
    	private String goToAdministrarPersonasCss=".space:nth-child(2) .igoadminwhite";
    	private String goToTitulosCss=".space:nth-child(2) .igotitleswhite";
    	private String goToGruposCss=".igogroups";
    	private String personasTableCss=".tables";    	
    	private String goToDirectorioCss =".space .igouserwhite";
    	private String goToActividadSocialCss=".igosocialswhite";
    	private String goToVerMasEspaciosCss=".noicon";
    	private String goToAdmistrarStoreCs="article .space:nth-child(3) .igoadminwhite";
    	private String goToTiendaCss=".space:nth-child(3) .igotitleswhite";
    	private String misEspaciosCss= ".igopasswordwhite";
    	private String goToUserMenuCss=".usermenu .last a figure";
    	private String goToLogoutCss=".users li:last-child a";		
    	private  String inputmailLogin = "label:nth-child(3) input";
    	private String goToSpaceIconUmbrellaCss=".igospaceumbrella ";
    	private String textPostCss=".posttext";
      //References
    	
    	By goToConfiguration=By.cssSelector(goToConfigurationCss);
    	By goToHome=By.cssSelector(goToHomeCss);
    	By goToMenu=By.cssSelector(goToMenuCss);
    	By goToDatosGenerales=By.cssSelector(goToDatosGeneraleCss);
    	By goToDisenio= By.cssSelector(goToDisenioCss);
    	By goToAdministrarPersonas =By.cssSelector(goToAdministrarPersonasCss);
    	By goToTitulos =By.cssSelector(goToTitulosCss);
    	By goToGrupos=By.cssSelector(goToGruposCss);
    	By goToDirectorio=By.cssSelector(goToDirectorioCss);
    	By goToAvtividadSocial=By.cssSelector(goToActividadSocialCss);
    	By goToAdministrarStore=By.cssSelector(goToAdmistrarStoreCs);
    	By goToTienda=By.cssSelector(goToTiendaCss);
    	
    	By personasTable=By.cssSelector(personasTableCss);
    	By ayudaLink=By.cssSelector(ayudaLinkCss);    	
    	By goToVerMasEspacios=By.cssSelector(goToVerMasEspaciosCss);
    	By misEspacios=By.cssSelector(misEspaciosCss);
    	By goToUserMenu= By.cssSelector(goToUserMenuCss);
    	By goToLogout=By.cssSelector(goToLogoutCss);
    	By inputLogin= By.cssSelector(inputmailLogin);
    	By goToSpaceIconUmbrella= By.cssSelector(goToSpaceIconUmbrellaCss);
    	By textPost=By.cssSelector(textPostCss);
    	
    	
    	
    	  WebDriver driver;
    
     
  
    	    public HomePage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
    public void goToConfiguration() throws InterruptedException{
    	driver.findElement(goToConfiguration).click();
    	Thread.sleep(2000);
    //	WebElement loadDatosGenerales = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(goToDatosGenerales));
    }
    	    
    	public void goToMenu(){
    		 Reporter.log("Abriendo menu" );  
    		driver.findElement(goToMenu).click();
    	}
    	    
    	public void goToUserMenu(){
    		driver.findElement(goToUserMenu).click();
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
   
   public void goToDirectorio() throws InterruptedException{
	   Reporter.log("Abriendo pagina de directorio" );  
	   driver.findElement(goToDirectorio).click();
	   Thread.sleep(3000);
	//   WebElement listaPersonas = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(personasTable));
    
   }
   
    public void goToAyuda(){
    	 Reporter.log("Abriendo la auyda" );  
    	driver.findElement(ayudaLink).click();
    }
    
    public void goToHome(){
   	 Reporter.log("Abriendo el home" );  
   	driver.findElement(goToHome
   			).click();
   }
	    
    public  void goToEspacios(){
    	Reporter.log("Abriendo espacios" );  
    	driver.findElement(goToVerMasEspacios).click();
    	WebElement insertPassword = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(misEspacios));
    
    }
    
    public void goToSpaceUmbrella(){
    	driver.findElement(goToSpaceIconUmbrella).click();
    	WebElement cargarSpace = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(textPost));
    }
    public void goToLogout() throws InterruptedException{
    	goToUserMenu();
    	Thread.sleep(4000);
    	driver.findElement(goToLogout).click();
    	WebElement insertPassword = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(inputLogin));
    }
    }

