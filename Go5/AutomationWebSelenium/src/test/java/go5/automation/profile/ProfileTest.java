package go5.automation.profile;



import go5.pageObjects.ProfilePage;
import org.testng.annotations.BeforeTest;




public class ProfileTest extends ProfileAC  {
	

ProfilePage profile = null;


@BeforeTest // call function to open the browser and login 
public void setup () throws Exception{
	 this.setUpMaven();
}

 
	}
		
	