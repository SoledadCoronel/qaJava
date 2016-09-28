import selenium from 'selenium-webdriver';

//var webdriver = require('selenium-webdriver');

var firefoxDriver = new selenium.Builder()
    .forBrowser('firefox');

/*var firefoxDriver  = new selenium.Builder()
	.withCapabilities(selenium.Capabilities.firefox())
	.build();
*/
var drivers = {
	firefox: firefoxDriver
};

export default {
	getDriver (driverName) {
		return drivers[driverName] || drivers.firefox;
	}
}
