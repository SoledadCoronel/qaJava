 var test = require('selenium-webdriver/testing');
    var webdriver = require('selenium-webdriver');
    test.describe('Test', function() {

        test.beforeEach();
        test.it('', function() {
            var driver = new webdriver.Builder().build();
            driver.get("http://www.airware.com");
            assertEquals("Airware", driver.getTitle());
        });
        test.afterEach();
    });
