package go5.pageObjects;

import go5.automation.SetUp;

import java.io.File;
import java.security.SecureRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class MuroSocialPage extends SetUp {

	// Css

	// Generics
	protected String publicarContenidoCss = "fieldset .primary";
	protected String iconcss = ".icon";
	protected String date = ".posttex :nth-child(n) p time";
	protected String irAActividadSocialcss = ".content menu li:first-child a";
	protected String irAMiembroscss = ".content menu li:nth-child(2) a";

	// postear, comentar, responder
	protected String goToEscribaAquiCss = ".postbox fieldset:nth-child(1) label:nth-child(4) div";
	protected String textAreaPostcss = ".postbox fieldset:nth-child(1) label:nth-child(4) div"; // .at
	protected String textAreaPostViejo = ".posttext:nth-child(n) fieldset textarea";
	protected String textofirstPostcss = ".posttext:nth-child(3) div:nth-child(2) p";
	protected String timefirstPostcss = ".posttext:nth-child(3) .socials p time";

	protected String commentFirstPostcss = ".posttext:nth-child(3) .actions .igocomments";
	protected String commentInputcss = ".posttext:nth-child(3) .commentsform fieldset div";
	protected String arbirResponderCommentFirstPstscss = ".posttext:nth-child(3) .commentsitem .socials a:nth-child(3) ";
	protected String reponderCommentFirstPostcss = ".posttext:nth-child(3) .commentsitem .commentsform fieldset div";
	protected String showMoreCommentscss = ".link showmore";

	//Eliminar post
	
	protected String goToEliminarPostCss=".posttext:nth-child(3) .btnoptions";
	protected String eliminarPostCss=".posttext:nth-child(3) .active li:first-child a";
	
	// Likes

	protected String likeFirstPostcss = ".posttext:nth-child(2) .socials .link:first-child";
	protected String likeFirstCommentcss = ".posttext:nth-child(3) .commentsitem .igolike";
	protected String likeReponseCommentcss = ".posttext:nth-child(3) .commentsreplay .socials .igolike ";
	protected String desplegarLikescss = ".posttext:nth-child(3) .socials:nth-child(3) p a:nth-child(2)";
	protected String countsLikesFirstPostcss = ".posttext:nth-child(3) .socials p a";
	protected String countsLikesCommentFirstPostcss = ".posttext:nth-child(3) .commentsitem .socials a:nth-child(4)";
	protected String countsLikesResponseCommentFirstPostcss = ".posttext:nth-child(3) .commentsreplay .socials a:nth-child(3)";

	// profiles
	protected String irAMuroEnPerfilcss = ".content menu li:first-child a";
	protected String irAlPerfilPost = ".posttext:nth-child(3) h2 a";
	protected String irAlPerfilWindowAsidecss = ".likes li:first-child a:first-child";

	// links
	protected String linkPostcss = ".igolink";
	protected String linkInputFieldCss = ".url input";
	protected String linkVerMascss = ".posttext:nth-child(3) div:nth-child(2) .link";

	// attachments
	
	protected String openloadFileCss = ".igoattach";
	protected String loadFilePart1Css = ".actions input" + "[id$="+ "'filePicker'" + "]";
	protected String loadPictureCss=".actions input" + "[id$=" + "'imagePicker'" + "]";
	protected String loadFilePart2Css = "filePicker";
	protected String cameraOrPicturePostcss = ".igocamerawhite";
	protected String cameracss = ".igocamera";
	protected String subirFotocss = ".postbox .menuoptions label:last-child";
	protected String abrirModalAdjuntarArchivocss = ".igoattach";

	// Others
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	// By
	// Generics
	By publicarContenido = By.cssSelector(publicarContenidoCss);
	By icon = By.cssSelector(iconcss);
	By timePost = By.cssSelector(timefirstPostcss);
	By irAActividadSocial = By.cssSelector(irAActividadSocialcss);
	By irAMiembros = By.cssSelector(irAMiembroscss);

	// postear, comentar, responder
	By goToEscribaAqui = By.cssSelector(goToEscribaAquiCss);
	By textPost = By.cssSelector(textAreaPostcss);
	By textPosteado = By.cssSelector(textofirstPostcss);
	By commentFirstPost = By.cssSelector(commentFirstPostcss);
	By comment = By.cssSelector(commentInputcss);
	By responseCommentFirstPost = By.cssSelector(reponderCommentFirstPostcss);
	By abrirReponderComment = By.cssSelector(arbirResponderCommentFirstPstscss);

	//Eliminar post
	
	By goToEliminarPost=By.cssSelector(goToEliminarPostCss);
	By eliminarPost=By.cssSelector(eliminarPostCss);
	
	// Likes
	By like = By.cssSelector(likeFirstPostcss);
	By desplegarLikes = By.cssSelector(desplegarLikescss);
	By countLikes = By.cssSelector(countsLikesFirstPostcss);
	By countLikesComment = By.cssSelector(countsLikesCommentFirstPostcss);
	By countLikesResponseComment = By
			.cssSelector(countsLikesResponseCommentFirstPostcss);
	By likeComment = By.cssSelector(likeFirstCommentcss);
	By likeResponseComment = By.cssSelector(likeReponseCommentcss);

	// profiles
	By irAMuroEnPerfil = By.cssSelector(irAMuroEnPerfilcss);
	By irAlPerfilWindowAside = By.cssSelector(irAlPerfilWindowAsidecss);

	// links
	By link = By.cssSelector(linkPostcss);
	By inputLink = By.cssSelector(linkInputFieldCss);
	By linkVerMas = By.cssSelector(linkVerMascss);

	// attachments

	By openloadFile = By.cssSelector(openloadFileCss);
	By loadFile = By.cssSelector(loadFilePart1Css);
	By loadPicture=By.cssSelector(loadPictureCss);
	By selectCameraOrPicture = By.cssSelector(cameraOrPicturePostcss);
	By subirFoto = By.cssSelector(subirFotocss);

	static SecureRandom rnd = new SecureRandom();

	// Objects

	WebDriver driver;

	// Inits

	public MuroSocialPage(WebDriver driver) {

		this.driver = driver;
	}

	// Generics

	private String setcssPost(Integer p) {
		// Buscar un post viejo
		String css = ".posttext :nth-child" + "(" + (p) + ")";
		return css;
	}

	public void goToPost(Integer pagina) {

		String css = this.setcssPost(pagina);
		driver.findElement(By.cssSelector(css)).click();
	}

	public void verifyLinkVerMas() {
		Reporter.log("Verificar el link VerMas");
		driver.findElement(linkVerMas).click();
	}

	public void verifyLinkVerMenos() {
		Reporter.log("Verificar el link VerMenos");
		driver.findElement(linkVerMas).click();
	}

	public String getTextFirstPost() {
		return driver.findElement(textPosteado).getText();

	}

	public String getTimeFirstPost() {
		return driver.findElement(timePost).getText();
	}

	public void goThroughPosts(Integer numberPosts) {
		for (int i = 0; i < numberPosts; i++) {
			this.goToPost(i);
		}
	}

	public String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();

	}

	public void irAActividadSocial() {
		Reporter.log("Clickeando Actividad Social");
		driver.findElement(irAActividadSocial).click();
	}

	public void irAMiembros() {
		driver.findElement(irAMiembros).click();
	}

	// Likes

	public void likearPost() {
		Reporter.log("Likear el primer post");
		driver.findElement(like).click();
	}

	public void likearComment() {
		Reporter.log("Likear el comment");
		driver.findElement(likeComment).click();

	}

	public void likearResponseComment() {
		Reporter.log("Likear el response del comment");
		driver.findElement(likeResponseComment).click();

	}

	public String countLikesPost() {
		return driver.findElement(countLikes).getText();
	}

	public String countLikesComments() {
		return driver.findElement(countLikesComment).getText();
	}

	public String countLikesResponseComment() {
		return driver.findElement(countLikesResponseComment).getText();
	}

	public void desplegarLikesWindowAside() {
		Reporter.log("Deplegar el window aside de los likes");
		driver.findElement(desplegarLikes).click();
	}

	// Ir a profiles

	public void goToProfilePost() {
		Reporter.log("Ir al perfil del posteador");
		driver.findElement(By.cssSelector(irAlPerfilPost)).click();
	}

	public void irAFirstProfileWindowAside() {
		driver.findElement(irAlPerfilWindowAside);
	}

	public void irAMuroEnPerfil() {
		driver.findElement(irAMuroEnPerfil).click();
	}

	// Postear,Comentar, Responder

	// Set a string in a posttext

	public void postTexto(String strTextPost) {

		Reporter.log("Ingresar un texto en el postbox");
		driver.findElement(textPost).clear();
		driver.findElement(textPost).click();
		driver.findElement(textPost).sendKeys(strTextPost);

	}

	public void postear() throws InterruptedException {

		Reporter.log("CLikeo publicar");
		driver.findElement(publicarContenido).click();
		Thread.sleep(3000);
	}

	public void postFile() throws InterruptedException {
		
		js = (JavascriptExecutor) driver;
		Reporter.log("Me posiciono en el text area para luego subir un file");
		driver.findElement(textPost).click();		
		Thread.sleep(3000);
		Reporter.log("Postear un file");
		// function to make visible the button logoFilePicker, as it is set to
		// class "off"		
		WebElement element = driver.findElement(loadFile);
		js.executeScript("arguments[0].setAttribute('style', 'display:block')",
				element);
		// Agarrar el elemento para cargar el file y pasarle el path
		WebElement upload = driver.findElement(loadFile);
		File file = new File("src/test/resources/Girasol.jpeg");
		Reporter.log(file.getAbsolutePath());
		upload.sendKeys(file.getAbsolutePath());

	}
	
	

	public void responderComment(String strResponseComment) {
		// Clickear Reponder
		Reporter.log("Clickeo en Responder del comment e ingreso un texto de respuesta");
		driver.findElement(abrirReponderComment).click();
		driver.findElement(responseCommentFirstPost).sendKeys(
				strResponseComment);
		driver.findElement(comment).sendKeys(Keys.ENTER);

	}

	public void comentarFIrstPost(String strCommentPost) {
		Reporter.log("Comentar en el primer post");
		driver.findElement(commentFirstPost).click();
		driver.findElement(comment).sendKeys(strCommentPost);
		driver.findElement(comment).sendKeys(Keys.ENTER);
	}

	public void postLink(String strlink) {
		Reporter.log("Posteo un link");
		driver.findElement(link).click();
		driver.findElement(inputLink).sendKeys(strlink);
		driver.findElement(inputLink).sendKeys(Keys.ENTER);
	}

	public void postPicture() throws InterruptedException {

		js = (JavascriptExecutor) driver;

		// driver.findElement(selectCameraOrPicture).click();
		Reporter.log("Ingresar un texto en el postbox");
		driver.findElement(textPost).clear();
		driver.findElement(textPost).click();
		Thread.sleep(3000);

		WebElement element = driver.findElement(loadPicture);
		js.executeScript("arguments[0].setAttribute('style', 'display:block')",
				element);

		// Agarrar el elemento para cargar el file y pasarle el path

		WebElement subirFile = driver.findElement(loadPicture);

		File file = new File("src/test/resources/Girasol.jpeg");
		subirFile.sendKeys(file.getAbsolutePath());

		Reporter.log(" Foto cargada exitosamente");
	}

	public void eliminarPost() {
		driver.findElement(goToEliminarPost).click();
		driver.findElement(eliminarPost).click();
	}
	
}
