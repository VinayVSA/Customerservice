package com.cg.in.service;

import java.util.List;

import com.cg.in.entities.Customer;
import com.cg.in.exception.CustomerException;

public interface CustomerService {

	 Customer getCustomerDetailsById(int customerId);

	    Customer addCustomer(Customer customer);

	    void deleteCustomer(int customerId);

	    void updateCustomer(Customer customer)throws CustomerException;
	
	    List<Customer> getAllCustomerDetails();
	    
	   
	
}
