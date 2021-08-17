package com.tests;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.pojo.PersonArrayPayloadWithConstructor;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPost_Constructor {
	
	
	// perform POST request using POJO where POJO class will have CONSTRUCTOR.
	
	// class used : 'PersonArrayPayloadWithConstructor'-> com.pojo package in src/main/java
		
//		JSON payload format starting with '[]':
		
//		[   {
//			  "firstName" : "Mike",
//			  "lastName" : "harvey",
//			  "age" : 34
//			}, {
//			  "firstName" : "Nick",
//			  "lastName" : "young",
//			  "age" : 75
//			} ]	
	
	@Test(enabled = true)
	public void postUserUsingPOJOwithArrayPayload() {
		
		PersonArrayPayloadWithConstructor jsonPayload1 =
				new PersonArrayPayloadWithConstructor("Kalika", "Mongia", 29);

		
		
		PersonArrayPayloadWithConstructor jsonPayload2 = 
				new PersonArrayPayloadWithConstructor("Monika", "Chantt", 27);
		
		
		List<PersonArrayPayloadWithConstructor> finalPayload = Arrays.asList(jsonPayload1,jsonPayload2);
		
		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(finalPayload);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

}
