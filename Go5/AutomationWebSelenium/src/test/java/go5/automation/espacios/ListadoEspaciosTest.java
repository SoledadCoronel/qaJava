package go5.automation.espacios;



import go5.pageObjects.EspaciosPage;


import org.testng.annotations.BeforeClass;




public class ListadoEspaciosTest extends ListadoEspaciosAC {
	
	

	
	EspaciosPage espacio=null;
	

	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}

}