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
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SharePost;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testSharePostEspecial {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_share_post_imagen() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFileImagen(textopost, ConfigElements.getFileImagen());
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();
		
		assertTrue(ConfigElements.getFileImagen().contains(sharepost.getSharedImg()));
		
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getOriginalImg()));
		assertEquals("\""+textopost+"\"", feeds.getOriginalText());
		
	}
	
	@Test
	public void test_share_post_file() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();
		
		
		assertEquals("Descargar "+title, sharepost.getSharedFile());
		
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		assertEquals("Descargar "+title, feeds.getOriginalFile());
		assertEquals("\""+textopost+"\"", feeds.getOriginalText());
	}
	
	@Test
	public void test_share_post_vinculo() {
		String textopost = DataGenerator.horaactual();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostLink(ConfigElements.getUrlTest(), textopost);
		WaitTool.setImplicitWait(driver, 3);
		post.waitForLinkLoad();
		post.submitPostLink();
		
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		SharePost sharepost = feeds.selectShareContent();
		
		sharepost.waitForLinkLoad();
		assertEquals(ConfigElements.getUrlTest(), sharepost.getShareUrl());
		
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		sharepost.waitForLinkLoad();
		assertEquals(ConfigElements.getUrlTest(), feeds.getOriginalUrl());
		assertEquals("\""+textopost+"\"", feeds.getOriginalText());
	}
	
	@Test
	public void test_share_post_extenso() {
		String textopost = DataGenerator.horaactual()+StringUtils.getTextoLargo();
		String textoshare = DataGenerator.horaactual()+" share";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		SharePost sharepost = feeds.selectShareContent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(textopost.contains(sharepost.getTextVerMas()));
		
		sharepost.completeShare(textoshare);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textoshare, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" compartió su publicación\n"+textoshare, feeds.getPublicoEn());
		assertTrue(textopost.contains(feeds.getTextVerMasContentPreview()));		
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
