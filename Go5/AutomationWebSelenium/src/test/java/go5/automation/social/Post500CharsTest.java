package go5.automation.social;




import org.testng.annotations.BeforeClass;



public class Post500CharsTest extends Post500CharsAC {
	
	
	
		
	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
}
	
	