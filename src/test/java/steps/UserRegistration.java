package steps;

import org.testng.Assert;

//import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterResultPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegisterObject;
	RegisterResultPage registerResultObject;
	/*
	 * Faker fakeData = new Faker(); String firstName = fakeData.name().firstName();
	 * String lastName = fakeData.name().lastName(); String email =
	 * fakeData.internet().emailAddress(); String password =
	 * fakeData.number().digits(10);
	 */

	@Given("The user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);

	}

	@When("I click on register link")
	public void i_click_on_register_link() {
		homeObject.openRegisterationPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * userRegisterObject = new UserRegistrationPage(driver);
	 * userRegisterObject.registerUser(firstName, lastName, email, password); }
	 */

	@When("I entered {string}, {string}, {string}, {string}")
	public void i_entered(String firstName, String lastName, String email, String password) {
		userRegisterObject = new UserRegistrationPage(driver);
		userRegisterObject.registerUser(firstName, lastName, email, password);
	}

	@Then("The registration page is displayed successfully")
	public void the_registration_page_is_displayed_successfully() {
		registerResultObject = new RegisterResultPage(driver);
		Assert.assertTrue(registerResultObject.resultMsg.getText().contains(registerResultObject.registerationSuccessful));
		registerResultObject.logoutAccount();
	}

}
