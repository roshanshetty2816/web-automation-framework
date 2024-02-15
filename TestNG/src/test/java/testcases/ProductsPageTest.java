package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import PageObjects.ProductsPage;

public class ProductsPageTest extends BaseClass {
	LoginPage loginPage;
	ProductPage productPage;
	ProductsPage productsPage;

	@Parameters({ "browserName" })
	@BeforeMethod
	public void setup(String browserName) throws IOException {
		launchBrowser(browserName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testProductsPagetoProductPageNav(@Optional("Sauce Labs Bike Light") String productName) {
		loginPage = new LoginPage();
		productsPage = loginPage.performLogin(props.getProperty("USERNAME"), props.getProperty("PASSWORD"));
		productPage = productsPage.clickOnProduct(productName);
		Assert.assertTrue(productPage.checkIfBackToProductsTextIsDisplayed());
		Assert.assertEquals(productName, productPage.extractProductTitle());
	}
}
