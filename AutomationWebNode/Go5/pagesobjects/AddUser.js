import BasePage from './BasePage';
import {By, until,select} from 'selenium-webdriver';
//Css
const navigationSelectors = {
	//SideBar user basic
	activateUser: '.statedata label:nth-child(2) input:nth-child(1)',
	inactivateUser: '.statedata label:nth-child(2) input:nth-child(2)',
	blockAccessUser: '.statedata label:nth-child(3) input',
	inputName: '.primarydata label:nth-child(1) input',
	inputLastName: '.primarydata label:nth-child(2) input',
	inputEmail: '.primarydata label:nth-child(3) input',
	selectRol: '.primarydata label:nth-child(4) select',
	groupsSelect: '.groupsdata select',
    allFields: '.addpeople fieldset.last .link',

    // Labor Data

	idEmployee:'.labordata label:nth-child(1) input',
	admissionDate: '.labordata label:nth-child(2) input',
	jobType: '.labordata label:nth-child(3) select',
	title: '.labordata label:nth-child(4) select',
	reportsTo: '.labordata label:nth-child(5)',
	reportToList: '.list li:nth-child(n)',
	phone: '.labordata label:nth-child(7) input',
	cellPhone: '.labordata label:nth-child(8) input',
	businessAddress: '.labordata label:nth-child(9) input',


	// Personal Data

	docType: '.personaldata label:nth-child(1) select',
	docNumber:'.personaldata label:nth-child(2) input',
	birthDate: '.personaldata label:nth-child(3) input',
	gender:'.personaldata label:nth-child(4) select',
	status: '.personaldata label:nth-child(5) select',
	mailPersonal:'.personaldata label:nth-child(6) input',
	telefonoFIjo: '.personaldata label:nth-child(7) input',
	telefonoMovil: '.personaldata label:nth-child(8) input',
	direccionPersonal: '.personaldata label:nth-child(9) input',

    adduserAndSendInvitation: '.addpeople fieldset.last .primary',
    addUserWithoutInivitation: 'addpeople fieldset.last .optional',

}


// Me traigo el driver de la  BasePage

class AddUser extends BasePage {
	constructor (webdriver) {
		super(webdriver);
		this.navigationSelectors = navigationSelectors;
		}

	sendName (username) {
 		this.driver.findElement (By.css(navigationSelectors.inputName)).sendKeys(username);
 	}

 	sendLastName (userlastname) {
		this.driver.findElement(By.css(navigationSelectors.inputLastName)).sendKeys(lastname);
 	}

	sendEmail (useremail) {
		this.driver.findElement(By.css(navigationSelectors.inputEmail)).sendKeys(useremail);
 	}/*
	selectRolBasic () {

	Select selectRoldropdown = new Select(this.driver.findElement(By.css(selectRol);
	selectRoldropdown.selectByIndex(2);
		}*/

	createUser (name,lastname,email) {

	this.sendName(name);
	this.sendLastName(lastname);
	this.sendEmail(email);
	//this.selectRolBasic();
	this.goTo('adduserAndSendInvitation');
	return this.driver.wait(until.elementLocated(By.css(addUserWithoutInivitation)),50000);
		}
	}

export default AddUser;
