package go5.pageObjects;



import java.io.File;
import java.security.SecureRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import io.appium.java_client.pagefactory.AndroidFindAll;

  
    
    
    public class MuroSocialPage {

    		
    	
    	//Css
    	
     //Generics	
    	protected String irAPublicarCss=".socialcomments .type";
    	protected String publicarContenidoCss="fieldset .primary";
    	protected String iconcss=".icon";
    	protected String date= ".posttex :nth-child(n) p time";
    	 protected String irAActividadSocialcss=".content menu li:first-child a";
         protected String irAMiembroscss=".content menu li:nth-child(2) a";
    	
     //postear, comentar, responder, eliminar
    	protected String textAreaPostcss= ".postbox fieldset:nth-child(1) label:nth-child(2) div"; //.at
    	protected String textAreaPostViejo=".posttext:nth-child(n) fieldset textarea";
        protected String textofirstPostcss= ".posttext:nth-child(2) .peoplepost p";
        protected String timefirstPostcss=".posttext:nth-child(3) .socials p time";
        
        protected String commentFirstPostcss=".posttext:nth-child(2) .actions .igocomments";
        protected String sendCommentcss=".btnsend";
        protected String commentInputcss =".commentsform fieldset div";
        protected String arbirResponderCommentFirstPstscss=".comments .socials button:nth-child(3)";
        protected String reponderCommentFirstPostInputcss=".commentsform fieldset div";
        protected String showMoreCommentscss=".link showmore";
        protected String selecteliminarPostcss=".posttext:nth-child(2) .btnoptions";
       
    	//Likes
    
        protected String likeFirstPostcss=".posttext:nth-child(2) .actions .igolikewhite";
        protected String likeFirstCommentcss=".comments .socials button:nth-child(2)";
        protected String likeReponseCommentcss=".posttext:nth-child(3) .commentsreplay .socials .igolike ";
        protected String desplegarLikescss=".posttext:nth-child(3) .socials:nth-child(3) p a:nth-child(2)";
        protected String countsLikesFirstPostcss=".posttext:nth-child(3) .socials p a";
        protected String countsLikesCommentFirstPostcss=".posttext:nth-child(3) .commentsitem .socials a:nth-child(4)";
        protected String countsLikesResponseCommentFirstPostcss=".posttext:nth-child(3) .commentsreplay .socials a:nth-child(3)";
       
        
    	//profiles
    	protected String irAMuroEnPerfilcss=".content menu li:first-child a";
        protected String irAlPerfilPost=".posttext:nth-child(3) h2 a";
        protected String irAlPerfilWindowAsidecss=".likes li:first-child a:first-child";
    	
    	//links
        protected String linkPostcss=".igolink";
    	protected String linkVerMascss=".posttext:nth-child(3) div:nth-child(2) .link";
        
    	//attachments    	
    	protected String loadPicturePostcss=".igopicturewhite";
    	protected String cameracss=".igocamerawhite";
    	protected String subirFotocss=".post .primary";
    	
    
              
        //Others
        static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        protected JavascriptExecutor js;
 	   
    	//By
        //Generics	
        By irApublicar=By.cssSelector(irAPublicarCss);
        By publicarContenido = By.cssSelector(publicarContenidoCss);
        By icon =By.cssSelector(iconcss);  
        By timePost=By.cssSelector(timefirstPostcss);
        By irAActividadSocial=By.cssSelector(irAActividadSocialcss);
        By irAMiembros = By.cssSelector(irAMiembroscss);
        
      //postear, comentar, responder,eliminar
        By textPost =By.cssSelector(textAreaPostcss);
    	By textPosteado=By.cssSelector(textofirstPostcss);
    	 By commentFirstPost=By.cssSelector(commentFirstPostcss);
    	 By sendComment=By.cssSelector(sendCommentcss);
         By comment = By.cssSelector(commentInputcss);
         By responseCommentFirstPost=By.cssSelector(reponderCommentFirstPostInputcss);
         By abrirReponderComment=By.cssSelector(arbirResponderCommentFirstPstscss);
         By selectEliminarPost=By.cssSelector(selecteliminarPostcss);
         
    	
    	
    	//Likes
         By like = By.cssSelector(likeFirstPostcss);
         By desplegarLikes=By.cssSelector(desplegarLikescss);
         By countLikes=By.cssSelector(countsLikesFirstPostcss);
     	By countLikesComment= By.cssSelector(countsLikesCommentFirstPostcss);
     	By countLikesResponseComment= By.cssSelector(countsLikesResponseCommentFirstPostcss);
    	By likeComment=By.cssSelector(likeFirstCommentcss);
        By likeResponseComment = By.cssSelector(likeReponseCommentcss);	
   
     	//profiles
    	 By irAMuroEnPerfil=By.cssSelector(irAMuroEnPerfilcss);
    	 By irAlPerfilWindowAside=By.cssSelector(irAlPerfilWindowAsidecss);
    	
    	//links
    	By link =By.cssSelector(linkPostcss);
    	By linkVerMas=By.cssSelector(linkVerMascss);
    	
    	//attachments      	
           
        By loadFile= By.cssSelector(loadPicturePostcss);
        By loadPicture=By.cssSelector(subirFotocss);
      
        
    	static SecureRandom rnd = new SecureRandom();
    	
    	//Objects
    	    
    	  WebDriver driver;
    
     //Inits
    	  
    	    public MuroSocialPage(WebDriver driver){
    	    	 
    	        this.driver = driver;
     }
   PageFactory.
    //Generics    
       
    public void goToCreatePost(){
    	driver.findElement(irApublicar).click();
    }
		
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
	   
	   public String getTextFirstPost(){
		  return driver.findElement(textPosteado).getText();
		   
	   }
	   
	   public String getTimeFirstPost(){
		   return driver.findElement(timePost).getText();
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
	  
		
    
     public void irAActividadSocial(){
    	 Reporter.log("Clickeando Actividad Social");
    	 driver.findElement(irAActividadSocial).click();
     }
     
     public void irAMiembros(){
    	 driver.findElement(irAMiembros).click();
     }
   
   	
	  //Likes
	  
	  public void likearPost(){
		 Reporter.log("Likear el primer post");
		 driver.findElement(like).click();
	 }
	
	  public void likearComment() {
		    Reporter.log("Likear el comment");
			driver.findElement(likeComment).click();
			
		}

		public void likearResponseComment() {
			Reporter.log("Likear el response del comment");
			driver.findElement(likeResponseComment).click();
			
		}
  
	 public String countLikesPost(){
		return driver.findElement(countLikes).getText();
	 }
	 
	 public String countLikesComments(){
			return driver.findElement(countLikesComment).getText();
		 }
	 public String countLikesResponseComment(){
			return driver.findElement(countLikesResponseComment).getText();
		 }
	 
   public void desplegarLikesWindowAside(){
  	 Reporter.log("Deplegar el window aside de los likes");
  	 driver.findElement(desplegarLikes).click();
   }
  
  
   //Ir a profiles
    
   
   public void goToProfilePost(){
	   Reporter.log("Ir al perfil del posteador");
	   driver.findElement(By.cssSelector(irAlPerfilPost)).click();
   }
   
   public void irAFirstProfileWindowAside(){
  	 driver.findElement(irAlPerfilWindowAside);
   }
   
   public void irAMuroEnPerfil(){
		  driver.findElement(irAMuroEnPerfil).click();
	  }
   
   //Postear,Comentar, Responder
   
   //Set a string in a posttext
	  
   public void postTexto(String strTextPost){
      
  	 Reporter.log("Ingresar un texto en el postbox");
  	// driver.findElement(textPost).click();
  //	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
  	 driver.findElement(textPost).clear();
  	 driver.findElement(textPost).sendKeys(strTextPost);
  	   	 	     	
   }
     
   public void postear(){
  	
  	 Reporter.log("CLikeo publicar");
  	 driver.findElement(publicarContenido).click();
  	 
   }
     
   
   public void responderComment(String strResponseComment) {
	   //Clickear Reponder
	   Reporter.log("Clickeo en Responder del comment e ingreso un texto de respuesta");
	   driver.findElement(abrirReponderComment).click();
	    driver.findElement(responseCommentFirstPost).sendKeys(strResponseComment);
	    driver.findElement(sendComment).click();
		
	}
	
	  public void comentarFIrstPost(String strCommentPost){
		  Reporter.log("Comentar en el primer post");
		  driver.findElement(commentFirstPost).click();
		  WebDriverWait wait = new WebDriverWait(driver, 20);
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(commentInputcss)));
		  driver.findElement(comment).sendKeys(strCommentPost);
		 driver.findElement(sendComment).click();
	  }
    
	 
	 
	     public void postLink (String strlink){
	    	 Reporter.log("Posteo un link");
	    	  driver.findElement(link).click();
	    	  driver.findElement(By.cssSelector(".url input")).sendKeys(strlink);
	    	  driver.findElement(By.cssSelector(".url input")).sendKeys(Keys.ENTER);
	    	    	 
	    }
	     public void postFile () throws InterruptedException{
	    	 Reporter.log("Posteo una imagen subida como un file");
	    	 
	    	  	 js=  (JavascriptExecutor) driver;
	        
	    	  	 	driver.findElement(loadFile).click();
	    	  	 WebElement fileInput = driver.findElement(By.cssSelector(".imgpost img"));
	    	  		fileInput.sendKeys("C://home/marinatouceda/Imágenes/Sunflower.jpeg");
	        	 		 // js.executeScript("arguments[0].setAttribute('style', 'display:block')",element);	    	      
	    	        Thread.sleep(6000);	    	      
	    		    Reporter.log(" Foto cargada exitosamente");
	        	    	 
	    
    }

		public void eliminarPost() {
		driver.findElement(selectEliminarPost).click();
		
			
		}
    }  
       	
        
    
    
      
     
               
         
    


