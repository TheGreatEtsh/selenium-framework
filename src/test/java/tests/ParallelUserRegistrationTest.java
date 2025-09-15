package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class ParallelUserRegistrationTest extends ParallelTestBase {
	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(10);

	@Test(priority = 1)
	public void testUserRegisteration() {
		homeObject = new HomePage(getDriver());
		homeObject.openRegisterationPage();

		userRegisterationObject = new UserRegistrationPage(getDriver());
		userRegisterationObject.registerUser("john", "doe", email, password);

		registerResultObject = new RegisterResultPage(getDriver());
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

		loginObject = new LoginPage(getDriver());
		loginObject.loginAccount(email, password);

		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
		testLogoutAccount();
	}


}
