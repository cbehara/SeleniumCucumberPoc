package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

public class NewArticlePage extends TestBase {

	public NewArticlePage(WebDriver driver) throws IOException {
		super(driver);
	}

	public By signInHeader = By.xpath("//h1");

	public By articleTitle = By.xpath("//input[@placeholder='Article Title']");
	public By articleAbout = By.xpath("//input[@placeholder=\"What's this article about?\"]");
	public By article = By.xpath("//textarea");
	public By articleTags = By.xpath("//input[@placeholder='Enter tags']");
	public By publishArticleButton = By.xpath("//button");

	public By articleHeader = By.xpath("//h1");
	
	public By homeLink = By.xpath("//a[text()=' Home ']");
	public By publishedArticleHeader = By.xpath("(//app-article-list//h1)[1]");

	public By userprofilePic = By.xpath("//img[@class='user-pic']/parent :: a");
	
	public By globalFeed = By.xpath("//a[text()=' Global Feed ']");
}
