package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement titleTxtBx;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxtBx;
	
	@FindBy(name = "AddProductReview.Rating")
	List<WebElement> starsRadioBtns;
	
	@FindBy(id = "add-review")
	WebElement submitBtn;
	
	@FindBy(id = "bar-notification")
	WebElement barNotification;
	
	public void addReview(String title, String review, String stars) {
		sendText(titleTxtBx, title);
		sendText(reviewTxtBx, review);
		for (WebElement webElement : starsRadioBtns) {
			if(webElement.getAttribute("value").equals(stars)) {
				clickButton(webElement);
			}
		}
		clickButton(submitBtn);
	}
	
	public boolean isReviewSuccessfullyAdded() {
		return barNotification.isDisplayed();
	}
	

}
