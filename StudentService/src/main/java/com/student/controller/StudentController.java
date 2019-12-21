package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.beans.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/registerStudent")
	public Student registerStudent(@RequestBody Student student) {
		return studentService.registerStudent(student);
	}

	@GetMapping("/getAllStudents")
	public Iterable<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/getStudentById/{studentId}")
	public Optional<Student> StudentById(@PathVariable("studentId") String id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/advanceSearch")
	public List<Student> advanceSearch(@RequestBody Student student) {
		return studentService.advanceSearch(student);
	}

	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		return studentService.update(student);
	}

	@DeleteMapping("/remove")
	public void remove(@RequestBody Student student) {
		studentService.remove(student);
	}

	@PutMapping("/inActive")
	public List<Student> inActive(@RequestBody List<String> studentIds) {
		return studentService.inActive(studentIds);
	}

	@PutMapping("/active")
	public List<Student> active(@RequestBody List<String> studentIds) {
		return studentService.active(studentIds);
	}

}
