var driver;
/***
Base constructor for a pageobject
*Takes in a WebDriver object
*Sets the WebDriver in the base page surfacing this to chid page objects
*@param webdriver
*@constructor
*/
function BasePage(webdriver){
	this.driver=webdriver;
}
/*
BasePage.prototype.waitForLocated = function (locator,timeout) {
	var MAX_RETRIES = 5;
	var retry = 0;

	timeout = timeout || WAIT_TIME_PRESENT;
	var _this = this;
	//The actual wait ,but we handle the error

	return _this.driver.wait
	}
	*/
BasePage.prototype.waitForPresent = function (locator,timeout){
	timeout = timeout || WAIT_TIMEOUT;
	var driver = this.driver;
	return this.driver.wait (function(){
		// definir que el elemento esta presente
		},timeout);
	};
