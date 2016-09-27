var driver;
/***
Base constructor for a pageobject
*Takes in a WebDriver object
*Sets the WebDriver in the base page surfacing this to chid page objects
*@param webdriver
*@constructor
*/
import {By, until} from 'selenium-webdriver';


class BasePage {
	constructor (webdriver) {
		this.driver = webdriver;
	}

	open (url) {
		return this.driver.get(url);
	}

	waitForDisplayed(locator,timeout){
		return this.driver.wait(until.elementLocated(By.css(locator)),timeout);
	}

}

export default BasePage;
