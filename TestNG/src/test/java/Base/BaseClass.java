package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;
	public static Properties props;

	@BeforeSuite
	public void loadPropertiesFile() throws IOException {
		FileInputStream file = new FileInputStream(".//src//test//resources//configs//config.properties");
		props = new Properties();
		props.load(file);
	}

	public void launchBrowser(String browserName) throws IOException {
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(props.getProperty("BASE_URL"));
	}
}
