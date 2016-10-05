package go5.automation.groupsytitles;

import go5.automation.SetUp;
import go5.pageObjects.GroupsPage;
import go5.pageObjects.HomePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GroupsDragAndDrop extends SetUp {

	GroupsPage groups = null;
	HomePage home=null;
	private String firstGroupCss=".groupsform fieldset:nth-child(2)";
	private String secondGroupCss=".groupsform fieldset:nth-child(3)";
	
	//References
	
	By firstGroup=By.cssSelector(firstGroupCss);
	By secondGroup=By.cssSelector(secondGroupCss);
	
	@AfterClass
	// call function to close browser
	public void teardown() {
		this.quitBrowser();
	}

	@Test
	public void dragAndDropGroups() throws Exception {

		groups = new GroupsPage(driver);
		home = new HomePage(driver);
		js = (JavascriptExecutor) driver;


		// Go to Grupos
		home.goToConfiguration();
		home.goToGrupos();

		// Drag and Drop

		// Cargando elementos
		WebElement element = driver.findElement(firstGroup);
		WebElement target = driver.findElement(secondGroup);
				

		// Cargando el javascript

		try {
			String jquerySimulator = new String(
					Files.readAllBytes(Paths
							.get("/home/marinatouceda/Documentos/qa/Go5/Automation/src/test/java/go5/automation/drag_and_drop_helper.js")));

			js.executeScript(jquerySimulator);

			js.executeScript("$('#" + element.getAttribute("id")
					+ "').simulateDragDrop({ dropTarget: '#"
					+ target.getAttribute("id") + "'});");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
