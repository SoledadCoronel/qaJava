package com.gointegro.Tests.Social;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({ 
	//testPostSimple.class, 
	testPostVinculo.class, 
	/*testPostFileNoImagen.class, testPostFileImagen.class, testPostExtenso.class, 
	/*testPostPrivateWorkspace.class,
	testPostEliminar.class,
	testComment.class, testCommentEliminar.class, testCommentExtenso.class,
	testLikePost.class, testLikeComment.class,
	testMentionsPostSimple.class, testMentionsComment.class,
	testHashtagPost.class,
	testHashtagComment.class, //no funciona 30/04 https://gointegro.atlassian.net/browse/PLATAFORMAII-2889
	testPostDetail.class,
	testSharePostSimple.class, testSharePostEspecial.class,
	testFollowUserPost.class, testFollowUserComment.class, testFollowUserLike.class,
	testFollowPost.class,
	testFollowingBoxes.class,
	testExcessComments.class*/
	})
public class AllTests {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		setDriver(new FirefoxDriver());
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTests.driver = driver;
	}
	
	@AfterClass
	 public static void tearDown() {
		driver.quit();
	}

}
