package com.student.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.student.beans.Student;
import com.student.constants.CommonConstants;
import com.student.repository.StudentRepository;
import com.student.util.StudentUtility;

@Repository
public class studentDaoImpl implements StudentDao{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentUtility studentUtility;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Student registerStudent(Student student) {
		  long number = studentUtility.seqGenerator(CommonConstants.STUDENT_SEQUENCE);
		  String getNextId = studentUtility.getNextSeqId(number);
		  student.setId(getNextId);
		  return studentRepository.save(student);
	}

	@Override
	public Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(String id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> advanceSearch(Student student) {
		Query query = studentUtility.createAdvanceSearchQuery(student);
		return mongoTemplate.find(query, Student.class);	
	}

	@Override
	public Student update(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void remove(Student student) {
		studentRepository.delete(student);
	}

	@Override
	public List<Student> inActive(List<String> studentIds) {
		List<Student> studentList = new ArrayList<Student>();
		if(studentIds.size() > 0) {
			studentIds.stream().forEach(studentId -> {
				Query query = new Query();
				query.addCriteria(Criteria.where(CommonConstants.ID).is(studentId));
				Update update = new Update();
				update.set(CommonConstants.IS_ACTIVE, false);
				Student student  = mongoTemplate.findAndModify(query, update, Student.class);
				studentList.add(student);
			});	
		}
		
		return studentList;
	}

	@Override
	public List<Student> active(List<String> studentIds) {
		List<Student> studentList = new ArrayList<Student>();
		if(studentIds.size() > 0) {
			studentIds.stream().forEach(studentId -> {
				Query query = new Query();
				query.addCriteria(Criteria.where(CommonConstants.ID).is(studentId));
				Update update = new Update();
				update.set(CommonConstants.IS_ACTIVE, true);
				Student student  = mongoTemplate.findAndModify(query, update, Student.class);
				studentList.add(student);
			});	
		}
		
		return studentList;	
	}

	
	



	
	

}
