package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "FullName")
	WebElement fullNameTxtBx;
	
	@FindBy(id = "Email")
	WebElement emailTxtBx;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTxtBx;
	
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	WebElement resultMsg;
	
	public void sendContactUsEnquiry(String fullName, String email, String enquiry) {
		sendText(fullNameTxtBx, fullName);
		sendText(emailTxtBx, email);
		sendText(enquiryTxtBx, enquiry);
		clickButton(submitBtn);
	}
	
	public boolean isResultDisplayed() {
		return resultMsg.isDisplayed();
	}
}
