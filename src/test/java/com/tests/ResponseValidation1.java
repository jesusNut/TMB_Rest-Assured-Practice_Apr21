package com.tests;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseValidation1 {

	// *******Validating the response using json path

	// response format :

//	[
//	    {
//	        "id": 1,
//	        "first_name": "Sebastian",
//	        "last_name": "Eschweiler",
//	        "email": "sebastian@codingthesmartway.com"
//	    },
//	    {
//	        "id": 2,
//	        "first_name": "Steve",
//	        "last_name": "Palmer",
//	        "email": "steve@codingthesmartway.com"
//	    },
//	    {
//	        "id": 3,
//	        "first_name": "Ann",
//	        "last_name": "Smith",
//	        "email": "ann@codingthesmartway.com"
//	    }
//	]

//sending get request and getting the response as above

	@Test(enabled = true)
	public void getRequest() {

		// req-res.in :: GET USER

		Response response = given().get("http://localhost:3000/employees");

		response.prettyPrint();

		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

		System.out.println(response.getStatusCode());

		// --------------------------------

		// **********RESPONSE VALIDATION 1 : for the first user the last name is
		// "Eschweiler"

		String firstUserLastName = response.jsonPath().get("[0].last_name");

		System.out.println(firstUserLastName);

	}

}
