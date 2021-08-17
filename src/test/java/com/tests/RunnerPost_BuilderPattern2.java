package com.tests;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.pojo.PersonArrayPayload;
import com.pojo.PersonArrayPayloadWithConstructor;
import com.pojo.PersonBuilderClass;
import com.pojo.PersonBuilderClass2;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPost_BuilderPattern2 {

	// ***Problem : We need to pass a payload format given below. It has 3
	// attributes - firstName,lastName and age. Now if i do not want to provide
	// 'lastName' attribute,
	// we can use BUILDER pattern-modified one with build(), and() and perform() methods for better readibility.
	// Using PersonArrayPayload.java,
	// So we have used Builder pattern - a new class "PersonBuilderClass2.java".

	// perform POST request using POJO.

	// class used : 'PersonArrayPayload' aka POJO class &
	// 'PersonBuilderClass2' aka BUILDER CLASS-> com.pojo package in src/main/java

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

		// Building first person : sending first name, last name and age

		PersonBuilderClass2 person1 = new PersonBuilderClass2();

		PersonArrayPayload jsonPayload1 =

				person1.setFirstName("Madan").and().setLastName("Jiee").and().and().setAge(67).build().perform();

		// Building second person : not sending last name, sending only first name and
		// age

		PersonBuilderClass2 person2 = new PersonBuilderClass2();

		PersonArrayPayload jsonPayload2 =

				person2.setFirstName("Kanupriya").and().setAge(87).build().perform();

		List<PersonArrayPayload> finalPayload = Arrays.asList(jsonPayload1, jsonPayload2);

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
