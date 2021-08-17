package com.tests;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.Test;

import deserializingPojoReqRes.ReqresData;
import deserializingPojoReqRes.ReqresMain;
import io.restassured.response.Response;

public class DeserealizingResponseReqRes {

	// we will do a get call and deserialize the response below to map it to POJO
	// classes.
	// Rememeber that we have to create our POJO classes before hitting the request,
	// because we have to map our response against the already created POJO classes.

	// Deserializing POJO classes used:

	// ReqresMain.java
	// ReqresData.java
	// ReqresSupport.java

	// Expected response:

//	{
//	    "page": 2,
//	    "per_page": 6,
//	    "total": 12,
//	    "total_pages": 2,
//	    "data": [
//	        {
//	            "id": 7,
//	            "email": "michael.lawson@reqres.in",
//	            "first_name": "Michael",
//	            "last_name": "Lawson",
//	            "avatar": "https://reqres.in/img/faces/7-image.jpg"
//	        },
//	        {
//	            "id": 8,
//	            "email": "lindsay.ferguson@reqres.in",
//	            "first_name": "Lindsay",
//	            "last_name": "Ferguson",
//	            "avatar": "https://reqres.in/img/faces/8-image.jpg"
//	        },
//	        {
//	            "id": 9,
//	            "email": "tobias.funke@reqres.in",
//	            "first_name": "Tobias",
//	            "last_name": "Funke",
//	            "avatar": "https://reqres.in/img/faces/9-image.jpg"
//	        },
//	        {
//	            "id": 10,
//	            "email": "byron.fields@reqres.in",
//	            "first_name": "Byron",
//	            "last_name": "Fields",
//	            "avatar": "https://reqres.in/img/faces/10-image.jpg"
//	        },
//	        {
//	            "id": 11,
//	            "email": "george.edwards@reqres.in",
//	            "first_name": "George",
//	            "last_name": "Edwards",
//	            "avatar": "https://reqres.in/img/faces/11-image.jpg"
//	        },
//	        {
//	            "id": 12,
//	            "email": "rachel.howell@reqres.in",
//	            "first_name": "Rachel",
//	            "last_name": "Howell",
//	            "avatar": "https://reqres.in/img/faces/12-image.jpg"
//	        }
//	    ],
//	    "support": {
//	        "url": "https://reqres.in/#support-heading",
//	        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
//	    }
//	}

	@Test(enabled = true)
	public void getRequest() {

		// req-res.in :: GET USER

		Response response = given().get("https://reqres.in/api/users?page=2");

		// for deserializing and mapping response to "ReqresMain.class" POJO class.

		ReqresMain mainResponse = response.as(ReqresMain.class);
		
		//Extracting data from POJO class : printing the whole main response

		System.out.println(mainResponse);

		// Extracting data from POJO class : printing all the list of data only

		List<ReqresData> data = mainResponse.getData();

		ListIterator<ReqresData> listIterator = data.listIterator();

		while (listIterator.hasNext()) {

			System.out.println(listIterator.next());

		}

	}

}
