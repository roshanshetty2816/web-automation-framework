package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.ActionClass;
import Base.BaseClass;

public class ProductPage extends BaseClass {
	ActionClass action = new ActionClass();

	@FindBy(id = "back-to-products")
	WebElement backToProductText;

	@FindBy(css = ".inventory_details_name.large_size")
	WebElement productTitle;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean checkIfBackToProductsTextIsDisplayed() {
		return backToProductText.isDisplayed();
	}

	public String extractProductTitle() {
		return productTitle.getText();
	}
}
