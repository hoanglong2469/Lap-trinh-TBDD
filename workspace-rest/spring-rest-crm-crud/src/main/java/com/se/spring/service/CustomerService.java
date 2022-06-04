package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer cus);
	public Customer getCustomerById(int id);
	public void deleteCustomer(int id);
}
