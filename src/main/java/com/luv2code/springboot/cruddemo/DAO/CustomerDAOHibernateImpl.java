package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Customer;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override	
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> theQuery =currentSession.createQuery("from Customer",Customer.class);
		List<Customer> customerList=theQuery.getResultList();
		return customerList;
	}

	@Override
	public Customer findByID(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Customer customer= currentSession.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public void deleteCustomerById(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> theQuery =currentSession.createQuery("delete from Customer where id=: theId");
		theQuery.setParameter("theId",theId);
		theQuery.executeUpdate();
		
	}

}
