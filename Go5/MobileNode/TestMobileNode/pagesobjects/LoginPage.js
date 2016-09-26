var BasePage = require ('./BasePage');
	goButtonLogin: '.signup .primary',
	inputEmail: '.signup fieldset label:nth-child(2) input',
	inputPassword:'.signup fieldset label:nth-child(3) input',

/**
*Constructor for the Login Page
*Hooks up the webdriver holder in the base page allowing to call this.driver in page objects
*@param webdriver
*@constructor
*/
function LoginPage(webdriver){
	BasePage.call(this,webdriver);
	this.isLoaded();
}

//Hooking up prototypal inheritance to BasePage
LoginPage.prototype = Object.create(BasePage.prototype);
//This is the constructor
LoginPage.prototype.constructor = LoginPage;


LoginPage.prototype.isLoaded = function (){
	this.waitForDisplayed (By.css (inputEmail));
	return this;
}

LoginPage.prototype.login = function (username,password) {
	this.waitForDisplayed(By.css(inputEmail));
	this.driver.findElement (By.css(inputEmail)).sendKeys(username);
	this.driver.findElement(By.css(inputPassword)).sendKeys(password);
	this.driver.findElement(By.css(goButtonLogin)).click;
	return this;


}

