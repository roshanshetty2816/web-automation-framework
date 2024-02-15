package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import DataProvider.DataProviders;
import PageObjects.LoginPage;
import PageObjects.ProductsPage;

@Listeners(Utility.ListenerClass.class)
public class LoginTest extends BaseClass {
	LoginPage loginPage;
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

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void loginTest(@Optional("standard_user") String userName, @Optional("secret_sauce") String password) {
		loginPage = new LoginPage();
		productsPage = loginPage.performLogin(userName, password);
		String actProductsPageHeader = productsPage.getProductsPageHeader();
		String expProductsPageHeader = "Swag Labs";
		Assert.assertEquals(actProductsPageHeader, expProductsPageHeader);
	}
}
