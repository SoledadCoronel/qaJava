var webdriver = require("selenium-webdriver");
var assert = require("chai").assert;
var loginSelectors = require('../selectors/login');

describe("Demonstrating webdriver promises", function() {
    this.timeout(30000);
    var driver;

    before(function() {
        driver = new webdriver.Builder().forBrowser('firefox').build();
    });

    after(function() {
        driver.quit();
    });

    it("I open the blog www", function() {
        driver.get("http://www.scottlogic.com/blog");
    });

    it("The title is 'Scott Logic Blog'", function() {
        // Since we want the title from the page, we need to manually handle the Promise
        return driver.getTitle().then(function(title) {
            assert.equal(title, "Scot Logic Blog");
        });
    });
});