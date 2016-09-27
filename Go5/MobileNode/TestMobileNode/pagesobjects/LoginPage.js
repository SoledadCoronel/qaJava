import BasePage from './BasePage';
const	goButtonLogin = '.primary';
const	inputEmail = '.label:nth-child(3) input';
const	inputPassword = '.label:nth-child(4) input';

import {By, until} from 'selenium-webdriver';


// Me traigo el driver de la  BasePage

class LoginPage extends BasePage {
	constructor (webdriver) {
		super(webdriver);
	}

	isLoaded () {
		return this.driver.wait(until.elementLocated(By.id('ember759')),30000);
		//return super.waitForDisplayed(inputEmail, 50000);
	}

 	sendUsername (username) {
 		this.driver.findElement (By.id('ember759')).sendKeys(username);
 	}

 	sendPassword (password) {
		this.driver.findElement(By.id('ember760')).sendKeys(password);
 	}

 	pressLoginButton () {
 		this.driver.findElement(By.css(goButtonLogin)).click();

 	}

 	login (username,password) {
 		//Sthis.isLoaded();
 		this.sendUsername(username);
 		this.sendPassword(password);
 		this.pressLoginButton();
 		return this.driver.wait(until.elementLocated(By.css('.igohome')),50000);
 	//	return this;
 	}

}

export default LoginPage;
