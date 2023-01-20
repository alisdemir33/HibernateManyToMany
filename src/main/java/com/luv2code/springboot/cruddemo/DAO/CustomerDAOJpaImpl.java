package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Customer;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub

		Query theQuery = entityManager.createQuery("from Customer");
		List<Customer> customerList = theQuery.getResultList();
		return customerList;
	}

	@Override
	public Customer findByID(int theId) {
		Customer cust = entityManager.find(Customer.class, theId);
		return cust;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Customer dbCust = entityManager.merge(customer);
		customer.setId(dbCust.getId());

	}

	@Override
	public void deleteCustomerById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Customer where id=:theId");
		theQuery.setParameter("theId", theId);
		theQuery.executeUpdate();

	}

}
