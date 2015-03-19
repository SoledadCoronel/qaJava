package testLogin;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Se instancia cada objeto de cada clase
		//SetSpanishLanguage language = new SetSpanishLanguage();
		LoginOk login = new LoginOk();
		LogoutOk logout = new LogoutOk();
		LoginFailUserWrong failUser = new LoginFailUserWrong();
		LoginFailPwdWrong failPwd = new LoginFailPwdWrong();
		RecoverPwdCancel recoverCancel = new RecoverPwdCancel();
		RecoverPwdClose recoverClose = new RecoverPwdClose();
		RecoverPwdFailInvalidCaptcha recoverCaptcha = new RecoverPwdFailInvalidCaptcha();
		
		
		// Se llaman en suite a cada unos de los métodos para testear todas las acciones de forma consecutiva
		//language.setSpanish();
		login.testLogin();
		logout.testLogout();
		failUser.testLogin();
		failPwd.testLogin();
		recoverCancel.recoverPwd();
		recoverClose.recoverPwd();
		recoverCaptcha.recoverPwd();
	}

}
