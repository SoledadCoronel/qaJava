import {By, until} from 'selenium-webdriver';

//Navigate selectors
const goBack ='header .back';

//Chai as Promised
const chaiAsPromised = require('chai-as-promised');
chai.use(chaiAsPromised);
//Class definition
var driver;
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
	waitForEnabled (locator,timeout){
		return this.driver.wait(until.elementLocated(By.css(locator)),timeout);
	}
    assertAValue (locator,expectedValue){
	     return expect(driver.findElement(By.css(locator)).getAttribute('value')).to.eventually.equal(expectedValue);
    }

}

export default BasePage;
