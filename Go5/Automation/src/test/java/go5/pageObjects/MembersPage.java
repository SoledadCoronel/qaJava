package go5.pageObjects;
import go5.automation.SetUp;

import java.io.File;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;


  
    
    
    public class MembersPage extends SetUp{

    		
    	
    	//Css
    	
     //Generics	
    	protected String goToMembersCss="";
    	protected String permisoDeAdminCss=".list li:nth-child(1) button";
    	protected String date= ".posttex :nth-child(n) p time";
    	 protected String irAActividadSocialcss=".content menu li:first-child a";
         protected String irAMiembroscss=".content menu li:nth-child(2) a";
    	
    

    	
    	//links
        protected String linkPostcss=".igolink";
    	protected String linkVerMascss=".posttext:nth-child(3) div:nth-child(2) .link";
        
    	//attachments    	
    	protected String cameraOrPicturePostcss=".igocamerawhite";
    	protected String cameracss=".igocamera";
    	protected String subirFotocss=".postbox .menuoptions label:last-child";
    	protected String abrirModalAdjuntarArchivocss=".igoattach";
    
              
        //Others
        static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
 	   
    	//By
        //Generics	
       
         By goToMembers= By.cssSelector(goToMembersCss); 
         By permisoDeAdmin=By.cssSelector(permisoDeAdminCss);
    	
    	
    
    	//links
    	By link =By.cssSelector(linkPostcss);
    	By linkVerMas=By.cssSelector(linkVerMascss);
    	
    	//attachments      	
           
        By selectCameraOrPicture= By.cssSelector(cameraOrPicturePostcss);
        By subirFoto=By.cssSelector(subirFotocss);
      
        
    	static SecureRandom rnd = new SecureRandom();
    	
    	//Objects
    	    
    	  WebDriver driver;
    
     //Inits
    	  
    	    public MembersPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
  
    //Generics    
       
    
		
     private String setcssPost(Integer p ){
    	 //Buscar un post viejo
    	   String css = ".posttext :nth-child"+"("+(p)+")";
  		    return css;
     }
     
	   
	   public void goToPost(Integer pagina){
		
	String css=this.setcssPost(pagina);
	  driver.findElement(By.cssSelector(css)).click();
    }
	   
	   public void verifyLinkVerMas(){
		   Reporter.log("Verificar el link VerMas");
		   driver.findElement(linkVerMas).click();
	   }
	   
	   public void verifyLinkVerMenos(){
		   Reporter.log("Verificar el link VerMenos");
		   driver.findElement(linkVerMas).click();
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
	      
     

		
       
	     public void postFile(){
	     	
	    	 js=  (JavascriptExecutor) driver;
	    	   	
	    //	driver.findElement(selectCameraOrPicture).click();
	    	 
	    	   WebElement element = driver.findElement(subirFoto);
			  js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);
		          
		      //Agarrar el elemento para cargar el file y pasarle el path 
		       
		        WebElement subirFile = driver.findElement(subirFoto);
		               
		        File file= new File("src/test/resources/Girasol.jpeg");
		        subirFile.sendKeys(file.getAbsolutePath());
		       
			    Reporter.log(" Foto cargada exitosamente");
	    }

		
    
    }
    
    
      
     
               
         
    


