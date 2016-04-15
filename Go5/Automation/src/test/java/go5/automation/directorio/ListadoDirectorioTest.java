package go5.automation.directorio;


import org.testng.annotations.BeforeClass;


public class ListadoDirectorioTest extends ListadoDirectorioAB{
	
		
	 @BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		this.setUpMaven();
	 }
	
}	