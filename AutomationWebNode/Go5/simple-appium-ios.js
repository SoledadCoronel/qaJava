var wd = require('wd'),
    desiredCaps = {
        browserName: '',
        appiumVersion: '1.4.16',
        deviceName: 'iPhone 6',
        platformVersion: '8.4',
        platformName: 'iOS',
        name: 'Sample Test',
        app: 'https://s3.amazonaws.com/appium/TestApp8.4.app.zip'
    },
    driver = wd.remote("ondemand.saucelabs.com", 80, "YOUR_SAUCE_USERNAME", "YOUR_SAUCE_ACCESS_KEY");

driver.init(desiredCaps, function(error) {
    if (error) {
        throw new Error('Session did not start properly. Please make sure you sauce credentials are correct');
    }
    driver.quit();
});
