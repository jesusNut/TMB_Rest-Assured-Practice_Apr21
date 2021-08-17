package com.pojo;

public class PersonBuilderClass {
	
	private String firstName;
	private String lastName;
	private int age;
	
	
	public PersonBuilderClass setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public PersonBuilderClass setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public PersonBuilderClass setAge(int age) {
		this.age = age;
		return this;
	}
	
	
	//this method creates a new PersonArrayPayloadWithConstructor object
	
	public PersonArrayPayloadWithConstructor getPerson() {
		
		return new PersonArrayPayloadWithConstructor(this.firstName, this.lastName, this.age);
		
		
	}
	
}
