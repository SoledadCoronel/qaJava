This branch is for automation purpose for Go5 mobile applications.The driver to be use is Appium,and the language for developing the test is NodeJS.

## Appium

Appium is an open source, cross-platform test automation tool for native, hybrid and mobile web apps, tested on simulators (iOS, FirefoxOS), emulators (Android), and real devices (iOS, Android, Windows, FirefoxOS).
[![NPM version](https://badge.fury.io/js/appium.svg)](https://npmjs.org/package/appium)

#### Android Requirements

* [Android SDK](http://developer.android.com) API &gt;= 17 (Additional features require 18/19)
* Appium supports Android on OS X, Linux and Windows. Make sure you follow the
  directions for setting up your environment properly for testing on different OSes:
  * [linux](/docs/en/appium-setup/running-on-linux.md)
  
#### Using Node.js

$ npm install -g appium
$ appium


### Writing Tests for Appium

The main guide for getting started writing and running tests is [the running tests](/docs/en/writing-running-appium/running-tests.md) doc, which includes explanations for iOS, Android, and Android older devices. If you're interested in testing on physical hardware, you might be interested in our [real devices guide](/docs/en/appium-setup/real-devices.md).

Essentially, we support a subset of the [Selenium WebDriver JSON Wire Protocol](https://w3c.github.io/webdriver/webdriver-spec.html), and extend it so that you can specify mobile-targeted [desired capabilities](/docs/en/writing-running-appium/caps.md) to run your test through Appium.

You find elements by using a subset of WebDriver's element-finding strategies.
See [finding elements](/docs/en/writing-running-appium/finding-elements.md) for detailed information. We also have several extensions to the JSON Wire Protocol for [automating mobile gestures](/docs/en/writing-running-appium/touch-actions.md) like tap, flick, and swipe.

You can also automate web views in hybrid apps! See the [hybrid app guide](/docs/en/advanced-concepts/hybrid.md)

This repository contains [many examples of tests in a variety of different languages](https://github.com/appium/sample-code)!

For the full list of Appium doc pages, visit [this directory](/docs/en/).
```  
