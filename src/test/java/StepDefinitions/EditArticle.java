package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import core.Assertions;
import core.CreateSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import logger.Log;
import pages.EditArticlePage;

public class EditArticle {
	
	EditArticlePage editPost;
	WebDriver driver;
	Assertions ass = new Assertions(driver);

	public EditArticle() throws IOException {
		driver = CreateSession.getWebDriver();
		editPost = new EditArticlePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@And("I will verify posts are there")
	public void verifyPostsAreThere() {
		try {
			List<WebElement> allPosts = editPost.findElements(editPost.postHeaders);
			if (allPosts.size() < 1 ) {
				Log.info("Skipping the rest of the steps in scenario execution");
				throw new SkipException("Skipping the rest of the steps in scenario execution");
			}else {
				for (WebElement webElement : allPosts) {
					Log.info(webElement.getText());
				}
			}
		}catch(Exception e) {
			
		}
	}
	
	@Then("I will click on first article")
	public void I_will_click_on_first_article() {
		List<WebElement> allPosts = editPost.findElements(editPost.postHeaders);
		allPosts.get(0).click();
	}
	
	@And("I will verify post details displayed")
	public void I_will_verify_post_displayed() {
		boolean postHeader = editPost.findElement(editPost.postHeaders).isDisplayed();
		editPost.verifyTrue(postHeader, "Post header not displayed", true, false);
	}
	
	@Then("I will click on edit article button")
	public void I_will_click_edit_post() {
		editPost.findElement(editPost.editPost).click();
	}
}
