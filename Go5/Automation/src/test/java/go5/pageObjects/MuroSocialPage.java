package go5.pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class MuroSocialPage {

    	//Css
    	
<<<<<<< HEAD
    	protected String textAreaPostcss= "fieldset textarea";
=======
    	protected String textAreaPostcss= ".postbox fieldset textarea";
>>>>>>> 4df2b558a7bbb618b872e97e7578437293d6d78e
    	protected String cameraPostcss=".igocamerawhite";
    	protected String linkPostcss=".igolink";
    	protected String attachPostcss=".igoattach";
    	protected String publicarContenidoCss="fieldset .primary";
    	protected String iconcss=".icon";
<<<<<<< HEAD
    	protected String date= ".posttex :nth-child(n) p time";
=======
    	protected String linkVerMascss=".posttext:nth-child(n) p:nth-child(n) .link";
    	protected String textAreaPostViejo=".posttext:nth-child(n) fieldset textarea";
>>>>>>> 4df2b558a7bbb618b872e97e7578437293d6d78e
    	
    	
    	By textPost =By.cssSelector(textAreaPostcss);
    	By link =By.cssSelector(linkPostcss);
    	By publicarContenido = By.cssSelector(publicarContenidoCss);
    	By icon =By.cssSelector(iconcss);
<<<<<<< HEAD
=======
    	By linkVerMas=By.cssSelector(linkVerMascss);
>>>>>>> 4df2b558a7bbb618b872e97e7578437293d6d78e
    	
    	
    	  WebDriver driver;
    
     
  
    	    public MuroSocialPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set a string in a posttext
  
     public void postTexto(String strTextPost){
      
    	 driver.findElement(textPost).clear();
    	 driver.findElement(textPost).sendKeys(strTextPost);
    	
     }
   
<<<<<<< HEAD
=======
     public String returnTextoPublicado(){
         Reporter.log("Imprimir lo que tiene el post de texto");
    	return driver.findElement(textPost).getText();
    	 
    	
     }
     
>>>>>>> 4df2b558a7bbb618b872e97e7578437293d6d78e
     public void postear(){
    	 
    	 driver.findElement(publicarContenido).click();
    	 Reporter.log("CLikeo publicar");
    	 
     }
      
     public void postLink (String strlink){
    	  driver.findElement(link).click();
    	  driver.findElement(By.cssSelector(".active input")).sendKeys(strlink);
    	 
    }
       
<<<<<<< HEAD
     
		
     private String setcssPost(Integer p ){
    	   String css = ".posttext :nth-child"+"("+(p)+")";
  		    return css;
     }
     
	   
	   public void goToPost(Integer pagina){
		
	String css=this.setcssPost(pagina);
	  driver.findElement(By.cssSelector(css)).click();
    }
	   
	   public void goThroughPosts(Integer numberPosts){
		   for (int i = 0; i <numberPosts; i++) {
			   this.goToPost(i);
	   }
    }
    }
=======
    }
    
      
>>>>>>> 4df2b558a7bbb618b872e97e7578437293d6d78e
  
     
               
         
    


