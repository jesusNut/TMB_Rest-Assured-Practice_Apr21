package com.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.pojo.EasyPayload;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPut {

	@Test(enabled = true)
	public void updateUserPut() {

		// updating user id :3 {using POJO, className : EasyPayload}

		EasyPayload jsonPayload = new EasyPayload();

		jsonPayload.setId(3);
		jsonPayload.setFirst_name("Zhingaaa");
		jsonPayload.setLast_name("Laala");
		jsonPayload.setEmail("zhingalal.ululul@gmail.com");

		RequestSpecification request = given();

		request = request.log().body();

		request = request.header("Content-Type", "application/json");

		request.body(jsonPayload);

		System.out.println("-------------------------------");

		Response putRes = request.put("http://localhost:3000/employees/3");

		System.out.println(putRes.getStatusCode());

		putRes.prettyPrint();

	}

}
