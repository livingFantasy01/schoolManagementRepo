package com.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.beans.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, String>{
		
}
