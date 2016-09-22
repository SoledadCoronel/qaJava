export default {
	goButtonLogin: '.signup .primary',
	inputEmail: '.signup fieldset label:nth-child(2) input',
	inputPasswordLogin:'.signup fieldset label:nth-child(3) input',
	inputSubdomain:'.signup fieldset label:nth-child(4) input',

	strUsername: 'marina.touceda@gointegro.com',
	strPassword: 'Auto1234',


	/*

	forgotPasswordLinkCss= ".signup fieldset label:nth-child(5) .link ";
	protected String inputmailForgotPasswordCss=".signup fieldset label input";
	protected String inputSubdomainForgotPasswordCss=".signup fieldset label:nth-child(2) input";
	protected String enviarForgotPasswordCss=".primary+";
	protected String emailNotRegisteredCss= ".signup fieldset .reject";
	protected String emailFormatcss=".signup fieldset .reject strong";
	protected String logocss="fieldset legend";

	*/





	//Set user name in textbox

	setUserName (driver, strUserName) {
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(strUserName);
	},



     //Set password in password textbox

     public void setPassword(String strPassword){


    	// wait.until(ExpectedConditions.elementToBeClickable(By.tagName("BUTTON")));
    	 driver.findElement(password).clear();
    	 driver.findElement(password).sendKeys(strPassword);

     }

     //Get the title of Login Page

     public String getLoginTitle(){

      return    driver.findElement(title).getText();

     }

     //Click on login button and wait until enter the Home Page

     public void clickLogin(){

             driver.findElement(go).click();

             WebDriverWait wait = new WebDriverWait(driver, 20);


             wait.until(ExpectedConditions.elementToBeClickable(By.tagName("h1")));

             WebElement title = driver.findElement(By.tagName("h1"));
             assertEquals("Actividad social", title.getText());

     }


     /**

      * This POM method will be exposed in test case to login in the application

      * @param strUserName

      * @param strPasword

      * @return

      */


     public void loginToGo(String strUserName,String strPasword){

         //Fill user name
    	 //Wait until the page is loaded

    	 WebDriverWait wait = new WebDriverWait(driver, 20);

         wait.until(ExpectedConditions.elementToBeClickable(By.tagName("BUTTON")));

         this.setUserName(strUserName);


         //Fill password

         this.setPassword(strPasword);

         //Click Login button

         this.clickLogin();

     }

         public void loginToGoAsAdmin(String strsubdomain) throws InterruptedException{

             //Fill user name
        	 this.setUserName(strUsername);


             //Fill password

             this.setPassword(strPassword);

             //Click Login button

             //Fill in Domain
             Thread.sleep(3000);

             this.insertSubdomainLogin(strsubdomain);

              //Click Login button

             this.clickLogin();


     }



         public void loginToGoAsAdminEspacios(String strsubdomain) throws InterruptedException{


             //Fill user name
        	 this.setUserName(strUsernameAdminEspacios);


             //Fill password

             this.setPassword(strPassword);

             //Fill in Domain
            Thread.sleep(3000);

            this.insertSubdomainLogin(strsubdomain);

             //Click Login button

             this.clickLogin();

         }

         public void loginToGoAsUSerBasic(){
          	  // Wait until the page is loaded



             //Fill user name
        	 this.setUserName(strUsernameUserBasic);


             //Fill password

             this.setPassword(strPassword);

             //Click Login button

             this.clickLogin();

         }

         public void insertSubdomainLogin(String strdomain) {
    		 driver.findElement(inputSubdomain).sendKeys(strdomain);

    		}
        public void goToForgotPassword(){
        	driver.findElement(forgotPasswordLink).click();
        	WebDriverWait wait = new WebDriverWait(driver, 20);

             wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inputmailForgotPasswordCss)));
        }

        public void pressSendForgotPassword(){
        	driver.findElement(enviarForgotPassword).click();
        }
        public void insertEmailForgotPassword(String stremail){
        	driver.findElement(inputmailForgotPassword).clear();
        	driver.findElement(inputmailForgotPassword).sendKeys(stremail);
        }

        public void validateErrorEmail(){
        	Assert.assertEquals(driver.findElement(emailNotRegistered).getText(),"El email ingresado no se encuentra registrado. Por favor vuelve a intentarlo");
        }

        public void validateFormatEmail(){
        	System.out.println(driver.findElement(emailFormat).getText());
        }

		public void insertSubdomainForgotPassword(String strdomain) {
		 driver.findElement(inputSubdomainForgotPassword).sendKeys(strdomain);

		}

        public void clickearLogo(){
        	driver.findElement(logo).click();
        }

    }





}
