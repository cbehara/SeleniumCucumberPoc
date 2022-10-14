package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

public class HomePage extends TestBase {

	public HomePage(WebDriver driver) throws IOException {
		super(driver);
	}

	public By conduitTitle = By.xpath("//h1[text()='conduit']/following-sibling :: p");
	public By globalFeed = By.xpath("//a[text()=' Global Feed ']");
	public By articleHeaders = By.xpath("//div[@class='article-preview']//h1");
	public By articleText = By.xpath("//div[@class='article-preview']//p");
	public By tagsSection = By.xpath("//div[@class='sidebar']");
	public By popularTags = By.xpath("//div[@class='tag-list']/a");

	public By signInLink = By.xpath("//a[text()=' Sign in ']");

	public By homeLink = By.xpath("//a[text()=' Home ']");
	public By publishedArticleHeader = By.xpath("(//app-article-list//h1)[1]");

	public By userprofilePic = By.xpath("//img[@class='user-pic']/parent :: a");

}
