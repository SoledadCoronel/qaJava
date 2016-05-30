package go5.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


    
    
    public class DirectorioPage {

    	//Css
    	
    	
    	private String Personas = new String (".igousergroup");
    	
    	private String firstName= new String(".tables tbody tr:nth-child(1) td:nth-child(2) a");
    	 private String lastName= new String(".tables tbody tr:nth-child(10) td:nth-child(2) a");  
    	
    		
    	
    	
    
    	
    	  WebDriver driver;
    
     
  //Constructor
    	    public DirectorioPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set user name in textbox
  
     public  void  goToDirectorio(){
      
    	 Reporter.log("Abriendo directorio de  personas" );
    	  	  
    	  driver.findElement(By.cssSelector(Personas)).click();
       
     }
  
     public   String getFirstName(){
         
    	 return driver.findElement(By.cssSelector(firstName)).getText();
     }
   
     public  String firstLetter(){
    	return (this.getFirstName().substring(0,1)).toLowerCase();
     }
     
     public  String  getLastName(){
         
   	  return driver.findElement(By.cssSelector(lastName)).getText();
    }
    
     public  String lastLetter(){
    	 return (this.getLastName().substring(0,1)).toLowerCase();
     }
     
    
     public  void verificarOrden(){
    	 
    	       
         if (firstLetter().compareTo(lastLetter())<0)
    	             
       Reporter.log("Los usuarios estan ordenados alfabeticamente por orden ascendente( de la A la Z,");
       else 
       	Reporter.log("La pagina esta ordenada alfabeticamente por orden descencdente ( de la Z a la A " );
     
    }
     public void goToFirstProfileUserByNameLink(){
    	 driver.findElement(By.cssSelector(firstName)).click();
    
    }
    }
    

