var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;

var driver = new webdriver.Builder()
    .forBrowser('firefox')
    .build();

// login test
//loginTest.run();
/*
driver.get('http://automation5.pla.qa.go5.gointegro.net/authentication/login');
driver.wait(until.titleIs('webdriver - GOintegro'), 1000);
driver.findElement(By.css('label:nth-child(3) input')).sendKeys('marina.touceda@gointegro.com');*/
driver.get('http://automation5.pla.qa.go5.gointegro.net/authentication/login');
//driver.findElement(By.name('q')).sendKeys('webdriver');
//driver.findElement(By.name('btnG')).click();
driver.wait(until.titleIs('webdriver - Google Search'), 10004);
driver.quit();
