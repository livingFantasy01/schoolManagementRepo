package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.beans.Student;
import com.student.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student registerStudent(Student student) {
		return studentDao.registerStudent(student);
	}

	@Override
	public Iterable<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Optional<Student> getStudentById(String id) {
		return studentDao.getStudentById(id);
	}

	@Override
	public List<Student> advanceSearch(Student student) {
		return studentDao.advanceSearch(student);
	}

	@Override
	public Student update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public void remove(Student student) {
		studentDao.remove(student);
	}

	@Override
	public List<Student> inActive(List<String> studentIds) {
		return studentDao.inActive(studentIds);
	}

	@Override
	public List<Student> active(List<String> studentIds) {
		return studentDao.active(studentIds);
	}


}
