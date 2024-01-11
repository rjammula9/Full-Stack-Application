
  package com.rajesh.model;
  
  import javax.persistence.Entity;
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id; 
  import javax.persistence.Table;
  
  @Entity
 
  public class Employee {
  
  
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id; 
  private String name;
  private String email;
  private int age; 
  private String position;
  private Address address;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", position=" + position
			+ ", address=" + address + "]";
}
  
 // Constructors, getters, setters, and other methods
  
 
  }
 