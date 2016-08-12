package go5.automation.groupsytitles;



import go5.automation.SetUp;
import go5.pageObjects.GroupsPage;
import go5.pageObjects.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class GroupsAB extends SetUp{

	GroupsPage groups = null;
	HomePage home=null;
	 protected String addSubgroup = new String (".subtree .active a");
     protected String inputNameSubgroup= new String (".additem.active input");
     protected String editfirstRow= new String (".tables tbody tr:nth-child(1) td:nth-child(7) a");
     protected String  desplegarCampos = new String (".addpeople .secondary");
     protected String  savePerson = new String (".container .addpeople .primary");
     protected String groupEnProfile = new String (".groupsdata select");
   	
	 
	
	
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
		this.quitBrowser();
		}


		

	@Test
	public void addGroups() throws Exception{
		
		groups = new GroupsPage(driver);
		home = new HomePage(driver);
		
    	  	  // Ir a Config
		     home.goToConfiguration();
		     Thread.sleep(3000);
    	
   	    	    home.goToGrupos();
   	    	    Thread.sleep(3000);
   	    	 	groups.addAGroups("Primer Grupo");
   	    	 	groups.deleteGroup();
   	    	 	groups.addAGroups("Segundo Grupo");
   	    	 	groups.addASubgroup("Probando subgrupo");
   	    	 	
   	    	 	
   	    	
   	    	 this.click(editfirstRow);
	    	 Thread.sleep(1000);
	    	 this.click(desplegarCampos);
	    	 Thread.sleep(1000);
	    	 Select selectGroups=new  Select(driver.findElement(By.cssSelector(groupEnProfile))); 
		 		
		 	  selectGroups.selectByIndex(1);
	    	 this.click(savePerson);
   	    	
   	    	  
   	    			 	  
		 	 
   	     
	 		       
	}
	
	
}
