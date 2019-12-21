package com.student.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.student.beans.Sequence;
import com.student.beans.Student;
import com.student.constants.CommonConstants;


@Component
public class StudentUtility {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public Long seqGenerator(String key) {
		
		Query query = new Query(Criteria.where("_id").is(key));
		Update update = new Update();
		update.inc("seq", 1);
		FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions();
		findAndModifyOptions.returnNew(true);
		Sequence sequence = mongoOperations.findAndModify(query, update, findAndModifyOptions,Sequence.class);
		return sequence.getSeq();
	}
	
	public String getNextSeqId(Long number) {
		return "S"+CommonConstants.STUDENT_SEQUENCE_LEN.substring(String.valueOf(number).length(),CommonConstants.STUDENT_SEQUENCE_LEN.length())+number;
		
	}
	
	public Query createAdvanceSearchQuery(Student student) {
		Query query = new Query();
		if(student.getId() != null && !student.getId().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.ID).is(student.getId()));
		}
		if(student.getFirstName() != null && !student.getFirstName().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.FIRST_NAME).is(student.getFirstName()));
		}
		if(student.getMiddleName() != null && !student.getMiddleName().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.MIDDLE_NAME).is(student.getMiddleName()));
		}
		if(student.getLastName() != null && !student.getLastName().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.LAST_NAME).is(student.getLastName()));
		}
		if(student.getFathersName() != null && !student.getFathersName().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.FATHER_NAME).is(student.getFathersName()));
		}
		if(student.getEmailId() != null && !student.getEmailId().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.EMAIL_ID).is(student.getEmailId()));
		}
		if(student.getPhoneNumber() != null && !student.getPhoneNumber().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.PHONE_NUMBER).is(student.getPhoneNumber()));
		}
		if(student.getAlternateNumber() != null && !student.getAlternateNumber().isEmpty()) {
			query.addCriteria(Criteria.where(CommonConstants.ALTERNATE_NUMBER).is(student.getAlternateNumber()));
		}
		if(student.getIsActive() != null) {
			query.addCriteria(Criteria.where(CommonConstants.IS_ACTIVE).is(student.getIsActive()));
		}
		if(student.getDob() != null) {
			query.addCriteria(Criteria.where(CommonConstants.DOB).is(student.getDob()));
		}
		return query;
	}
	

}
