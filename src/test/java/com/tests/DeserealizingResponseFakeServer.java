package com.tests;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import deserializingPojoFakeServer.MyMain;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class DeserealizingResponseFakeServer {

	// we will do a get call and deserialize the response below to map it to POJO
	// classes.
	// Rememeber that we have to create our POJO classes before hitting the request,
	// because we have to map our response against the already created POJO classes.

	// Deserializing POJO classes used:

	// MyMain.java
	// MyArray.java

	// Expected response_Simple: **********Here response starts with an
	// array/LIST************

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

	@Test(enabled = false)
	public void getRequestSimple() {

		// Fake Server:: GET USER

		Response response = given().get("http://localhost:3000/employees");

		// for deserializing and mapping response to "ReqresMain.class" POJO class.

		List<MyMain> mainResponse = response.as(new TypeRef<List<MyMain>>() {
		});

		// Extracting data from POJO class : printing the whole main response

		System.out.println(mainResponse);

		// Extracting data from POJO class : printing data of each id

		for (MyMain m : mainResponse) {

			System.out.println(m.toString());

		}

	}

}
