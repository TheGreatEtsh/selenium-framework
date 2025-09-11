package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		//wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstNameTxtBx;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastNameTxtBx;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxtBx;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxtBx;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxtBx;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxtBx;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxtBx;

	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement newAddressContinueBtn;

	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement stateProvinceDropDown;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement shippingMethodContinueBtn;

	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;

	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;

	@FindBys({ @FindBy(css = "div.page.checkout-page"), @FindBy(css = "button.button-1") })
	WebElement continueBtn;

	@FindBy(tagName = "strong")
	WebElement confirmationMsg;

	@FindBy(partialLinkText = "order details")
	WebElement orderDetailsLink;

	public void addCheckOutDetails(WebDriverWait wait, String firstName, String lastName, String email, String city, String address,
			String stateProvinceId, String zipCode, String phoneNumber) {
		sendText(cityTxtBx, city);
		sendText(addressTxtBx, address);
		selectDropDownByTxt(stateProvinceDropDown, stateProvinceId);
		sendText(postalCodeTxtBx, zipCode);
		sendText(phoneNumberTxtBx, phoneNumber);
		scrollToElement(newAddressContinueBtn);
		clickButton(newAddressContinueBtn);
		
		scrollToElement(shippingMethodContinueBtn);
		wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueBtn));
		//clickButton(continueBtn);
		clickButton(shippingMethodContinueBtn);
		
		scrollToElement(paymentMethodContinueBtn);
		wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueBtn));
		clickButton(paymentMethodContinueBtn);
		
		scrollToElement(paymentInfoContinueBtn);
		wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueBtn));
		clickButton(paymentInfoContinueBtn);
		//clickButton(continueBtn);
		scrollToElement(confirmOrderBtn);
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));
		clickButton(confirmOrderBtn);
	}

	public boolean confirmationMsgDisplayed(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(confirmationMsg));
		return confirmationMsg.isDisplayed();
	}

	public void openOrderDetailsPage() {
		
		clickButton(orderDetailsLink);
	}
	
	public WebElement getNewAddressContinueBtn() {
		return newAddressContinueBtn;
	}
	public WebElement getShippingMethodContinueBtn() {
		return shippingMethodContinueBtn;
	}
	public WebElement getPaymentInfoContinueBtn() {
		return paymentInfoContinueBtn;
	}
	public WebElement getConfirmOrderBtn() {
		return confirmOrderBtn;
	}
}
