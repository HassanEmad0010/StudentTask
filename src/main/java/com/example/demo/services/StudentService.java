package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.demo.model.Student;

@Service
public class StudentService {

	private final List<Student> students ;

	
	
public StudentService() {
		System.out.println("StudentService Constructor");
		this.students = new ArrayList<Student>();
	}



public Optional<Student> getStudent(final String id) {
		
		for (Student std : students)
		{
			System.out.println("Std: "+ std);
			 if (std.getId().equals(id)) 
				 return Optional.of(std);
		}
		return Optional.empty();
	}
	


public String addStudent(final Student student) {

	if (!students.stream().anyMatch(s -> s.getId().equals(student.getId()))) 
	{
	students.add(student);
	return "Student added: ".concat(student.getId());	
	}
	else 
		return "this id: "+ student.getId()+" exists";
	}


public Optional<Student> updateStudentName( String name,  String id) {
	
	for (Student std : students)
	{
		 if (std.getId().equals(id)) 
		 {
			 std.setName(name);
			 return Optional.of(std);
		 }
		 }
	
	return  Optional.empty();
	
	
}


public String deleteStudent( String id) {
	
	for (Student std : students)
	{
		 if (std.getId().equals(id)) 
		 {
			 students.remove(std);
			 return "ID: "+ id + " removed";
		 }
		 }
	
	return  id +" Not Found";
	
	
}




public Optional<Student> getFirstStudent() {
	
	if (!students.isEmpty())
		return Optional.of(students.get(0));

		return Optional.empty();
}	



public Optional<List<Student>> displayAllStudents() {
	
	if (!students.isEmpty())
		return Optional.of(students) ;

		return Optional.empty();
}	


	
}
