package DataProvider;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import Utility.Util;

public class DataProviders {
	@DataProvider(name = "loginData")
	public static Object[][] loginDataProvider() throws IOException, ParseException {

		// Extract JSON data
//		JSONArray jsonArray = Util.JSONArrayExtractor();
//		Object[][] resObj = new Object[jsonArray.size()][2];
//		for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject userDetails = (JSONObject) jsonArray.get(i);
//			resObj[i][0] = userDetails.get("username");
//			resObj[i][1] = userDetails.get("password");
//		}
//		return resObj;

		// Extract Data from Excel
		return Util.ExcelReader("loginData");
	}
}
