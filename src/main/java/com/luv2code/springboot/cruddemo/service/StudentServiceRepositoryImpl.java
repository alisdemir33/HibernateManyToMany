package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.DAO.StudentRepository;
import com.luv2code.springboot.cruddemo.entity.Student;

@Service
public class StudentServiceRepositoryImpl implements StudentService {

	// need to inject Student dao
	
	private StudentRepository StudentRepository;
	
	
	@Autowired
	public StudentServiceRepositoryImpl(StudentRepository theStudentRepository) {
		//super();
		this.StudentRepository = theStudentRepository;
	}

	@Override	
	public List<Student> getStudents() {
		return StudentRepository.findAll();
	}

	@Override	
	public void saveStudent(Student theStudent) {

		StudentRepository.save(theStudent);
	}

	@Override	
	public Student getStudent(int theId) {
		
		Optional<Student> result = StudentRepository.findById(theId);
		Student theStudent=null;
		if(result.isPresent()) {
			theStudent = result.get();
		}else {
			throw new RuntimeException("NotFound");
		}
		return theStudent;
	}

	@Override	
	public void deleteStudent(int theId) {
		
		StudentRepository.deleteById(theId);
	}
}





