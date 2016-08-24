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
   	    	 	Thread.sleep(6000);
   	    	 	groups.addAFirstSubgroup("Primer subgrupo del Grupo 1"); 	    	 	
   	    	 	
   	    	 	groups.addAGroups("Segundo Grupo");
   	    	 	Thread.sleep(6000);
   	    	 	groups.addASubgroup("Probando subgrupo");
   	    	 	groups.deleteFirstSubGroup();
   	    	 	Thread.sleep(3000);
   	    	 	groups.deleteFirstGroup();
   	    	 	
   	    	 	
   	    	/*
   	    	 this.click(editfirstRow);
	    	 Thread.sleep(1000);
	    	 this.click(desplegarCampos);
	    	 Thread.sleep(1000);
	    	 Select selectGroups=new  Select(driver.findElement(By.cssSelector(groupEnProfile))); 
		 		
		 	  selectGroups.selectByIndex(1);
	    	 this.click(savePerson);
   	    	
   	    	  */
   	    			 	  
		 	 
   	     
	 		       
	}
	
	
}
