package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.DAO.CustomerDAO;
import com.luv2code.springboot.cruddemo.DAO.CustomerDAOHibernateImpl;
import com.luv2code.springboot.cruddemo.DAO.CustomerRepository;
import com.luv2code.springboot.cruddemo.entity.Customer;

@Service
public class CustomerServiceRepositoryImpl implements CustomerService {

	// need to inject customer dao
	
	private CustomerRepository customerRepository;
	
	
	@Autowired
	public CustomerServiceRepositoryImpl(CustomerRepository theCustomerRepository) {
		//super();
		this.customerRepository = theCustomerRepository;
	}

	@Override	
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override	
	public void saveCustomer(Customer theCustomer) {

		customerRepository.save(theCustomer);
	}

	@Override	
	public Customer getCustomer(int theId) {
		
		Optional<Customer> result = customerRepository.findById(theId);
		Customer theCustomer=null;
		if(result.isPresent()) {
			theCustomer = result.get();
		}else {
			throw new RuntimeException("NotFound");
		}
		return theCustomer;
	}

	@Override	
	public void deleteCustomer(int theId) {
		
		customerRepository.deleteById(theId);
	}
}





