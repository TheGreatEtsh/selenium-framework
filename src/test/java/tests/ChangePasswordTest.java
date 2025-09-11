package tests;


//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ChangePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class ChangePasswordTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	ChangePasswordPage changePasswordObject;
	
	

	String email = "test17@gmail.com";
	String oldPassword = "GOIWH)@*YYLKDN";
	String newPassword = "KGWouhqofgWOUW";

	@Test(priority = 1)
	public void testUserRegisteration() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();

		userRegisterationObject = new UserRegistrationPage(driver);
		userRegisterationObject.registerUser("Ahmed", "Hesham", email, oldPassword);

		registerResultObject = new RegisterResultPage(driver);
		Assert.assertTrue(
				registerResultObject.resultMsg.getText().contains(registerResultObject.registerationSuccessful));
	}

	@Test(dependsOnMethods = "testUserRegisteration")
	public void changePasswordTest() {
		registerResultObject.openMyAccountPage();

		myAccountObject = new MyAccountPage(driver);
		myAccountObject.changePassword();

		changePasswordObject = new ChangePasswordPage(driver);
		changePasswordObject.changePassword(oldPassword, newPassword);

		Assert.assertTrue(changePasswordObject.changePasswordResult.getText()
				.equalsIgnoreCase(changePasswordObject.changePasswordSuccessfulTxt));
		
		changePasswordObject.closeMsg();
		
		//wait.until(ExpectedConditions.invisibilityOf(changePasswordObject.barNotification));
		//wait.until(ExpectedConditions.elementToBeClickable(changePasswordObject.logoutLink));
		changePasswordObject.logout();

	}
	
	@Test(dependsOnMethods = "changePasswordTest")
	public void testLoginAccount() {
		homeObject.openLogInPage();

		loginObject = new LoginPage(driver);
		loginObject.loginAccount(email, newPassword);

		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	}

}
