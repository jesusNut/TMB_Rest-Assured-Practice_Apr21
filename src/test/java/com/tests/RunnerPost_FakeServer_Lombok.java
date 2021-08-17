package com.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.pojo.PersonRequest_Lombok;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//POJO class used : com.Pojo.PersonRequest_Lombok

public class RunnerPost_FakeServer_Lombok {
	
	@Test(enabled = true)
	public void postUserUsingPOJO() {
		
	    PersonRequest_Lombok payload = PersonRequest_Lombok.builder().setFirstName("Rumba").setLastName("Maithani").setAge(34).setAddress("{\r\n" + 
	    		"\r\n" + 
	    		"	  \"unit\":\"22\",\r\n" + 
	    		"	  \"street\":\"khau gali\",\r\n" + 
	    		"	  \"city\":\"Luxemberg\"\r\n" + 
	    		"	\r\n" + 
	    		"     }").build();
	    
	    
		
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
