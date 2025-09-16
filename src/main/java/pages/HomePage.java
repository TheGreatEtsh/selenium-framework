package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);

	}

	@FindBy(css = "a.ico-register")
	WebElement registerLink;

	@FindBy(css = "a.ico-login")
	public WebElement loginLink;

	@FindBy(css = "a.ico-logout")
	public WebElement logoutLink;

	@FindBy(partialLinkText = "My account")
	WebElement myAccountLink;

	@FindBy(id = "small-searchterms")
	WebElement searchTxtBx;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;

	@FindBys({ @FindBy(id = "ui-id-1"), @FindBy(className = "ui-menu-item-wrapper"), @FindBy(tagName = "span") })
	List<WebElement> searchResultsItms;

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;

	@FindBy(id = "customerCurrency")
	WebElement currencyDropDown;

	@FindBy(css = "span.price.actual-price")
	List<WebElement> prices;

	@FindBy(linkText = "Computers")
	WebElement computersLink;

	@FindBys({ @FindBy(css = "ul.sublist.first-level"), @FindBy(tagName = "a") })
	List<WebElement> productListItems;

	public void openRegisterationPage() {
		clickButton(registerLink);
	}

	public void openLogInPage() {
		clickButton(loginLink);
	}

	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}

	public void searchUsingSeachBtn(String productName) {
		sendText(searchTxtBx, productName);
		clickButton(searchBtn);
	}

	public void searchUsingAutoSuggest(String searchTxt, String productName) {
		sendText(searchTxtBx, searchTxt);
		for (WebElement webElement : searchResultsItms) {
			if (webElement.getText().equalsIgnoreCase(productName)) {
				clickButton(webElement);
				break;
			}
		}
	}

	public void openContactUsPage() {
		scrollToElement(contactUsLink);
		clickButton(contactUsLink);

	}

	public void changeCurrency(String currency) {
		selectDropDownByTxt(currencyDropDown, currency);
	}

	public boolean isCurrencyChanged(String currency) {
		boolean changed = true;
		for (WebElement webElement : prices) {
			scrollToElement(webElement);
			if ((!webElement.getText().contains("€")) && currency.equalsIgnoreCase("Euro")) {
				changed = false;
				break;
			} else if ((!webElement.getText().contains("$")) && currency.equalsIgnoreCase("US Dollar")) {
				changed = false;
				break;
			}
		}
		return changed;
	}

	public void openNotebooksPage(String productName) {

		action.moveToElement(computersLink).build().perform();
		for (WebElement webElement : productListItems) {
			System.out.println(webElement.getText());
			if (webElement.getText().equals(productName)) {
				action.moveToElement(webElement).click().release().build().perform();
				action.moveToLocation(0, 0);
				break;
			}
		}
	}
}
