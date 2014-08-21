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
import com.gointegro.Pages.Platform.MyProfileOtherViewer;
import com.gointegro.Pages.Profile.OtherProfile;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.ExcessLikers;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testLikePost extends AllTests {
	
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

	@Test
	public void test_Like_post_social_wall() {
		String textopost = DataGenerator.horaactual();
		
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
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_social_app() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appsocial = PageFactory.initElements(driver, AppSocial.class);
		appsocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		appsocial.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_en_mi_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		MyProfileOtherViewer otherprofileview = PageFactory.initElements(driver, MyProfileOtherViewer.class);
		otherprofileview.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_en_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprofile = PageFactory.initElements(driver, OtherProfile.class);
		otherprofile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		otherprofile.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_vinculo() {
		String textopost = DataGenerator.horaactual();
		
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_imagen() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFileImagen(textopost, ConfigElements.getFileImagen());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_file() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_extenso() {
		String textopost = DataGenerator.horaactual()+StringUtils.getTextoLargo();
		
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
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_with_likes() {
		String textopost = DataGenerator.horaactual();
		
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
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+", y a vos les gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_Like_post_link_name() {
		String textopost = DataGenerator.horaactual();
		
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
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		feeds.selectLikeUser();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		assertEquals(ConfigElements.getNombreUsuario(), profile.getUserName());
	}
	
	@Test
	public void test_Like_post_excess_likers() {
		String textopost = DataGenerator.horaactual();
		
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
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("A "+ConfigElements.getNombreUsuario()+", y a vos les gusta esto.", feeds.getLikes());
		
		logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUser(), ConfigElements.getPassword());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ExcessLikers likers = feeds.selectExcessLikers();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(likers.getColabLikeList().contains(ConfigElements.getNameOtherUser()));
		assertTrue(likers.getColabLikeList().contains(ConfigElements.getotherUserName2()));
		assertTrue(likers.getColabLikeList().contains(ConfigElements.getNombreUsuario()));
		
	}
	
	@Test
	public void test_Like_post_dislike() {
		String textopost = DataGenerator.horaactual();
		
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
		
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		WaitTool.waitForJQueryProcessing(driver, 5);
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("none", feeds.likeDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
