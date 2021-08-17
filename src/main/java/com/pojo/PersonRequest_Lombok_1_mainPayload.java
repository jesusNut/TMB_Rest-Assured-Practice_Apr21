package com.pojo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonPropertyOrder(value= {"address","age","lastName","firstName"})
public class PersonRequest_Lombok_1_mainPayload {
	
	
	private String firstName;
	private String lastName;
	private int age;
	private PersonRequest_Lombok_1_address address;

}
