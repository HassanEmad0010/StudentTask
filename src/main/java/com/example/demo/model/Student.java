package com.example.demo.model;

import java.util.Objects;


//@Component
public class Student {

	private int id;
	private String name, email;
	private int age;
	
	
	public Student() {
	System.out.println("Student Constructor");
	
	}
	

	/*
	 * public Student(String id, String name, String age, String email) { this.id =
	 * id; this.name = name; this.age = age; this.email = email; }
	 */

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}





	
	
	
	
	
}
