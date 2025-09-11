package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestDDTandUsingCSV extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterationObject;
	RegisterResultPage registerResultObject;
	LoginPage loginObject;

	CSVReader reader;

	@Test(priority = 1)
	public void testUserRegisteration() throws CsvValidationException, IOException {

		String csvPath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(csvPath));

		String[] userData;

		while ((userData = reader.readNext()) != null) {
			String firstName = userData[0];
			String lastName = userData[1];
			String email = userData[2];
			String password = userData[3];
			
			homeObject = new HomePage(driver);
			homeObject.openRegisterationPage();

			userRegisterationObject = new UserRegistrationPage(driver);
			userRegisterationObject.registerUser(firstName, lastName, email, password);

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
}
