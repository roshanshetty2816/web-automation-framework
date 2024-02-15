package Utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.BaseClass;

public class Util extends BaseClass {

	public static void captureScreenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(".//screenshots//screenshot.jpg");
		FileHandler.copy(src, dest);
	}

	public static JSONArray JSONArrayExtractor() throws IOException, ParseException {
		FileReader file = new FileReader(".//src//test//resources//testdata//JSONFiles//LoginData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(file);
		return (JSONArray) obj;
	}
}
