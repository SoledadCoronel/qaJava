package go5.pageObjects;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


  
    
    
    public class MuroSocialPage {

    	//Css
    	

    	

    	protected String textAreaPostcss= ".postbox fieldset textarea";

    	protected String cameraPostcss=".igocamerawhite";
    	protected String linkPostcss=".igolink";
    	protected String attachPostcss=".igoattach";
    	protected String publicarContenidoCss="fieldset .primary";
    	protected String iconcss=".icon";

    	protected String date= ".posttex :nth-child(n) p time";

    	protected String linkVerMascss=".posttext:nth-child(3) p:nth-child(2) .link";
    	protected String textAreaPostViejo=".posttext:nth-child(n) fieldset textarea";
        protected String textofirstPostcss= ".posttext:nth-child(3) p:nth-child(2)";
        protected String timefirstPostcss=".posttext:nth-child(3) .socials p time";
        protected String irAMuroEnPerfilcss=".content menu li:first-child a";
        protected String irAlPerfilPost=".posttext:nth-child(3) h2 a";
        
        static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
 	   
    	
    	
    	By textPost =By.cssSelector(textAreaPostcss);
    	By link =By.cssSelector(linkPostcss);
    	By publicarContenido = By.cssSelector(publicarContenidoCss);
    	By icon =By.cssSelector(iconcss);  
    	By textPosteado=By.cssSelector(textofirstPostcss);
    	By linkVerMas=By.cssSelector(linkVerMascss);
        By timePost=By.cssSelector(timefirstPostcss);
        By irAMuroEnPerfil=By.cssSelector(irAMuroEnPerfilcss);
    	
    	static SecureRandom rnd = new SecureRandom();
    	
    	
    	  WebDriver driver;
    
     
  
    	    public MuroSocialPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
     //Set a string in a posttext
  
     public void postTexto(String strTextPost){
      
    	 driver.findElement(textPost).clear();
    	 driver.findElement(textPost).sendKeys(strTextPost);
    	     	
     }
   
      

     public void postear(){
    	 
    	 driver.findElement(publicarContenido).click();
    	 Reporter.log("CLikeo publicar");
    	 
     }
      
     public void postLink (String strlink){
    	  driver.findElement(link).click();
    	  driver.findElement(By.cssSelector(".active input")).sendKeys(strlink);
    	  driver.findElement(By.cssSelector(".active input")).sendKeys(Keys.ENTER);
    	    	 
    }
       
    
		
     private String setcssPost(Integer p ){
    	   String css = ".posttext :nth-child"+"("+(p)+")";
  		    return css;
     }
     
	   
	   public void goToPost(Integer pagina){
		
	String css=this.setcssPost(pagina);
	  driver.findElement(By.cssSelector(css)).click();
    }
	   
	   public void verifyLinkVerMas(){
		   driver.findElement(linkVerMas).click();
	   }
	   
	   public void verifyLinkVerMenos(){
		   driver.findElement(linkVerMas).click();
	   }
	   
	   public String getTextFirstPost(){
		  return driver.findElement(textPosteado).getText();
		   
	   }
	   
	   public String getTimeFirstPost(){
		   return driver.findElement(timePost).getText();
	   }
	   
	   
	   public void goToProfilePost(){
		   driver.findElement(By.cssSelector(irAlPerfilPost)).click();
	   }
	   
	   public void goThroughPosts(Integer numberPosts){
		   for (int i = 0; i <numberPosts; i++) {
			   this.goToPost(i);
	   }
    }
	 
	  public  String randomString( int len ){
	      StringBuilder sb = new StringBuilder( len );
	      for( int i = 0; i < len; i++ ) 
	         sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	      return sb.toString();
    
    }
	  public void irAMuroEnPerfil(){
		  driver.findElement(irAMuroEnPerfil).click();
	  }

	
		
	}


    
      
     
               
         
    


