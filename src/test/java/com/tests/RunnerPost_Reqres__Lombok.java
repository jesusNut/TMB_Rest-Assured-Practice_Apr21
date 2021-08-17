package com.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.Lombok.ReqresPostRequestPojo;
import com.Lombok.ReqresPostResponsePojo;
import com.Lombok.ReqresPostRequestPojo.ReqresPostRequestPojoBuilder;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPost_Reqres__Lombok {

	// USE OF LOMBOK : used for easy creation of POJO classes for both Serilaization
	// and De-serialization

	// Use case : we will create POJO classes for both request and response for
	// REQRES POST operation.

	// POJO location : com.Lombok

	// POJO classes used : ReqresPostRequestPojo.java & ReqresPostResponsePojo.java

	@Test(enabled = true)
	public void postUserUsingPOJOwithArrayPayload() {

		// calling inner class 'ReqresPostRequestPojoBuilder' (created by @Builder
		// lombok annotation) from 'ReqresPostRequestPojo' class

		ReqresPostRequestPojoBuilder builder = ReqresPostRequestPojo.builder();

		ReqresPostRequestPojo payload = builder.setJob("porn star").setName("Mia Khalifa").build();

		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(payload);

		Response postRes = request.post("https://reqres.in/api/users");

		System.out.println("-------------------------------");

		ReqresPostResponsePojo responseObject = postRes.as(ReqresPostResponsePojo.class);

		System.out.println(responseObject.toString());

	}

}
