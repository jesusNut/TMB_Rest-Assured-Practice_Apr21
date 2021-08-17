package com.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.pojo.PersonRequest_Lombok;
import com.pojo.PersonRequest_Lombok_1_address;
import com.pojo.PersonRequest_Lombok_1_mainPayload;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//POJO class used : com.Pojo.PersonRequest_Lombok_1_main & com.Pojo.PersonRequest_Lombok_1_address

public class RunnerPost_FakeServer_Lombok_1 {
	
	@Test(enabled = true)
	public void postUserUsingPOJO() {
		
	   
	    PersonRequest_Lombok_1_address address = new PersonRequest_Lombok_1_address();
	    address.setUnit("22");
	    address.setStreet("Bradway");
	    address.setCity("Islamabad");
	    
	    PersonRequest_Lombok_1_mainPayload payload = new PersonRequest_Lombok_1_mainPayload();
	    payload.setAddress(address);
	    payload.setAge(39);
	    payload.setFirstName("Saarthi");
	    payload.setLastName("Kaye");
		
		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(payload);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		
		postRes.prettyPrint();

	}



}
