package com.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Response_storeInExternalFile {

	// send a get request and save the response on an external file

	@Test
	public void getRequest() throws IOException {

		// req-res.in :: GET USER

		Response response = given().get("http://localhost:3000/employees");

		response.prettyPrint();

		// save in an external file

		LocalDate localDate = new LocalDate(); // passing it just for fun and unique file name.

		Files.write(Paths.get(System.getProperty("user.dir") + "\\output" + localDate.toString() + ".json"),
				response.asByteArray());

	}

}
