import BasePage from './BasePage';
//Css
const	goToConfiguration = '.igoconfigurationwhite';
const   goToHome ='.igohome';
const 	goToMenu ='.menu';
const 	helpLink ='igohelpwhite';
const   goToDatosGenerales = '.igocompanydata';
const   goToDisenio = '.igodesign';
const   goToAdministrarPersonas = '.space:nth-child(2) .igoadminwhite';
const   goToTitulos = '.space:nth-child(2) .igotitleswhite';
const   goToGrupos = '.igogroups';
const   personasTable = '.tables';
const   goToDirectorio = '.space .igouserwhite';
const   goToActividadSocial = '.igosocialswhite';
const   goToVerMasEspacios = '.noicon';
const   goToAdmistrarStore = 'article .space:nth-child(3) .igoadminwhite';
const   goToTienda = '.space:nth-child(3) .igotitleswhite';
const   mySpaces = '.igopasswordwhite';
const   goToUserMenu = '.usermenu .last a figure';
const   goToLogout = '.users li:last-child a';
const   goToSpaceIconUmbrella = '.igospaceumbrella ';
const   textPost = '.posttext';
const	inputEmail = 'label:nth-child(3) input';

import {By, until} from 'selenium-webdriver';


// Me traigo el driver de la  BasePage

class HomePage extends BasePage {
	constructor (webdriver) {
		super(webdriver);
	}

	isLoaded () {
		//return this.driver.wait(until.elementLocated(By.id('ember759')),30000);
		return super.waitForDisplayed(goToHome, 50000);
	}
	goToHome (){
		this.driver.findElement(By.css(goToHome)).click();
	}
	goToMenu () {
		this.driver.findElement(By.css(goToMenu)).click();
	}
	goToUserMenu () {
		this.driver.findElement(By.css(goToUserMenu)).click();
	}
	goToAdministrar () {
		this.driver.findElement(By.css(goToAdministrar)).click();
	}
	goToTitulos () {
		console.log('Abriendo titulos');
		this.driver.findElement(By.css(goToTitulos)).click();
	}
	goToGrupos () {
		this.driver.findElement(By.css(goToGrupos)).click();
	}
	goToDatosGenerales () {
		this.driver.findElement(By.css(goToDatosGenerales)).click();
	}
	goToDisenio () {
		this.driver.findElement(By.css(goToDisenio)).click();
	}
	goToDirectorio () {
		this.driver.findElement(By.css(goToDirectorio)).click();
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

export default LoginPage;
