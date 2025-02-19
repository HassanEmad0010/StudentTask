package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentService {

	private final List<Student> students ;

	private final JdbcTemplate jdbcTemplate;
	
public StudentService(JdbcTemplate jdbcTemplate) {
		System.out.println("StudentService Constructor");
		this.students = new ArrayList<Student>();
		this.jdbcTemplate=jdbcTemplate;
		
		System.out.println("Importing Data from DB: " + importFromDb());
		System.out.println("students: "+ students);
	}






public boolean importFromDb()
	{
    String sql = "SELECT * FROM students_table";
    
    List <Student> dbStudents = jdbcTemplate.query(sql, (result, rowNum) -> {
        Student student = new Student();
        student.setId(Integer.parseInt(result.getString("id")));
        student.setName(result.getString("name"));
        student.setAge(Integer.parseInt(result.getString("age")));
        student.setEmail(result.getString("email"));
        return student;
    });
    
    return students.addAll(dbStudents);

	}

public void exportToDb()
{
	students.stream().forEach(s->{
		
		String name  = s.getName();
		String email = s.getEmail();
		int age 	 = s.getAge();
		
	    String sql = "INSERT INTO students_table (name, age, email) VALUES (?, ?, ?)";
	   jdbcTemplate.update(sql, name, age, email);

	});

}





//work on DB directly 
public int insertStudentDb(int id , String name, int age, String email) {
    String sql = "INSERT INTO students_table (id, name, age, email) VALUES (?,?, ?, ?)";
    return jdbcTemplate.update(sql,id, name, age, email);
}

//work on DB directly 
public int deleteStudentDb(int id) {
    String sql = "DELETE FROM students_table WHERE id = ?";
  return jdbcTemplate.update(sql, id);
}

//work on DB directly 
public int updateStudentDb(String name , int id) {
    String sql = "UPDATE students_table SET name = ? WHERE id = ?";
    return jdbcTemplate.update(sql,name, id);
}



public Optional<Student> getStudent(final int id) {
	
		for (Student std : students)
		{
			System.out.println("Std: "+ std);
			 if (std.getId() == id) 
				 return Optional.of(std);
		
		}
		
		return Optional.empty();
	}
	


public String addStudent(final Student student) {

	if (!students.stream().anyMatch(s -> s.getId() == (student.getId()))) 
	{
	students.add(student);
	{
		insertStudentDb(student.getId(),student.getName(), student.getAge(), student.getEmail());
		return "Student added: " + (student.getId());	
	}
	}
	else 
		return "this id: "+ student.getId()+" exists";
	}


public Optional<Student> updateStudentName( String name,  int id) {
	
	for (Student std : students)
	{
		 if (std.getId() == id) 
		 {			 
			 std.setName(name);
			 updateStudentDb(name, id);
			 return Optional.of(std);
		 }
		 }
	
	return  Optional.empty();
	
	
}


public String deleteStudent( int id) {
	
	for (Student std : students)
	{
		 if (std.getId() == id) 
		 {
			 students.remove(std);
			 deleteStudentDb(id);
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
