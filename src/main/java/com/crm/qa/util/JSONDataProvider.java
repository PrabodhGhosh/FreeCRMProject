package com.crm.qa.util;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

public class JSONDataProvider {
	
	public static String testCaseName = null;
	
	@DataProvider(name = "dataproviderMethod")
	public static Object[][] fetchData(Method method) throws Exception {
		testCaseName = method.getName();     
		JSONArray testData = (JSONArray) extractData_JSON(testCaseName);
		List<JSONObject> testDataList = new ArrayList<JSONObject>();       
		for (int i = 0; i < testData.size(); i++) {
			testDataList.add((JSONObject) testData.get(i));
		}
		Object[][] result = new Object[testDataList.size()][testDataList.get(0).size()];

		for (int i = 0; i < testDataList.size(); i++) {
			result[i] = new Object[] { testDataList.get(i) };
		}
        return result;
	}
	
	public static JSONArray extractData_JSON(String key) throws Exception {		 
		File file = new File("src/test/resources/testData/"+key+".json");
		FileReader reader = new FileReader(file);
	    JSONParser jsonParser = new JSONParser();
	    JSONArray testCases = (JSONArray) jsonParser.parse(reader);
	    return testCases;
	}

}
