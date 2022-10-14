package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import core.Assertions;
import core.CreateSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.UserPostsPage;

public class UserPosts {
	
	UserPostsPage userPosts;
	WebDriver driver;
	Assertions ass = new Assertions(driver);
	
	public UserPosts() throws IOException {
		driver = CreateSession.getWebDriver();
		userPosts = new UserPostsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@And("I will verify user posts page displayed")
	public void I_will_verify_user_posts_page_displayed() {
		boolean userHeader = userPosts.findElement(userPosts.userProfileHeader).isDisplayed();
		ass.verifyTrue(userHeader, "User Profile didn't display", true, false);
	}
	
	@When("I will click on edit profile settings button")
	public void I_will_click_on_edit_profile_settings_button() {
		userPosts.findElement(userPosts.userSettingsButton).click();
	}
}
