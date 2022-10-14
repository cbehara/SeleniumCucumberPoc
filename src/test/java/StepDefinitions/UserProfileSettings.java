package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import core.Assertions;
import core.CreateSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.UserProfileSettingsPage;

public class UserProfileSettings {
	
	UserProfileSettingsPage userProfileSettings;
	WebDriver driver;
	Assertions ass = new Assertions(driver);

	public UserProfileSettings() throws IOException {
		driver = CreateSession.getWebDriver();
		userProfileSettings  = new UserProfileSettingsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@And("I will verify user settings page displayed")
	public void I_will_verify_user_settings_page_displayed() {
		boolean userSettingHead = userProfileSettings.findElement
										(userProfileSettings.userSettingsHeader).isDisplayed();
		ass.verifyTrue(userSettingHead, "User Settings didn't display", true, false);
	}
	
	@Then("I will click on logout button")
	public void I_will_click_on_logout_button() {
		userProfileSettings.findElement(userProfileSettings.userLogoutButton).click();
	}
	
}
