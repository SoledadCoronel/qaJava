var webdriver = require('selenium-webdriver'), // muse use selenium-webdriver version <=2.47.0
    username = "toucedam",
    accessKey = "0ee9d162-fefa-4b13-b9aa-57f91c36dfae",
    driver;

driver = new webdriver.Builder(). withCapabilities({
    'browserName': 'chrome',
    'platform': 'Windows XP',
    'version': '43.0',
    'username': username,
    'accessKey': accessKey
  }).
  usingServer("http://" + username + ":" + accessKey +
              "@ondemand.saucelabs.com:80/wd/hub").
  build();

driver.get('http://automation5.pla.qa.go5.gointegro.net/authentication/login');

driver.getTitle().then(function (title) {
    console.log("title is: " + title);
});

driver.quit();