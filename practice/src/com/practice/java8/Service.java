package com.practice.java8;

import java.util.Arrays;
import java.util.List;

public class Service {

	public List<Employee> getEmployess(){
		return Arrays.asList(
				  new Employee(5, "jhon", "jhon@mail"),
				  new Employee(3, "Abram", "Abram@mail"),
				  new Employee(2, "vicky", "vicky@mail"),
				  new Employee(1, "Ram", "Ram@mail"),
				  new Employee(4, "Murali", "Murali@mail")
				);
	}
	
}
