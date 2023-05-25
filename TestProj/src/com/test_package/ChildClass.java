package com.test_package;

public class ChildClass{

	public static void main(String[] args) {
		TestClass.m1();
		
		TestClass objName=new TestClass();
		System.out.println(objName.var);
		
		objName.m2();
	}
}
