package com.tests;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.pojo.PersonArrayPayloadWithConstructor;
import com.pojo.PersonBuilderClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPost_BuilderPattern {
	
	//***Problem : We need to pass a payload format given below. It has 3 attributes - firstName,lastName and age. Now if i do not want to provide 'lastName' attribute,
	//we can use BUILDER pattern. Using PersonArrayPayloadWithConstructor.java, this problem cannot be implemented because constructor will throw error if any parameter is missed. 
	//So we should use Builder pattern - a new class "PersonBuilderClass.java"
	
	// perform POST request using POJO where POJO class will have CONSTRUCTOR.
	
	// class used : 'PersonArrayPayloadWithConstructor' aka POJO class & 'PersonBuilderClass' aka BUILDER CLASS-> com.pojo package in src/main/java
	
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
	public void postUserUsingPOJOwithArrayPayloadNoLastName() {
		
		//Building first person : sending first name, last name and age
		
		PersonBuilderClass person1 = new PersonBuilderClass();
		
		person1.setFirstName("Akkash").setLastName("Budania").setAge(88);
		
		PersonArrayPayloadWithConstructor jsonPayload1 = person1.getPerson();
		
		//Building second person : not sending last name, sending only first name and age
		
         PersonBuilderClass person2 = new PersonBuilderClass();
		
		 person2.setFirstName("Madan").setLastName("kusum").setAge(89);
		 
		 PersonArrayPayloadWithConstructor jsonPayload2 = person2.getPerson();
		
	
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
