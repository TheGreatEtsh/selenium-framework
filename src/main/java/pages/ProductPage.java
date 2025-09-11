package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBys({ @FindBy(className = "overview"), @FindBy(className = "product-name"), @FindBy(tagName = "h1")

	})
	WebElement productName;

	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;

	@FindBy(partialLinkText = "Add your review")
	WebElement addReviewLink;

	@FindBy(css = "span.close")
	WebElement closeNotificationBtn;

	@FindBy(css = "button.button-1.add-to-cart-button")
	WebElement addToCartBtn;

	@FindBy(css = "input.qty-input")
	WebElement quantityInputTxtBx;

	@FindBy(css = "div.bar-notification.success")
	WebElement successNotification;

	@FindBy(css = "span.cart-label")
	WebElement shoppingCartLink;

	public String getProductName() {
		return productName.getText();
	}

	public void openEmailFriendPage() {
		clickButton(emailFriendBtn);
	}

	public void openAddReviewPage() {
		clickButton(addReviewLink);
	}

	public void closeNotificationBar() {
		clickButton(closeNotificationBtn);
	}

	public void addToCart(String quantity) {
		sendText(quantityInputTxtBx, quantity);
		clickButton(addToCartBtn);
	}

	public boolean isProductAddedToCart() {
		return successNotification.isDisplayed();
	}

	public void openShoppingCartPage() {
		clickButton(shoppingCartLink);
	}
	
	public WebElement getSuccessMsgElement() {
		return successNotification;
	}
}
