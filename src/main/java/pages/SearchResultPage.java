package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageBase {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "h2.product-title")
	List<WebElement> productsTitle;

	public void findProduct(String productName) {
		for (WebElement webElement : productsTitle) {
			if (webElement.getText().equalsIgnoreCase(productName)) {
				clickButton(webElement);
				break;
			}
		}
	}
}
