package com.priti.code.model;

public class Customer {
	
	//this is model class
	//here, we declare all fields name of table
	int id;
	String name;
	String gender;
	String city;
	String hobbies;
	
	
	//this is simple constructor
	public Customer() {
		
	}
	
	//this is without id constructor
	public Customer(String name, String gender, String city, String hobbies) {
		
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.hobbies = hobbies;
	}
    
	//this is with id constructor
	public Customer(int id, String name, String gender, String city, String hobbies) {
	
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.hobbies = hobbies;
	}
    
	
	//this is Getters and Setters method
	//to get and set the values
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getHobbies() {
		return hobbies;
	}
	
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	
}
