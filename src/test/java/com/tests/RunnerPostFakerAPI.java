package com.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//use of FAKER API to generate 

public class RunnerPostFakerAPI {

	@Test(enabled = true)
	public void postUserUsingMapComplexJson() throws IOException {

		// creating faker object

		Faker faker = new Faker(new Locale("en-PAK"));

		Map<String, Object> requestMap = new HashMap<String, Object>();

		requestMap.put("id", Integer.parseInt(faker.number().digits(2)));
		requestMap.put("first_name", faker.name().firstName());
		requestMap.put("last_name", faker.name().lastName());
		requestMap.put("email", faker.bothify("?##??##@Microsoft.co.uk"));

		List<String> reqArrayinMap = new ArrayList<String>();

		reqArrayinMap.add(faker.job().title());
		reqArrayinMap.add(faker.job().title());

		requestMap.put("job", reqArrayinMap);

		Map<String, String> requestMapinMap = new HashMap<String, String>();

		requestMapinMap.put("breakfast", faker.food().vegetable());
		requestMapinMap.put("lunch", faker.food().dish());

		requestMap.put("favfood", requestMapinMap);

		// -------------------------------------------------

		RequestSpecification request = given();

		request = request.log().all();

		request = request.header("Content-Type", "application/json");

		request.body(requestMap);

		System.out.println("-------------------------------");

		Response postRes = request.post("http://localhost:3000/employees");

		postRes.prettyPrint();

	}

}
