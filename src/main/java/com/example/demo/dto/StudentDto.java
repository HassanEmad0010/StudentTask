package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class StudentDto {
	 int id;
	 String name;
	 String email;
	 int age;
	
}
