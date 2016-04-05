package go5.automation;




import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import go5.automation.pages.LoginPage;


public class TestSuite {
		 
	protected WebDriver driver;
	protected Logger log = Logger.getLogger("automation");
		
	
	//Declaracion de variables	
	
	protected String strUsername= new String("marina.touceda@gointegro.com");
	protected String strPassword= new String("Auto1234");
	protected String strUsernameAdminEspacios= new String("marina.touceda+023@gointegro.com");
	protected String strUsernameUserBasic= new String("marina.touceda+022@gointegro.com");
	protected String urlSiteAutomation1= new String ("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
	protected String urlSiteAutomation2= new String ("http://automation4.pla.qa.go5.gointegro.net/authentication/login");
	protected String urlSiteAutomation3= new String ("http://automation5.pla.qa.go5.gointegro.net/authentication/login");
	private String email = this.generateRandomEmail();
	private String name = this.generateName();
	private int password = this.generatePassword();
	
	//Declaracion de cssSelectors
	
	protected String inputmailLogin = new String (".session label:nth-child(2) input");
	protected String inputPasswordLogin = new String (".session label:nth-child(3) input");
	protected String goButton = new String (".session .primary");
	protected String desplegaMenuUsuario = new String (".applications .users menu li:last-child .user");
	protected String irAConfiguration= new String(".applications .users .configuration");
	protected String irAMenu =new String (".menu");
	protected String irAPagina= new String("a[title='Ir a la página 4']");
	protected String irASpaces = new String ("a[title='Ir a listar espacios']");
	protected String irAConfigurarCuenta = new String (".applications .users menu li:last-child li:nth-child(3) a");
	protected String irATitles = new String ("nav .space:nth-child(3) ol li:nth-child(3)");
	protected String irAPersonas = new String ("nav .space:nth-child(3) ol li:nth-child(2) a");
	protected String searchButton = new String(".actions .search .btnsearch");
	protected String inputSearch = new String(".actions .search input");
	protected String orden =new String (".tables thead tr th:nth-child(2) a");
	protected String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
	protected String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
	protected String crearUser= new String(".content .title a");  
	
	
		
	
	
	
	// Declaracion de funciones
	
	
	   public void loginGoWithPageObject() throws Exception
       {           
             		   
	            LoginPage loginPage = new LoginPage();
	            loginPage.loginObjectFactory(strUsername, strPassword);
                }
	     
	   
	   public void login() throws Exception{
	    
		this.clear(inputmailLogin);
	   this.sendValue(inputmailLogin,strUsername);
	   this.clear(inputPasswordLogin);
	   this.sendValue(inputPasswordLogin,strPassword);
	 
	   this.clickWhenReady(By.cssSelector(goButton),10);
	 // throw new IllegalStateException("El login fallo");	  
	      }
		
	   public void loginAdminEspacios() throws Exception{
		    
			this.clear(inputmailLogin);
		   this.sendValue(inputmailLogin,strUsernameAdminEspacios);
		   this.clear(inputPasswordLogin);
		   this.sendValue(inputPasswordLogin,strPassword);
		   this.clickWhenReady(By.cssSelector(goButton),10);
		 //  throw new IllegalStateException("El loguin fallo");	   
		   }
	
	   public void openSite(String site)throws Exception{
		   this.driver = new FirefoxDriver();
		   driver.get(site);
		   driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// throw new IllegalStateException("No se pudo abrir el site");	
	   }
	  
	   
	   
	   /*
	   public void  setUDriver(String driver){
		 
		   if (driver=="firefox")
			this.driver = new FirefoxDriver();
		   */
	   public void setUpBrowserStack(String browser, String version, String platform,String url,String build) throws Exception {
		    DesiredCapabilities capability = new DesiredCapabilities();
		    capability.setCapability("platform",platform);
		    capability.setCapability("browserName", browser);
		    capability.setCapability("browserVersion", version);
		    capability.setCapability("project", "GOIntegro");
		    capability.setCapability("build", build);
		    capability.setCapability("debug", false);
		     this.driver = new RemoteWebDriver(
		    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
		    	      capability);
    
		    driver.get(url);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 this.login();
					
		  }  
	
	  public void loginAdminEspacios(String browser, String version, String platform,String url,String build) throws Exception {
		    DesiredCapabilities capability = new DesiredCapabilities();
		    capability.setCapability("platform",platform);
		    capability.setCapability("browserName", browser);
		    capability.setCapability("browserVersion", version);
		    capability.setCapability("project", "GOIntegro");
		    capability.setCapability("build", build);
		    capability.setCapability("debug", false);
		    capability.setCapability("name", "Administrador de Espacios");
		     this.driver = new RemoteWebDriver(
		    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
		    	      capability);
  
		    driver.get(url);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 this.loginAdminEspacios();
			
		  }  
	public void openSiteSignUp(){
		 
		 driver.get("http://signup.qa.go5.gointegro.net/landing");
		 driver.manage().window().maximize();
	   }
	
	
public void openSiteMobile(){
   	 driver.get("http://mobile.uat.go5.gointegro.net/");
	driver.manage().window().maximize();
   } 
      public void openSiteLogin(){
		 
		 driver.get("http://automation5.pla.qa.go5.gointegro.net/authentication/login");
		 driver.manage().window().maximize();
	   } 
	  public void openSitePortuguese(){
			 
			 driver.get("http://automation4.pla.qa.go5.gointegro.net/authentication/login");
			 driver.manage().window().maximize();
		   } 
	  
	  public void openSignupForAccount(){
		   driver.get("http://signup.qa.go5.gointegro.net/es/signup");
		   driver.manage().window().maximize();
	  }
	  
	  public void openSiteAfterCreatePlatformSpanish() {
		  driver.get("http://signup.qa.go5.gointegro.net/es/signup");
		  driver.manage().window().maximize();
		}
	  
	  public WebElement getWhenVisible(By locator, int timeout) {
		  
		  WebElement element = null;
		   
		  WebDriverWait wait = new WebDriverWait(driver, timeout);
		   
		  element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		   
		  return element;
		   
		  }
	  
	  public void clickWhenReady(By goButton2, int timeout) {
		  
		  WebElement element = null;
		   
		  WebDriverWait wait = new WebDriverWait(driver, timeout);
		   
		  element = wait.until(ExpectedConditions.elementToBeClickable(goButton2));
		   
		  element.click();
		   
		   }
	  
	  
	  //To Close Browser--It closes only the browser window that WebDriver is currently controlling.
	 public void closeBrowser(){
	  driver.close();
	 	 } 
	 
	 // To quit-- Close all the windows the driver use
	 public void quitBrowser(){
		 driver.quit();
	 }
  	 	 	
	 	
	 	public String generateRandomEmail(){
	 	
	 	 int rand = (int) (Math.random() * 999999999);
	    String email = "qa" + rand + "@gointegro.com";
	    return email;
}
	 	
	 	public String generateName(){
		 	
		 	 int rand = (int) (Math.random() * 999999999);
		    String name = "qaname" + rand ;
		    return name;
	}
	 	
	 	
	 	
	 	public int generatePassword(){
		 	
		 	 int rand = (int) (Math.random() * 999999999);
		    int password =  rand ;
		    return password;
	}	

	 // Function to select the 3 available languages
		 public void selectLanguage(String language){
			 if (language =="Spanish"){
				 driver.findElement(By.id("SignupRequest_language_0")).click();
			 }
			 else if (language=="English"){
				 driver.findElement(By.id("SignupRequest_language_2")).click();			 
			 }
			 else if (language=="Portuguese"){
				 driver.findElement(By.id("SignupRequest_language_1")).click();
				 }
	 	 }

		 
			
		         public void sendValue(String sSelector,String sValue) throws Exception{
		           driver.findElement(By.cssSelector(sSelector)).sendKeys(sValue);
		         }
		           
		           public void click(String sSelector) throws Exception{
			           driver.findElement(By.cssSelector(sSelector)).click();
		           }
		           
			           public void clear(String sSelector) throws Exception{
				           driver.findElement(By.cssSelector(sSelector)).clear();
				               
		           }
			           public String getText(String sSelector) throws Exception{
				           return (driver.findElement(By.cssSelector(sSelector)).getText());
			           }   
	
					public void goToConfiguration() throws Exception {
						
						this.click(irAConfiguration);
					}
					
					public void ordenar() throws Exception{
						 this.click(orden);
					 }
					public void goToMenu() throws Exception {
							
						this.click(irAMenu);
					}
				
					public void search(String nombreABuscar) throws Exception{
						
						 this.click(searchButton);
						 Thread.sleep(1000);
			               this.clear(inputSearch);
			               this.sendValue(inputSearch, nombreABuscar);
					}
					public void goToMenuUsuario() throws Exception {
						this.click(desplegaMenuUsuario);
					}
					
					public void goToTitles() throws Exception{
						this.click(irATitles);
					}
					
					public void goToPersonas() throws Exception{
						this.click(irAPersonas);
					}
					
					public void crearUserAdmin() throws Exception{
						this.click(crearUser);
						   
						//Lo creo activado
					      Thread.sleep(1000);
					     driver.findElement(By.cssSelector(".basicdata label:nth-child(2)")).click();
					     
					     //Poner el nombre
					     
				         this.sendValue(".basicdata label:nth-child(4) input", name);
					     //driver.findElement(By.cssSelector(".basicdata label:nth-child(4) input")).sendKeys("Random Name" + numero.nextInt());
				          this.sendValue(".basicdata label:nth-child(5) input", name);
					  //   driver.findElement(By.cssSelector(".basicdata label:nth-child(5) input")).sendKeys("Random Lastname"+ numero.nextDouble());
				          this.sendValue(".basicdata label:nth-child(6) input", email);
				       //   driver.findElement(By.cssSelector(".basicdata label:nth-child(6) input")).sendKeys("randomemail"+numero.nextInt()+"@gointegro.com");
					     
					     //Seleccionar el rol admin
					      
					     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
					 		
					        selectRol.selectByIndex(1);
					     	
					 		
					     // Grabar el nuevo usuario creado
					        Thread.sleep(2000);
					         driver.findElement(By.cssSelector(".content .addpeople fieldset:nth-child(4) .primary")).click();    
					        
					
					  // Verificar que vuelva al listado de personas 
					          
					          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					         log.info(driver.findElement(By.cssSelector(".tablefilter")).isDisplayed());
					}
			
}






