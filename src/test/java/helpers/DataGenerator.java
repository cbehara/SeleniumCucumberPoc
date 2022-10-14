package helpers;

import com.github.javafaker.Faker;

public class DataGenerator {

	Faker faker = new Faker();

	public String getRandomUserEmail() {
		String userEmail = faker.name().firstName().toLowerCase() + "@test.com";
		return userEmail;
	}

	public String getRandomUsername() {
		String userName = faker.name().username().toLowerCase();
		return userName;
	}
	
	public String getArticleTitle() {
		String articleTite = faker.funnyName().name();
		return articleTite;
	}

}
