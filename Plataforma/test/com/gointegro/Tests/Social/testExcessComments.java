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
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testExcessComments {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_excess_comments() {
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
		
		Comment comment = PageFactory.initElements(driver, Comment.class);
		
		for(int x=1;x<10;x++) {
			comment.completeComment(commentpost+" "+x);
			WaitTool.waitForJQueryProcessing(driver, 3);
		}
		
		social.open();
		
		assertTrue(comment.isDisplayedExcessComments());
		
		comment.selectExcessComments();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		for (int x=1; x<10; x++) {
			assertTrue(comment.getfeedComments().contains(commentpost+" "+x));
		}
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
