var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;

var driver = new webdriver.Builder()
    .forBrowser('firefox')
    .build();

var loginTest = require('./pages/login'),
	forgotPasswordTest = require('./pages/forgot-password');


// login test
loginTest.run();

forgotPasswordTest.run();


driver.get('http://www.google.com/ncr');




driver.findElement(By.name('q')).sendKeys('webdriver');
driver.findElement(By.name('btnG')).click();
driver.wait(until.titleIs('webdriver - Google Search'), 1000);
driver.quit();