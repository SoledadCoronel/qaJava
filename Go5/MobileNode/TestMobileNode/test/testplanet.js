var assert = require('assert');
var selenium = require('selenium-webdriver');
var test = require('selenium-webdriver/testing');
var driver;
var planetPage;
//import planetPage from './pagesobjects/PlanetPage.js';
var PlanetPage = require('../pagesobjects/PlanetPage.js');

const timeOut = 15000;

test.describe('calculating weights', function() {
	test.beforeEach(function() {
		this.timeout(timeOut);
		driver = new selenium.Builder().
			withCapabilities(selenium.Capabilities.firefox()).
			build();
		planetPage = new PlanetPage(driver);
		planetPage.visit();
	});

	test.afterEach(function() {
		driver.quit();
	});

	test.it('calculates weights', function() {
		planetPage.weightEntryPresent().then(function(weight) {
			assert.equal(weight, true, "Weight entry not possible");
		});
	});

	test.it('provides no default weight', function() {
		planetPage.weightEntryBlank().then(function(weight) {
			assert.equal(weight, '', "Weight started with values");
		});
	});
});
