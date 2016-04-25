package go5.automation.groupsytitles;


import org.testng.annotations.BeforeClass;


public class GroupsTest extends GroupsAB{

	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
	
 	
}
