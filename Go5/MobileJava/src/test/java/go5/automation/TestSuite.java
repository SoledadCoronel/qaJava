package go5.automation;




import go5.pageObjects.LoginPage;


import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class TestSuite {
		 
	//Declaracion de objects
	
	protected WebDriver driver;
	
	LoginPage login = null;
	protected JavascriptExecutor js;
	
		
	//Declaracion de variables	
	
	protected String strUsername= new String("marina.touceda@gointegro.com");
	protected String strPassword= new String("Auto1234");
	protected String strUsernameAdminEspacios= new String("marina.touceda+023@gointegro.com");
	protected String strUsernameUserBasic= new String("marina.touceda+022@gointegro.com");
	protected String urlSiteAutomation1= new String ("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
	protected String urlSignup= "http://signup.qa.go5.gointegro.net/landing";
	protected String urlSiteAutomation2= new String ("http://automation4.pla.qa.go5.gointegro.net/authentication/login");
	protected String urlSiteAutomation3= new String ("http://automation5.pla.qa.go5.gointegro.net/authentication/login");
	protected String email = this.generateRandomEmail();
	protected String name = this.generateName();
	
	
	//Declaracion de cssSelectors
	
	private String home = (".home");
	protected String inputmailLogin = new String (".session label:nth-child(2) input");
	protected String inputPasswordLogin = new String (".session label:nth-child(3) input");
	protected String goButton = new String (".session .primary");
	protected String desplegaMenuUsuario = new String (".applications .users menu li:last-child .user");
	protected String irAConfiguration= new String(".applications .users .configuration");
	protected String irAMenu =new String (".menu");

	protected String irAConfigurarCuenta = new String (".applications .users menu li:last-child li:nth-child(3) a");
	 protected String irAGroups =".igogroups";
     protected String irATitles = ".igotitles";
	protected String irAPersonas = ".igoadmin";
	protected String searchButton =".actions .search .btnsearch";
	protected String inputSearch = ".actions .search input";
	protected String ordenNombre =".tables thead tr th:nth-child(2) a";
	protected String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
	protected String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
	protected String crearUser= new String(".content .title a");  
	protected String irAInvitaciones= new String (".title menu li:nth-child(2) a");
	protected String ordenTitulo = new String (".tables thead tr th:nth-child(3) a");
	protected String ordenRol = new String (".tables thead tr th:nth-child(4) a");
	protected String ordenEstado = new String (".tables thead tr th:nth-child(5) a");	
	protected String ordenRegistrado = new String (".tables thead tr th:nth-child(6) a");
	protected String irALogout= new String (".subusers li:last-child a");
	protected String irAProfile= new String (".subusers li:nth-child(2) a");
	protected String irASpaces = ".wrapper .space:nth-child(4) li:first-child a";
	
	
	
	// Declaracion de funciones
	
	    	   
	   
	
	  
	   public void setUpMaven() throws Exception {
					
	        driver = new FirefoxDriver();
	        login= new LoginPage(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	        this.openSite(urlSiteAutomation1);
	       
	        Reporter.log("Abriendo la aplicacion");
			
			//this.openSite(urlSiteAutomation2);
			 login.loginToGo("marina.touceda@gointegro.com","Auto1234");
			 Reporter.log(" Login como admin exitoso");
		
	   }
	   
	 	  
	   public void setUpMavenSignup() throws Exception {
			
	        driver = new FirefoxDriver();	          	 
	        this.openSite(urlSignup);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        Reporter.log("Abriendo la pagina de signup plataforma");
			
			 
	   }
	   public void setUpMavenAdminEspacios() throws Exception {
			
	        driver = new FirefoxDriver();
	        login= new LoginPage(driver);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	        this.openSite(urlSiteAutomation1);
	       
	        Reporter.log("Abriendo la aplicacion");
			
			//this.openSite(urlSiteAutomation2);
			 login.loginToGo("marina.touceda+023@gointegro.com","Auto1234");
			 Reporter.log(" Login como admin de espacios exitoso");
	   }
			 
			  public void setUpMavenUserBasic() throws Exception {
					
			        driver = new FirefoxDriver();
			        login= new LoginPage(driver);
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			        this.openSite(urlSiteAutomation1);
			       
			        Reporter.log("Abriendo la aplicacion");
					
					//this.openSite(urlSiteAutomation2);
					 login.loginToGo("marina.touceda+022@gointegro.com","Auto1234");
					 Reporter.log(" Login como usuerio bascio exitoso");
	   }
	   
	   public void setUpBrowserStack(String browser, String version, String platform,String url,String build,String testName) throws Exception {
		    DesiredCapabilities capability = new DesiredCapabilities();
		    capability.setCapability("platform",platform);
		    capability.setCapability("browserName", browser);
		    capability.setCapability("browserVersion", version);
		    capability.setCapability("project", "GOIntegro");
		    capability.setCapability("build", build);
		    capability.setCapability("debug", false);
		     driver = new RemoteWebDriver(
		    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
		    	      capability);
    
		    driver.get(url);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 
			 login= new LoginPage(driver);
			 login.loginToGo("marina.touceda@gointegro.com","Auto1234");
					
		  }  
	
	  public void setUpBrowserStackAdminEspacio(String browser, String version, String platform,String url,String build) throws Exception {
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
			 login= new LoginPage(driver);
			 login.loginToGo("marina.touceda+023@gointegro.com","Auto1234");
			
		  }  
	
	  public void openSite(String site){
			 
			 driver.get(site);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   }
	 
	
	  public void openSiteMobile(){
   	 driver.get("http://mobile.uat.go5.gointegro.net/");
	driver.manage().window().maximize();
   } 
      public void openSiteLogin(){
		 
		 driver.get("http://automation5.pla.qa.go5.gointegro.net/authentication/login");
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
		 
		
			   public  String cssgoToAPagina (Integer p)  {
				   String css = ".paged a:nth-child"+"("+(p)+")";
				 
				   return css;
				 
			   }
			   
			   
			   public void goToPagina(Integer pagina){
				
			String css=this.cssgoToAPagina(pagina);
			  driver.findElement(By.cssSelector(css)).click();
			   }
			  
			  	   
     
		         public void sendValue(String sSelector,String sValue) throws Exception{
		           driver.findElement(By.cssSelector(sSelector)).sendKeys(sValue);
		         }
		           
		           public void click(String sSelector) {
			           driver.findElement(By.cssSelector(sSelector)).click();
		           }
		           
			           public void clear(String sSelector) throws Exception{
				           driver.findElement(By.cssSelector(sSelector)).clear();
				               
		           }
			           public String getText(String sSelector) {
				           return (driver.findElement(By.cssSelector(sSelector)).getText());
			           }   
	
					public void goToConfiguration() throws Exception {
						
						this.click(irAConfiguration);
						Thread.sleep(1000);
					}
					
					public void goToProfile() throws Exception {
						
						this.click(irAProfile);
						Thread.sleep(1000);
					}
					
					public void ordenarPorNombre() throws Exception{
						 this.click(ordenNombre);
					 }
					
					public void ordenarPorTitulo() throws Exception{
						 this.click(ordenTitulo);
					 }
					
					public void ordenarPorRol() throws Exception{
						 this.click(ordenRol);
					 }
					
					
					public void ordenarPorRegistro() throws Exception{
						 this.click(ordenRegistrado);
					 }
					
					public void ordenarPorEstado() throws Exception{
						 this.click(ordenEstado);
					 }
					public void goToMenu() throws Exception {
							
						this.click(irAMenu);
					}
					
					public void goToHome() throws Exception{
						this.click(home);
					}
				
					public void search(String nombreABuscar) throws Exception{
						
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						WebElement searchavailable = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(searchButton)));
						 this.click(searchButton);
						 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 WebElement someElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputSearch)));
										
			               this.clear(inputSearch);
			               this.sendValue(inputSearch, nombreABuscar);
			         //      driver.findElement(By.cssSelector(inputSearch)).sendKeys(Keys.ENTER);
					}
					
					public void goToMenuUsuario() throws Exception {
						this.click(desplegaMenuUsuario);
						Thread.sleep(1000);
					}
					
					public void goToTitles() {
						this.click(irATitles);
					}
					
					public void logout() throws Exception {
						this.click(irALogout);
					}
										
					
					public void goToInvitations() {
						this.click(irAInvitaciones);
					}
					
					
				
					
					public void goToSpaces(){
					
						driver.findElement(By.cssSelector(irASpaces)).click();
					}
					public String crearUserAdminReturningmail() throws Exception{
						
						// Devuelve el mail para despues poder loguearme
						this.click(crearUser);
						   
						//Lo creo activado
					      Thread.sleep(1000);
					     driver.findElement(By.cssSelector(".basicdata label:nth-child(2)")).click();
					     
					     //Poner el nombre
					     
				         this.sendValue(".basicdata label:nth-child(4) input", name);
				          
					     this.sendValue(".basicdata label:nth-child(5) input", name);
					      this.sendValue(".basicdata label:nth-child(6) input", email);
				      					     
					     //Seleccionar el rol admin
					      
					     Select selectRol = new Select(driver.findElement(By.cssSelector(".basicdata label:nth-child(7) select"))); 
					 		
					        selectRol.selectByIndex(1);
					     					 		
					     // Grabar el nuevo usuario creado
					        Thread.sleep(2000);
					         driver.findElement(By.cssSelector(".content .addpeople fieldset:nth-child(4) .primary")).click();    
					        
					
					  // Verificar que vuelva al listado de personas 
					          
					          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					        
					         return email;
					}
			
					protected void handleMultipleWindows(String windowTitle) {
			            Set<String> windows = driver.getWindowHandles();

			            for (String window : windows) {
			                driver.switchTo().window(window);
			                if (driver.getTitle().contains(windowTitle)) {
			                    return;
			                }
			            }
			        }
					

}






