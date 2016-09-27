import webdriver from 'selenium-webdriver';
import test from 'selenium-webdriver/testing';
import {assert} from 'chai';
import login from '../pagesobjects/LoginPage';

test.describe("tratando de hacer andar mi test", function () {
	var driver;

	this.timeout(30000);

	before(() => {
		console.log('running before');
		//driver = new webdriver.Builder().forBrowser('firefox').build();
	});

	after(() => {
		console.log('running after');
		driver.quit();
	});

	test.it("I open the blog www", (done) => {
		console.log('Loading google page');
		driver = new webdriver.Builder().forBrowser('firefox').build();
		driver.get("http://automation5.pla.qa.go5.gointegro.net/authentication/login")
			.then(() => {
				login.isLoaded();
			})
			.catch(() => {

			})
			.finally(() => {
				done();
			});
	});
});
