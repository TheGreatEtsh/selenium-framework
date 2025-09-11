package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class UserRegisterationUsingDDTandDataProvider extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;

	@DataProvider(name = "userData")
	public static Object[][] userData() {
		return new Object[][] { { "test05@gmail.com", "KGWouhqofgWOUW" }, { "test06@gmail.com", "KGWouhqofgWOUW" } };
	}

	@Test(priority = 1, dataProvider = "userData")
	public void testUserRegisteration(String email, String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();

		userRegisterationObject = new UserRegistrationPage(driver);
		userRegisterationObject.registerUser("john", "doe", email, password);

		registerResultObject = new RegisterResultPage(driver);
		Assert.assertTrue(
				registerResultObject.resultMsg.getText().contains(registerResultObject.registerationSuccessful));
		
		registerResultObject.logoutAccount();
		Assert.assertTrue(homeObject.loginLink.isDisplayed());
		
		homeObject.openLogInPage();

		loginObject = new LoginPage(driver);
		loginObject.loginAccount(email, password);

		Assert.assertTrue(homeObject.logoutLink.isDisplayed());	

		registerResultObject.logoutAccount();
		Assert.assertTrue(homeObject.loginLink.isDisplayed());
		
	}
/*
	@Test(dependsOnMethods = "testUserRegisteration")
	public void testLogoutAccount() {
		registerResultObject.logoutAccount();
		Assert.assertTrue(homeObject.loginLink.isDisplayed());
	}

	@Test(dependsOnMethods = "testLogoutAccount", dataProvider = "userData")
	public void testLoginAccount(String email, String password) {
		homeObject.openLogInPage();

		loginObject = new LoginPage(driver);
		loginObject.loginAccount(email, password);

		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	}
*/	
}
