import test from 'selenium-webdriver/testing';
import {assert} from 'chai';
import LoginPage from '../pagesobjects/LoginPage';
import HomePage from '../pagesobjects/HomePage';
import DriverFactory from '../drivers/';

const username = 'marina.touceda@gointegro.com';
const password ='Auto1234';
const url = 'http://automation5.pla.qa.go5.gointegro.net/authentication/login';

test.describe("Test de login", function (done) {
	this.timeout(300000);
	var driver;
	//var webdriver;

	before(() => {
		//webdriver = require('selenium-webdriver');
		//driver = new webdriver.Builder()
		  //  .forBrowser('firefox');
		driver = DriverFactory.getDriver('firefox');

	});

	after(() => {
		driver.quit();
	});

	test.it("go to Users and add a new user ", (done) => {
		driver = driver.build();

		var loginPage = new LoginPage(driver);
		var home = new HomePage(driver);
		loginPage.open(url)
			.then(() => {
				return loginPage.isLoaded();
			})
			.then(() => {
				return loginPage.login(username,password);
			})
			.then(() => {
				return home.goTo('configuration');
				//return home.goToConfiguration();
			})
			.then(() => {
				return home.goTo('users');
				//return home.goToUsers();
			})
			.then(() => {
				return home.goToLogout();
			})
			.then(() => {
				done();
			});
	});

});
