package com.Lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//use of Lombok annotations 

//********Lombok @Getter annotation on the class level can be used only to produce getters for non static variables.

@Getter
@Setter
@Builder(setterPrefix = "set")
@AllArgsConstructor
public class ReqresPostRequestPojo {
	
	private String name;
	private String job;

}
