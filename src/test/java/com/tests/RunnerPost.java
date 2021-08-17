package com.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojo.ComplexPayload;
import com.pojo.EasyPayload;
import com.pojo.FavFood4ComplexPayload;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPost {

	// variable for method which generate randomNumericString

	private static final SecureRandom random = new SecureRandom();

	@Test(enabled = false)
	public void getUser() {

		// ********* Get Request

		RequestSpecification getReq = given();

		getReq = getReq.log().all();

		Response getRes = getReq.get("http://localhost:3000/employees");

		System.out.println("-------------------------------");

		System.out.println("The response is *********\n" + getRes.asPrettyString());

		// validating the email of 2nd ID

		String actuallEmail = getRes.jsonPath().getString("[1].email");

		System.out.println(actuallEmail);

		Assert.assertEquals(actuallEmail, "steve@codingthesmartway.com");

		System.out.println("-------------------------------");

		// assert headers

		Headers allHeaders = getRes.headers();

		for (Header h : allHeaders) {

			System.out.println(h.getName() + " :: " + h.getValue());

		}

	}

	// ********** POST Request - where body is String

	@Test(enabled = true)
	public void postUser() {

		RequestSpecification request = given();

		request = request.log().body();

		request = request.header("Content-Type", "application/json");

		request.body("{\r\n" + "        \"id\": 4,\r\n" + "        \"first_name\": \"Parambir\",\r\n"
				+ "        \"last_name\": \"Arknob\",\r\n" + "        \"email\": \"chongla.pongla.com\"\r\n" + "    }");

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

	// *********** POST Request - where body is passed as an external JSON file

	@Test(enabled = false)
	public void postUserFromJsonFile() {

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(new File(System.getProperty("user.dir") + "\\test.json"));

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

	// *********** POST Request - where body is passed as JSON file, converted to
	// String and customized
	// value for certain fields i.e. ID here

	// a method to get JSON file dynamically as String so request can be manipulated

	private String getJSONfileAsString(String location) throws IOException {

		return new String(Files.readAllBytes(Paths.get(location)));

	}

	// a method to generate random number for ID

	public static String generateRandomNumericString(int length) {

		String textnumber = "0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			sb.append(textnumber.charAt(random.nextInt(textnumber.length())));

		}

		return sb.toString();

	}

	@Test(enabled = false)
	public void postUserFromJsonFileConvertedToString() throws IOException {

		RequestSpecification request = given();

		String jsonBody = getJSONfileAsString(System.getProperty("user.dir") + "\\test.json");

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(jsonBody.replace("14", generateRandomNumericString(3)));

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

	// *********** POST Request - using HASHMAP and ARRAY LIST for simple JSON

	// JSONObject -> HashMap
	// JSON Array -> Array List

	// for simple json payload in format : {
//    "id": 1,
//    "first_name": "Sebastian",
//    "last_name": "Eschweiler",
//    "email": "sebastian@codingthesmartway.com"

	@Test(enabled = false)
	public void postUserUsingMapSimpleJson() throws IOException {

		Map<String, Object> requestMap = new HashMap<String, Object>();

		requestMap.put("id", generateRandomNumericString(3));
		requestMap.put("first_name", "Mona");
		requestMap.put("last_name", "Darling");
		requestMap.put("email", "MonaDarling@yahoo.co.uk");

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(requestMap);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

	// *********** POST Request - using HASHMAP and ARRAY LIST for COMPLEX JSON

	// JSONObject -> HashMap (insertion order not maintained)
	// JSON Array -> Array List

	// for simple json payload in format :
//  {  
//		"id": 14,
//		"first_name": "Amuthan",
//		"last_name": "Sakthivel",
//		"email": "checking@gmail.com",
//		"job": [
//			"tester",
//			"trainer"
//		],
//		"favfood": {
//			"breakfast": "dosa",
//			"lunch": "rice"
//		}
//	}
//
//		
	@Test(enabled = false)
	public void postUserUsingMapComplexJson() throws IOException {

		Map<String, Object> requestMap = new HashMap<String, Object>();

		requestMap.put("id", generateRandomNumericString(3));
		requestMap.put("first_name", "Mona");
		requestMap.put("last_name", "Darling");
		requestMap.put("email", "MonaDarling@yahoo.co.uk");

		List<String> reqArrayinMap = new ArrayList<String>();

		reqArrayinMap.add("Trainer");
		reqArrayinMap.add("Tester");

		requestMap.put("job", reqArrayinMap);

		Map<String, String> requestMapinMap = new HashMap<String, String>();

		requestMapinMap.put("breakfast", "dosa");
		requestMapinMap.put("lunch", "rice");

		requestMap.put("favfood", requestMapinMap);

		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(requestMap);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

	// *********** POST Request - using JSON LIBRARY

	// JSONObject -> Replacement of HashMap
	// JSONArray -> Replacement of ArrayList

	@Test(enabled = false)
	public void postUserUsingJSONLibrary() throws IOException {

		JSONObject outerObj = new JSONObject();
		outerObj.put("id", generateRandomNumericString(3));
		outerObj.put("first_name", "Mona");
		outerObj.put("last_name", "Darling");
		outerObj.put("email", "MonaDarling@yahoo.co.uk");

		// use of accumulate method - converts two values having same key as JSONArray

		// outerObj.accumulate("first_name", "Sona");

		// outerObj.putOpt("first_name", "Lee hao chao");

		JSONArray innerArray = new JSONArray();

		innerArray.put("Trainer");
		innerArray.put("Tester");
		innerArray.put("Farmer");

		outerObj.put("job", innerArray);

		JSONObject innerMapObj = new JSONObject();

		innerMapObj.put("breakfast", "dosa");
		innerMapObj.put("lunch", "rice");

		outerObj.put("favfood", innerMapObj);

		Map<String, Object> myMap = outerObj.toMap();

		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(myMap);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

	// *********** POST Request - using POJO {POJO classes in com.pojo package in
	// src/main/java}

	// class used : 'EasyPayload'-> com.pojo package in src/main/java

	// POST json paylod format :

//	{
//        "id": 1,
//        "first_name": "Sebastian",
//        "last_name": "Eschweiler",
//        "email": "sebastian@codingthesmartway.com"
//    }

	@Test(enabled = false)
	public void postUserUsingPOJOEasy() throws IOException {

		EasyPayload jsonPayload = new EasyPayload();

		jsonPayload.setId(Integer.parseInt(generateRandomNumericString(3)));
		jsonPayload.setFirst_name("Raghav");
		jsonPayload.setLast_name("Chaddha");
		jsonPayload.setEmail("Dalla@aapparty.com");

		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(jsonPayload);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

	// *********** POST Request - using POJO {POJO classes in com.pojo package in
	// src/main/java} -COMPLEX JSON PAYLOAD

	// class used : 'ComplexPayload' & 'FavFood'-> com.pojo package in src/main/java

	// POST json paylod format :

//	{
//		"id": 14,
//		"first_name": "Amuthan",
//		"last_name": "Sakthivel",
//		"email": "checking@gmail.com",
//		"job": [
//			"tester",
//			"trainer"
//		],
//		"favfood": {
//			"breakfast": "dosa",
//			"lunch": "rice"
//		}
//	}

	@Test(enabled = false)
	public void postUserUsingPOJOEay() throws IOException {

		ComplexPayload jsonPayload = new ComplexPayload();

		jsonPayload.setId(Integer.parseInt(generateRandomNumericString(3)));
		jsonPayload.setFirst_name("Raghav");
		jsonPayload.setLast_name("Chaddha");
		jsonPayload.setEmail("Dalla@aapparty.com");

		FavFood4ComplexPayload myFood = new FavFood4ComplexPayload();
		myFood.setBreakfast("Pancakes");
		myFood.setLunch("McDonalds");

		jsonPayload.setFavfood(myFood);

		jsonPayload.setJob(Arrays.asList("CA", "Dalaal", "Spokesperson"));

		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(jsonPayload);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

}
