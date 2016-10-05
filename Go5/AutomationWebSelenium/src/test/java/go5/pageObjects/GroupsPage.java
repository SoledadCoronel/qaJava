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
	private String addFirstSubgroupcss= ".groupsform fieldset:nth-child(2) .subtree a";
	private String deletePrimerGrupo=".groupsform fieldset:nth-child(2) .tree .delete";
	private String deleteFirstSubgroupCss=".groupsform fieldset:nth-child(2) .subtree .delete";
	private String confirmDeleteGroup=".active .mconfirmation .primary";
	private String inputNameGroupCss = ".groupsform fieldset:nth-child(1) label:nth-child(2) input";	
	private String confirmCss = ".mconfirmation a";
	
	// Subgroup
	
	protected String inputNameSubgroupCss = ".groupsform fieldset:nth-child(2) .additem input";
	protected String editfirstRowCss = ".tables tbody tr:nth-child(1) td:nth-child(7) a";
	protected String desplegarCamposCss = ".addpeople .secondary";
	protected String savePersonCss = ".container .addpeople .primary";
	
	// References

	By addGroup = By.cssSelector(addGroupCss);
	By addFirstSubrgoup=By.cssSelector(addFirstSubgroupcss);
	By inputNameGroup = By.cssSelector(inputNameGroupCss);
	By deleteFirstGroup = By.cssSelector(deletePrimerGrupo);
	By deleteFirstSubgroup=By.cssSelector(deleteFirstSubgroupCss);
	By confirmDelete=By.cssSelector(confirmDeleteGroup);
	By confirm = By.cssSelector(confirmCss);	
	By inputNameSubgroup = By.cssSelector(inputNameSubgroupCss);
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
	public void deleteFirstGroup() {
		// Borrar Grupo
		driver.findElement(deleteFirstGroup).click();
		driver.findElement(confirmDelete).click();	
	}
	
	public void deleteFirstSubGroup(){
		driver.findElement(deleteFirstSubgroup).click();
		driver.findElement(confirmDelete).click();
	}
	
	public void addAFirstSubgroup(String name) throws InterruptedException {
		// Agregar un Subgrupo
		driver.findElement(addFirstSubrgoup).click();
		WebElement addgroup = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(inputNameSubgroup));		
		driver.findElement(inputNameSubgroup).sendKeys(name);
		driver.findElement(inputNameSubgroup).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
	
	}

	}
