package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestDDTandUsingExcel extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;

	@DataProvider(name = "userData")
	public static Object[][] userData() throws IOException {
		ExcelReader dataReader = new ExcelReader();
		return dataReader.getExcelData();
	}

	@Test(priority = 1, dataProvider = "userData")
	public void testUserRegisteration(String firstName,String lastName, String email, String password) {
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
}
