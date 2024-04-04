package com.cg.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.in.entities.Customer;

import com.cg.in.exception.CustomerException;
import com.cg.in.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository customerRepository;
	
	
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
		this.customerRepository=customerRepository;
		
	}
	
	
	

	@Override
	public Customer getCustomerDetailsById(int customerId) {
		
		return customerRepository.findById(customerId).get();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		 return customerRepository.save(customer);
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		
		return customerRepository.findAll();
	}

	

}
