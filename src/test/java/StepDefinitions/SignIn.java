package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import core.Assertions;
import core.CreateSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SignInPage;

public class SignIn {

	SignInPage signIn;
	WebDriver driver;
	Assertions ass = new Assertions(driver);

	public SignIn() throws IOException {
		driver = CreateSession.getWebDriver();
		signIn = new SignInPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@And("^I will verify sign in page displayed$")
	public void I_will_verify_signin_page_displayed() {
		ass.verifyTrue(signIn.findElement(signIn.signInHeader).isDisplayed(), "sign in page didn't display", true,
				false);
	}

	@When("^user enters \"(.*)\", \"(.*)\" and clicks on sign in$")
	public void enterSignInDetails(String un, String pwd) {
		signIn.findElement(signIn.signIn_email).sendKeys(un);
		signIn.findElement(signIn.signIn_pwd).sendKeys(pwd);
		signIn.findElement(signIn.signIn_button).click();
	}

	@And("^I will verify user logged in$")
	public void I_will_verify_user_loggedin() {
		ass.verifyEquals(signIn.findElement(signIn.signInUser).isDisplayed(), true, "Signin failed", true, false);
	}

	@Given("User clicks on new article link")
	public void User_clicks_on_new_article_link() {
		signIn.findElement(signIn.newArticleLink).click();
	}

}
