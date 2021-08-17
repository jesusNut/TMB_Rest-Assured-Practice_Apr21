package com.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo_path_query_Param {

	// Get method to demonsrate path parameter

	// URI to be called in format : http://localhost:3000/employees/4

	@Test(enabled = false)
	public void getRequestIndividualPathParams() {

		// Fake Server:: GET USER : passing individual path paramaters

		Response response = given().pathParam("param1", "employees").pathParam("param2", 4)
				.get("http://localhost:3000/{param1}/{param2}");
		

		response.prettyPrint();

	}

	@Test(enabled = false)
	public void getRequestMapofPathParams() {

		// Fake Server:: GET USER : passing individual path paramaters

		Map<String, Object> pathParams = new HashMap<String, Object>();
		pathParams.put("param1", "employees");
		pathParams.put("param2", 4);

		RequestSpecification request = given().pathParams(pathParams);
		
		request.log().all();

		Response response = request.get("http://localhost:3000/{param1}/{param2}");

		response.prettyPrint();
		
		
	 
	}
	
	@Test(enabled = true)
	public void getRequestQueryParam() {

		// Fake Server:: GET USER : passing one path paramater and one query parameter


		RequestSpecification request = given().pathParams("param1","employees").
				queryParam("id", 3);
		
		request.log().all();

		Response response = request.get("http://localhost:3000/{param1}");

		response.prettyPrint();
		
		
		
		
	 
	}

}
