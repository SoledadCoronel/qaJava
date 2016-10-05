import BasePage from './BasePage';
import {By, until} from 'selenium-webdriver';
//Css
const navigationSelectors = {
	//SideBar user basic
	menu: '.menu',
	configuration: '.igoconfigurationwhite',
	users: '.space:nth-child(2) .igoadminwhite',
	home:'.igohome',
	myProfile: '.igowithoutimage',
	people: '.space .igouserwhite',
	mySpaces: '.igopasswordwhite',
    userMenu: '.usermenu .last a figure',
    logout: '.users li:last-child a',
    //SideBar user admin
 	design : '.igodesign',
 	emails:'.igomail',
 	titles : '.space:nth-child(2) .igotitleswhite',
 	groups : '.igogroups',
 	peopleTable : '.tables',
	social : '.igosocialswhite',
 	manageStore : 'article .space:nth-child(3) .igoadminwhite',
	manageSpaces : 'article .space:nth-child(4) .igoadminwhite',
	//Elemens for explicit waits
 	textPost : '.posttext',
 	inputEmail : 'label:nth-child(3) input',
 	helpLink :'igohelpwhite',
}

const pagesToWait = {
	users: true,
	configuration: true,
}


// Me traigo el driver de la  BasePage

class HomePage extends BasePage {
	constructor (webdriver) {
		super(webdriver);
		this.navigationSelectors = navigationSelectors;
	}

	isLoaded () {
		return super.waitForDisplayed(goToHome, 30000);
	}

	showUserMenu () {
		return this.driver.findElement(By.css(userMenu)).click();

	}


	goToLogout () {
		  //this.showUserMenu()
		 this.goTo('userMenu')
			.then(() => {
				this.goTo('logout')

			});

	}

}

export default HomePage;
