package go5.automation.espacios;



import go5.pageObjects.EspacioPage;


import org.testng.annotations.BeforeClass;




public class ListadoEspaciosTest extends ListadoEspaciosAC {
	
	

	
	EspacioPage espacio=null;
	

	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}

}