package com.gointegro.Tests.Social;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.OtherProfile;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testCommentEliminar {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_eliminar_comentario_social_wall() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		comment.deleteCommment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(commentpost, comment.getTextComment());
		
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertFalse(feeds.getPublicoEn().contains(ConfigElements.getNombreUsuario()+" comentó la publicación de "+ConfigElements.getNombreUsuario()));
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertNotEquals(commentpost, comment.getTextComment());
	}
	
	@Test
	public void test_eliminar_comentario_app_social () {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appsocial = PageFactory.initElements(driver, AppSocial.class);
		appsocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		comment.deleteCommment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(commentpost, comment.getTextComment());
		
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertFalse(feeds.getPublicoEn().contains(ConfigElements.getNombreUsuario()+" comentó la publicación de "+ConfigElements.getNombreUsuario()));
		assertEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertNotEquals(commentpost, comment.getTextComment());
	}
	
	@Test
	public void test_eliminar_comentario_mi_perfil() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		comment.deleteCommment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(commentpost, comment.getTextComment());
	}
	
	@Test
	public void test_eliminar_comentario_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprof = PageFactory.initElements(driver, OtherProfile.class);
		otherprof.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		comment.deleteCommment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(commentpost, comment.getTextComment());
		
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertFalse(feeds.getPublicoEn().contains(ConfigElements.getNombreUsuario()+" comentó la publicación de "+ConfigElements.getNombreUsuario()));
		assertEquals(ConfigElements.getNombreUsuario()+" publicó en el muro de "+ConfigElements.getNameOtherUser()+"\n"+textopost, feeds.getPublicoEn());
		assertNotEquals(commentpost, comment.getTextComment());
	}
	
	private Comment createComment(String commentpost) {
		Comment comment = PageFactory.initElements(driver, Comment.class);
		comment.completeComment(commentpost);
		return comment;
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
