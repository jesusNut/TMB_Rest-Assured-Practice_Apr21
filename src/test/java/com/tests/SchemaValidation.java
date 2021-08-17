package com.tests;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidation {

	// *******Validating the JSON SCHEMA : expected schema is saved as a file schema.json 

	@Test(enabled = true)
	public void getRequest() {

		// req-res.in :: GET USER

     given().get("http://localhost:3000/employees")
     .then()
     .body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir") + "\\schema.json")));
		
	}

}
