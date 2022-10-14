package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

/**
 * class to interact with page
 * 
 * @author shanky
 *
 *         This class has web elements of homepage which are used by
 *         HomePageHelper
 */
public class GoogleSearchPage extends TestBase {

	public GoogleSearchPage(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By searchbox = By.name("q");
	public By searchButton = By.xpath("(//input[@value='Google Search'])[2]");
	public By searchResults = By.xpath("//h3");
	public By imagesButton = By.xpath("//a[text()='Images']");
	public By imageContainer = By.id("islmp");

}
