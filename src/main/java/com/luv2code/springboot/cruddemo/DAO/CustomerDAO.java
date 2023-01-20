package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();
	
	public Customer findByID(int theId);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomerById(int theId);
}
