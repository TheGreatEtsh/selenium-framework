package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductReviewPage;

public class AddProductReviewTest extends TestBase{

	String productReviewTitle = "Test2";
	String productReviewMsg = "Test2";
	String productReviewStars = "4";
	
	ProductPage productObject;
	ProductReviewPage productReviewObject;
	HomePage homeObject;
	LoginPage loginObject;
	
	String yourEmail = "test17@gmail.com";
	String password = "KGWouhqofgWOUW";
	
	String productName = "Apple iPhone 16 128GB";
	String searchTxt = "Apple";
	
	
	@Test(priority = 1)	
	public void testLoginAccount() {
		homeObject = new HomePage(driver);
		homeObject.openLogInPage();

		loginObject = new LoginPage(driver);
		loginObject.loginAccount(yourEmail, password);

		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	}


	@Test(dependsOnMethods = "testLoginAccount")
	public void searchUsingAutoSuggestTest() {
		homeObject = new HomePage(driver);
		productObject = new ProductPage(driver);
		
		homeObject.searchUsingAutoSuggest(searchTxt, productName);
		Assert.assertEquals(productObject.getProductName(), productName);
	}

	@Test(dependsOnMethods = "searchUsingAutoSuggestTest")
	public void addReviewTest() {
		productReviewObject = new ProductReviewPage(driver);
		
		productObject.openAddReviewPage();
		productReviewObject.addReview(productReviewTitle, productReviewMsg, productReviewStars);
		
		Assert.assertTrue(productReviewObject.isReviewSuccessfullyAdded());
	}
}
