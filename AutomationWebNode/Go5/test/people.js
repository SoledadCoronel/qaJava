import test from 'selenium-webdriver/testing';
import {assert} from 'chai';
import LoginPage from '../pagesobjects/LoginPage';
import HomePage from '../pagesobjects/HomePage';
import ManageUsers from '../pagesobjects/ManageUsers';
import AddUser from '../pagesobjects/AddUser';
import DriverFactory from '../drivers/';

const username = 'marina.touceda@gointegro.com';
const password ='Auto1234';
const url = 'http://automation5.pla.qa.go5.gointegro.net/authentication/login';

test.describe("Test de login", function (done) {
	this.timeout(300000);
	var driver;


	before(() => {

		driver = DriverFactory.getDriver('firefox');

	});

	after(() => {
		driver.quit();
	});

	test.it("go to Users and add a new user ", (done) => {
		driver = driver.build();

		var loginPage = new LoginPage(driver);
		var home = new HomePage(driver);
		var users = new ManageUsers(driver);
		var adduser = new AddUser(driver);
		loginPage.open(url)
			.then(() => {
				return loginPage.isLoaded();
			})
			.then(() => {
				return loginPage.login(username,password);
			})
			.then(() => {
				return home.goTo('configuration');
				console.log ('open configuration page');
			})
			.then(() => {
				return home.goTo('users');
				console.log ('open manage users page');
			})
			.then(() => {
				return users.goTo('addUser');
			})
			.then(() => {
				return adduser.createUser('testname','testautomation','testauto@gointegro.com');
			})
			.then(() => {
				return home.goToLogout();
			})
			.then(() => {
				done();
			});
	});

});
