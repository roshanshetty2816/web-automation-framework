package ActionDriver;

import org.openqa.selenium.WebElement;

public class ActionClass {
	public void sendKeys(WebElement elem, String value) {
		elem.clear();
		elem.sendKeys(value);
	}

	public void click(WebElement elem) {
		elem.click();
	}
}
