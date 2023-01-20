package com.luv2code.springboot.cruddemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
