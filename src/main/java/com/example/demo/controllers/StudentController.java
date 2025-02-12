package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("studenturl")

public class StudentController {

	//private final Student student ;
	private List<Student> students ;
	
	public StudentController ()
	{
		//this.student = student;
		this.students = new ArrayList<Student>();
	}
	
	
	
	
	
	// input id , out the student data
	@GetMapping("/read")
	public Optional<Student> getMethodApi(@RequestParam String id) {
		
		for (Student std : students)
		{
			System.out.println("Std: "+ std);
			 if (std.getId().equals(id)) 
				 return Optional.of(std);
		}
		return Optional.empty();
	}
	
	@PostMapping("/create")
	public String postMethodApi(@RequestBody Student student) {

		if (!students.stream().anyMatch(s -> s.getId().equals(student.getId()))) 
		{
		students.add(student);
		return "Student added: ".concat(student.getId());	
		}
		else 
			return "this id: "+ student.getId()+" exists";
		}
	
	
	
	
	
	@PutMapping("update/{name}/{id}")
	public Optional<Student> updateNameMethodApi(@PathVariable String name, @PathVariable String id) {
		
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
	
	@DeleteMapping("delete/{id}")
	public String deleteNameMethodApi(@PathVariable String id) {
		
		for (Student std : students)
		{
			 if (std.getId().equals(id)) 
			 {
				 students.remove(std);
				 return "ID: "+ id + " removed";
			 }
			 }
		
		return  "Id Not Found";
		
		
	}
	
	
	@GetMapping("findfirst")
	public Optional<Student> getFirstMethodApi() {
		
		if (!students.isEmpty())
			return Optional.of(students.get(0));

			return Optional.empty();
	}	
	
	
	@GetMapping("findall")
	public Optional<List<Student>> getAllStdMethodApi() {
		
		if (!students.isEmpty())
			return Optional.of(students) ;

			return Optional.empty();
	}	
	
	
	
	
	
}
