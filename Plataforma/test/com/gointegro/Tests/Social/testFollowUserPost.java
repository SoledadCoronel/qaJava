package com.gointegro.Tests.Social;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsFollowers;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.OtherProfileFollow;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testFollowUserPost {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_follow_post_social_wall() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElementsFollowers.getFollower2name()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_follow_post_social_app() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		AppSocial appsocial = PageFactory.initElements(driver, AppSocial.class);
		appsocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElementsFollowers.getFollower2name()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_follow_post_profile() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		OtherProfileFollow oprofile = PageFactory.initElements(driver, OtherProfileFollow.class);
		oprofile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElementsFollowers.getFollower2name()+" publicó en su muro\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_follow_post_imagen() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFileImagen(textopost, ConfigElements.getFileImagen());
		WaitTool.setImplicitWait(driver, 3);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElementsFollowers.getFollower2name()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
	}
	
	@Test
	public void test_follow_post_file() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
				
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElementsFollowers.getFollower2name()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
	}
	
	@Test
	public void test_follow_post_vinculo() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostLink(ConfigElements.getUrlTest(), textopost);
		WaitTool.setImplicitWait(driver, 3);
		post.waitForLinkLoad();
		post.submitPostLink();
		
		WaitTool.setImplicitWait(driver, 3);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElementsFollowers.getFollower2name()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(ConfigElements.getUrlTest(), feeds.getURLFeed());
	}
	
	@Test
	public void test_follow_post_extenso() {
		String textopost = DataGenerator.horaactual()+StringUtils.getTextoLargo();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(textopost.contains(feeds.getTextVerMas()));
		feeds.selectViewMore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(textopost+"\nVer menos", feeds.getFeedContent());
		feeds.selectViewLess();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(textopost.contains(feeds.getTextVerMas()));
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
