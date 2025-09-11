package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestUsingDDTandPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;
	
	String firstName = LoadProperties.userData.getProperty("firstName");
	String lastName = LoadProperties.userData.getProperty("lastName");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	@Test(priority = 1)
	public void testUserRegisteration() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();

		userRegisterationObject = new UserRegistrationPage(driver);
		userRegisterationObject.registerUser(firstName, lastName, email, password);

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
