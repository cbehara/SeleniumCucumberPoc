package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

public class SignInPage extends TestBase {

	public SignInPage(WebDriver driver) throws IOException {
		super(driver);
	}

	public By signInHeader = By.xpath("//h1");
	public By signIn_email = By.xpath("//input[@placeholder='Email']");
	public By signIn_pwd = By.xpath("//input[@placeholder='Password']");
	public By signIn_button = By.xpath("//button");

	public By signInUser = By.xpath("//img[@class='user-pic']/parent :: a");
	public By newArticleLink = By.xpath("//a[text()[contains(.,'New Article')]]");

}
