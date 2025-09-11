package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	String fullName = "test";
	String email = "test@email.com";
	String Enquiry = "This is a test msg";
	
	HomePage homeObject;
	ContactUsPage contactUsObject;
		
	@Test
	public void contactUsTest() {
		homeObject = new HomePage(driver);
		contactUsObject = new ContactUsPage(driver);
		
		homeObject.openContactUsPage();
		contactUsObject.sendContactUsEnquiry(fullName, email, Enquiry);
		Assert.assertTrue(contactUsObject.isResultDisplayed());
	}
}
