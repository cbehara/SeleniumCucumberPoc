package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

public class EditArticlePage extends TestBase {

	public EditArticlePage(WebDriver driver) throws IOException {
		super(driver);
	}

	public By postHeaders = By.xpath("//h1");
	public By editPost = By.xpath("(//a[text()=' Edit Article '])[1]");
	
}
