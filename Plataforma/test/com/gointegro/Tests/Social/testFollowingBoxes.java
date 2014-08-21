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
import com.gointegro.Helpers.ConfigElementsFollowers;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Profile.OtherProfile;
import com.gointegro.Pages.Profile.OtherProfileFollow;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Util.WaitTool;

public class testFollowingBoxes extends AllTests {
	
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
	public void test_following_box() {
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(profile.searchfollowing(ConfigElementsFollowers.getFollower2name()));
	}
	
	@Test
	public void test_follower_box() {
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower2(), ConfigElementsFollowers.getFollower2pwd());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(profile.searchfollowers(ConfigElementsFollowers.getFollower1name()));
	}
	
	@Test
	public void test_follow_button_unfollow() {
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElementsFollowers.getFollower1(), ConfigElementsFollowers.getFollower1pwd());
		OtherProfileFollow otherprofilefollow = PageFactory.initElements(driver, OtherProfileFollow.class);
		otherprofilefollow.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(otherprofilefollow.isPresentUnfollowBtn());
	}
	
	@Test
	public void test_follow_button_follow() {
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprofile = PageFactory.initElements(driver, OtherProfile.class);
		otherprofile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(otherprofile.isFollowBtnPresent());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
