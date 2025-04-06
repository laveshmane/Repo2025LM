package Restassured;

import java.io.IOException;

import utilities.baseclass;

public class D_getProperty extends baseclass{
public static void main(String[] args) throws IOException {
	
	baseclass base = new baseclass();
	String name = base.getProperty("name");
	String age = base.getProperty("age");
	
	System.out.println(name+" "+ age);
}
}
 