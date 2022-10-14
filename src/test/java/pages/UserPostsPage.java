package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

public class UserPostsPage extends TestBase {

	public UserPostsPage(WebDriver driver) throws IOException {
		super(driver);
	}
	
	public By userProfileHeader = By.xpath("//h4");
	public By userSettingsButton = By.xpath("//a[text()=' Edit Profile Settings ']");

}
