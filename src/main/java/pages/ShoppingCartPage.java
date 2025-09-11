package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "td.product")
	List<WebElement> products;

	@FindBy(css = "td.quantity input.qty-input")
	List<WebElement> productsQuantity;
	
	@FindBy(id = "termsofservice")
	WebElement termsOfServiceChkBx;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	public boolean isProductQuantityTrue(String productName, String productQuantity) {
		boolean returnValue = false;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().contains(productName)) {
				if (productsQuantity.get(i).getAttribute("value").contains(productQuantity)) {
					returnValue = true;
					System.out.println(products.get(i).getText());
					System.out.println(productsQuantity.get(i).getAttribute("value"));
					break;
				}
			}
			System.out.println(products.get(i).getText());
			System.out.println(productsQuantity.get(i).getText());
			
		}

		return returnValue;
	}

	public void openCheckoutPage() {
		scrollToElement(termsOfServiceChkBx);
		clickButton(termsOfServiceChkBx);
		scrollToElement(checkoutBtn);
		clickButton(checkoutBtn);
	}
}
