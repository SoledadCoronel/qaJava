package go5.automation.espacios;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;




public class UnirseAEspacioUserBasicTest extends EspacioUserBasicAbstractClass {
	
		
	@BeforeClass
	
	  public void setUpUnirseAEspacio() throws Exception {
		
			this.setUpMaven();
	}
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
		this.quitBrowser();
		}
		 
				
     }

