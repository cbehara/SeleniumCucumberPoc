package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.Assertions;
import core.CreateSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class Home {

	HomePage home;
	WebDriver driver;
	Assertions ass = new Assertions(driver);

	public Home() throws IOException {
		driver = CreateSession.getWebDriver();
		home = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("User is on Conduit app")
	public void user_is_on_conduit_app() {
		home.get("http://angular.realworld.io/");
	}

	@And("I will verify conduit title")
	public void verify_conduit_title() {
		ass.verifyEquals(home.findElement(home.conduitTitle).getText(),
				"A place to share your Angular knowledge.", "Title Verification", true, false);
	}

	@When("I go to Global Feed section")
	public void goto_globalfeed() {
		home.findElement(home.globalFeed).click();
		home.wait(2000);
	}

	@And("I will verify articles are displayed")
	public void article_displayed() {
		List<WebElement> articles = home.findElements(home.articleHeaders);
		if (articles.size() > 0) {
			ass.verifyTrue(true, "Articles are displayed", true, false);
		} else {
			ass.screenShot("Articles are not displayed");
		}

	}

	@Then("I will display articles in console")
	public void articles_in_console() {
		List<WebElement> articleHeader = home.findElements(home.articleHeaders);
		List<WebElement> articleText = home.findElements(home.articleText);
		System.out.println("+++++++++++++++++++++++++++++");
		for (int i = 0; i < articleHeader.size(); i++) {
			System.out.println(articleHeader.get(i).getText());
			System.out.println(articleText.get(i).getText());
		}
		System.out.println("+++++++++++++++++++++++++++++");
	}

	@And("I will verify tags section displayed")
	public void verify_tags_section_displayed() {
		ass.verifyTrue(home.findElement(home.tagsSection).isDisplayed(), "Tags Section", true, false);
	}

	@Then("^I will verify \"(.*)\" in tags section$")
	public void verify_popular_tags(String popularTag) {
		List<WebElement> tagElements = home.findElements(home.popularTags);
		for (WebElement webElement : tagElements) {
			String tagName = webElement.getText();
			if (tagName.equalsIgnoreCase(popularTag)) {
				ass.verifyEquals(tagName, popularTag, "Tags verification", true, false);
			}
		}
	}

	@And("I will click on sign in link")
	public void I_will_click_on_signin_link() {
		home.findElement(home.signInLink).click();
	}
	
	@Given("I will click on user pic")
	public void I_will_click_on_user_pic() {
		home.findElement(home.userprofilePic).click();
	}
	
	@And("I will verify user logged out")
	public void I_will_verify_user_logged_out() {
		ass.verifyEquals(home.findElement(home.conduitTitle).getText(),
				"A place to share your Angular knowledge.", "User didn't logged out", true, false);
	}
}
