import BasePage from './BasePage';
import {By, until} from 'selenium-webdriver';
//Css
const navigationSelectors = {
	//Css
	addUser: '.adduser',
	invitations: '.title menu li:nth-child(2) a',
	users: '.open .admin li:first-child',
	usersList:'tables admin'
	invitationsList: '.tables',
	searchButton: '.btnsearch',
	inputSearch: '.search input',
	orderByName: 'thead tr th:nth-child(1) a',
	firstRow: 'tbody tr:nth-child(1) td:nth-child(2)',
	secondRow: 'tbody tr:nth-child(2) td:nth-child(2)',

	}

	const pagesToWait = {
	users: true,
	invitations: true,
}


// Iniit the page with driver and selectors

class ManageUsers extends BasePage {
	constructor (webdriver) {
		super(webdriver);
		this.navigationSelectors = navigationSelectors;
	}

		}

}

export default ManageUsers;



