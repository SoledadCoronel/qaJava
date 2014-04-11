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
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testMentionsPostSimple {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	
	@Test
	public void test_mention_en_social_wall() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostMention(textopost, ConfigElements.getNameOtherUser());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		Profile profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		assertNotEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5); 
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_mention_en_app_social() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appSocial = PageFactory.initElements(driver, AppSocial.class);
		appSocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostMention(textopost, ConfigElements.getNameOtherUser());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		Profile profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		assertNotEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Mention_en_mi_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostMention(textopost, ConfigElements.getNameOtherUser());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_mention_en_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherProfile = PageFactory.initElements(driver, OtherProfile.class);
		otherProfile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostMention(textopost, ConfigElements.getNameOtherUser());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
		Profile profile = feeds.selectMentionSocialFeed();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNombreUsuario()+" publicó en el muro de "+ConfigElements.getNameOtherUser()+"\n"+"@"+ConfigElements.getNameOtherUser()+" "+textopost, feeds.getPublicoEn());
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
