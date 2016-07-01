package go5.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


    
    
    public class DirectorioPage {

    	//Css
    	
    	
    	private String personasCss = ".igousergroupwhite";
    	private String searchCss=".search input";
      	private String firstNameCss= ".list li:nth-child(1) span";
      	private String goToProfileFirstRowCss=".list li:nth-child(1) a";
      
    	
    	//References
      	
      	By personas=By.cssSelector(personasCss);
      	By search= By.cssSelector(searchCss);
      	By firstName=By.cssSelector(firstNameCss);
      	By goToProfileFirstRow= By.cssSelector(goToProfileFirstRowCss);
    	
    	
    
    	
    	  WebDriver driver;
    
     
  //Constructor
    	    public DirectorioPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
     public  void  goToDirectorio(){
      
    	 Reporter.log("Abriendo directorio de  personas" );
    	  
    	 driver.findElement(personas).click();
     }
  
      public void search(String strUserName) throws InterruptedException{
    	  driver.findElement(search).sendKeys(strUserName);
    	  Thread.sleep(3000);
      }
     
     public   String getFirstName(){
         
     return driver.findElement(firstName).getText() ;  	
     }
   
     public  String firstLetter(){
    	return (this.getFirstName().substring(0,1)).toLowerCase();
     }
     
       
     
   
     public void goToFirstProfileUser(){
    	 driver.findElement(goToProfileFirstRow).click();
    	
    }
    }
    

