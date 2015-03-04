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
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Pages.Social.ExcessLikers;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testLikeComment extends AllTests {
	
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
	public void test_like_comment_comun() {
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
		
		comment.selectLikeComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Ya no me gusta", comment.getTextLikeComment());
		ExcessLikers likers = comment.selectExcessLikers();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(likers.getColabLikeList().contains(ConfigElements.getNombreUsuario()));
	}
	
	@Test
	public void test_like_comment_extenso() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile()+StringUtils.getTextoLargo();
		
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
		
		comment.selectLikeComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Ya no me gusta", comment.getTextLikeComment());
		ExcessLikers likers = comment.selectExcessLikers();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(likers.getColabLikeList().contains(ConfigElements.getNombreUsuario()));
		
		social.open();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(commentpost.contains(comment.getTextVerMas()));
		comment.selectViewMore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Ya no me gusta", comment.getTextLikeComment());
		comment.selectViewLess();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Ya no me gusta", comment.getTextLikeComment());
		
	}
	
	@Test
	public void test_like_comment_dislike() {
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
		
		comment.selectLikeComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Ya no me gusta", comment.getTextLikeComment());
		comment.selectLikeComment();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals("Me gusta", comment.getTextLikeComment());
		
		assertEquals("none", comment.likecommentisDisplayed());
	}
	
	
	
	private Comment createComment(String commentpost) {
		Comment comment = PageFactory.initElements(driver, Comment.class);
		comment.completeComment(commentpost);
		return comment;
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
