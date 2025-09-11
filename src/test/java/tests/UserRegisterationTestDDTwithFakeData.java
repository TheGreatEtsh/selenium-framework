package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestDDTwithFakeData extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(9).toString();

	@Test(priority = 1)
	public void testUserRegisteration() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();

		userRegisterationObject = new UserRegistrationPage(driver);
		userRegisterationObject.registerUser(firstName, lastName, email, password);
		System.out.println(firstName + "," + lastName + "," + email + "," + password);
		registerResultObject = new RegisterResultPage(driver);
		Assert.assertTrue(
				registerResultObject.resultMsg.getText().contains(registerResultObject.registerationSuccessful));
	}

	@Test(dependsOnMethods = "testUserRegisteration")
	public void testLogoutAccount() {
		registerResultObject.logoutAccount();
		Assert.assertTrue(homeObject.loginLink.isDisplayed());
	}

	@Test(dependsOnMethods = "testLogoutAccount")
	public void testLoginAccount() {
		homeObject.openLogInPage();

		loginObject = new LoginPage(driver);
		loginObject.loginAccount(email, password);

		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	}

}
