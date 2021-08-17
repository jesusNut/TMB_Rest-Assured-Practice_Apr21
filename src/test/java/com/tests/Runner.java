package com.tests;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Runner {

	@Test(enabled = true)
	public void getRequest() {

		// req-res.in :: GET USER

		Response response = given().get("https://reqres.in/api/users");

		response.prettyPrint();

		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

		System.out.println(response.getStatusCode());

	}

	@Test(enabled =false)
	public void postRequest() {

		// req-res.in :: POST USER - with a HEADER and JSON payload as String

		String reqBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";

		Response responsePOST = given().log().all().header("Content-Type", "application/json").body(reqBody)
				.post("https://reqres.in/api/users");

		System.out.println("The response body is : " + responsePOST.asPrettyString());

	}
	
	

}
