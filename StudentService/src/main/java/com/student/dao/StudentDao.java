package com.student.dao;

import java.util.List;
import java.util.Optional;

import com.student.beans.Student;

public interface StudentDao {

	public Student registerStudent(Student student);

	public Iterable<Student> getAllStudents();

	public Optional<Student> getStudentById(String id);

	public List<Student> advanceSearch(Student student);

	public Student update(Student student);

	public void remove(Student student);

	public List<Student> inActive(List<String> studentIds);

	public List<Student> active(List<String> studentIds);

}
