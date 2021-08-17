package com.tests;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import deserializingPojoFakeServer.MyMain;
import deserializingPojoFakeServerStudent.MyStudent;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class DeserealizingResponseFakeServer_student {

	// we will do a get call and deserialize the response below to map it to POJO
	// classes.
	// Rememeber that we have to create our POJO classes before hitting the request,
	// because we have to map our response against the already created POJO classes.

	// Deserializing POJO classes used:

	// MyStudent.java

	// Expected response_Simple: **********Here response starts with an
	// array/LIST && course has an array of String************

//	[
//    {
//        "id": 1,
//        "firstName": "Vernon",
//        "lastName": "Harper",
//        "email": "egestas.rhoncus.Proin@massaQuisqueporttitor.org",
//        "programme": "Financial Analysis",
//        "courses": [
//            "Accounting",
//            "Statistics"
//        ]
//    },
//    {
//        "id": 2,
//        "firstName": "Murphy",
//        "lastName": "Holmes",
//        "email": "faucibus.orci.luctus@Duisac.net",
//        "programme": "Financial Analysis",
//        "courses": [
//            "Accounting",
//            "Statistics"
//        ]
//    },
//]

	@Test(enabled = true)
	public void getRequestSimple() {

		// Fake Server:: GET USER

		Response response = given().get("http://localhost:8085/student/list");

		// for deserializing and mapping response to "ReqresMain.class" POJO class.

		List<MyStudent> mainResponse = response.as(new TypeRef<List<MyStudent>>() {
		});

		// Extracting data from POJO class : printing the whole main response

		System.out.println(mainResponse);

		// Extracting data from POJO class : printing data of each id

		for (MyStudent m : mainResponse) {

			System.out.println(m.toString());

		}

	}

}
