package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import core.Assertions;
import core.CreateSession;
import helpers.DataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NewArticlePage;

public class NewArticle {

	NewArticlePage newArticle;
	WebDriver driver;
	Assertions ass = new Assertions(driver);
	DataGenerator dataGen = new DataGenerator();
	String articleName;

	public NewArticle() throws IOException {
		driver = CreateSession.getWebDriver();
		newArticle = new NewArticlePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("generate random article title")
	public void generate_ArticleTitle() {
		articleName = dataGen.getArticleTitle();
		
	}

	@When("^user enters \"(.*)\", \"(.*)\", \"(.*)\" and publish$")
	public void fillNewArticleDetails(String about, String body, String tags) {
		if (articleName == null) {
			articleName = dataGen.getArticleTitle();
		}
		newArticle.findElement(newArticle.articleTitle).clear();
		newArticle.findElement(newArticle.articleTitle).sendKeys(articleName);
		
		newArticle.findElement(newArticle.articleAbout).clear();
		newArticle.findElement(newArticle.articleAbout).sendKeys(about);
		
		newArticle.findElement(newArticle.article).clear();
		newArticle.findElement(newArticle.article).sendKeys(body);
		
		newArticle.findElement(newArticle.articleTags).clear();
		newArticle.findElement(newArticle.articleTags).sendKeys(tags);
		
		newArticle.findElement(newArticle.publishArticleButton).click();
		newArticle.wait(2000);
	}

	@Then("^I will verify article published successfully$")
	public void verifyArticlePublished() {
		String actualTitle = newArticle.findElement(newArticle.articleHeader).getText();
		ass.verifyEquals(actualTitle, articleName, "Article didn't published", true, false);
	}

	@And("^I will verify new article page displayed$")
	public void verifyNewArticlePageDisplayed() {
		boolean titleDisplayed = newArticle.findElement(newArticle.articleTitle).isDisplayed();
		ass.verifyTrue(titleDisplayed, "New Article page didn't display", true, false);
	}
	
	@And("^I will verify article displayed in Global Feed$")
	public void verifyArticleDisplayedInGlobalFeed() {
		newArticle.findElement(newArticle.homeLink).click();
		newArticle.wait(2000);
		newArticle.findElement(newArticle.globalFeed).click();
		newArticle.wait(3000);
		String artTitle = newArticle.findElement(newArticle.publishedArticleHeader).getText();
		ass.verifyEquals(artTitle, articleName, "Published article not displayed", true, false);
	}
}
