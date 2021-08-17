package com.pojo;

//This class builds a person object used as JSON payload. 

//Just a more appropriate and well made class with functions like build() , and() & perform()

public class PersonBuilderClass2 {

	private String firstName;
	private String lastName;
	private int age;

	public PersonBuilderClass2 setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonBuilderClass2 setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PersonBuilderClass2 setAge(int age) {
		this.age = age;
		return this;
	}

	public PersonBuilderClass2 build() {

		return this;
	}

	public PersonBuilderClass2 and() {

		return this;
	}

	// this method creates a new PersonArrayPayload object

	public PersonArrayPayload perform() {

		PersonArrayPayload temp_person = new PersonArrayPayload();
		temp_person.setAge(this.age);
		temp_person.setFirstName(this.firstName);
		temp_person.setLastName(this.lastName);

		return temp_person;

	}

}
