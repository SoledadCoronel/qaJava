package go5.automation.groupsytitles;


import go5.pageObjects.GroupsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class GroupsBS extends GroupsAB{

	GroupsPage groups = null;
	   

	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build);
				
	 }
	


		

}
