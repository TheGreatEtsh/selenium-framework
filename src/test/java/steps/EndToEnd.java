package steps;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.OrderDetailsPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import tests.TestBase;
import utilities.Helper;

public class EndToEnd extends TestBase{
	
	HomePage homeObject;
	LoginPage loginObject;
	ProductPage productObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage checkoutObject;
	MyAccountPage myAccountObject;
	OrderDetailsPage orderDetailsObject;
	
	@Given("The user is on the login page")
	public void the_user_is_on_the_login_page() {
		homeObject = new HomePage(driver);
		homeObject.openLogInPage();
	}
	
	@When("The user can login with right credentials: {string}, {string}")
	public void the_user_can_login_with_right_credentials(String email, String password) {
		loginObject = new LoginPage(driver);
	    
	    loginObject.loginAccount(email, password);
	    Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	}
	
	@When("The user search for the {string} and choose the {string} from the auto suggest")
	public void the_user_search_for_the_and_choose_the_from_the_auto_suggest(String product, String productName) {
		homeObject.searchUsingAutoSuggest(product, productName);
	}
	
	@When("The user can add the product to cart")
	public void The_user_can_add_the_product_to_cart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		productObject = new ProductPage(driver);
		productObject.addToCart("3");
		Assert.assertTrue(productObject.isProductAddedToCart());
		productObject.closeNotificationBar();
		wait.until(ExpectedConditions.invisibilityOf(productObject.getSuccessMsgElement()));
	}
	
	@When("The user go to shopping cart page to checkout")
	public void the_user_go_to_shopping_cart_page_to_checkout() {
		productObject.openShoppingCartPage();
		
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.openCheckoutPage();
	}
	@When("The user enter checkout details and confirm checkout entering {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void the_user_enter_checkout_details_and_confirm_checkout(String phoneNumber, String zipCode, String stateProvinceId, String address, String city, String lastName, String firstName, String email) {
		checkoutObject = new CheckOutPage(driver);
		checkoutObject.addCheckOutDetails(wait ,firstName, lastName, email, city, address, stateProvinceId, zipCode, phoneNumber);
		
	}
	
	@Then("The confirmation message should appear")
	public void the_confirmation_message_should_appear() {
		Assert.assertTrue(checkoutObject.confirmationMsgDisplayed(wait));
	}
	
	@Then("The should be able to download the invoice")
	public void the_should_be_able_to_download_the_invoice() {
		myAccountObject = new MyAccountPage(driver);
		orderDetailsObject = new OrderDetailsPage(driver);
		
		homeObject.openMyAccountPage();
		myAccountObject.openOrderDetialsPage(wait);
		orderDetailsObject.downloadInvoice();
		Helper.waitForNewFile();
	}

}
