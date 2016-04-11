package go5.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class DirectorioPage {

    	//Css
    	
    	
    	
    	 private String irAPagina4= new String("a[title='Ir a la página 4']");
    	 private String searchButton = new String(".actions .search .btnsearch");
    	 private String inputSearch = new String(".actions .search input");
    	 private String ordencss =new String (".tables thead tr th:nth-child(2) a");
    	 private String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
    	 private String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
    	
    	    	
    	By serach =By.cssSelector(searchButton);
    	By orden =By.cssSelector(ordencss);
    
    	
    	  WebDriver driver;
    
     
  //Constructor
    	    public DirectorioPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
     public  void  irADirectorio(){
      
    	 Reporter.log("Abriendo directorio de  personas" );  
         driver.findElement(By.cssSelector(".igouser")).click();
    	 //this.click(".igouser");
         // Thread.sleep(1000);
          driver.findElement(By.cssSelector(".igousergroup")).click();
       //   this.click(".igousergroup");
         // Thread.sleep(1000);
  
     }
  
      
/*  
     //Set password in password textbox

     public void setPassword(String strPassword){
  
          driver.findElement(password).sendKeys(strPassword);
  
     }
  
     //Get the title of Login Page
     
     public String getLoginTitle(){
  
      return    driver.findElement(title).getText();
  
     }
  
     //Click on login button
  
     public void clickLogin(){
  
             driver.findElement(go).click();
  
     }
       
   
     /**
  
      * This POM method will be exposed in test case to login in the application
  
      * @param strUserName
  
      * @param strPasword
  
      * @return
  
      */
  
     public void loginToGo(String strUserName,String strPasword){
  
         //Fill user name
  
     //    this.setUserName(strUserName);
  
         //Fill password
  
    //     this.setPassword(strPasword);
  
         //Click Login button
  
   //      this.clickLogin();
     } 
  
  

 

    }



