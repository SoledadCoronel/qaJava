package com.gointegro.Tests.Social;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Profile.OtherProfile;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testMentionsPostImagen extends AllTests {
	
	private WebDriver driver;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}

	@Test(groups = {"FunctTest"})
	public void test_mention_post_img_en_social_wall() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostImageMention(textopost,  ConfigElements.getNameOtherUser(), ConfigElements.getFileImagen());
		WaitTool.waitForJQueryProcessing(driver, 10);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
		Profile profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		assertNotEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5); 
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_mention_post_img_en_social_app() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appSocial = PageFactory.initElements(driver, AppSocial.class);
		appSocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostImageMention(textopost,  ConfigElements.getNameOtherUser(), ConfigElements.getFileImagen());
		WaitTool.waitForJQueryProcessing(driver, 10);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
		Profile profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		assertNotEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_mention_post_img_mi_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostImageMention(textopost,  ConfigElements.getNameOtherUser(), ConfigElements.getFileImagen());
		WaitTool.waitForJQueryProcessing(driver, 10);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
		profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_mention_post_img_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		OtherProfile otherProfile = PageFactory.initElements(driver, OtherProfile.class);
		otherProfile.open();
		
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostImageMention(textopost,  ConfigElements.getNameOtherUser(), ConfigElements.getFileImagen());
		WaitTool.waitForJQueryProcessing(driver, 10);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
		Profile profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNombreUsuario()+" publicó en el muro de "+ConfigElements.getNameOtherUser()+"\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
