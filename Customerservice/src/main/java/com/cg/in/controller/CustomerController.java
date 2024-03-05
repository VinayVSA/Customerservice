package com.cg.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import com.cg.in.entities.Account;
import com.cg.in.entities.Customer;
//import com.cg.in.entities.Logindatabase;
import com.cg.in.service.CustomerServiceImpl;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private  CustomerServiceImpl customerService;
	/*
	  @GetMapping("/admin/createcustomer")
	    public String showCreateCustomerPage(Model model) {
	        model.addAttribute("customer", new Customer());
	        return "createcustomer";
	    }

	    @PostMapping("/admin/createcustomer")
	    public String createCustomer(@ModelAttribute("customer") Customer customer) {
	        customerService.addCustomer(customer);
	        return "redirect:/admin/createcustomer"; // Redirect to the customer list page
	    }
    */
	@GetMapping("/admin/createcustomer")
	public ModelAndView showCreateCustomerPage() {
	    ModelAndView modelAndView = new ModelAndView("createcustomer");
	    modelAndView.addObject("customer", new Customer());
	    return modelAndView;
	}

	@PostMapping("/admin/createcustomer")
	public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer) {
	    customerService.addCustomer(customer);
	    return new ModelAndView("redirect:/customer/admin/createcustomer");
	}

	
	@GetMapping("/admin/getcustomerbyid")
	public ModelAndView getCustomerById()
	{
		return new ModelAndView("getcustomerbyid");
	}
	
	@GetMapping("/id")
	public ModelAndView getCustomerByid(@RequestParam("id") int id) {
	    Customer customer = customerService.getCustomerDetailsById(id);
	    ModelAndView modelAndView = new ModelAndView("getcustomerbyid");
	    modelAndView.addObject("customer", customer);
	    return modelAndView;
	}
     
	@GetMapping("/admin/{id}")
	public Customer getCustomerById(@PathVariable int id)
	{
		return customerService.getCustomerDetailsById(id);
	}
	
	
	
	@GetMapping("/admin")
	public List<Customer> getAllCustomerDetails()
	{
		return customerService.getAllCustomerDetails();
	}
	
	 @GetMapping("/admin/getallcustomers")
	    public ModelAndView showGetAllAustomersPage(Model model) {
	        model.addAttribute("customers", customerService.getAllCustomerDetails());
	        return new ModelAndView("getallcustomers");
	    }
	    
		
	
	

}
