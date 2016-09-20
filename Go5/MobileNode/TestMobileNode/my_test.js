
var Capabilities = require('selenium-webdriver/lib/capabilities').Capabilities;
var capabilities = Capabilities.firefox();
capabilities.set('marionette', true);
var Assert = require('assert');
 
var driver = new webdriver.Builder().withCapabilities(capabilities).build();
var driver = new WebDriver.Builder().withCapabilities({'browserName': 'firefox'}).build();

driver.get('http://www.google.com');
driver.findElement(WebDriver.By.name('q')).sendKeys('webdriver');
driver.findElement(WebDriver.By.name('btnG')).click();

driver.getTitle().then(function(title) {
  Assert.equal('webdriver - Google Search', title);
});