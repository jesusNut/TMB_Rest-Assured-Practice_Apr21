package com.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.pojo.EasyPayload;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RunnerPatch {

	// change email for id=3. We have to send email field only in patch. We cannot use POJO, JSON CLASS concept here because 
	//the rest of the fields will also be passed as null (or the default type of data used in JSON schema).For Example: the 
	// first_name and last_name will be passed as NULL and cannot be eliminated altogether.

	@Test(enabled = true)
	public void updateUserPatch() {

		// updating user id :3 {by passing JSON payload as string}

		EasyPayload jsonPayload = new EasyPayload();

		jsonPayload.setEmail("maharaj.yankushee@gmail.com");

		RequestSpecification request = given();

		request = request.log().body();

		request = request.header("Content-Type", "application/json");

		request.body(" {\r\n" + 
				"        \"email\": \"abhishek.bhardwaj1@facebook.com\"\r\n" + 
				"    }");

		System.out.println("-------------------------------");

		Response patchRes = request.patch("http://localhost:3000/employees/3");

		System.out.println(patchRes.getStatusCode());

		patchRes.prettyPrint();

	}

}
