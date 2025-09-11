package tests;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestDDTandUsingJson extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;

	JsonReader jsonReader;

	@Test(priority = 1)
	public void testUserRegisteration() throws IOException, ParseException {

		jsonReader = new JsonReader();
		List<JsonReader.User>users = jsonReader.jsonRead();
		
		for (JsonReader.User user : users) {
			homeObject = new HomePage(driver);
			homeObject.openRegisterationPage();

			userRegisterationObject = new UserRegistrationPage(driver);
			userRegisterationObject.registerUser(user.firstName, user.lastName, user.email, user.password);

			registerResultObject = new RegisterResultPage(driver);
			Assert.assertTrue(
					registerResultObject.resultMsg.getText().contains(registerResultObject.registerationSuccessful));

			registerResultObject.logoutAccount();
			Assert.assertTrue(homeObject.loginLink.isDisplayed());

			homeObject.openLogInPage();

			loginObject = new LoginPage(driver);
			loginObject.loginAccount(user.email, user.password);

			Assert.assertTrue(homeObject.logoutLink.isDisplayed());

			registerResultObject.logoutAccount();
			Assert.assertTrue(homeObject.loginLink.isDisplayed());

		}
		
	}
}
