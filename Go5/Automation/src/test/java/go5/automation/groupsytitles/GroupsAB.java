package go5.automation.groupsytitles;



import go5.automation.TestSuite;
import go5.pageObjects.GroupsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class GroupsAB extends TestSuite{

	GroupsPage groups = null;
	
	protected String irAGroups = new String (".space:nth-child(3) ol li:nth-child(4) a");
	 protected String irATitles = new String ("nav .space:nth-child(3) ol li:nth-child(3)");
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
		
		

		  // Go to the configuration
		 this.goToConfiguration();
		 this.goToMenu();	
		
		 //groups.goToGroups();

    	 Reporter.log("Abriendo pagina de grupos" );
    	  		this.click(irATitles);
    	
   	    	 
   	    	 	groups.goToGroups();
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
