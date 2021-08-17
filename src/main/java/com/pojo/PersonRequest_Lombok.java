package com.pojo;

import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//to be utilized in RunnerPost_FakeServer_Lombok.class

//**** USE CASE : We have to pass the below address filed which is in json object form.
//2 approaches to solve this :
//1. Create a new POJO class as the address is a JSON object and 
//then create a new variable in this class as "Private <nameOfClass><variable>".
//Then use it accordingly in RunnerPost_BuilderPattern
//2. Use it directly as json string (shown here) with XXXXXXX annotation.

//adress format:

//     {
//
//	  "unit":"22",
//	  "street":"khau gali",
//	  "city":"Luxemberg"
//	
//     }

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "set" )
public class PersonRequest_Lombok {
	
	
	private String firstName;
	private String lastName;
	private int age;
	
	//to pass the Address string in exact JSON format without escape characters etc.
	@JsonRawValue
	private String address;

}
