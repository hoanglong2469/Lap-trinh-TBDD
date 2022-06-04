package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer cus);
	public Customer getCustomerById(int id);
	public void deleteCustomer(int id);
}
