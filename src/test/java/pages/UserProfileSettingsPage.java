package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

public class UserProfileSettingsPage extends TestBase {

	public UserProfileSettingsPage(WebDriver driver) throws IOException {
		super(driver);
	}
	
	public By userSettingsHeader = By.xpath("//h1[text()='Your Settings']");
	public By userLogoutButton = By.cssSelector(".btn-outline-danger");

}
