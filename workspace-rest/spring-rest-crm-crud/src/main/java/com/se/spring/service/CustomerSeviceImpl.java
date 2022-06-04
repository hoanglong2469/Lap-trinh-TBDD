package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.CustomerDAO;
import com.se.spring.entity.Customer;

@Service
public class CustomerSeviceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer cus) {
		dao.saveCustomer(cus);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return dao.getCustomerById(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
	}

}
