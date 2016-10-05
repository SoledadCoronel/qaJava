import {By, until} from 'selenium-webdriver';
import {timeouts} from '../config/';
//import chaiAsPromised from 'chai-as-promised';

// esto tiene que ir en algun archivo vieja!
const waiterSelectors = {
	configuration: '.igoconfigurationwhite',
	people: '.tables',
	logout: 'label:nth-child(3) input',
	addUser: '.primarydata label:nth-child(1) input'
};

//Navigate selectors
const goBack = 'header .back';
var driver;

class BasePage {
	constructor (webdriver) {
		this.driver = webdriver;
	}

	open (url) {
		return this.driver.get(url);
	}

	_navigateTo (pageName) {
		const {navigationSelectors} = this;

		if (!navigationSelectors) {
			console.error('must define navigationSelectors on implementation class');
		}
		return this.driver.findElement(By.css(navigationSelectors[pageName])).click()
	}

	getPageWaiterSelector (pageName) {
		return waiterSelectors[pageName] || false;
	}

	goTo (pageName) {
		return this._navigateTo(pageName)
		.then((result)=> {
			let waiterSelector = this.getPageWaiterSelector(pageName);

			if (waiterSelector) {
				return this.waitForDisplayed(waiterSelector, timeouts.visible_elements);
			}

			return result;
		})
	}

	setValue (locator,value) {
		 this.driver.findElement(By.css(locator)).clear
		.then (()=>{
			 this.driver.findElement(By.css(locator)).sendKeys(value);
		})
	}
	waitForDisplayed (locator,timeout){
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
