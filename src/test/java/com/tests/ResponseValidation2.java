package com.tests;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseValidation2 {

	// *******Validating the response using jsonpath

	// response format :

	// [
	// {
	// "id": 1,
	// "first_name": "Sebastian",
	// "last_name": "Eschweiler",
	// "email": "sebastian@codingthesmartway.com"
	// },
	// {
	// "id": 2,
	// "first_name": "Steve",
	// "last_name": "Palmer",
	// "email": "steve@codingthesmartway.com"
	// },
	// {
	// "id": 3,
	// "first_name": "Ann",
	// "last_name": "Smith",
	// "email": "ann@codingthesmartway.com"
	// },
	// {
	// "last_name": "Darling",
	// "favfood": {
	// "lunch": "rice",
	// "breakfast": "dosa"
	// },
	// "id": 4,
	// "job": [
	// "Trainer",
	// "Tester"
	// ],
	// "first_name": "Mona",
	// "email": "MonaDarling@yahoo.co.uk"
	// }
	// ]

	// sending get request and getting the response as above

	@Test(enabled = true)
	public void getRequest() {

		// req-res.in :: GET USER

		Response response = given().get("http://localhost:3000/employees");

		response.prettyPrint();

		// --------------------------------

		// **********RESPONSE VALIDATION 1 : for the user with id = 4, validate that he
		// has job as both TRAINER and TESTER and he has exactly 2 jobs

		List<String> allJobs = response.jsonPath().getList("[3].job");

		System.out.println(allJobs);
		
		
		Assert.assertEquals(allJobs, Arrays.asList("Trainer","Tester"));
		
		Assert.assertEquals(allJobs.size(),2);
		
		

	}

}
