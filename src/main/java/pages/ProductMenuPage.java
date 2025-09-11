package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductMenuPage extends PageBase {

	public ProductMenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div.page-title")
	WebElement pagetitle;

	public boolean isProductPageCorrect(String title) {
		return pagetitle.getText().contains(title);
	}
}
