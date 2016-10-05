package go5.automation.social;




import org.testng.annotations.BeforeClass;



public class PostFileTest extends PostFileAC {
	
	
	
		
	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
}
	
	