package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//jackson annotations

//does not include null values
//@JsonInclude(value = Include.NON_NULL)

//does not include NULL or EMPTY values
@JsonInclude(value = Include.NON_EMPTY)

//maintain order
@JsonPropertyOrder(value = {"age","firstName","lastName"})

//to ignore multiple properties/fields
@JsonIgnoreProperties(value = {"age"})

public class PersonArrayPayloadWithConstructor {

	private String firstName;
	private String lastName;
	
	
	//to ignore a field/property
	//@JsonIgnore
	private int age;
		
	// constructor

	public PersonArrayPayloadWithConstructor(String firstName, String lastName, int age) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// getter-setters

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
