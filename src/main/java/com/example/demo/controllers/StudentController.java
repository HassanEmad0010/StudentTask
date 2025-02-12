package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

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

	private final StudentService studentService ;

	public StudentController (StudentService studentService )
	{
		this.studentService = studentService;
	}


	// input id , out the student data
	@GetMapping("/read")
	public Optional<Student> getMethodApi(@RequestParam String id) {

		return studentService.getStudent(id);
	}

	@PostMapping("/create")
	public String postMethodApi(@RequestBody Student student) {
		return studentService.addStudent(student);
	}





	@PutMapping("update/{name}/{id}")
	public Optional<Student> updateNameMethodApi(@PathVariable String name, @PathVariable String id) {

		return studentService.updateStudentName(name, id);

	}

	@DeleteMapping("delete/{id}")
	public String deleteNameMethodApi(@PathVariable String id) {

		return studentService.deleteStudent(id);
	}


	@GetMapping("findfirst")
	public Optional<Student> getFirstMethodApi() {

		return studentService.getFirstStudent();
	}	


	@GetMapping("findall")
	public Optional<List<Student>> getAllStdMethodApi() {

		return studentService.displayAllStudents();
	}	





}
