package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class ProductsPage extends BaseClass {
	@FindBy(css = ".app_logo")
	WebElement appLogo;

	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProductsPageHeader() {
		return appLogo.getText();
	}

	public ProductPage clickOnProduct(String productName) {
		String productNameXPath = "//div[text()='" + productName + "']";
		driver.findElement(By.xpath(productNameXPath)).click();
		return new ProductPage();
	}
}
