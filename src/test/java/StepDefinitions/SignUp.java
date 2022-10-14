package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import core.Assertions;
import core.CreateSession;
import helpers.DataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logger.Log;
import pages.SignupPage;

public class SignUp {

	SignupPage signUp;
	WebDriver driver;
	Assertions ass = new Assertions(driver);
	DataGenerator dataGen = new DataGenerator();
	String username;
	String email;

	public SignUp() throws IOException {
		driver = CreateSession.getWebDriver();
		signUp = new SignupPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("generate random username and email")
	public void generate_Username_Email() {
		username = dataGen.getRandomUsername();
		email = dataGen.getRandomUserEmail();
	}

	@When("^I will click on sign up link$")
	public void I_will_click_on_sign_up_link() {
		signUp.findElement(signUp.signupLink).click();
	}

	@And("^I will verify sign up page displayed$")
	public void I_will_verify_sign_up_page_displayed() {
		ass.verifyTrue(signUp.findElement(signUp.signupHeader).isDisplayed(), "Verify sign up header", true, false);
	}

	@When("^I will enter Username, Email, Password and click on sign up$")
	public void userSignup() {
		Log.info("Generated username: " + username);
		Log.info("Generated email: " + email);

		signUp.findElement(signUp.username).sendKeys(username);
		signUp.findElement(signUp.email).sendKeys(email);
		signUp.findElement(signUp.password).sendKeys("test1234");
		signUp.findElement(signUp.signupButton).click();
		signUp.wait(5000);
	}

	@Then("I will verify sign up successful")
	public void I_will_verify_sign_up_success() {
		String signInUser = signUp.findElement(signUp.signInUser).getText().trim();
		ass.verifyEquals(signInUser, username, "Signup failed", true, false);
	}

	@Given("user is logged in?")
	public void user_is_logged_in() {
		try {
			boolean userTrue = signUp.findElement(signUp.signInUser).isDisplayed();
			if (userTrue) {
				Log.info("Skipping the rest of the steps in scenario execution");
				throw new SkipException("Skipping the rest of the steps in scenario execution");
			}
			
		} catch (Exception e) {
			
		}
	}
}
