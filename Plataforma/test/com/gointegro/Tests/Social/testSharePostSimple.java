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
import com.gointegro.Pages.Profile.OtherProfile;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.DetailPost;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SharePost;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testSharePostSimple {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_share_post_propio_social_wall() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();
		
		assertEquals(textopost, sharepost.getSharedText());
		
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		assertEquals(textopost, feeds.getContentPreview());
	}
	
	@Test
	public void test_share_post_propio_social_app() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appsocial = PageFactory.initElements(driver, AppSocial.class);
		appsocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();

		assertEquals(textopost, sharepost.getSharedText());
		
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		assertEquals(textopost, feeds.getContentPreview());
	}
	
	@Test
	public void test_share_post_propio_en_otro_muro() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprof = PageFactory.initElements(driver, OtherProfile.class);
		otherprof.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();

		assertEquals(textopost, sharepost.getSharedText());
		
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		assertEquals(textopost, feeds.getContentPreview());
	}
	
	@Test
	public void test_share_post_propio_detalle() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		DetailPost detailpost = feeds.selectSuPublicacion();
		
		assertEquals("Detalle de la publicación", detailpost.getTitle());
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_share_post_propio_eliminar() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();
		sharepost.completeShare(textoshare);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		feeds.deletePost();
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(textoshare, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		assertNotEquals(textopost, feeds.getContentPreview());
	}
	
	@Test
	public void test_share_post_ajeno() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió la publicación de "+ConfigElements.getNameOtherUser()+"\n"+textoshare, feeds.getPublicoEn());
		assertEquals(textopost, feeds.getContentPreview());
	}
	
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
