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
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testMentionsComment {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_mention_comment_en_social_wall() {
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
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+commentpost, comment.getTextComment());
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		profile = feeds.selectMentionInComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
	}
	
	@Test
	public void test_mention_comment_en_social_app() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appSocial = PageFactory.initElements(driver, AppSocial.class);
		appSocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+commentpost, comment.getTextComment());
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		profile = feeds.selectMentionInComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
	}
	
	@Test
	public void test_mention_comment_en_mi_perfil() {
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
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+commentpost, comment.getTextComment());
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		profile = feeds.selectMentionInComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
	}
	
	@Test
	public void test_mention_comment_en_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprofile = PageFactory.initElements(driver, OtherProfile.class);
		otherprofile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		assertEquals("@"+ConfigElements.getNameOtherUser()+" "+commentpost, comment.getTextComment());
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		profile = feeds.selectMentionInComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(ConfigElements.getNameOtherUser(), profile.getUserName());
	}
	
	private Comment createComment(String commentpost) {
		Comment comment = PageFactory.initElements(driver, Comment.class);
		comment.completCommentMention(commentpost, ConfigElements.getNameOtherUser());
		return comment;
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
