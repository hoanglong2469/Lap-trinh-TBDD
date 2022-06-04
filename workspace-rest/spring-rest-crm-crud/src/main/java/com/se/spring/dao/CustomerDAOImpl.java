package com.se.spring.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// current session query ...sort by last name
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer cus) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/ update the customer
		currentSession.saveOrUpdate(cus);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// read from database using the primary key
		Customer customer = currentSession.get(Customer.class, id);

		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = getCustomerById(id);

		currentSession.delete(customer);

	}

}
