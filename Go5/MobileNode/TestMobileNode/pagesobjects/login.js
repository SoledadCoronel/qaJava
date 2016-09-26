export default {
	goButtonLogin: '.signup .primary',
	inputEmail: '.signup fieldset label:nth-child(2) input',
	inputPasswordLogin:'.signup fieldset label:nth-child(3) input',
	inputSubdomain:'.signup fieldset label:nth-child(4) input',

	strUsername: 'marina.touceda@gointegro.com',
	strPassword: 'Auto1234',
	emailNotRegistered:'.signup fieldset .reject',
	emailFormat:'.signup fieldset .reject strong',
	logo:'fieldset legend',

	//Set user name in textbox

	setUserName (driver, strUserName) {
		driver.findElement(userName).clear();
		return driver.findElement(userName).sendKeys(strUserName);
	},



     //Set password in password textbox

     setPassword(driver, strPassword){
    	 driver.findElement(password).clear();
    	 driver.findElement(password).sendKeys(strPassword);

     }



     //Get the title of Login Page


      getLoginTitle(){

      return  driver.findElement(title).getText();

     }

     //Click on login button and wait until enter the Home Page

	clickLogin(){

	driver.findElement(go).click();




	loginToGo(strUserName,strPasword){

	this.setUserName(strUserName);
	this.setPassword(strPasword);
	this.clickLogin();

     }


	loginToGoAsAdmin( strsubdomain){

	this.setUserName(strUsername);
	this.setPassword(strPassword);
	this.insertSubdomainLogin(strsubdomain);
	this.clickLogin();
     }


	insertSubdomainLogin(strdomain) {
	driver.findElement(inputSubdomain).sendKeys(strdomain);

	}

	goToForgotPassword(){
	driver.findElement(forgotPasswordLink).click();
	}

	pressSendForgotPassword(){
	driver.findElement(enviarForgotPassword).click();
	}

	insertEmailForgotPassword(stremail){
	driver.findElement(inputmailForgotPassword).clear();
	driver.findElement(inputmailForgotPassword).sendKeys(stremail);
	}

	validateErrorEmail(){
	Assert.assertEquals(driver.findElement(emailNotRegistered).getText(),"El email ingresado no se encuentra registrado. Por favor vuelve a intentarlo");
	}

	validateFormatEmail(){
	driver.findElement(emailFormat).getText();
	}

	insertSubdomainForgotPassword(strdomain) {
	driver.findElement(inputSubdomainForgotPassword).sendKeys(strdomain);

	}

	clickLogo(){
	driver.findElement(logo).click();

	}

	}

