import BasePage from './BasePage';
//Css
const navigationSelectors = {
	configuration: '.igoconfigurationwhite',
	users: '.space:nth-child(2) .igoadminwhite',
}

const pagesToWait = {
	users: true,
	configuration: true
}


const goToMenu ='.menu';

//SideBar user basic

const goToHome ='.igohome';
const goToMyProfile = '.igowithoutimage';
const goToPeople = '.space .igouserwhite';
const mySpaces = '.igopasswordwhite';
const goToUserMenu = '.usermenu .last a figure';
const goToLogout = '.users li:last-child a';
const goToSpaceIconUmbrella = '.igospaceumbrella ';

//SideBar user admin


const goToImage = '.igodesign';
const goToEmails='.igomail';
const goToTitles = '.space:nth-child(2) .igotitleswhite';
const goToGroups = '.igogroups';
const peopleTable = '.tables';

const goToSocial = '.igosocialswhite';
const goToManageStore = 'article .space:nth-child(3) .igoadminwhite';
const goToManageSpaces = 'article .space:nth-child(4) .igoadminwhite';
//Elemens for explicit waits
const textPost = '.posttext';
const inputEmail = 'label:nth-child(3) input';
const helpLink ='igohelpwhite';
const timeout = 20000;


import {By, until} from 'selenium-webdriver';


// Me traigo el driver de la  BasePage

class HomePage extends BasePage {
	constructor (webdriver) {
		super(webdriver);
		this.navigationSelectors = navigationSelectors;
	}

	isLoaded () {
		//return this.driver.wait(until.elementLocated(By.id('ember759')),30000);
		return super.waitForDisplayed(goToHome, 30000);
	}
	goToHome (){
		this.driver.findElement(By.css(goToHome)).click();
	}
	goToMenu () {
		console.log('open menu');
		return this.driver.findElement(By.css(goToMenu)).click();
	}
	goToUserMenu () {
		this.driver.findElement(By.css(goToUserMenu)).click();
	}
	goToMyProfile () {
		this.driver.findElement(By.css(goToMyProfile)).click();
	}
	goToPeople () {
		this.driver.findElement(By.css(goToPeople)).click();
	}

	// Sidebar user admin

	goToTitles () {
		console.log('Abriendo titulos');
		this.driver.findElement(By.css(goToTitles)).click();
	}
	goToGroups () {
		this.driver.findElement(By.css(goToGroups)).click();
	}
	goToGeneralInfo () {
		this.driver.findElement(By.css(goToGeneralInfo)).click();
	}
	goToImage () {
		this.driver.findElement(By.css(goToImage)).click();
	}

	goToEmails () {
		this.driver.findElement(By.css(goToEmails)).click();
	}
	goToAyuda () {
		this.driver.findElement(By.css(helpLink)).click();
	}
	goToLogout () {
		goToUserMenu();
		this.driver.findElement(By.css(goToLogout)).click();
		waitForDisplayed(inputEmail,15);
	}

}

export default HomePage;
