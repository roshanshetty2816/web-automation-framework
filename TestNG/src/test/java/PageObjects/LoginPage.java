package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.ActionClass;
import Base.BaseClass;

public class LoginPage extends BaseClass {
	ActionClass Action = new ActionClass();

	@FindBy(id = "user-name")
	WebElement userNameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) {
		Action.sendKeys(userNameField, userName);
	}

	public void enterPassword(String password) {
		Action.sendKeys(passwordField, password);
	}

	public void clickLoginBtn() {
		Action.click(loginBtn);
	}

	public ProductsPage performLogin(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickLoginBtn();
		return new ProductsPage();
	}
}
