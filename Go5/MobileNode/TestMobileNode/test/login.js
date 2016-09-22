import webdriver from 'selenium-webdriver';
import {assert} from 'chai';
import loginSelectors from '../selectors/login';

describe("Demonstrating webdriver promises", function () {
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

	it("I open the blog www", (done) => {
		console.log('Loading google page');
		driver = new webdriver.Builder().forBrowser('firefox').build();
		driver.get("http://google.com")
			.then(() => {
				done();
			});
		
	});

	/* it("The title is 'Scott Logic Blog'", () => {
		// Since we want the title from the page, we need to manually handle the Promise
		return driver.getTitle().then(function(title) {
			assert.equal(title, "Scot Logic Blog");
		});
	});*/
});