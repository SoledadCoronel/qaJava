var driver;
/***
Base constructor for a pageobject
*Takes in a WebDriver object
*Sets the WebDriver in the base page surfacing this to chid page objects
*@param webdriver
*@constructor
*/
	class BasePage {
	constructor (webdriver) {
		this.driver = webdriver;
	}

	waitForPresent(locator,timeout){
		timeout = timeout || WAIT_TIMEOUT;
		driver.waitForPresent=>(locator)//No se si se hace asi...
	}

	}

