package com.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.pojo.PersonArrayPayload;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPost2 {
	
// perform POST request using POJO. 
	
	// class used : 'PersonArrayPayload'-> com.pojo package in src/main/java
	
//	JSON payload format starting with '[]':
	
//	[   {
//		  "firstName" : "Mike",
//		  "lastName" : "harvey",
//		  "age" : 34
//		}, {
//		  "firstName" : "Nick",
//		  "lastName" : "young",
//		  "age" : 75
//		} ]	
	
	@Test(enabled = true)
	public void postUserUsingPOJOWithArrayPayload() {
		
		PersonArrayPayload jsonPayload1 = new PersonArrayPayload();
		jsonPayload1.setAge(22);
		jsonPayload1.setFirstName("Manju");
		jsonPayload1.setLastName("Nath");
		
		
		PersonArrayPayload jsonPayload2 = new PersonArrayPayload();
		jsonPayload2.setAge(29);
		jsonPayload2.setFirstName("Mahisasur");
		jsonPayload2.setLastName("Gundaaa");
		
		
		List<PersonArrayPayload> finalPayload = new ArrayList<PersonArrayPayload>();
		
		finalPayload.add(jsonPayload1);
		finalPayload.add(jsonPayload2);

		
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
