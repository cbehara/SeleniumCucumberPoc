package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.TestBase;

public class SignupPage extends TestBase {

	public SignupPage(WebDriver driver) throws IOException {
		super(driver);
	}

	public By signupLink = By.xpath("//a[text()=' Sign up ']");
	public By signupHeader = By.xpath("//h1");
	public By username = By.xpath("//input[@placeholder='Username']");
	public By email = By.xpath("//input[@placeholder='Email']");
	public By password = By.xpath("//input[@placeholder='Password']");
	public By signupButton = By.cssSelector(".btn-primary");
	public By signInUser = By.xpath("//img[@class='user-pic']/parent :: a");
}
