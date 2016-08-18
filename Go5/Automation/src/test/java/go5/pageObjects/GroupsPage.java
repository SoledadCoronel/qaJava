package go5.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GroupsPage {

	// Css

	// Group
	private String addGroupCss = ".groupsform fieldset:nth-child(1) label:nth-child(1) a";
	private String inputNameGroupCss = ".groupsform fieldset:nth-child(1) label:nth-child(2) input";
	private String deleteGroupCss = ".groupsform fieldset:nth-child(2) .delete";
	private String confirmCss = ".mconfirmation a";
	// Subgroup
	protected String addSubgroupCss = ".subtree .active a";
	protected String inputNameSubgroupCss = ".additem.active input";
	protected String editfirstRowCss = ".tables tbody tr:nth-child(1) td:nth-child(7) a";
	protected String desplegarCamposCss = ".addpeople .secondary";
	protected String savePersonCss = ".container .addpeople .primary";
	
	// References

	By addGroup = By.cssSelector(addGroupCss);
	By inputNameGroup = By.cssSelector(inputNameGroupCss);
	By deleteGroup = By.cssSelector(deleteGroupCss);
	By confirm = By.cssSelector(confirmCss);
	By addSubgroup = By.cssSelector(addSubgroupCss);
	By inputNameSubgroup = By.cssSelector(inputNameGroupCss);
	By editfirstRow =By.cssSelector(editfirstRowCss);
	By desplegarCampos = By.cssSelector(desplegarCamposCss);
	By savePerson = By.cssSelector(savePersonCss);

	// Driver

	WebDriver driver;

	// Constructor
	public GroupsPage(WebDriver driver) {

		this.driver = driver;
	}

	
	public void addAGroups(String nameGroup) {

		Reporter.log("Agregando un grupo");
		WebElement addgroup = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(addGroup));
		// Agregar un Grupo
		driver.findElement(addGroup).click();

		// Insertar un nombre de Grupo

		driver.findElement(inputNameGroup).sendKeys(nameGroup);
		driver.findElement(inputNameGroup).sendKeys(Keys.RETURN);

	}

	public void deleteGroup() {
		// Borrar Grupo
		driver.findElement(deleteGroup).click();
		driver.findElement(confirm).click();	
	}

	public void addASubgroup(String name) throws InterruptedException {
		// Agregar un Subgrupo
		driver.findElement(addSubgroup).click();
		WebElement addgroup = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(inputNameSubgroup));		
		driver.findElement(inputNameSubgroup).sendKeys(name);
		driver.findElement(inputNameSubgroup).sendKeys(Keys.RETURN);
		Thread.sleep(1000);

	}
	
		
	}
