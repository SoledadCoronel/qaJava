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
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testFollowUserLike {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_follow_user_like_post() {
		String textopost = DataGenerator.horaactual();
				
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		
		social.open();
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		feeds.selectLikePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Te gusta esto.", feeds.getLikes());
		
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertNotEquals("A "+ConfigElements.getNombreUsuario()+" le gusta esto.", feeds.getLikes());
	}
	
	@Test
	public void test_follow_user_like_comment() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		comment.selectLikeComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Ya no me gusta", comment.getTextLikeComment());
		
		logout.open();
		
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 10);		
		
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
