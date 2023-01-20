package com.luv2code.springboot.cruddemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
